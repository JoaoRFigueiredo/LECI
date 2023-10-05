public class CakeMaster extends Cake{

    private CakeBuilder cakeBuilder;


    public void setCakeBuilder(CakeBuilder c){
        this.cakeBuilder = c;
    }

    public void createCake(String message){
        this.cakeBuilder.addMessage(message);
        this.cakeBuilder.addCakeLayer();
        this.cakeBuilder.addTopLayer();
        this.cakeBuilder.addTopping();
        this.cakeBuilder.createCake();
    }

    public void createCake(Shape shape, int layers, String message){    
        this.cakeBuilder.setCakeShape(shape);
        this.cakeBuilder.addMessage(message);
        for(int i = 0; i < layers; i++){
            this.cakeBuilder.addCakeLayer();
            this.cakeBuilder.addCreamLayer();
        }
        this.cakeBuilder.addTopLayer();
        this.cakeBuilder.addTopping();
        this.cakeBuilder.createCake();
    }

    public void createCake(int layers, String message){
        this.cakeBuilder.addMessage(message);
        for(int i = 0; i < layers; i++){
            this.cakeBuilder.addCakeLayer();
            this.cakeBuilder.addCreamLayer();
        }
        this.cakeBuilder.addTopLayer();
        this.cakeBuilder.addTopping();
        this.cakeBuilder.createCake();
    }

    public Cake getCake(){
        return this.cakeBuilder.getCake();
    }
}
