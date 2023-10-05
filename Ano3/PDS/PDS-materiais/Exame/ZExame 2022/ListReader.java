import java.util.ArrayList;
import java.util.List;

public class ListReader {
    //This class will create new Products from a List<Products>

    List<Product> prods = new ArrayList<>();

    public void readList(List<Product> products){
        // TODO Auto-generated method stub
        for (Product p : products) {    
            prods.add(p);
        }
    }

    //print products

    public void printProducts(){
        for (Product p : prods) {
            System.out.println(p);
        }
    }
}
