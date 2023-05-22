import java.util.ArrayList;
import java.util.List;

public class ProductService {
    List<Product>products = new ArrayList<>();
    ProductDB db=new ProductDB();
    public void addProduct(Product p){
        db.save(p);
    }

    public List<Product> getAllProducts(){
        return db.getAll();
    }

    public List<Product> getProduct(String name){
        return db.getProductWithName(name);
    }
    public  List<Product> OutOfWarranty(){
        System.out.println("Details of the products which are out of warranty:");
        return  db.getOutofWarranty();
    }
    public List<Product> getProductWithString(String searchString){
        System.out.println("Details of the products which contain the given string");
        return db.getWithString(searchString);
    }
}
