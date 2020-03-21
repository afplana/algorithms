package me.coursera.algorithms.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightedQuickUnionUFTest {

    WeightedQuickUnionUF weightedQuickUnionUF;

    @BeforeEach
    void setUp() {
        weightedQuickUnionUF = new WeightedQuickUnionUF(10);
        weightedQuickUnionUF.union(0, 5);
        weightedQuickUnionUF.union(4, 5);
        weightedQuickUnionUF.union(0, 3);
        weightedQuickUnionUF.union(0, 9);
        weightedQuickUnionUF.union(6, 7);
    }

    @Test
    void find() {
        assertEquals(0, weightedQuickUnionUF.find(5));
    }

    @Test
    void connected() {
        assertTrue(weightedQuickUnionUF.connected(0, 5));
        assertTrue(weightedQuickUnionUF.connected(0, 4));
        assertFalse(weightedQuickUnionUF.connected(7, 5));
    }
}