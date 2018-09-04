package batch_address;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AddrDAO;
import dao.impl.AddrDAOImpl;

public class BatchTest {
	
	public static void main(String[] args) throws IOException {
		String path = "C://jsp_study//zipcode_DB";
		File f = new File(path);
		
		System.out.println("폴더 유무 : " +f.isDirectory());
		System.out.println("폴더존재 유무 : " +f.exists());
		
		File[] fList = f.listFiles();
		List<List<String>> list = new ArrayList<List<String>>();
		
		for(File ff:fList) {
			if(ff.getName().endsWith(".txt")) {
				FileInputStream fis = new FileInputStream(ff);
				InputStreamReader fr = new InputStreamReader(fis,"euc-kr");
				BufferedReader br = new BufferedReader(fr);
				String line;
				br.readLine();
				
				while((line=br.readLine()) != null) {
					String[] strs = line.split("\\|");
					List<String> strList = new ArrayList<String>();
					
					for(int i=0, max=9; i<=max; i++) {
						strList.add(strs[i]);
					}
					for(int i=11, max=12; i<=max; i++) {
						strList.add(strs[i]);
					}
					list.add(strList);
				}
				
				br.close();
				fr.close();
				
				AddrDAO ad = new AddrDAOImpl();
				
				try {
					
					System.out.println(ad.insertD(list));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

}
