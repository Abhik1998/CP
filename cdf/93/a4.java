import java.util.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int g=sc.nextInt();
        int b=sc.nextInt();
        int i=0,j=0,k=0;
        ArrayList<Integer> r1=new ArrayList<>();
        ArrayList<Integer> g1=new ArrayList<>();
        ArrayList<Integer> b1=new ArrayList<>();
        for(int u=0;u<r;u++)
        r1.add(sc.nextInt());
        for(int u=0;u<g;u++)
        g1.add(sc.nextInt());
        for(int u=0;u<b;u++)
        b1.add(sc.nextInt());

        Collections.sort(r1);
        Collections.reverse(r1);
        Collections.sort(g1);
        Collections.reverse(g1);
        Collections.sort(b1);
        Collections.reverse(b1);
        long area=0;
        // System.out.println(r1);
        // System.out.println(g1);
        // System.out.println(b1);
        while(i<r&&j<g&&k<b){
            int x =r1.get(i);
            int y =g1.get(j);
            int z =b1.get(k);
            int min = Math.min(Math.min(x,y),z);
            if(min==z){
                i+=1;
                j+=1;
                area = (long) area + (x*y);
            }
            else
            if(min==y){
                i+=1;
                k+=1;
                area = (long) area + (x*z);
            }
            else
            {
                j+=1;
                k+=1;
                area = (long) area + (z*y);
            }
            //System.out.println(area +" "+i+" "+j+" "+k);

        }
        if(i==r){
            while(j<g&&k<b){
                area = (long)area + (g1.get(j)*b1.get(k));
                j+=1;
                k+=1;
            }
        }
        else
        if(j==g){
            while(i<r&&k<b){
                area = (long)area + (r1.get(i)*b1.get(k));
                i+=1;
                k+=1;
            }
        }
        else
        if(k==b){
            while(j<g&&i<r){
                area = (long)area + (g1.get(j)*r1.get(i));
                j+=1;
                i+=1;
            }
        }
        System.out.println(area);


       
        sc.close();

    }
}