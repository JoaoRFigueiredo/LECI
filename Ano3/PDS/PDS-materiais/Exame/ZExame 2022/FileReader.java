import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    //This class will create new Products from a file named "cars.txt"
    //The file must be in the same folder as the class
    //The file must have the following format:
    //Type;code;description;points
    //Example:
    //Car;JJ0011;Some old SUV;88.5

    //Instance variable to store the products
    private List<Product> products = new ArrayList<>();

    public void readFile(String path) throws FileNotFoundException {
        // TODO Auto-generated method stub
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(";");
                String type = parts[0];
                String code = parts[1];
                String description = parts[2];
                int points = Integer.parseInt(parts[3]);
                if (type.equals("Car")) {
                    Car car = new Car(code, description, points);
                    products.add(car);
                    //System.out.println(car);
                } else if (type.equals("Van")) {
                    Van van = new Van(code, description, points);
                    products.add(van);
                    //System.out.println(van);
                } else if (type.equals("Motorcycle")) {
                    Motorcycle motorcycle = new Motorcycle(code, description, points);
                    products.add(motorcycle);
                    //System.out.println(motorcycle);
                } else if (type.equals("Jeep")) {
                    Jeep Jeep = new Jeep(code, description, points);
                    products.add(Jeep);
                    //System.out.println(Jeep);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //get products
    public List<Product> getProducts() {
        return products;
    }

}

