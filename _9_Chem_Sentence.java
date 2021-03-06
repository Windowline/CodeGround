import java.util.Scanner;
import java.io.FileInputStream;

import java.util.HashMap;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution
{
  	static String sen;
	static boolean isAns=false;
	static HashMap map;
	
	static boolean cache[][];
	
	static String[] ce
	
	={ "h", "he",
	   "li", "be", "b", "c", "n", "o", "f", "ne", 
	   "na", "mg", "al", "si", "p", "s", "cl", "Ar",
	   "k", "ca", "sc", "ti", "v", "cr", "mn", "fe", "co", "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr",
	   "rb", "sr", "y", "zr", "nb", "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe",
	   "cs", "ba", "*", "hf", "ta", "w", "re", "os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn",
	   "fr", "ra", "**", "rf", "db", "sg", "bh", "hs", "mt", "ds", "rg", "cn",     "fl",       "lv",           
	   
	         "la", "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu",
	         "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr" 
	   
	};
	
	
	public static void main(String args[]) throws Exception	
	{
		int T;
		int test_case;
  		Scanner sc = new Scanner(System.in);
		map = new HashMap();
		for(int i=0; i<ce.length; i++)
		  map.put(ce[i], ce[i]);
		
		T = sc.nextInt();        
		sc.nextLine();
		
		for(test_case = 1; test_case <= T; test_case++) 
		{
			sen = sc.nextLine();

			//	이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			solve();
		}
	}
	
	public static void solve()
	{
		isAns=false;
		cache = new boolean [sen.length()+5][2];
		check(0, 0); 
		check(0, 1);
		if(isAns) 
		  System.out.println("YES");
		else 
		  System.out.println("NO"); 
	}
	
	public static void check(int curIdx, int wLen)
	{
		if(isAns)
		  return;
		
		cache[curIdx][wLen] = true;
		String tmp="";
		
		if(curIdx+wLen>=sen.length()-1)
		{	
			if(curIdx+wLen>sen.length()-1) 
				return; 
				
			else if(curIdx+wLen==sen.length()-1)
			{
				tmp = sen.substring(curIdx, curIdx+wLen+1);
				if(map.containsKey(tmp))
				{
					isAns=true;
					return;
				}
				else
					return;
			}
		}
		
		tmp = sen.substring(curIdx, curIdx+wLen+1);
		
		if(map.containsKey(tmp))
		{
			if(!cache[curIdx+1+wLen][0])
				check(curIdx+1+wLen, 0);
	
			if(!cache[curIdx+1+wLen][1])
				check(curIdx+1+wLen, 1);
		}
		else
			return;
		
	}
    
}
