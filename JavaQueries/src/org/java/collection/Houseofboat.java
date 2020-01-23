package org.java.collection;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Houseofboat {
    
    public static void main(String[] args) {
        Houseofboat hb = new Houseofboat();
        int arr[] = hb.getRandomArray(8);
        System.out.println("Array : " + Arrays.toString(arr));
        hb.pairs2Pointer(arr, 15);
    }

    private int[] getRandomArray(int length) {
        int random[] = new int[length];
        for(int i=0; i<length; i++) {
            random[i] = (int) (Math.random() * 15);
        }
        return random;
    }

    public void missing(int arr[], int n) {
        int count = n-arr.length;
        BitSet bitSet = new BitSet(n);
        for(int num: arr) {
            bitSet.set(num-1);
        }
        int last = 0;
        for(int i=0; i<count; i++) {
            last = bitSet.nextClearBit(last);
            System.out.println(++last);
        }
    }

    public void removeDups(int arr[]) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[j] != -1 && arr[i] == arr[j]) {
                    arr[j] = -1;
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(arr[i] != -1) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public void removeDups2(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int previous = arr[0];
        for(int i=1; i<n; i++) {
            if(previous == arr[i]) {
                arr[i] = -1;
            } else {
                previous = arr[i];
            }
        }
        for(int i=0; i<n; i++) {
            if(arr[i] != -1) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public void smallLargest(int arr[]) {
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < small) {
                small = arr[i];
            }
            if(arr[i] > large) {
                large = arr[i];
            }
        }
        System.out.println("Small: " + small + " Large: " + large);
    }

    public void pairs(int arr[], int sum) {
        int n = arr.length;
        boolean flag = false;
        Set<Integer> set = new HashSet<>(n);
        for(int num: arr) {
            int target = sum - num;
            if(!set.contains(target)) {
                set.add(num);
            } else {
                flag = true;
                System.out.println("("+num+", "+target+")");
            }
        }
        if(!flag) {
            System.out.println("No pair...");
        }
    }

    public void pairs2Pointer(int arr[], int sum) {
        int n = arr.length;
        Arrays.sort(arr);
        for(int left=0, right=n-1; left<right;) {
            if(arr[left] + arr[right] > sum) {
                right--;
            } else if(arr[left] + arr[right] < sum) {
                left++;
            } else {
                System.out.println("(" + arr[left] + ", " + arr[right] + ")");
                left++;
                right--;
            }
        }
    }
}