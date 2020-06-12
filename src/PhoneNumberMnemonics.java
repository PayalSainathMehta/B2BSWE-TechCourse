import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonics {
	 
	 public  static Map<Integer, String> mapping = new HashMap<Integer, String>() {{
		 
		 	put(2,"abc");
			put(3,"def");
			put(4,"ghi");
			put(5,"jkl");
			put(6,"mno");
			put(7,"pqrs");
			put(8,"tuv");
			put(9,"wxyz");
		 
	 }};
	 
	 
		public static List<String> letterCombinations(String digits) {
			List<String> result = new ArrayList<>();
			combinations(digits, 0, result, new StringBuilder());
			return result;
    }

		private static void combinations(String digits, int current, List<String> result, StringBuilder temp) {
			// TODO Auto-generated method stub
			if(current == digits.length()) {
				result.add(temp.toString());
				return;
			}
			char c = digits.charAt(current);
//			System.out.println(Character.getNumericValue(c1));
			String letters = mapping.get(Character.getNumericValue(c));
			for(char ch: letters.toCharArray()) {
				temp.append(ch);
				combinations(digits, current + 1, result, temp);
				temp.deleteCharAt(temp.length() - 1);
			}
		}
		
		
		public static void main(String[] args) {
			String digits = "23";
			System.out.println(letterCombinations(digits).toString());
		}
}
