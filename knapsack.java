import java.util.*;
public class knapsack {
    Scanner in =new Scanner(System.in);
    static void sopp(String text)
    {
        System.out.print(text);
       // System.out.println("");
    }
    static void sop(String text)
    {
        System.out.println(text);
    }
    
    float profit[],weight[],/*ratio[]*/c;
    int n;
    float tc=0;
    float x[],ratio[];
    
    void input()
    {   
        sopp("Enter the capacity of the  knapsack : ");
        c=in.nextInt();
        
        sopp("Enter the number of objects");
        n=in.nextInt();    
        
        profit = new float[n];
        weight = new float[n];
        ratio = new float [n];
        x = new float[n];
        sop("Enter the weights of object and profit associated to each object : ");
        
        for(int i=0;i<n;i++)
        {
            sop("");
            sopp("weight "+(i+1)+" : ");
            weight[i]=in.nextInt();
            sopp("profit "+(i+1)+" : ");
            profit[i]=in.nextInt();
            ratio[i]=profit[i]/weight[i];
            x[i]=0;
        }
    }

    void knapsack_func()
    {
        float u=c;
        while(u>0)
        {
            int mini=0;
            float max=ratio[0];
            for(int i=0;i<n;i++)
            {
                if (ratio[i]>max)
                {
                    mini=i;
                    max=ratio[i];
                }
            }
            //ratio[mini]
            if(weight[mini] <= u)
            {
                x[mini]=1;
                ratio[mini]=-1;
                u=u-weight[mini];
                tc+=tc+profit[mini];
            }         
            else 
            {
                x[mini]=u/weight[mini];
                tc+=profit[mini]*x[mini];
                break ;
            }
        }

    }
    void display()
    {
        for(int i=0;i<n;i++)
        {   
            sop("Include "+weight[i]*x[i]+" gram "+"of object number "+(i+1));
        }
        sop("Total profit is  : "+tc);
           
    }
    public static void main(String[] args)  
    {
        knapsack obj =new knapsack();
        obj.input();
        obj.knapsack_func();
        obj.display();
    }
}