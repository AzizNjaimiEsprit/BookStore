package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.User;

import java.util.List;

public interface IUserService {
    User Authority(String login, String password);

    String Signup(User us);

    List<User> GetAllUsers();

    List<User> GetAllAdmin();

    User Update(User us);

    String VerifyMyaccount(User u, String verifcode);

    int ResetPassword(String mail);

    boolean isVerified(String login, String pwd);

    boolean VerifLogin(String login, long id);

    boolean VerifEmail(String Email, long id);

    boolean exist(String login, String pwd);

    void AddCode(String code, User user_id);

    void mailling(String mail, String message);

    void sendsms(String str, int body);

    User GetUser(long id);

    long SelectByid(String login);

    void Delete(long id);

    void ifNotverifiedVerif(long id, String verification_code);

    String UpdateRestPassword(int code, String password, long id);
    /* 
    public String VerifyAccount();
    public Void AddAdmin();
    */

}
