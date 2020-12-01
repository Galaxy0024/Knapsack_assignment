package com.lukacs_peter;
import static com.lukacs_peter.JsonHandling.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.lukacs_peter.Main.knapSack;
import static org.junit.Assert.assertEquals;

public class Testing {
    @Test
    public void testValues() {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        assertEquals("60,100,120;10,20,30 should be 220", 220, knapSack(W, wt, val, n));
    }

    @Test
    public void testValues2() {
        int val[] = new int[] { 4, 5, 3, 7 };
        int wt[] = new int[] { 2, 3, 1, 4 };
        int W = 5;
        int n = val.length;
        assertEquals("60,100,120;10,20,30 should be 220", 10, knapSack(W, wt, val, n));
    }

    @Test
    public void zeroIfEmptyArray() {
        int val[] = new int[0];
        int wt[] = new int[0];
        int W = 0;
        int n = 0;
        assertEquals("Empty array's max value should be 0.", 0, knapSack(W, wt, val, n));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundExceptionOnIncorrectArraySize() {
        int val[] = new int[0];
        int wt[] = new int[0];
        int W = 5;
        int n = 5;
        knapSack(W, wt, val, n);
    }

    @Test
    public void catchFileNotFoundExceptionOnEmptyFilename() {
        assertEquals("Function should return with 1, when empty filename is given.", 1, generateJson(""));
    }
}