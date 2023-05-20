import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number:");
        int num=s.nextInt();
        s.close();
        System.out.println(fact(num));
    }
    public static int fact(int num){
        if (num==1){
            return 1;
        }
        return num*fact(num-1);
    }
}
