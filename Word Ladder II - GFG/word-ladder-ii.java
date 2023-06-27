//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        HashSet<String>hs=new HashSet<>();
        for(var k:wordList)hs.add(k);
        Queue<ArrayList<String>>q=new LinkedList<>();
        ArrayList<String>al=new ArrayList<>();
        al.add(startWord);
        q.add(al);
        
        ArrayList<String>UsedOnLevel=new ArrayList<>();
        UsedOnLevel.add(startWord);
        
        int level=0;
        ArrayList<ArrayList<String>>ans=new ArrayList<>();
        
        while(q.size()>0){
            ArrayList<String> temp=q.remove();
            
            if(temp.size()>level){
                level++;
                
                for(var k:UsedOnLevel){
                    hs.remove(k);
                }
            }
            String word=temp.get(temp.size()-1);
            if(word.equals(targetWord)){
                if(ans.size()==0)ans.add(temp);
                else if(ans.get(0).size()==temp.size())ans.add(temp);
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char a[]=word.toCharArray();
                    a[i]=ch;
                    String replaceWord=String.valueOf(a);
                    
                    if(hs.contains(replaceWord)){
                        temp.add(replaceWord);
                        ArrayList<String>vec=new ArrayList<>(temp);
                        q.add(vec);
                        UsedOnLevel.add(replaceWord);
                        temp.remove(temp.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}