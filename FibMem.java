import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FibMem {
    private static Map<Integer,Integer> cache =new HashMap<>();
    public static void main(String[] args) {
        int n;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the position:");
        n=s.nextInt();
        s.close();
        System.out.print(fib(n));
    }
    public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        if (cache.containsKey(n)){
            return cache.get(n);
        }
        int result=fib(n-1)+fib(n-2);
        cache.put(n,result);
        return result;
    }   
}
