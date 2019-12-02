package com.lzlg.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    /**
     * 二维数组转换成稀疏数组
     */
    @org.junit.Test
    public void toSparseArray() {
        int[][] originalArray = {
                {0, 0, 0, 22, 0, 0, 15},
                {0, 11, 0, 0, 0, 17, 0},
                {0, 0, 0, -6, 0, 0, 0},
                {0, 0, 0, 0, 0, 39, 0},
                {91, 0, 0, 0, 0, 0, 0},
                {0, 0, 28, 0, 0, 0, 0}
        };

        int r = originalArray.length;
        int c = originalArray[0].length;

        List<Data> list = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                if (originalArray[i][j] != 0) {
                    Data data = new Data(i, j, originalArray[i][j]);
                    list.add(data);
                }
            }
        }
        int sum = list.size();
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = r;
        sparseArray[0][1] = c;
        sparseArray[0][2] = sum;

        for (int i = 1; i < sparseArray.length; i++) {
            sparseArray[i][0] = list.get(i - 1).r;
            sparseArray[i][1] = list.get(i - 1).c;
            sparseArray[i][2] = list.get(i - 1).v;
        }

//        for (int[] array : sparseArray) {
//            System.out.println(Arrays.toString(array));
//        }
        // 将稀疏数组转换成原始二维数组
        toOriginalArray(sparseArray);
    }

    class Data {
        int r;   // 行
        int c;   // 列
        int v;   // 值

        Data(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    public void toOriginalArray(int[][] sparseArray) {
        int[][] originalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            originalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] array : originalArray) {
            System.out.println(Arrays.toString(array));
        }
    }
}
