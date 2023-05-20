import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Pascal {
    private static Map<Integer,Integer> cache=new HashMap<>();
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the rows:");
        int n=s.nextInt();
        s.close();
        pas(1,n);
    }
    public static void pas(int m,int n){
        if(m<=n){
        System.out.print(" ".repeat(n-m));
        if(m==1){
            System.out.print("1"+"\n");
            pas(m+1,n);
        }
        else if(m==2){
            System.out.print("1"+" "+"1"+" \n");
            cache.put(0,1);
            cache.put(1,1);
            pas(m+1,n);
        }
        else{
            int index=0;
            Integer arr[]=new Integer[cache.size()];
            for(Integer k:cache.values()){
                arr[index++]=k;
            }
            Integer arr1[]=new Integer[arr.length+1];
            arr1[0]=1;
            for(int i=1;i<arr.length;i++){
                arr1[i]=arr[i-1]+arr[i];
            }
            arr1[arr1.length-1]=1;
            cache.clear();
            for(int i=0;i<arr1.length;i++){
                System.out.print(arr1[i]+" ");
                cache.put(i,arr1[i]);
            }
            System.out.println();
            pas(m+1,n);
        }
    }
    }
}
