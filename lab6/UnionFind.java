import org.junit.Test;

public class UnionFind {

    // TODO - Add instance variables
    private int[] items;
    private int[] size;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        items = new int[n];
        size = new int[n];
        for (int i = 0;i < n;i += 1){
            items[i] = i;
            size[i] = 1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex < 0 || vertex > items.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        int t = v1;
        while (items[t] != t){
            t = items[t];
        }
        return size[t];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        if (items[v1] != v1){
            return items[v1];
        }
        return -size[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        int i = v1;
        int j = v2;
        while (items[i] != i){
            i = items[i];
        }
        while (items[j] != j){
            j = items[j];
        }
        if (i == j){
            return true;
        }
        return false;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        if (connected(v1, v2)){
            return;
        }
        int s1 = sizeOf(v1);
        int s2 = sizeOf(v2);
        int r1 = find(v1);
        int r2 = find(v2);
        if (s1 > s2){
            items[r2] = r1;
            size[r1] += size[r2];
        }
        else {
            items[r1] = r2;
            size[r2] += size[r1];
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        while (items[vertex] != vertex){
            vertex = items[vertex];
        }
        return vertex;
    }

    public static void main(String[] str){
        UnionFind test = new UnionFind(8);
        test.union(2,3);
        test.union(2,5);
        test.union(6,7);
        System.out.println(test.sizeOf(3));
    }

}
