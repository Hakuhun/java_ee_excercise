package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>();
    
    public void Add(User u){
        users.add(u);
    }
    
    public User getByName(String pName) throws NullPointerException{
        for (User user : users) 
            if (user.getName().equals(pName)) 
                return user;

        throw new NullPointerException();
    }
    
    public List<User> getAll(){
        return users;
    }
}
