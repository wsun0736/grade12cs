package cccruleofthree;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class CCCRuleofThree {
         public static int found=0;
          public static ArrayList<ArrayList<String>>graph = new ArrayList();
  public static ArrayList<ArrayList<Integer>>intu = new ArrayList();
  public static ArrayList<ArrayList<Integer>>use = new ArrayList();
  public static ArrayList<ArrayList<Integer>>prevInt = new ArrayList();
  public static ArrayList<ArrayList<String>>rev = new ArrayList();
    public static void main(String[] args) {
String[][]rules = new String[3][];
String[][]revrules = new String[3][2];
Scanner input= new Scanner(System.in);
        rules[0]=input.nextLine().split(" ");
        rules[1]= input.nextLine().split(" ");
        rules[2]=input.nextLine().split(" ");
        for(int c=0;c<3;c++){
            revrules[c][0]= rules[c][1];
            revrules[c][1]= rules[c][0];
        }
        String[]line=input.nextLine().split(" ");
        int num = Integer.parseInt(line[0]);
        for(int h=0;h<num+1;h++){
            if(h!=num){    
    rev.add(new ArrayList<>());}
    graph.add(new ArrayList<>());
    intu.add(new ArrayList<>());
    use.add(new ArrayList<>());
    prevInt.add(new ArrayList<>());
}

rev.get(0).add(line[2]);
     reverse(num,revrules);
        String start = line[1],end =line[2];
        graph.get(0).add(start);
       makegraph(num,rules,end);
       
    ArrayList<String> print = new ArrayList();
String opp;
int l, u;
    int n =0;
    for(int c=num;c>0;c--){
           opp = graph.get(c).get(n);
      l = intu.get(c).get(n);
        u = use.get(c).get(n);
        print.add(Integer.toString(u+1)+" "+Integer.toString(l+1)+" "+opp);
       int nn = n;
       n = prevInt.get(c).get(nn);
        }
           for(int c=print.size()-1;c>=0;c-=1){
               System.out.println(print.get(c));
           }
          


    }
    public static void reverse(int num, String[][]revrules){
            for(int c=1;c<num;c++){
            HashSet<String>aa = new HashSet();
            for(int h=0;h<rev.get(c-1).size();h++){
                for(int l=0;l<rev.get(c-1).get(h).length();l++){
                    for(int k=0;k<3;k++){
                      if(l+revrules[k][0].length()<=rev.get(c-1).get(h).length()){
        if(rev.get(c-1).get(h).substring(l,l+revrules[k][0].length()).equals(revrules[k][0])){
        String qq = rev.get(c-1).get(h).substring(0,l);
        String pp = rev.get(c-1).get(h).substring(l+revrules[k][0].length(),rev.get(c-1).get(h).length());
      String o = qq+revrules[k][1]+pp;
      if(aa.add(o)){
       rev.get(c).add(o);}}}}}}}
    }
    public static void makegraph(int num, String[][]rules, String end){
         for(int c=1;c<num+1;c++){
    
        for(int h =0;h<graph.get(c-1).size();h++){
      
            HashSet<String>aa = new HashSet(); 
      HashSet<String>trys = new HashSet(rev.get(num-c));
      String qq, pp, o;
      
      for(int l=0;l<graph.get(c-1).get(h).length();l++){
        for(int k=0;k<3;k++){
        if(l+rules[k][0].length()<=graph.get(c-1).get(h).length()){
        if(graph.get(c-1).get(h).substring(l,l+rules[k][0].length()).equals(rules[k][0])){
        qq = graph.get(c-1).get(h).substring(0,l);
        pp = graph.get(c-1).get(h).substring(l+rules[k][0].length(),graph.get(c-1).get(h).length());
      o = qq+rules[k][1]+pp;
        int p = trys.size();
        trys.add(o);
        if(trys.size()==p){
    
         if(o.length()<end.length()+5){
              // if(aa.add(o)){
  if(!graph.get(c).contains(o)){
       graph.get(c).add(o);
      intu.get(c).add(l);
       use.get(c).add(k);
       prevInt.get(c).add(h);}}}
      } }}}aa.clear();}}
    }
     

}

