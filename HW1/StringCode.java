import java.util.HashSet;
import java.util.Stack;


public class StringCode {

	/* 
	 * String blowup(String str)
	 * 		Related problem: 394.Decode String 
	 * 		https://leetcode.com/problems/decode-string/description/	
	 */
	
    public static String blowup(String str) {
    	if(str==null || str.length()==0){
    		return "";
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<str.length(); i++){		
    		char c = str.charAt(i);
    		if(Character.isDigit(c)){
    			sb.append(generateNchars(str,i));
    		}
    		else{// isLetter
    			sb.append(c);
    		}
    	}
    	
    	return sb.toString();
    }

    private static String generateNchars(String str, int pos){
    	StringBuilder sb = new StringBuilder();
    	
    	if(pos<str.length()-1){
    		char nextChar = str.charAt(pos+1);
    		int  repeatNum= Character.getNumericValue(str.charAt(pos));
    		
    		for(int i=0; i<repeatNum; i++){
    			sb.append(nextChar);
    		}
    	}
    	
    	return sb.toString();
    }
    
	/* 
	 * maxRun(String str)
	 */	
    
	public static int maxRun(String str){
		
		char lastChar = '\0';
		
		int maxNum = 0;
		int num = 0;
		
		for(int i=0; i<str.length();i++){
			
			char cur = str.charAt(i);
			if( cur == lastChar ){
				num++;
			}
			else{
				num = 1;	//num here should be 1 but not 0
			}
				
			lastChar = cur;
			maxNum = Math.max(num, maxNum);
		}
		
		return maxNum;
	}
	
	/* 
	 * stringIntersect(String a, String b, int len)
	 */	
	
	public static boolean stringIntersect(String a, String b, int len){
		//build Hashset
		HashSet<String> setting = new HashSet<>();
		
		for(int i=0; i+len-1< a.length(); i++){
			String cur = a.substring(i, i+len);
			setting.add(cur);
		}
		
		//Check HashSet, compare substring of a/b
		for(int j=0; j+len-1<b.length();j++){
			String cur = b.substring(j, j+len);
			if(setting.contains(cur)){
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		
		
	}

}
