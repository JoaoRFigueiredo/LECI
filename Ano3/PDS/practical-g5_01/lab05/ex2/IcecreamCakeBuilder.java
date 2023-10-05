public class IcecreamCakeBuilder implements CakeBuilder{

    public Shape shape = Shape.Circle;
    private String cakeLayers = "Cold Ice Cream";
    private int numCakeLayers = 0;
    private Cream midLayerCream = null;
    private Cream topLayerCream;
    private Topping topping;
    private String message;
    private Cake cake;

    @Override
    public void setCakeShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void addCakeLayer() {
        this.numCakeLayers++;
    }

    @Override
    public void addCreamLayer() {
        this.midLayerCream = Cream.Vanilla;
    }

    @Override
    public void addTopLayer() {
        this.topLayerCream = Cream.Chocolate;
    }

    @Override
    public void addTopping() {
        this.topping = Topping.Almonds;
    }

    @Override
    public void addMessage(String m) {
        this.message = m;
    }

    @Override
    public void createCake() {
        this.cake = new Cake();
        this.cake.setCakeShape(this.shape);
        this.cake.setCakeLayer(this.cakeLayers);
        this.cake.setnumCakeLayers(this.numCakeLayers);
        this.cake.setmidLayerCream(this.midLayerCream);
        this.cake.settopLayerCream(this.topLayerCream);
        this.cake.setTopping(this.topping);
        this.cake.setMessage(this.message);
    }

    @Override
    public Cake getCake() {
        return this.cake;
    }
    
}
