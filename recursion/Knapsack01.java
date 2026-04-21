package recursion;
// this is recursive code for solving 0/1 knapsack 
// 0/1 knapsack is basically where u can add either 0 items or 1, no in between

import java.util.*;
public class Knapsack01{
    private static int knapsack(int[] val,int[] w,int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        if(W>=w[n-1]){
            return Math.max(val[n-1]+knapsack(val,w,W-w[n-1],n-1),knapsack(val,w,W,n-1));
        }
        else{
            return knapsack(val,w,W,n-1);
        }
    }
    public static void main(String args[]){
        int val[]={1,2,3};
        int w[]={4,5,1};
        int W=4,n=3;
        System.out.println(knapsack(val,w,W,n));
    }
}