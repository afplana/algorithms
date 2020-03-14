package me.coursera.algorithms.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionUFTest {

    QuickUnionUF quickUnionUF;

    @BeforeEach
    void setUp() {
        quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.union(0, 5);
    }

    @Test
    void root() {
        assertEquals(5, quickUnionUF.root(0));
        assertTrue(quickUnionUF.connected(0, 5));
    }

    @Test
    void connected() {
        assertTrue(quickUnionUF.connected(5, 0));
        assertFalse(quickUnionUF.connected(8, 0));
    }

    @Test
    void union() {
        quickUnionUF.union(2, 5);
        assertTrue(quickUnionUF.connected(5, 2));
        assertEquals(5, quickUnionUF.root(2));
        assertNotEquals(2, quickUnionUF.root(5));
    }

    @Test
    void unionWeighted(){
        quickUnionUF.unionWeighted(5, 2);
        assertTrue(quickUnionUF.connected(5, 2));
        assertEquals(5, quickUnionUF.root(2));
        assertNotEquals(2, quickUnionUF.root(5));
    }
}