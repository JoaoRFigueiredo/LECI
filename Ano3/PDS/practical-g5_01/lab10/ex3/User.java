package ex3;

abstract class User {
    protected String name;
    protected ChatMediator mediator;



    public User(String name, ChatMediator mediator){
        this.name = name;
        this.mediator = mediator;
    }


    public String getName(){
        return name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);

    
}
