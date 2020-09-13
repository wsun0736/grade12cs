
package test2;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        System.out.println("Initial");
      int initial = input.nextInt();
        System.out.println("Term");
        int term = input.nextInt();
        find(initial,term,0,0);
    }
    public static void find(int num, int term, int choice, int p){
        if(p==term-1){
            System.out.println(num);
        }
       else if(choice==0){
            num=num*2+3;
            find(num,term,1,p+=1);
        }else if(choice==1){
            num-=2;
            find(num,term,0,p+=1);
        }
    }
    
}
