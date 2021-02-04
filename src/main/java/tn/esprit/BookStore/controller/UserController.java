package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.service.ImpUserService;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {


    @Autowired
    private ImpUserService srvUsr;


    /// Sign up user
    @PostMapping("/Signup")
    @ResponseBody
    public String Adduser(User us) {
        return srvUsr.Signup(us);

    }

    /// Sign up user
    @PostMapping("/SignupClient")
    @ResponseBody
    public String AdduserClient(User us) {
        return srvUsr.SignupClient(us);

    }

    // Get All
    @GetMapping
    @ResponseBody
    public List<User> getAllUsers() {

        List<User> list = srvUsr.GetAllUsers();
        return list;
    }

    // Get All Admin
    @GetMapping("Admins")
    @ResponseBody
    public List<User> getAllAdmin() {

        List<User> list = srvUsr.GetAllAdmin();
        if (list != null && list.isEmpty()) {

            return null;
        }
        return list;
    }

    // Login
    @PostMapping("/au")
    @ResponseBody
    public User Login(User usr) {

        return srvUsr.Authority(usr.getLogin(), usr.getPassword());
    }

    //update
    @PutMapping("/modify")
    @ResponseBody
    public User modifyUser(User user) {
        return srvUsr.Update(user);
    }

    @DeleteMapping("/suppression/{id}")
    @ResponseBody
    public String SupprimerUser(@PathVariable("id") long id) {
        srvUsr.Delete(id);
        return "User Deleted successfully !";
    }

    //Get user infos
    @GetMapping("/informationUser/{id}")
    @ResponseBody
    public User userInfo(@PathVariable("id") long id) {
        return srvUsr.GetUser(id);

    }

    @GetMapping("/resetPassword")
    @ResponseBody
    public int Reset(@RequestParam String email) {
        int x = srvUsr.ResetPassword(email);
        return ImpUserService.coderest;
    }

    @GetMapping("/ChangePassword")
    @ResponseBody
    public String Change(@RequestParam int number, @RequestParam String password, @RequestParam long id) {
        String x = srvUsr.UpdateRestPassword(number, password, id);
        return x;
    }

    @GetMapping("/VerifyAccount")
    @ResponseBody
    public String verify(User u, @RequestParam String Code) {
        return srvUsr.VerifyMyaccount(u, Code);
    }

    @GetMapping("/isVerified")
    @ResponseBody
    public boolean isverify(User u) {
        return srvUsr.isVerified(u.getLogin(), u.getPassword());
    }

    @RequestMapping("/hello")
    public String hello() {
        return "helloworld";

    }


}
