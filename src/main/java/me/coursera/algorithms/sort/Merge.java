package me.coursera.algorithms.sort;

import static java.lang.System.arraycopy;
import static me.coursera.algorithms.Common.less;

public class Merge {

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        if (hi + 1 - lo >= 0) arraycopy(a, lo, aux, lo, hi + 1 - lo);

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i < mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi);
    }

    private static boolean isSorted(Comparable[] a, int i, int hi) {
        Comparable aux = a[i];
        for (int k = i; k < hi - 1; k++) {
            if (less(a[k + 1], a[k]))
                return false;
        }
        return true;
    }


    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }


    public static void main(String[] args) {

    }
}
