package com.lukacs_peter;

public class Main {

    private static final String fileName = "items.json";

    private static int max(int a, int b) { return (a > b) ? a : b; }

    // Recursive function, returns the maximum value, what can be put to the knapsack
    public static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more
        // than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        JsonHandling.generateJson(fileName);
        Knapsack knapsack = JsonHandling.readJson(fileName);
        System.out.println(knapSack(knapsack.getMaxWeight(), knapsack.getWeights(), knapsack.getValues(), knapsack.getItemCount()));
    }
}
