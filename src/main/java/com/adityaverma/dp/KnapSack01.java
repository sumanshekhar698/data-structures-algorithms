package com.adityaverma.dp;

public class KnapSack01 {
    public static void main(String[] args) {


        int[] weight = {3, 4, 6, 5};
        int[] value = {2, 3, 1, 4};
        int capacity = 8;
        int n = weight.length;
        System.out.println(knapSack(weight, value, capacity, n));
    }

    static int knapSack(int[] weight, int[] value, int capacity, int n) {

//        Base Condition ( see the smallest valid input)
//        n = 0 ; capacity = 0
        if (n == 0 || capacity == 0)
            return 0;// In the above case, we will have no profit

//We will start selecting from end
//        Choice Diagram
        if (weight[n - 1] <= capacity)
            return Integer.max(value[n - 1] + knapSack(weight, value, capacity - value[n - 1], n - 1)//Max of choose
                    , knapSack(weight, value, capacity, n - 1));//and not choosing it
        else if (weight[n - 1] > capacity)//If the object is not choose-able
            return knapSack(weight, value, capacity, n - 1);

        return 0;//to follow the Java method law
    }

}
