
package stacksi;
import java.util.Stack;
import java.util.Scanner;
        
public class Stacksi {

    public static void main(String[] args) {
      Stack op = new Stack();
      Stack num = new Stack();
      Scanner input = new Scanner(System.in);
        System.out.println("Enter an Expression");
        String qp = input.nextLine();
        String[]line = qp.split(" ");
        num.push(line[0]);
        num.push(line[2]);
        op.push(line[1]);
        String n ="",o="";
        
        for(int c=0;c<line.length;c++){
            if(c%2==0||c==0){
               n+= line[c]+" ";
            }else{
                o+= line[c]+" ";
            }
    
        
        }
     String []ops= o.split(" ");
    String [] var = n.split(" ");
    int[]nums = new int[var.length];
    for(int c=0;c<var.length;c++){
        nums[c]= Integer.parseInt(var[c]);
    }int c=1;
    while(c<ops.length){
int h=c;
        if(order(ops[c-1])<=order(ops[c])){
            op.push(ops[c]);
            num.push(nums[c+1]);
         
        }else{     
            
              while(!op.empty()){
                  if(order(ops[c-1])<order(ops[c]))break;
                String  bb = num.pop().toString();
                String aa= num.pop().toString();
                String t = op.pop().toString();
                int k = check(t,aa,bb);
            
                num.push(k);
        
    }
              op.push(ops[c]);
    num.push(nums[c+1]);
            }
   c++;
        }

   while(!op.empty()){
       String bb= num.pop().toString();
                String aa = num.pop().toString();
                
                String t = op.pop().toString();
    
                int k = check(t,aa,bb);
          
               
                num.push(k);
    }
        System.out.println("The answer is "+num.pop());
 

    }
        public static int order(String t){
            int h=0;
        if(t.equals("+")||t.equals("-"))h=1;
        else if(t.equals("*")||t.equals("/"))h=2;
        else if(t.equals("^"))h=3;
        return h;
    }
      public static int check(String t, String aa, String bb){ 
          int k =1;
          int b = Integer.parseInt(bb);
          int a = Integer.parseInt(aa);
        if (t.equals("+"))k =a+b;
        else if (t.equals("-"))k= a-b;
        else if(t.equals("*"))k = a*b;
        else if(t.equals("/"))k =a/b;
        else if(t.equals("^")){ k =(int)Math.pow(a,b);
        /*   for(int c=0;c<a;c++){
               k*=b;
      
           }*/     
        }
         // System.out.println(k);
        return k;
    }
}
