package memoization;
import java.util.*;

//this is optimised version for recursion since in recursion, we may call same function more than once
//in this memoization we maintain a table and store values while doing recursion and use them when needed
//how to choose that to store in dp table??
//we must store values which are changing... like here n,W are changing so t[n+1][W+1]

import java.util.*;
public class Knapsack01{
    static int[][] t;
    private static int knapsack(int[] val,int[] w,int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        if(t[n][W]!=-1){
            return t[n-1][W-1];
        }
        if(W>=w[n-1]){
            return t[n][W]=Math.max(val[n-1]+knapsack(val,w,W-w[n-1],n-1),knapsack(val,w,W,n-1));
        }
        else{
            return t[n][W]=knapsack(val,w,W,n-1);
        }
    }
    public static void main(String args[]){
        int val[]={1,2,3};
        int w[]={4,5,1};
        int W=4,n=3;
        t=new int[n+1][W+1];
        for(int i=0;i<=n;i++)Arrays.fill(t[i],-1);
        System.out.println(knapsack(val,w,W,n));
    }
}
