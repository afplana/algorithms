package me.coursera.algorithms.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class QuickFindUFTest {

    QuickFindUF quickFindUF;

    @BeforeEach
    void setUp(){
        quickFindUF = new QuickFindUF(10);
        quickFindUF.union(5, 8);
    }

    @Test
    void connected() {
        assertTrue(quickFindUF.connected(5, 8));
        assertFalse(quickFindUF.connected(1, 9));
    }

    @Test
    void union() {
        quickFindUF.union(2,3);
        assertTrue(quickFindUF.connected(2, 3));
    }
}