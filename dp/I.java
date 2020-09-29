import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class h{
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=sc.nextInt();
        double p[]=new double[n];
        for(int i=0;i<n;i++)
        p[i]=sc.nextDouble();
        double dp[][]=new double[n][n];
        
        sc.close();
    }
}
/*
11100- 6
11110- 4
11111- 1



*/