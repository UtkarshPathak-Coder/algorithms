import java.util.*;
public class floyds {
	Scanner in = new Scanner(System.in);
	int v;
	static void sop(String text)
	{
		System.out.println(text);
	}
	void floyd(int graph[][])
	{   int i,j;
		int dist[][]=new int[v][v];
		for(i=0;i<v;i++)
		{
			for(j=0;j<v;j++)
				dist[i][j]=graph[i][j];
		}
		for (int k = 0; k < v; k++)
	      {
	  
	          for (i = 0; i < v; i++)
	          {
	            
	              for (j = 0; j < v; j++)
	              {
	                  
	                  if (dist[i][k] + dist[k][j] < dist[i][j])
	                      dist[i][j] = dist[i][k] + dist[k][j];
	              }
	          }
	      }
        sop("\nAll source shortest path distance matrix  :");
		for (i=0; i< v ; i++) 
		{
			for(j=0 ; j < v ; j++)
			    System.out.print(dist[i][j]+" ");
		
            sop("");
        }

		//sop();
		
		
}
	public static void main(String[] args) 
	{
		
		int i,j;
		floyds a=new floyds();
		sop("Enter the number of verices");
		a.v=a.in.nextInt();
		sop("Enter the adjacency matrix");
		int graph[][]=new int[a.v][a.v];
		for(i=0;i<a.v;i++)
		{
			for(j=0;j<a.v;j++)
				graph[i][j]=a.in.nextInt();
                // int()
		}
		
		a.floyd(graph);
	}

}
