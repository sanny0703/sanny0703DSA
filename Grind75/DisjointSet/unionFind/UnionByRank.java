package DisjointSet.unionFind;

public class UnionByRank {
    private int[] root;
    private int[] rank;
    public UnionByRank(int n){
        rank = new int[n];
        root = new int[n];
        for(int i=0;i<n;i++){
            rank[i]=1;
            root[i]=i;
        }
    }
    public int find(int x){
        /**
         * since we are not blindly adding nodes to each parent, the height of the tree will be at most logN
         * so, TC of find is logN
         */
        while (x!= root[x])
            x= root[x];
        return  x;
    }
    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!= rootY){
            if(rank[rootX]>rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootY]>rank[rootX])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public boolean connected(int x,int y){
        return find(x)==find(y);
    }
    /**
     * Tc:
     * find:(logN), union:O(logN), connected:O(logN), constructor:O(N)
     */
}
