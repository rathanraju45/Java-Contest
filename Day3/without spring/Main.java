import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        ProductService service=new ProductService();
        System.out.println("Select the product service:");
        System.out.println("1.Get all the products\n2.Get deatils of  particular product\n3.Get products which are out of warranty\n4.Get products with a particular String\n5.Add another product");
        System.out.print("Enter the choice:");
        int choice=s.nextInt();
        s.nextLine();
        if(choice==1){
            List<Product> products = service.getAllProducts();
            for(Product p:products){
                System.out.println(p);
            }
        }
        else if(choice==2){
            System.out.println("Enter the name to get a particular product");
            String nameOfProduct=s.nextLine();
            System.out.println("Details of the product with name:"+nameOfProduct);
            List<Product> products = service.getProduct(nameOfProduct);
            for(Product p:products){
                System.out.println(p);
            }
        }
        else if(choice==3){
            List<Product> products = service.OutOfWarranty();
            for(Product p:products){
                System.out.println(p);
            }
        }
        else if(choice==4){
            System.out.print("Enter the string to search for the products:");
            String searchString=s.nextLine();
            List<Product> products=service.getProductWithString(searchString.toLowerCase());
            for(Product p:products){
                System.out.println(p);
            }
        }
        else if(choice==5){
            System.out.println("Enter the product details:");
            System.out.println("Enter the name of product:");
            String pname= s.nextLine();
            System.out.println(("Enter the type of product:"));
            String ptype=s.nextLine();
            System.out.println("Enter the place of product:");
            String pplace= s.nextLine();
            System.out.println("Enter the warranty of product:");
            int pwarranty=s.nextInt();
            service.addProduct(new Product(pname, ptype, pplace, pwarranty));
        }
        else{
            System.out.println("Enter the correct choice");
        }
        s.close();
    }
}
