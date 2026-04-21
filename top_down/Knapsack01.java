package top_down;


//this is more optimal than memoization
//we dont use recursion only dp array is used and we start from base case
//each grid is a sub-problem in the matrix
//1st row and 1st column are base condns, so they are generally 0,-1,1 based on condn
public class Knapsack01 {
    public static void main(String[] args) {
        int[] w={4,5,1};
        int[] val={1,2,3};
        int W=4,n=3;
        int[][] t=new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 ||j==0)t[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(w[i-1]<=j){
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-w[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        System.out.println(t[n][W]);
    }
}
