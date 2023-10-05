package ex3;

public class ChatUser extends User {
    
    public ChatUser(String name, ChatMediator mediator){
        super(name, mediator);
    }

    @Override
    public void sendMessage(String message) {
        // TODO Auto-generated method stub
        System.out.println(name + " is sending a message: " + message); 
        mediator.sendMessage(this, message);
   
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received a message: " + message);
    }

    

}
