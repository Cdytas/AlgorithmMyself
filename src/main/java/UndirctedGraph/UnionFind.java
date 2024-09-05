package UndirctedGraph;

public class UnionFind {
    private int[] id;  //父链接数组
    private int[] size;  //各个根节点所对应的连通分量的大小
    private int count; //连通分量总数；

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;  //初始时每个结点都是一个连通分量
            size[i] = 1;  //初始时每个结点都是根节点
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        //查找当前树的根节点root
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        //路径压缩
        int dad;
        while (p != id[p]) {
            dad = id[p];
            id[p] = root;   //将p结点直接连接上其所在树的根节点
            p = dad;  //处理p原来的父结点
        }
        return root;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        else if (size[i] < size[j]) {  //小树连接到大树上
            id[i] = j;
            size[j] += size[i];
        }
        else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;  //每次归并总连通分量数都会减一
    }
}
