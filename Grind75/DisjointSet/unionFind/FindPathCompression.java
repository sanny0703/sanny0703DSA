package DisjointSet.unionFind;

public class FindPathCompression {
    private int[] root;
    public FindPathCompression(int n){
        root = new int[n];
        for(int i=0;i<n;i++)
            root[i]=i;
    }
    public int find(int x){
        if(x == root[x])
            return  x;
        return root[x] = find(root[x]);
    }
    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!= rootY){
            root[rootY] = rootX;
        }
    }
    public boolean connected(int x,int y){
        return  find(x) == find(y);
    }
}
