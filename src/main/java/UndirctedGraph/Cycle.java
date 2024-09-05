package UndirctedGraph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {   //其中，u是v的父节点
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);   //v是w的父节点
            }
            else if (w != u) {
                hasCycle = false;   //w作为v的连通结点已被到防过但又不是v的父节点，说明出现了环路
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
