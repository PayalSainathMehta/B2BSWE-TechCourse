public class DecodeWays {
	   public static int numDecodings(String s) {
	        	int[] dp  = new int[s.length() + 1];
	        	//number of ways to decode a string of length 0
	        	dp[0] = 1;
	        	//number of ways to decode a string of length 1. 
	        	//so we have mappings for everything between 1-9 but not 0
	        	dp[1] = s.charAt(0) == '0' ? 0 : 1;
	        	for(int i = 2; i <= s.length(); i++) {
	        		//we see the current character
	        		int oneDigit = Integer.valueOf(s.substring(i-1,i));
	        		//we see previous and current character
	        		int twoDigits = Integer.valueOf(s.substring(i-2,i));
	        		
	        		
	        		//Just checking the mappings
	        		//if indeed its between 1 and 9 , then we add it
	        		if(oneDigit >= 1)
	        			dp[i] += dp[i-1];
	        		//if its between 10 and 26 inclusive, we add it
	        		if(twoDigits >= 10 && twoDigits <= 26)
	        			dp[i] += dp[i-2];
	        	}
	        	return dp[s.length()];
	    }
	   
	public static void main(String[] args) {
		   	String s = "123";
		   	System.out.println(numDecodings(s));
	}
}
