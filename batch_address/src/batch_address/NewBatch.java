package batch_address;

import java.io.File;

public class NewBatch {
	
	private static final String FILE_LOCATION = "E:\\java_study\\zipcode_DB";
	
	public static void main(String[] args) {
		
		File f = new File(FILE_LOCATION);
		
		System.out.println(f.isDirectory());
		
		System.out.println(f.exists());
		
	}
}
