package tn.esprit.BookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Packet;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.repository.BookRepository;
import tn.esprit.BookStore.repository.PacketRepository;

@Service
public class PacketService implements IPacketService{
	@Autowired
	BookServiceImp bsrv;
	@Autowired
	BookRepository bRepo;
	@Autowired
	private PacketRepository Pkr;
	public List<Object[]> ListerLesBookBypacket(){
		return Pkr.NumberBookGroupedByPacket();
	}
	
	public List<Packet> getAll() {
		return Pkr.findAll();
	}
public String Add(Packet pk) {
	Packet pkt=Pkr.saveAndFlush(pk);
	if(pkt != null) {
		return "Packet Ajoutee avec Success";
	}
	return "erreur Ajout Packet";
}


public String Delete(long id) {
	// TODO Auto-generated method stub
	List<Book> b=new ArrayList<Book>();
	
	if(Pkr.findById(id)!=null) {
		
	b=bRepo.selectAllBookid(Pkr.findById(id));
	} 
	for(Book bc: b) {
		bc.setPkt(null);
		bsrv.updateBook(bsrv.getBookByID(bc.getId()));
	}

Pkr.deleteById(id);
return "packet Removed";
 
}
public Packet Update(Packet us) {
	if(Pkr.findById(us.getId())!=null) {


		Pkr.save(us);
	return us;
	}
	return null;
}

}
