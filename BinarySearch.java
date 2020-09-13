package binary.search;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {
       String[] words= {"alpha", "apple","bravo","charlie","delta","echo","foxtrot","golf","hotel","india","julliet","kilo","lima","november","mike","oscar","papa","quebec","romeo","sierra","tango","uniform","victer","whisky","x-ray","zulu"};
       ArrayList<String>w = new ArrayList();
       for(int c=0;c<words.length;c++){
           w.add(words[c]);
       }
        ArrayList<String>dic = new ArrayList();
       Scanner input1 = new Scanner(new File("dictionary.txt"));
       while(input1.hasNextLine()){
           dic.add(input1.nextLine());
       }
       MergeSort(dic,0,dic.size()-1);
       /*for(int c=0;c<dic.size();c++){
           System.out.println(dic.get(c));
       }*/
      Scanner input = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = input.nextLine();
        if(binarysearch(dic,word)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    public static boolean binarysearch(ArrayList<String>dic, String word){
        int start = 0, end = dic.size()-1, mid;
        while(start<=end){
            mid = (start+end)/2;
           if(word.equals(dic.get(mid)))return true;
           else if(word.compareToIgnoreCase(dic.get(mid))>0)start = mid+1;
           else end = mid-1;
           // if(word.equals(dic.get(mid)))return true;
        }
        return false;
    }
    public static void MergeSort(ArrayList name, int lo,int n){
int low = lo;
int high = n;
if (low >= high) {
    return;
}

int middle = (low + high) / 2;
MergeSort(name, low, middle);
MergeSort(name, middle + 1, high);
int end_low = middle;
int start_high = middle + 1;
while ((lo <= end_low) && (start_high <= high)) {
    if (name.get(low).toString().compareTo(name.get(start_high).toString())<0) {
        low++;
    } else {
        String TempName = name.get(start_high).toString();
        
        for (int k = start_high- 1; k >= low; k--) {
            name.set(k+1, name.get(k));
          
        }
        name.set(low, TempName);
      
        low++;
        end_low++;
        start_high++;
    }
}
}
    
}
