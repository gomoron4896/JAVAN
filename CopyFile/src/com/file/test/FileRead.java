package com.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileRead {
	static Map<String,String> prop = new HashMap<String,String>();
	public static void main(String[]args) throws FileNotFoundException {
		String path = "C:\\test\\ict.txt";
		try {
	
			InputStream is = new FileInputStream(path);
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			String str ;
			while((str=br.readLine())!=null) {
				prop.put(str.split(":")[0],str.split(":")[1]);
			}
				System.out.println(prop.get("classname"));
				System.out.println(prop.get("subject"));
				
				Scanner s = new Scanner(System.in);
				System.out.println("저장할 경로 및 파일명을 적어주셈");
				path=s.nextLine();
				File f = new File(path);
				f.createNewFile();
				OutputStream os = new FileOutputStream(f);
				OutputStreamWriter ow = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWrit+er(ow);
				bw.write("classname: "+prop.get("classname"));
				bw.newLine();
				bw.write("subcject: "+prop.get("subcject"));
				bw.flush();
				br.close();
				bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
