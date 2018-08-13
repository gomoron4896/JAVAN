import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParamTest {
	
	public static void makeData(Map<String,String> data) {
		data.put("key1", "value1");
		data.put("key2", "value2");
		data.put("key3", "value3");
		data.put("key4", "value4");
		data.put("key5", "value5");
		data.put("key6", "value6");
		data.put("key7", "value7");
		data.put("key8", "value8");
		data.put("key9", "value9");
		data.put("key10", "value10");
		data.put("key11", "value11");
		data.put("key12", "value12");
		data.put("key13", "value13");
		data.put("key14", "value14");
		data.put("key15", "value15");
		data.put("key16", "value16");
		data.put("key17", "value17");
		data.put("key18", "value18");
		data.put("key19", "value19");

	}
	
	public static void printData(Map<String,String> data) {
		Iterator<String> it = data.keySet().iterator();
		Iterator<String> it2 = data.values().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = it2.next();
			System.out.println(key+ " " +value);	
		}
		
	}
	
	public String[] test() {
		String[] str = {"a","b"};
		return str;
	}
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		makeData(map);
		printData(map);
		
	}

}
