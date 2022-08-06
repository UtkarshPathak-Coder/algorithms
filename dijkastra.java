import java.util.*;
public class dijkastra {
	static void sop(String text)
	{
		System.out.println(text);
	}
	
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int v,i,src,j,unvis=0,vertex=0;
		sop("Enter the number of vertices  : ");
		v=in.nextInt();
		
		int dist[]=new int[v];
		int visited[]=new int[v];
		int adj[][]=new int[v][v];
		
		sop("Enter the adjacency matrix : ");
		for(i=0;i<v;i++)
		{
			for(j=0;j<v;j++)
			{		
				adj[i][j]=in.nextInt();
				
			}
		}
		sop("Enter the source vertex");
		src=in.nextInt();
		
		for(i=0;i<v;i++)
		{
			visited[i]=0;
			dist[i]=adj[src-1][i];				
		}
		visited[src-1]=1;
		for(i=0;i<v;i++)
		{	int min=9999;
			for(j=0;j<v;j++)
			{
				if((dist[j]<min)&& visited[j]==0)
				{
					min=dist[j];
					unvis=j;
				}
			}
			
			visited[unvis]=1;
			for(j=0;j<v;j++)
			{	if(visited[j]==0)
				{	vertex=j;
					if(dist[vertex]>dist[unvis]+adj[unvis][vertex])
					{
						dist[vertex]=dist[unvis]+adj[unvis][vertex];
					}
				}
			}
			
		}
		for (i=0;i<v;i++)
		{
			sop("Shortest path from "+(src)+" to "+(i+1)+" is : "+dist[i] );
		}
		
	}

}
