package mothers;
import java.util.Scanner;
import java.util.ArrayList;
public class Mothers {
    public static ArrayList<ArrayList<String>> p = new ArrayList();
       public static ArrayList<String> women = new ArrayList();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        int aa = Integer.parseInt(a);
        for (int c=0;c<aa;c++) {
            String b[] = input.nextLine().split(" ");
          
                int d;
                for(d =0; d<women.size();d++){
                    if(women.get(d).equals(b[0])){
                        break;
                    }
                }
                if(d<women.size()-1){
                p.get(d).add(b[1]);
                if (!women.contains(b[1])) {
                  
                    p.add(new ArrayList<>());
                    women.add(b[1]);}}
            else{
               
                women.add(b[0]); 
                    p.add(new ArrayList<>());
                p.get(p.size()-1).add(b[1]);
                if (!women.contains(b[1])) {
                    p.add(new ArrayList<>());
                    women.add(b[1]);}}}
        
        for (int c=0;c<10;c++) {
           String person = input.nextLine();
           int sister = sister(person);
            int total = total(person);
            System.out.println("Cousins: "+(total-sister-1)+", Sisters: "+sister);
      
        }
 
    }
    public static int sister(String person){
      int sister =0;
        for(int c=0;c<p.size();c++){
            if(p.get(c).contains(person)){
               sister = p.get(c).size()-1;
            }
        }
        return sister;
    }
    public static int total(String person ){
int total =0;
for(int c=0;c<p.size();c++){
                if (p.get(c).contains(person)) {
                   for (int i=0;i<women.size();i++) { 
                        if (p.get(i).contains(women.get(c))) {
                            for (int h=0;h<p.get(i).size();h++) {
                                    total += p.get(women.indexOf(p.get(i).get(h))).size();
                            }
                       }                   
                   }
                }
}
        return total;
}
}

 


