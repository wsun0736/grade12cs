/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r62;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author waynesun
 */
public class R62 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Random num = new Random();
     int a = num.nextInt(20)+1;
        System.out.println(a);
        Scanner input= new Scanner(System.in);
        System.out.println("Guess");
        int b = input.nextInt();
     if(ifw(a,0)){
         System.out.println("Win");
     }
    }
    public static boolean ifw(int num, int guess){
        if(guess==num){return true;}
        else{
           Scanner input = new Scanner(System.in);
            System.out.println("Guess again");
            if(ifw(num,input.nextInt()))return true;
        }
        return false;
    }
    
}
