import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ProductService {
    List<Product>products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }

    public void getAllProducts(){
        System.out.println("Details of all the products:");
        products.forEach(System.out::println);
        // without Stream API
        // for(Product k:products){
        //     System.out.println(k);
        // }
    }

    public void getProduct(String name){
        System.out.println("Details of the product with name:"+name);
        products.stream()
        .filter(p -> p.getName().equals(name))
        .findFirst()
        .ifPresent(System.out::println);
        // without Stream API
        // for(Product p :products){
        //     if(p.getName().equals(name)){
        //         System.out.println(p);
        //         break;
        //     }
        // }
    }
    public void OutOfWarranty(){
        System.out.println("Details of the products which are out of warranty:");
        products.stream()
                .filter(p -> p.getWarranty() < 2023)
                .forEach(System.out::println);
        // without Stream API
        // for(Product k:products){
        //     if(k.getWarranty()<2023){
        //         System.out.println(k);
        //     }
        // }
    }
    public void getProductWithString(String searchString){
        System.out.println("Details of the products which contain the given string");
        products.stream()
                .filter(p -> p.getName().toLowerCase().contains(searchString) ||
                             p.getPlace().toLowerCase().contains(searchString) ||
                             p.getType().toLowerCase().contains(searchString))
                .forEach(System.out::println);
        // without Stream API
        // for(Product k:products){
        //     String name=k.getName().toLowerCase();
        //     String place=k.getPlace().toLowerCase();
        //     String type=k.getType().toLowerCase();
        //     if(name.contains(searchString) || place.contains(searchString) || type.contains(searchString)){
        //         System.out.println(k);
        //     }
        // }
    }
}
