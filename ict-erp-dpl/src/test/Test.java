package test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	public static String byteToBinaryString(byte n) {
	    StringBuilder sb = new StringBuilder("00000000");
	    for (int bit = 0; bit < 8; bit++) {
	        if (((n >> bit) & 1) > 0) {
	            sb.setCharAt(7 - bit, '1');
	        }
	    }
	    return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		String path  = "D:\\t.txt";
		InputStream is = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(is);
		
		if(is!=null) {
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bs = new byte[1024];

		int a = -1;
		while((a = is.read(bs,0,bs.length))!=-1) {
			baos.write(bs,0,a);
		}
		baos.flush();

	    StringBuilder sb=new StringBuilder();
		for(byte b:baos.toByteArray()) {
			int chCode = Integer.parseInt(byteToBinaryString(b),2);
			System.out.println(new Character((char)chCode));
		}
	}
}
