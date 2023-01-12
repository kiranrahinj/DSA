//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{

public:

    bool isNum(char ch) {

        if(ch >= '0' && ch <= '9') return true;

        return false;

    }

    string decodedString(string s){

        // code here

       string ans;

       

       for(int i = 0; i < s.length(); i++) {

           char ch = s[i];

           if(ch == ']') {

               string toAdd;

               while(ans.back() != '[') {

                   toAdd.push_back(ans.back());

                   ans.pop_back();

               }

               ans.pop_back();

               reverse(toAdd.begin(), toAdd.end());

               string num;

               while(isNum(ans.back())) {

                   num.push_back(ans.back());

                   ans.pop_back();

               }

               reverse(num.begin(), num.end());

               int cnt = stoi(num);

               string expr;

               while(cnt--) expr += toAdd;

               ans += expr;

           }

           else

           ans.push_back(ch);

       }

       return ans;

    }

};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string s;
        cin>>s;
        
        Solution ob;
        cout<<ob.decodedString(s)<<"\n";
    }
    return 0;
}
// } Driver Code Ends