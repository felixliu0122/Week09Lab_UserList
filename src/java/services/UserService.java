package services;

import dataaccess.UserDB;
import models.Users;
import java.util.List;

public class UserService {

    private UserDB userDB;

    public UserService() {
        userDB = new UserDB();
    }

    public Users get(String username) throws Exception {
        return userDB.getUser(username);
    }

    public List<Users> getAll() throws Exception {
        return userDB.getAll();
    }

    public void update(String username, String password, String firstname, String lastname, String email) throws Exception {
        Users user = get(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        userDB.update(user);
    }

    public void delete(String username) throws Exception {
        Users deletedUser = userDB.getUser(username);
        
        if (!deletedUser.getUsername().equals("admin")) {           userDB.delete(deletedUser);
        }
    }

    public void insert(String username, String password, String firstname, String lastname, String email) throws Exception {
        Users user = new Users(username, password);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        userDB.insert(user);
    }
}
