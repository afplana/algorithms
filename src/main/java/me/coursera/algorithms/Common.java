package me.coursera.algorithms;

public class Common {
    private Common() {
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void exch(Comparable i, Comparable j) {
        Comparable temp = i;
        i = j;
        j = temp;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
