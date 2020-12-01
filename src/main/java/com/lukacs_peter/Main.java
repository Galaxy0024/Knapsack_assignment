package com.lukacs_peter;

import java.util.Arrays;

public class Main {

    private static final String fileName = "items.json";

    //Get maximum of two values
    private static int max(int a, int b)
    {
        if (a > b)
            return a;
        else
            return b;
    }

    // Recursive function, returns the maximum value, which can be put to the knapsack
    public static int knapSack(int W, int wt[], int val[], int n)
    {
        //Base case
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W) //if nth item's weight is bigger than the maximum weight, we can't use it
            return knapSack(W, wt, val, n - 1);

        else //calculate and return the maximum of a: nth item included, b: nth item not included
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }

    public static void main(String args[])
    {
        JsonHandling.generateJson(fileName); //generate items to file
        Knapsack knapsack = JsonHandling.readJson(fileName); // read knapsack attributes from the file

        //Writing out the results
        System.out.println("Max weight: " + knapsack.getMaxWeight());
        System.out.println("Item weights: " + Arrays.toString(knapsack.getWeights()));
        System.out.println("Item values: " + Arrays.toString(knapsack.getValues()));
        System.out.println("Most valuable knapsack's value: " + knapSack(knapsack.getMaxWeight(), knapsack.getWeights(), knapsack.getValues(), knapsack.getItemCount()));
    }
}
