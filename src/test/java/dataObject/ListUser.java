package dataObject;

import java.util.ArrayList;
import java.util.List;

public class ListUser {
   public List<User> users = new ArrayList<>();
    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
