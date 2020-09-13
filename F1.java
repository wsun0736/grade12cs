/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author waynesun
 */
public class F1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       Scanner input = new Scanner(new File("a.txt"));
       ArrayList<String>words = new ArrayList();
       ArrayList<Integer>num = new ArrayList();
  
       while(input.hasNext()){
  String[]aa = input.nextLine().split(" ");
  for(int c=0;c<aa.length;c++){ 
      aa[c]= aa[c].replaceAll(",", "");
      if(words.contains(aa[c])){
         
          int a = num.get(words.indexOf(aa[c]));
     num.set(words.indexOf(aa[c]), a+=1);
          
      }else{
          words.add(aa[c]);
          num.add(1);
      }
  }
  for(int c=0;c<words.size();c++){
      System.out.println(words.get(c)+" "+num.get(c));
  }
       }
    }
    
}
