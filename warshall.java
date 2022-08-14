import java.util.*;
public class warshall {
	Scanner in = new Scanner(System.in);
	int v;
	static void sop(String text)
	{
		System.out.println(text);
	}
	void floyd(int graph[][])
	{   int i,j;
		int r[][]=new int[v][v];
		for(i=0;i<v;i++)
		{
			for(j=0;j<v;j++)
				r[i][j]=graph[i][j];
		}
		for (int k = 0; k < v; k++)
	      {
	  
	          for (i = 0; i < v; i++)
	          {
	            
	              for (j = 0; j < v; j++)
	              {
	                if( ( r[i][j]==1) || ( (r[i][k]==1) && (r[k][j]==1) ) )
                    {
                        r[i][j]=1;
                    }
	                 
	              }
	          }
	      }
        sop("\nAll source path matrix (TRansitive closure) :");
		for (i=0; i< v ; i++) 
		{
			for(j=0 ; j < v ; j++)
			    System.out.print(r[i][j]+" ");
		
            sop("");
        }

		//sop();
		
		
}
	public static void main(String[] args) 
	{
		
		int i,j;
		warshall a=new warshall();
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
