
package shahir;
import java.util.*;
 class Graph 
{ 
    private int V;   
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

 void printShortestDistance(int s,int dest) 
{ 
    // predecessor[i] array stores predecessor of 
    // i and distance array stores distance of i 
    // from s 
    int pred[]=new int[V], dist[]=new int[V]; 
  
    if (BFS(s, dest,  pred, dist) == false) 
    { 
        if(s==dest){
             System.out.println("GO SHAHIR!"); 
        }else{
        System.out.println("NO SHAHIR!"); }
        return; 
    } 
  
    // ArrayList path stores the shortest path 
    ArrayList<Integer> path=new ArrayList<Integer>(); 
    int crawl = dest; 
    path.add(crawl); 
    while (pred[crawl] != -1) { 
        path.add(pred[crawl]); 
        crawl = pred[crawl]; 
    } 
  
    // distance from source is in distance array 
    System.out.println("GO SHAHIR!"); 
  
    // printing path from source to destination 
   // System.out.println( "\nPath is::\n"); 
    //for (int i = path.size() - 1; i >= 0; i--) 
      //  System.out.println( path.get(i) + " "); 
} 
 }
public class Shahir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] a = input.nextLine().split(" ");
       // System.out.println("Yes");
        Graph g = new Graph(Integer.parseInt(a[0])+1);
        for(int c=0;c<Integer.parseInt(a[1]);c++){
            String[]b = input.nextLine().split(" ");
            g.addEdge(Integer.parseInt(b[0]), Integer.parseInt(b[1]));
            g.addEdge(Integer.parseInt(b[1]), Integer.parseInt(b[0]));
        }
     
        int source = Integer.parseInt(a[2]), dest = Integer.parseInt(a[3]); 
        g.printShortestDistance(source, dest); 
    }
}
