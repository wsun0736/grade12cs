
package shortestpath;
import java.util.*;
 class Graph 
{ 
    private int V;   
    public static int patha=0, pathb=0;
    private LinkedList<Integer> adj[]; 
  
     Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
     void addEdge(int v, int w) 
    { 
        adj[v].add(w);   
       
    } 
  void print(){
       for(int c=0;c<adj.length;c++)System.out.println(adj[c]);
  }
   
  boolean BFS(int s,int dest, int pred[], int dist[]) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V]; 
        for (int i = 0; i < V; i++) { 
             visited[i] = false; 
             dist[i] = Integer.MAX_VALUE; 
             pred[i] = -1; 
         } 
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        dist[s] = 0; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            //System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    dist[n] = dist[s] + 1; 
                    pred[n] = s; 
                    queue.add(n); 
                    // We stop BFS when we find 
                // destination. 
                if (n == dest)return true; 
                } 
            } 
        } 
        return false;
    }  

 void printShortestDistance(int s,int dest, int o) 
{ 
    // predecessor[i] array stores predecessor of 
    // i and distance array stores distance of i 
    // from s 
    int pred[]=new int[V], dist[]=new int[V]; 
  
    if (BFS(s, dest,  pred, dist) == false) 
    { 
        System.out.println("Given source and destination are not connected"); 
      if(0==1){
       patha = -1;
      }else{
          pathb=-1;
      }
    } 
  
    // ArrayList path stores the shortest path 
    ArrayList<Integer> path=new ArrayList(); 
    int crawl = dest; 
    path.add(crawl); 
    while (pred[crawl] != -1) { 
        path.add(pred[crawl]); 
        crawl = pred[crawl]; 
    } 
  
    // distance from source is in distance array 
  
    System.out.println(dist[dest]);
    //printing path from source to destination 
   // System.out.println( "\nPath is::\n"); 
  //for (int i = path.size() - 1; i >= 0; i--) 
       // System.out.println( path.get(i) + " "); 
 if(0==1){
       patha = -1;
      }else{
          pathb=-1;
      }
} 
 }
public class Shortestpath {
    public static void main(String[] args) {
        ArrayList<int[]> points = new ArrayList();
        int h=1;
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String[]aa = a.split(" ");
        while(h<Integer.parseInt(aa[1])+Integer.parseInt(aa[2])+2){
            
        Graph g = new Graph(Integer.parseInt(aa[1]+1));
        if(h<Integer.parseInt(aa[1])+1){  
           // System.out.println("Yes");
            String b =input.nextLine();
            String[]bb = b.split(" ");
            g.addEdge(Integer.parseInt(bb[0]),Integer.parseInt(bb[1]));
             g.addEdge(Integer.parseInt(bb[1]),Integer.parseInt(bb[0]));
        }
       if(h>Integer.parseInt(aa[1])+1&&h<Integer.parseInt(aa[1])+Integer.parseInt(aa[2])+1){
          
           String c = input.nextLine();
            String[]cc = c.split(" ");
            int [] o = new int[2];
        int source = Integer.parseInt(cc[0]), dest = Integer.parseInt(aa[3]); 
           System.out.println("\t"+source+" "+dest);
           if(source==dest)o[0]=0;
           else{
       g.printShortestDistance(source, dest,1); 
          } 
           source = Integer.parseInt(aa[3]); dest = Integer.parseInt(cc[1]);
           if(source==dest)o[0]=0;
           else{
     
           System.out.println("\t"+source+" "+dest);
    g.printShortestDistance(source,dest,2);
          }
          o[0]= Graph.patha;
          o[1]= Graph.pathb;
        points.add(o);
        Graph.pathb=0; 
        Graph.pathb=0;
        }
       h++;
       }
        for(int c=0;c<points.size();c++){
            if(points.get(c)[0]==-1||points.get(c)[1]==-1){
            System.out.println("This is a scam!");
        }
        else{
            System.out.println(points.get(c)[0]+points.get(c)[1]);
        }
        }
    }
}
