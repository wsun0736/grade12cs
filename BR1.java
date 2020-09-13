/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author waynesun
 */
public class BR1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       BufferedReader input = new BufferedReader(new FileReader("a.txt"));
       String line;
       ArrayList<String[]>list = new ArrayList();
      
       while((line =input.readLine())!=null){
          // System.out.println(line);
       String b = line;
           //System.out.println(b);
         String []a = b.split(" ");
         
           list.add(a);
       }
       // System.out.println(list);
       Scanner in = new Scanner(System.in);
       int choice = in.nextInt();
       while(true){
           if(choice ==1){
               
                for(int h=0;h<list.size();h++){
                    System.out.println("");
                    for(int c=0;c<5;c++){
           System.out.print(list.get(h)[c]+" ");
                   choice=0; }}}else if(choice ==2){
               BufferedWriter write = new BufferedWriter(new FileWriter("b.txt"));
            for(int c=0;c<list.size();c++){
                write.newLine();
                for(int h=0;h<list.get(c).length;h++){
                write.write(list.get(c)[h]+",");
                
            }
                
            }write.close();choice=0;
               }
           if(choice ==7){
           break;}
       }
   
      
    }
    
}
