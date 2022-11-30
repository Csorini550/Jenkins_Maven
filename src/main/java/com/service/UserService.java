package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    ArrayList<User> userList = new ArrayList<User>();
    public boolean loginValidate(User user) {
        if(user.getUname().equals("admin") && user.getPass().equals("manager")) {
            return true;
        } else {
            return false;
        }
    }
    public void addUser(User user) {
        userDao.addUser(user);
        if(user.getCity().equals("london")){
            throw new RuntimeException("Something went wrong");
        }
        User user2 = new User("sam", "pass","sam@mail.com","mumbai");
        userDao.addUser(user2);
    }

    public void registrationValidation(User user) {
        userList.add(user);
        System.out.println(userList);
    }

    public List<User> loadAll() {

        return userDao.getAllUsers();
    }

    public Boolean findUser(String uname) {
        for (User user : userList) {
            if (user.getUname().equals(uname)) {
                return true;
            }
        }
        return false;
    }

    public Boolean deleteUser(String uname) {
        for (User user : userList) {
            if (user.getUname().equals(uname)) {
                userList.remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean updateUser(String uname, User user) {
            if (findUser(uname)) {
                for (User myUser : userList) {
                userList.set(userList.indexOf(myUser), user);
                }
                return true;
            }
        return false;
    }

}
