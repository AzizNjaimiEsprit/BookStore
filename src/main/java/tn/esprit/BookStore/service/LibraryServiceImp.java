package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import tn.esprit.BookStore.model.*;
import tn.esprit.BookStore.exception.ApiRequestException;
import tn.esprit.BookStore.repository.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class LibraryServiceImp implements LibraryService {

    @Autowired
    LibraryRepo libraryRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    OnlineBookRepository onlineBookRepo;

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    SendMail sendMail;

    @Override
    public Library addLibrary(Library library) {
        try {
           return libraryRepo.save(library);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void addBookLibrary(Library library) {
        try {
            if(!libraryRepo.findById(library.getId()).isPresent()){
                throw new EntityNotFoundException("No library with that ID was found!");
            }
            Library library1 = libraryRepo.findById(library.getId()).get();

            if(!onlineBookRepo.findById(library1.getOnlineBook().getId()).isPresent()){
                throw new  EntityNotFoundException("No online book with that ID was found!");
            }
            OnlineBook onlineBook = onlineBookRepo.findById(library1.getOnlineBook().getId()).get();
            if(library1.getOnlineBook().getId() == library.getOnlineBook().getId()){
                throw new Exception("Online book already added to that library!");
            }
            library1.setOnlineBook(onlineBook);
            library1.setStatus(Status.Recently_added);
            library1.setReachedPage(0);
            libraryRepo.save(library1);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Library> findLibraryByUserId(Library library) {
        try{
            List<Library> userLibrary = libraryRepo.findLibraryItems((int) library.getUser().getId());
            if(userLibrary.size() == 0){
                throw new EntityNotFoundException("User doesn't have a library");
            }
            return userLibrary;
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public void editLibrary(Library library) {
        try {
        Library updatedLibrary=libraryRepo.findLibraryItem((int) library.getUser().getId(),library.getOnlineBook().getId());
        if(updatedLibrary==null){
            throw new EntityNotFoundException("No library with that ID was found!");
        }
        updatedLibrary.setReachedPage(library.getReachedPage());
        if(updatedLibrary.getReachedPage()==0)
            updatedLibrary.setStatus(Status.Recently_added);
        if(updatedLibrary.getReachedPage()>0)
            updatedLibrary.setStatus(Status.On_progress);
        if(updatedLibrary.getReachedPage()==updatedLibrary.getOnlineBook().getBook().getNbPage())
            updatedLibrary.setStatus(Status.Finished);
        libraryRepo.save(updatedLibrary);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public Book suggestBook(User user){
        try{
            if(userRepo.findById(user.getId()) == null){
                throw new EntityNotFoundException("No User with that ID was found!");
            }
            User user1 = userRepo.findById(user.getId());
            Set<Book> books= libraryRepo.getPurchasedBooks((int) user1.getId());
            Map<Integer,Long> result =books.stream()
                    .collect(Collectors.groupingBy(book -> book.getCategory().getId(),Collectors.counting()));

            Map<Integer, Long> finalMap = new LinkedHashMap<>();
            result.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
            int mostPurchasedCategoryIdInLibrary = finalMap.entrySet().iterator().next().getKey();

            if(!categoryRepo.findById(mostPurchasedCategoryIdInLibrary).isPresent()){
                throw new EntityNotFoundException("No Category with that ID was found!");
            }
            Category suggedtedCategory = categoryRepo.findById(mostPurchasedCategoryIdInLibrary).get();

            List<Book> booksOfSuggestedCategory = libraryRepo.findBookByCategoryId(suggedtedCategory.getId());
            if(booksOfSuggestedCategory.size() == 0){
                throw new EntityNotFoundException("No Books in that category!");
            }

            Book suggestedBook = new Book();
            do {
                Random randomGenerator = new Random();
                int index = randomGenerator.nextInt(booksOfSuggestedCategory.size());

                suggestedBook = booksOfSuggestedCategory.get(index);
            }
            while(libraryRepo.findLibraryItem((int) user1.getId(),  suggestedBook.getId()) != null);

            sendMail.sendEmail(user1, "Dear "+ user1.getFull_name() +
                    ", \n\nThank you for being a loyal customer and we hope that you and your family are doing well, \n" +
                    "We have noticed that you are interested in this category " +suggedtedCategory.getName() +
                    " and we are happy to have a large collection of books in this category." +
                    "We strongly recommend that you check out this book '" + suggestedBook.getTitle() +
                    "' \n\nHave a nice day. " +
                    "\n\nBest regards. ");

            return suggestedBook;
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void readBook(Library library,HttpServletResponse response) throws IOException {
        try {
            String bookTitle = libraryRepo.getBookTitle(library.getOnlineBook().getId(), (int) library.getUser().getId());
            String fileName = "onlineBooks/" + bookTitle + ".pdf";
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            if (file.exists()) {
                //get the mimetype
                String mimeType = URLConnection.guessContentTypeFromName(file.getName());
                if (mimeType == null) {
                    //unknown mimetype so set the mimetype to application/octet-stream
                    mimeType = "application/octet-stream";
                }
                response.setContentType(mimeType);
                response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
                response.setContentLength((int) file.length());
                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                FileCopyUtils.copy(inputStream, response.getOutputStream());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
