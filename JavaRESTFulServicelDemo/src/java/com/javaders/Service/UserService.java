package com.javaders.Service;

import com.javaders.Model.User;
import java.util.ArrayList;
import java.util.List;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author tugba
 */
public class UserService {

    public List<User> userList = new ArrayList<>();

    private static UserService instance;

    private UserService() {
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean registerUser(String name, String password) {
        userList.add(new User(name, password)); 
        return true;
    }

    public boolean isUserNameUsed(String name) {
        for (User u : userList) {
            if (u.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String id) {
        User user = null;

        for (User u : userList) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            return false;
        } else {
            userList.remove(user);
            return true;
        }
    }

    public User findUserByName(String name) {
        for (User u : userList) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null; //Bu satıra gelirse bu isimli user yok demek. User varsa for'un içinde iken return eder ve metod biter.
    }

    public User findUserById(String id) {
        for (User u : userList) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null; //Bu satıra gelirse bu isimli user yok demek. User varsa for'un içinde iken return eder ve metod biter.
    }

    public boolean changeUserName(String userId, String newName) {
        for (User u : userList) {
            if (u.getId().equals(userId)) {
                u.setName(newName);
                return true;
            }
        }
        return false;// Bu id'li kullanıcı yok.
    }

}
