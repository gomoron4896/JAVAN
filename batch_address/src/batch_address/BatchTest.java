package batch_address;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

import com.own.batch.dao.impl.BatchDAOImpl;

public class BatchTest {

	private Log log = LogFactory.getLog(this.getClass());

	public static void main(String[] args) throws IOException {
		String path = "C:\\jsp_study\\zipcode_DB";
		File f = new File(path);
		System.out.println("폴더 유무 : " + f.isDirectory());
		System.out.println("폴더 유무 : " + f.exists());
		File[] fList = f.listFiles();
		List<List<String>> list = new ArrayList<List<String>>();
		for (File ff : fList) {
			if (ff.getName().endsWith("경기도.txt")) {
				list = new ArrayList<List<String>>();
				FileInputStream fis = new FileInputStream(ff);
				InputStreamReader fr = new InputStreamReader(fis, "EUC-KR");
				BufferedReader br = new BufferedReader(fr);
				br.readLine();
				String line;
				while ((line = br.readLine()) != null) {
					String[] strs = line.split("\\|");
					List<String> strList = new ArrayList<String>();
					for (int i = 0, max = 13; i <= max; i++) {
						strList.add(strs[i]);
					}
					list.add(strList);
				}
				br.close();
				fr.close();
				BatchDAOImpl bdao = new BatchDAOImpl();
				System.out.println("파일명 - " + ff.getName());
				int rCnt = bdao.insert(list);
				System.out.println("적용 개수 - " + rCnt);
				System.out.println("");
			}

		}
	}
}
