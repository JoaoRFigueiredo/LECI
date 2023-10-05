public interface Component{
    void draw();
    String getName();
    double getWeight();
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
    
}