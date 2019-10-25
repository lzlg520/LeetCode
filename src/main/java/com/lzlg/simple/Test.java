package com.lzlg.simple;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] cont = {4, 1, 2};
        int[] result = fraction(cont);
        System.out.println(Arrays.toString(result));
    }

    public static int[] fraction(int[] cont) {
        int[] result = new int[2];
        if(cont == null) return result;

        int len = cont.length;
        result[0] = cont[len - 1];
        result[1] = 1;
        for(int i = len - 2; i >= 0; i--) {
            int temp = result[0];
            result[0] = result[0] * cont[i] + result[1];
            result[1] = temp;

        }
        return result;
    }
}
