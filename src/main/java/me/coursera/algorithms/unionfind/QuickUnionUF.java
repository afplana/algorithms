package me.coursera.algorithms.unionfind;

/**
 * Implementation of the Quick-Union algorithm (lazy approach)
 * Expensive algorithm, needs N array accesses, the trees can get tall and has an extra cost of find
 * the root element
 */
public class QuickUnionUF {

    private int[] arr;
    private int[] extra;

    /**
     * Init arr of size with each object to itself
     *
     * @param n size of array
     */
    QuickUnionUF(int n) {
        arr = new int[n];
        extra = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
    }

    /**
     * Search in parent pointers until reach the root
     * @param i index of node
     * @return index of root
     */
    int root(int i) {
        if (i == arr[i]) return i;
        return root(arr[i]);
    }

    /**
     * Check if two nodes have the same root
     * @param p node 1
     * @param q node 2
     * @return True if nodes have the same root False in other case
     */
    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     *Change root of p to point to root of q
     * @param p node 1
     * @param q node 2
     */
    void union(int p, int q) {
        arr[root(p)] = arr[root(q)];
    }

    /**
     *Change root of the smallest node to the one with bigger root
     * @param p node 1
     * @param q node 2
     */
    void unionWeighted (int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (extra[i] < extra[j]) {
            arr[i] = j;
            extra[j] += extra[i];
        } else {
            arr[j] = extra[i];
            extra[i] += extra[j];
        }
    }

}
