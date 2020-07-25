package com.stenal.pp;

import java.util.Arrays;

/*
Author: Stenal P Jolly
Problem:
1. Given an array, rotate the array to the right by k steps, where k is non-negative.
Example:
Input: [1,2,7,8,9] & k=3 (3 steps)
Output: [7,8,9,1,2]

 */

public class RotatePrb {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        if (test.runTest()) {
            System.out.println("All test passed");
        }else {
            System.out.println("Tests failed");
        }
    }

    static class Test {
        boolean runTest(){
            boolean result = true;
            result &= test();
            result &= test2();
            result &= test3();
            result &= test4();
            return result;
        }

        boolean test(){
            RotatePrb rotatePrb = new RotatePrb();
            int[] test =  {1,2,7,8,9};
            int[] result = {7,8,9,1,2};
            rotatePrb.rotate(test, 3);
            return Arrays.equals(test, result);
        }

        boolean test2(){
            RotatePrb rotatePrb = new RotatePrb();
            int[] test =  {1,2,3};
            int[] result = {1,2,3};
            rotatePrb.rotate(test, 6);
            return Arrays.equals(test, result);
        }

        boolean test3(){
            RotatePrb rotatePrb = new RotatePrb();
            int[] test =  {1,2,3};
            int[] result = {1,2,3};
            rotatePrb.rotate(test, 0);
            return Arrays.equals(test, result);
        }

        boolean test4(){
            RotatePrb rotatePrb = new RotatePrb();
            int[] test =  {1,2,3,4,5};
            int[] result = {5,1,2,3, 4};
            rotatePrb.rotate(test, 1);
            return Arrays.equals(test, result);
        }

    }
}



