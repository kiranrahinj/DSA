//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int[] constructLowerArray(int[] arr, int n) {
        // code here
int[] smallerOnRight = new int[n];
        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        mergeSort(arr, 0, n-1, index, smallerOnRight);

        return smallerOnRight;
    }

    public static void mergeSort(int[] arr, int start, int end, int[] index, int[] smallerOnRight) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid, index, smallerOnRight);
        mergeSort(arr, mid+1, end, index, smallerOnRight);

        merge(arr, start, mid, end, index, smallerOnRight);
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] index, int[] smallerOnRight) {
        int[] mergedArr = new int[end-start+1];
        int[] mergedIndex = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                mergedArr[k] = arr[i];
                mergedIndex[k] = index[i];
                smallerOnRight[index[i]] += j - mid - 1;
                i++;
            } else {
                mergedArr[k] = arr[j];
                mergedIndex[k] = index[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            mergedArr[k] = arr[i];
            mergedIndex[k] = index[i];
            smallerOnRight[index[i]] += j - mid - 1;
            i++;
            k++;
        }

        while (j <= end) {
            mergedArr[k] = arr[j];
            mergedIndex[k] = index[j];
            j++;
            k++;
        }

        for (k = 0; k < mergedArr.length; k++) {
            arr[start + k] = mergedArr[k];
            index[start + k] = mergedIndex[k];
        }
            
        
//=========================================================================================
        // for(int i=0;i<n;i++){
        //     int count=0;
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j]<arr[i])count++;
        //     }
        //     ans[i]=count;
        // }
        // return ans;
        
    }
}