
package f2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class F2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("a.txt"));
        Scanner input1 = new Scanner(new File("b.txt"));
        ArrayList<Integer> num = new ArrayList();
        int a = input.nextInt();
        int b = input1.nextInt();
        while(input.hasNext()||input1.hasNext()){
        
            if(a!=0&&b!=0){
       if(a<=b){
                num.add(a);
                if(input.hasNext()){
                      a = input.nextInt(); 
                }else{
                    b=0;
                }
            }
            else if(a>b){
                
                num.add(b);
                if(input1.hasNext()){
                    b = input1.nextInt();
                    
                }else{
                    b=0;
                }
            }    }else{  if(!input.hasNext()){
                while(input1.hasNext()){
                    num.add(input1.nextInt());
                }
            }else if(!input1.hasNext()){
         while(input.hasNext()){
             num.add(input.nextInt());
         }
            }
            }
            
        }
        for(int c=0;c<num.size();c++){
            System.out.print(num.get(c)+" ");
        }
    }
    
}
