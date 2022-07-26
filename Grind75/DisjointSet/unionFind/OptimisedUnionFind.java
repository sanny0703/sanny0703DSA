package DisjointSet.unionFind;

public class OptimisedUnionFind {
    private int[] root;
    private  int[] rank;
    public OptimisedUnionFind(int n){
        root = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x){
        if(x == root[x])
            return x;
        return  root[x]=find(root[x]);
    }
    public void  union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!= rootY){
            if(rank[rootX]>rank[rootY])
                root[rootY] = rootX;
            else if( rank[rootY]>rank[rootX])
                root[rootX]=rootY;
            else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public boolean connected(int x,int y){
        return find(x) == find(y);
    }
    /**
     * TC:
     * find:O(1),union:O(1), connected:O(1),constructor:O(N)
     */
}
