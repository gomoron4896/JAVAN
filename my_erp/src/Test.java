import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		String[] strs = { "김기섭", "25", "서울시 도봉구", "oxym4896", "qwe!@#" };
		Map<String, String> map = new HashMap<String, String>();
		map.put("이름", "김기섭");
		map.put("나이", "25세");
		map.put("주소", "서울시 도봉구");
	}
	
	

}

// public static String str = "";
//
// public static String[] split(String str2) {
// int num = 0;
// String strr = str;
//
// for (int i = 0; i < strr.length(); i++) {
// Character c = strr.charAt(i);
// if (c.toString().equals(str2)) {
// num++;
// }
// }
// String[] strArr = new String[num+1];
//
// for (int i = 0; i < num+1; i++) {
// int idx = strr.indexOf(",");
// if (idx == -1) {
// strArr[i] = strr;
// break;
// }
// strArr[i] = strr.substring(0, idx);
// strr = strr.substring(idx + 1);
// }
//
// for(String s : strArr)
// {
// System.out.println(s);
// }
// return strArr;
// }
//
// public static void main(String[] args) {
// str = "A,B,C,D";
// String[] arr = Test.split(",");
//
// }
