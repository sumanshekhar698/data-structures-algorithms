package com.gfg.live.simple_maths;

import java.util.Arrays;

public class Lec2_ReverseTheArray {


    public static void main(String[] args) {
        int x[] = {
                0, 6, 8, 2, 5, 8, 11
        };

        int i = 0, j = x.length - 1;

        System.out.println(Arrays.toString(x));

        int temp;
        while (i <= j) {
            temp = x[i];
            x[i] = x[j];
            x[j] = temp;
            ++i;
            --j;
        }

        System.out.println(Arrays.toString(x));


    }


}
