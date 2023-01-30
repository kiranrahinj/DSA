//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution{
public:
	int maxSortedAdjacentDiff(int* arr, int n) {
	  int maximum=INT_MIN;

     sort(arr,arr+n,greater<int>());

     if(n<2) return 0;

      else{

        

        for(int i=0;i<n-1;i++){

            if(abs(arr[i]-arr[i+1])>maximum){

                maximum=abs(arr[i]-arr[i+1]);

            }

        }

    }

    return maximum;
	}
};

//{ Driver Code Starts.


int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int a[n];
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.maxSortedAdjacentDiff(a, n);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends