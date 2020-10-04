boolean findit(int[][] g, int val){
    int mx = m;
    int mxx = -1;
    int my = n;
    int mxy = -1;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(g[i][j]==val){
                mx = Math.min(mx, i);
                mxx = Math.max(mxx, i);
                my = Math.min(my, j);
                mxy = Math.max(mxy, j);
            }
        }
    }

    for(int i=mx; i<=mxx; i++)
        for(int j=my; j<=mxy; j++)
            if(g[i][j]!=val && g[i][j]!=0)  
                return false; 
    for(int i=mx; i<=mxx; i++)
        for(int j=my; j<=mxy; j++)
            g[i][j]=0;
    
    return true;
}

int m = 0; int n = 0;

public boolean isPrintable(int[][] g) {
    
    m = g.length;  n = g[0].length;
    
    Set<Integer> set = new HashSet<>();
    for(int i=0; i<m; i++)
        for(int j=0; j<n; j++)
            set.add(g[i][j]);

    while(!set.isEmpty()){
        Iterator<Integer> it = set.iterator();
        boolean flag = false;
        while(it.hasNext()){
            int next = it.next();
            if(findit(g, next)){
                it.remove();
                flag = true;
            }
        }
        if(!flag)
            break;
    }
    
    return set.isEmpty(); 
}