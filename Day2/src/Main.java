import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        ProductService service=new ProductService();
        service.addProduct(new Product("Asus vivobook", "Laptop", "Brown Table", 2022));
        service.addProduct(new Product("Redmi note pro", "Mobile", "Black Table", 2023));
        service.addProduct(new Product("Samsung S22", "Tablet", "White Table", 2021));
        service.addProduct(new Product("Iwatch", "Watch", "Black Table", 2023));
        service.addProduct(new Product("Samung S22", "Mobile", "White Table", 2022));
        System.out.println("Select the product service:");
        System.out.println("1.Get all the products\n2.Get deatils of  particular product\n3.Get products which are out of warranty\n4.Get products with a particular String");
        System.out.print("Enter the choice:");
        int choice=s.nextInt();
        s.nextLine();
        if(choice==1){
            service.getAllProducts();
        }
        else if(choice==2){
            System.out.println("Enter the name to get a particular product");
            String nameOfProduct=s.nextLine();
            service.getProduct(nameOfProduct);
        }
        else if(choice==3){
            service.OutOfWarranty();
        }
        else if(choice==4){
            System.out.print("Enter the string to search for the products:");
            String searchString=s.nextLine();
            service.getProductWithString(searchString.toLowerCase());
        }
        else{
            System.out.println("Enter the correct choice");
        }
        s.close();
    }
}
