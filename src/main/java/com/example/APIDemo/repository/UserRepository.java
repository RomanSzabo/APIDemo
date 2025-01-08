package com.example.APIDemo.repository;

import com.example.APIDemo.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public User getUser(int id) {
        return userList.stream().filter(user -> user.getId() == id).toList().get(0);
    }

    public User getUser(String eid) {
        return userList.stream().filter(user -> user.getEnterpriseId().equals(eid)).toList().get(0);
    }

    public List<User> getUsers() {
        return userList;
    }

    public User addUser(User user) {
        int maxId = userList.stream().max(Comparator.comparingInt(User::getId)).isPresent() ? userList.stream().max(Comparator.comparingInt(User::getId)).get().getId() : 0;
        Date date = new Date();
        user.setId(maxId + 1);
        user.setEnterpriseId(user.getName().toLowerCase() + "." + user.getSurname().toLowerCase());
        user.setCreatedAt(date);
        user.setModifiedAt(date);
        userList.add(user);
        return user;
    }

    public User modify(User user) {
        User old = userList.stream().filter(u -> u.getId() == user.getId()).toList().get(0);
        int idx = userList.indexOf(old);
        Date date = new Date();
        old.setName(user.getName());
        old.setSurname(user.getSurname());
        old.setModifiedAt(date);
        userList.set(idx, old);
        return old;
    }

    public boolean removeUser(int id) {
        try {
            User old = userList.stream().filter(u -> u.getId() == id).toList().get(0);
            userList.remove(old);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
