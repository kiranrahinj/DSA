//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
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
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String word;
    int step;
    
    public Pair(String word,int step){
        this.word=word;
        this.step=step;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair>q =new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String>st=new HashSet<>();
        
        for(String a:wordList){
            st.add(a);
        }
        st.remove(startWord);
        
        while(q.size()>0){
            Pair p=q.remove();
            int step=p.step;
            String word=p.word;
            
            if(targetWord.equals(word)==true)return step;
            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char wordArr[]=word.toCharArray();
                    wordArr[i]=ch;
                    String replaceWord=String.valueOf(wordArr);
                    
                    if(st.contains(replaceWord)){
                        q.add(new Pair(replaceWord,step+1));
                        st.remove(replaceWord);
                    }
                }
            }
        }
        return 0;
    }
}