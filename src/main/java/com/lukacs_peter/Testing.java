package com.lukacs_peter;
import static com.lukacs_peter.JsonHandling.*;


import org.junit.Test;

import static com.lukacs_peter.Main.knapSack;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;

public class Testing {
    @Test
    public void testValues() {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        assertEquals(String.valueOf(220), knapSack(W, wt, val, n), "60,100,12;10,20,30 should be 220");
    }

    @Test
    public void throwsFileNotFoundExceptionIfFilenameIsEmpty() {

    }
}