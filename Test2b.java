
package test2b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2b {

    public static void main(String[] args) throws FileNotFoundException {
       Scanner file = new Scanner(new File("a.txt"));
       String cipher = file.nextLine();
       String alpha = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Enter a String");
        Scanner input = new Scanner(System.in);
        String sent = input.nextLine();
        translate(cipher,alpha,sent,0);
    }
    public static void translate(String cipher, String alpha, String word, int spot){
        if(spot<word.length()){
       if(word.substring(spot,spot+1).equals(" ")){
           System.out.print(" ");
           translate(cipher,alpha,word,spot+=1);
       }else{
           int q = alpha.indexOf(word.substring(spot,spot+1));
           System.out.print(cipher.substring(q,q+1));
           translate(cipher,alpha,word,spot+=1);
       }}
    }
    
}
