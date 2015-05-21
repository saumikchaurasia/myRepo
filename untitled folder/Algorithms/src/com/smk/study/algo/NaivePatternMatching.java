package com.smk.study.algo;

public class NaivePatternMatching {

	public static void main(String[] args) {
		String inp = "This year is unlucky for me";
		String pattern = "year";
		seacrh(inp, pattern);
		char []txt = {'A','B','A','B','D','A','B','A','C','D','A','B','A','B','C','A','B','A','B'};
		char []pat = {'A','B','A','B','C','A','B','A','B'};//ABABCABAB
		int [] ips = new int[pat.length];
		//computeLPSArray(pat,pat.length,ips);
		
		String tdArr[][] = {{"you", "we"},
		        {"have", "are"},
		        {"sleep", "eat", "drink"}};
		int c=1;
		for(int i =0 ; i < 1; i++){
			String val = tdArr[0][i];
			for(int j=1; j<tdArr.length;j++){
				for(int k =0;k<tdArr[j].length;k++){
					System.out.println(tdArr[j][k-c]);
				}
			}
		}
	}

	static int seacrh(String str, String pattern){
		for(int i = 0 ; i < str.length(); i++){
			int subStrIndex = pattern.length() + i;
			
			if(subStrIndex > str.length())
				return -1;
			
			String subStr = str.substring(i,subStrIndex);
			//System.out.println(subStr);
			if(subStr.equals(pattern))
				System.out.println("found : index : "+i + " : "+ subStr);
			
		}
		return 0;
	}
	
	static void computeLPSArray(char []pat, int M, int []lps)
	{
	    int len = 0;  // lenght of the previous longest prefix suffix
	    int i;
	 
	    lps[0] = 0; // lps[0] is always 0
	    i = 1;
	    System.out.println(lps[0]);
	    // the loop calculates lps[i] for i = 1 to M-1
	    while (i < M)
	    {
	       if (pat[i] == pat[len])
	       {
	         len++;
	         lps[i] = len;
	         i++;
	       }
	       else // (pat[i] != pat[len])
	       {
	         if (len != 0)
	         {
	           // This is tricky. Consider the example AAACAAAA and i = 7.
	           len = lps[len-1];
	 
	           // Also, note that we do not increment i here
	         }
	         else // if (len == 0)
	         {
	           lps[i] = 0;
	           i++;
	         }
	       }
	       //ABABCABAB
	       System.out.print(lps[i-1]);
	    }
	}
	 

	   
	   //KMPSearch(pat, txt);
	

}
