package com.lukacs_peter;

public class Knapsack {
    private int itemCount;
    private int maxWeight;
    private int[] weights;
    private int[] values;


    public Knapsack(int itemCount, int maxWeight, int[] weights, int[] values) {
        this.itemCount = itemCount;
        this.maxWeight = maxWeight;
        this.weights = weights;
        this.values = values;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getWeights() {
        return weights;
    }
}
