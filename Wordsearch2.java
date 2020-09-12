
package wordsearch2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Wordsearch2 {
    public static void main(String[] args) throws FileNotFoundException {
     Scanner word = new Scanner(new File("words.txt"));
   Scanner boards=new Scanner(new File("board.txt"));

   ArrayList<String>words= new ArrayList();
   ArrayList<String>rev = new ArrayList();
   int size= boards.nextInt();
   String [][]board= new String[size][size];
   while(word.hasNext()){
       words.add(word.nextLine());
   }boolean []ifs=new boolean[words.size()];
   for(int c=0;c<ifs.length;c++){
       ifs[c]=false;
   }
   String r= "";
   for(int c=0;c<words.size();c++){
       for(int j=words.get(c).length()-1;j>=0;j--){
           r+=words.get(c).substring(j,j+1);
       }rev.add(r);
       r=""; }
 for(int a=0;a<size;a++){
     String line = boards.next();
     for(int p=0;p<size;p++){
         board[a][p]= line.substring(p,p+1);}}
 for(int a=0;a<size;a++){
     System.out.println();
     //+" "+a+ " "+p
     for(int p=0;p<size;p++){
         System.out.print(board[a][p]);}}
 String line="";
 String vert = "";
    for(int f=0;f<size;f++){
 for(int c=0;c<size;c++){
  line+=board[f][c];
  vert+=board[c][f];
}}
String l ="";
String j= "";

for(int c=0;c<words.size();c++){
    for(int h=0;h<line.length();h+=size){
        int p=h;
        j= vert.substring(h,h+size);
   l=line.substring(p,p+size);

    if(l.contains(words.get(c))||l.contains(rev.get(c))){
        ifs[c]=true;
    }else if(j.contains(words.get(c))||j.contains(rev.get(c))){
        ifs[c]=true;
    }}}String diagonal ="";
    int spota=0;
    for(int k= 0; k<words.size();k++){
    for(int c=0;c<size;c++){
        for(int p= c;p<-(p-size)+size;p++){
            diagonal+=board[p][spota];
          spota+=1;
        }
      spota=0;
      
     if(diagonal.contains(words.get(k))||diagonal.contains(rev.get(k))){
         ifs[k]=true;
         break;
     } diagonal="";
   
   
     
    }}
    String diagonaly="";
    for(int k=0;k<words.size();k++){
for(int c=1;c<size;c++){
        for(int p= c;p<-(p-size);p++){
            diagonaly+=board[spota][p];
          spota+=1;
        }
      spota=0;
     // System.out.println(diagonaly);
     
     
         diagonaly ="";
    }}
    


int spotb=0;
String diagonalx ="";
for(int k=0;k<words.size();k++){
for(int c=size-1;c>=0;c-=1){
   for(int p=c;p>=0;p-=1){
 
       diagonalx+=board[spotb][p];
       spotb++;
       
   }   spotb=0;
  // System.out.println(diagonalx);
    if(diagonalx.contains(words.get(k))||diagonalx.contains(rev.get(k))){
         ifs[k]=true;
         break;
     }
   diagonalx="";
 
}
}
spotb= 6;
String diagonalv= "";
for(int k=0;k<words.size();k++){
for(int c=1;c<size;c++){
    for(int p=c;c<-(p-size)+c;p++){
        diagonalv+=board[spotb][p];
        spotb--;
                }spotb=6; 
               // System.out.println(diagonalv); 
                if(diagonalv.contains(words.get(k))||diagonalv.contains(rev.get(k))){
         ifs[k]=true;
         break;
     }
                diagonalv="";
              
}}System.out.println();
for(int c=0;c<words.size();c++){
    if(ifs[c]){
        System.out.println(words.get(c)+" was found on the board");
    }else{
        System.out.println(words.get(c)+" was not found on the board");
    }
       
    
}
}   
}