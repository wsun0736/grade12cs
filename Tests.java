package tests;

import java.util.ArrayList;
import java.util.Scanner;

public class Tests {
    
    public static void main(String[] args) {
        String[] binary= {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        String[]hex ={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
      Scanner input = new Scanner(System.in);
        System.out.println("Enter choice");
        System.out.println("1. Convert Binary to Hexadecimal");
        System.out.println("2. Convert Hexadecimal to Binary");
       String choice = input.nextLine();
      
      if(choice.equals("1")){
            System.out.println("Enter numbers");
          String c= input.nextLine();
        
            ArrayList<String>parts = new ArrayList();
            while(c.length()%4!=0){
                c= "0"+c;
            }
           for(int cc=0;cc<c.length();cc+=4){
      
               String j = c.substring(cc,cc+4);
            
               parts.add(j);
               
           }
           String h = "";
        
           for(int l=0;l<parts.size();l++){
               //System.out.println(h);
              for(int k=0;k<binary.length;k++){
                  if(binary[k].equals(parts.get(l))){
                      h+=hex[k];
                      break;
                  }
              }
           }
           System.out.println(h);  
    }else if(choice.equals("2")){
        String h ="";
          System.out.println("Enter the hex");
          String hexa = input.nextLine();
          for(int p=0;p<hexa.length();p++){
              for(int k=0;k<hex.length;k++){
                  if(hex[k].equals(hexa.substring(p,p+1))){
                      h+=binary[k];
                      break;
                  }
              }
          }
          System.out.println(h);
    }
   
}
}