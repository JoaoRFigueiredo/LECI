package ex3;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator{
    private List<User> users;

    public ChatMediatorImpl(){
        this.users = new ArrayList<>();
    }

    public void sendMessage(User user, String message){
        for (User u : users){
            if (u != user){
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        // TODO Auto-generated method stub
        users.add(user);
    }   
    
}
