//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
      
      Arrays.sort(intervals,(x,y)->(x[0]-y[0]));
      
        int dp[]=new int[n];
      
        for(int i=0;i<n;i++)

         dp[i]=intervals[i][2];

        for(int i=0;i<n;i++)

        {

            for(int j=0;j<i;j++)

            {

                if(intervals[j][1]<=intervals[i][0] && intervals[j][0]<intervals[i][0])

                {

                    dp[i]=Math.max(dp[i],intervals[i][2]+dp[j]);

                }

            }

        }

        int ans=0;

        for(int i=0;i<n;i++)

         ans=Math.max(ans,dp[i]);

        return ans;
    }
}
