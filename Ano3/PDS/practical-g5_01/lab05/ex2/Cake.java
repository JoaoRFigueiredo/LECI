public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public void setCakeShape(Shape shape){
        this.shape = shape;
    }

    public void setCakeLayer(String layer){
        this.cakeLayer = layer;
    }

    public void setnumCakeLayers(int numCakeLayers){
        this.numCakeLayers = numCakeLayers;
    }

    public void setmidLayerCream(Cream cream){
        this.midLayerCream = cream;
    }

    public void settopLayerCream(Cream cream){
        this.topLayerCream = cream;
    }

    public void setTopping(Topping topping){
        this.topping = topping;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        if(this.numCakeLayers == 1){
            return this.cakeLayer + " with " + this.numCakeLayers + " layers, topped with " + this.topLayerCream + " cream and " + this.topping + ". Message says: '" + this.message + "'.\n" ;
        }else{
            return this.cakeLayer + " with " + this.numCakeLayers + " layers and " + this.midLayerCream + " cream, topped with " + this.topLayerCream + " cream and " + this.topping + ". Message says: '" + this.message + "'.\n" ;
        }
    }
}
