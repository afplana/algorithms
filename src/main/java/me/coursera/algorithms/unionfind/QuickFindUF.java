package me.coursera.algorithms.unionfind;

/**
 * Implementation of the Quick-Find algorithm
 * This algorithm is safe but not very efficient and takes about N**2 time of accesses to the array
 */
public class QuickFindUF {

    private int[] arr;

    /**
     * Init arr of size with each object to itself
     *
     * @param n size of array
     */
    QuickFindUF(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
    }

    /**
     * Checks whether two nodes are connected or not
     *
     * @param p position of node 1
     * @param q position of node 2
     * @return True if they are connected of false if not
     */
    boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }

    /**
     * Establish link between two nodes if not exist
     * @param p position of node 1
     * @param q position of node 2
     */
    void union(int p, int q) {
        int pArr = arr[p];
        int qArr = arr[q];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pArr) arr[i] = qArr;
        }
    }
}
