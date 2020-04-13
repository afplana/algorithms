package me.coursera.algorithms.sort;

import static me.coursera.algorithms.Common.exch;
import static me.coursera.algorithms.Common.less;

public class Quick {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi - 1);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // Add 3-way quicksort
    private static void sort3Way(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        do {
            while (less(a[i++], a[lo])) if (i == hi) break;
            while (less(a[lo], a[--j])) if (lo == j) break;
            exch(a, i, j);
        } while (i < j);

        exch(a, lo, j);
        return j;
    }
}
