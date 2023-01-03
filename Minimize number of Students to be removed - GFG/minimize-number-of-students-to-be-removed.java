//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
      
       List<Integer> temp = new ArrayList<>(N);
        temp.add(H[0]);
       
        for (int i=1; i < N; i++) {
            if (temp.get(temp.size() - 1) < H[i]) {
                temp.add(H[i]);
            } else {
                int idx = Collections.binarySearch(temp, H[i]);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                temp.set(idx, H[i]);
            }
        }
        return N - temp.size();
       
    }
};