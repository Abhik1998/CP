import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder st=new StringBuilder();
        int k=51;
        while(k-->0)
        st.append('a');
        String s = st.toString();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n+1];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            a[n]=a[n-1];
            int j=0;
            String str[]=new String[n+1];
            if(a[0]!=0)
            str[0]=s.substring(0,a[0]);
            
            int u=100;
            if(a[0]==0)
            str[0]=(char)(u++) + ""+(char)(u);
            System.out.println(str[0]);
            while(j<n){
                int m=0;
                

                // if(a[j]>=a[j-1])
                // {
                //     str[j] = str[j-1];
                //     m = a[j]-a[j-1];
                //     while(m-->0)
                //     str[j]+='z';
                // }
                // else
                // {
                //     str[j] = str[j-1].substring(0,a[j]);
                // }
                int max = Math.max(a[j+1],a[j]);
                if(max!=0&&a[j]==0)
                {
                    if(s.charAt(0)=='a')
                    s = s.replace('a', 'z');
                    else
                    s = s.replace('z', 'a');
                }
                if(max==0){
                    str[j+1]=(char)(u++) + ""+(char)u;
                    
                    System.out.println(str[j+1]);
                    j+=1;
                    continue;
                }
                if(a[j]>=a[j+1])
                {
                    str[j+1]=str[j];
                }
                else
                {
                    str[j+1]=str[j];
                    m=a[j+1]-a[j];
                    while(m-->0)
                    str[j+1]+='z';
                }
                // if(max > a[j])
                // {

                // }
                
                // str[j+1] = str[j].substring(0, max);

                System.out.println(str[j+1]);
                j+=1;

            }
        }
        sc.close();
    }
}