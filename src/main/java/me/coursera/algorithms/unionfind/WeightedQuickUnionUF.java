package me.coursera.algorithms.unionfind;

/**
 * Implementation of the Weighted-Quick-Union algorithm
 * Expensive algorithm, needs N array accesses, the trees can get tall and has an extra cost of find
 * the root element
 */
public class WeightedQuickUnionUF {

    private int[] parents;
    private int[] size;
    private int count; // Number of components (between  1..n)

    /**
     * Init arr of size with each object to itself
     *
     * @param n size of array
     */
    public WeightedQuickUnionUF(int n) {
        count = n;
        parents = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Search in parent pointers until reach the root
     *
     * @param p index of node
     * @return index of root
     */
    public int find(int p) {
        validate(p);
        while (p != parents[p])
            p = parents[p];
        return p;
    }


    /**
     * Check if two nodes have the same root
     *
     * @param p node 1
     * @param q node 2
     * @return True if nodes have the same root False in other case
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Improvement over normal {@code QuickUnion}. {@code access = log N}
     * Change root of the smallest node to the one with bigger root
     *
     * @param p node 1
     * @param q node 2
     * @throws IllegalArgumentException unless
     *                                  both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parents.length;
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("Index " + p + " is not in range 0 and " + (n - 1));
    }
}

