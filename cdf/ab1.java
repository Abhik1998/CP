import java.util.*;

public class ab1{
    static class Pair{
        int xl,xr,y;
        Pair(int a,int b,int c){
            this.xl=a;
            this.xr=b;
            this.y=c;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            
            int a[][]=new int[n][3];
            double dist=0,lasty=0,firsty=0;
            for(int i=0;i<n;i++)
            {
                
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                a[i][2]=sc.nextInt();
                dist += a[i][1]-a[i][0];
            }
            Stack<Pair> st=new Stack<>();
            Arrays.sort(a,(x,y)->x[0]-y[0]);
            //firsty = a[0][2];
            
            st.push(new Pair(a[0][0],a[0][1],a[0][2]));
            double angle = 0,min = Integer.MAX_VALUE;
            for(int i=1;i<n;i++){
                Pair p=st.peek();
                if(p.xr>a[i][0]||isgreat(p, a[i], min))
                {
                     if(p.y>a[i][2]){
                            angle = (double)(p.y - a[i][2])/(a[i][1]-p.xl);
                            min = Math.min(min,angle);
                            Pair tmp = st.pop();
                            st.push(new Pair(a[i][0],a[i][1],a[i][2]));
                            st.push(tmp);
                            //continue;
                        }
                        else
                        {
                            angle = (double)(a[i][2]-p.y)/(p.xr-a[i][0]);
                            st.push(new Pair(a[i][0],a[i][1],a[i][2]));
                            min = Math.min(angle,min);
                        }

                }
                else
                st.push(new Pair(a[i][0],a[i][1],a[i][2]));


            }
            double xr1=a[0][0],xr2=a[n-1][1];
            
            if(!st.isEmpty()) {lasty = st.peek().y;xr2=st.peek().xr;}
            
            while(!st.isEmpty()){
                System.out.println(st.peek().xl);
                xr1 = st.peek().xl;
                firsty = st.pop().y;
            }

            //if(min != Integer.MAX_VALUE)
            dist = (double)xr2 - xr1 + (double)lasty/min - (double)firsty/min;
            System.out.println(dist+" "+min);

    }
    public static boolean isgreat(Pair a,int crd[],double min){
        double angle = (double) Math.abs(a.y - crd[2])/(a.xr - crd[0]);
        return (angle>min);
    }
}