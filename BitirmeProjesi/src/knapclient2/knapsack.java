package knapclient2;

/**
 ** Java Program to Implement Knapsack Algorithm
 **/
 
import java.util.Arrays;
import java.util.Scanner;
 
/** Class Knapsack **/
public class knapsack
{
    public int[] solve(int[] wt, int[] val, int W, int N)
    {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
        
        for (int i = 1; i <= N; i++)
        {
            for (int j = 0; j <= W; j++)
            {
                int m1 = m[i - 1][j];
                int m2 = NEGATIVE_INFINITY; 
                if (j >= wt[i])
                    m2 = m[i - 1][j - wt[i]] + val[i];
                /** select max of m1, m2 **/
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }        
        /** make list of what all items to finally select **/
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--)
        {
            if (sol[n][w] != 0)
            {
                selected[n] = 1;
                w = w - wt[n];
            }
            else
                selected[n] = 0;
        }
        /** Print finally selected items **/
        System.out.println("\nItems selected : ");
        for (int i = 1; i < N + 1; i++){
            if (selected[i] == 1){
            	wt[i]=W+1;
                System.out.print(i +" ");       
            }
        }
        return wt;
    }
    /** Main function 
     * @return **/
    public static int[] main (int[] wt, int[] val, int W, int n) 
    {
        
        knapsack ks = new knapsack();
         ks.solve(wt, val, W, n);
         return wt; 
    }
}