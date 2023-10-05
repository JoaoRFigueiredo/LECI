import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToShare {
    //list of products
    private List<Product> products;
    //Map of products, client
    private Map<Product, Client> clients = new HashMap<>();
    //product quantity
    private int quantity = 0;

    //Map of product: arraylist of clients
    private Map<Product, ArrayList<Client>> subs = new HashMap<>();

    public ToShare() {
        this.products = new ArrayList<>();
    }


    public boolean add(Product p) {
        //add Product p to the list of products
        products.add(p);
        //quantity ++
        quantity++;
        return true;
    }

    public Product remove(String code) {
        //find product with code
        Product p = find(code);
        //if product is not found
        if (p == null) {
            return null;
        }
        //remove product from list of products
        products.remove(p);
        //quantity --
        quantity--;
        return p;
    }

    private Product find(String code) {

        for (Product p : products) {
            if (p.code().equals(code)) {
                return p;
            }
        }
        return null;
    }

    public Product remove(Product p) {
        //remove product from list of products
        //check if produt is in list of products
        if (products.contains(p)) {
            products.remove(p);
            //quantity --
            quantity--;
            return p;
        }
        return p;
    }

    public boolean share(String code, Client user) {
        //Product with code will be shared with user and will be unavailable until giveBack is called
        //find product with code
        Product p = find(code);
        //if product is not found
        if (p == null) {
            System.out.println("Product not found");
            return false;
        }
        //add product to map of products, client
        clients.put(p, user);
        //set product state to unavailable
        p.setState(State.UNAVAILABLE);
        //notify all subscribers
        notifySubscribers(p);

        return true;

    }

    public boolean share(Product p, Client user) {
        //Product will be shared with user and will be unavailable until giveBack is called
        //check if product is in list of products
        if (products.contains(p)) {
            //add product to map of products, client
            clients.put(p, user);
            //set product state to unavailable
            p.setState(State.UNAVAILABLE);
            //notify all subscribers
            notifySubscribers(p);
            return true;
        }
        System.out.println("Product not found");
        return false;

    }

    public boolean giveBack(String code) {
        //Find product with code
        Product p = find(code);
        //if product is not found
        if (p == null) {
            System.out.println("Product not found");
            return false;
        }
        //remove product from map of products, client
        clients.remove(p);
        //set product state to available
        p.setState(State.AVAILABLE);
        //notify all subscribers
        notifySubscribers(p);
        return true;
    }

    public boolean giveBack(Product product) {
        //Check if product is in list of products
        if (products.contains(product)) {
            //remove product from map of products, client
            clients.remove(product);
            //set product state to available
            product.setState(State.AVAILABLE);
            //notify all subscribers
            notifySubscribers(product);
            return true;
        }
        return false;
    }

    public String totalProducts() {
        //return quantity to string
        return Integer.toString(quantity);

    }

    public String sharedProducts() {
        //return product: client to string
        StringBuilder sb = new StringBuilder();
        for (Product p : clients.keySet()) {
            sb.append(p.code() + " shared with " + clients.get(p) + "\n");

        }
        return sb.toString();
    }

   

    public Product[] getProducts() {
        //return products to array
        return products.toArray(new Product[products.size()]);

    }

    public boolean subscribe(Client c, Product p)
    {
        //check if product is in list of products
        if (products.contains(p)) {
            //add client to list of subscribers
            if (subs.get(p) == null) {
                subs.put(p, new ArrayList<Client>());
            }
            subs.get(p).add(c);

            return true;
        }
        return false;
    }

    //Notify subscribers of product when product state changes
    public void notifySubscribers(Product p)
    {
        //check if product is in list of products
        if (products.contains(p)) {
            //check if product is in map of subscribers
            if (subs.get(p) != null) {
                //notify all subscribers
                for (Client c : subs.get(p)) {
                    System.out.println(c + " your product " + p + " is now " + p.getState());
                }
            }
        }
    }

}
