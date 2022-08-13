import java.util.Scanner;
import java.lang.Math;
public class dyn_knapsack {
    static void sop(String text)
    {
        System.out.println(text);
    }
    Scanner in=new Scanner(System.in);
    public static void main(String args[])
    {
        dyn_knapsack obj =new dyn_knapsack();
        int n,W,V[];
        sop("Enter the weight capacity of the knapsack :");
        W=obj.in.nextInt();
        sop("Enter the number of objects available  :");
        n=obj.in.nextInt();
        
        int w[]=new int[n+1];
        V=new int[n+1];
        sop("Enter the weight of individual objects ");
        for(int i=1;i<n+1;i++)
        w[i]=obj.in.nextInt();
        
        sop("Enter the value (price) of individual objects ");
        for(int i=1;i<n+1;i++)
        V[i]=obj.in.nextInt();
        
        int v[][]=new int[n+1][W+1];
        for(int i=0;i<=n;i++)
        v[i][0]=0;
        for( int j=0; j<=W; j++)
        v[0][j]=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(j<w[i])
                {  // sop(""+w[i]);
                    v[i][j]=v[i-1][j];
                }
                else
                {
                  v[i][j]=  Math.max(v[i-1][j],V[i]+v[i-1][j-w[i]]);
                }
            }
        }
        sop("The cost matrix is : ");
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                System.out.print(v[i][j]+" ");                
            }
            sop("");
        }

        sop("Optimal solution (max possible profit is ) : "+v[n][W]);
    }
    
}
