package com.mycompany.mavenproject2;

public class UserService {
    
    UserRepository repo = new UserRepository();
    
    public boolean isExist(User u){
        for (User user : repo.getAll()) {
            if (user.getName().equals(u.getName())) {
                return true;
            }
        }
        return false;
    }
}
