
package recussion51;
import java.util.Scanner;

public class Recussion51 {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the divided");
      int  a=input.nextInt();
      System.out.println("Enter the diviser"); 
      int b=input.nextInt();
      int c=0;
        int count=0;
        calc(a,b,c,count);
    }
    public static void calc(int a, int b, int c, int count){
      
        
        if(c+b<a){
            c+=b;
            count ++;
       
        calc(a,b,c,count);
            
        }else{
            int rem = a-c;
            System.out.println("The remainder is "+ rem);
            System.out.println("The divident is "+ count);
        }
    }
    
}
