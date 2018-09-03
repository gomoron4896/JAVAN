package test;

import java.util.ArrayList;
import java.util.List;

class FileItem {
	private String name;
	private String string;

	public FileItem(String name, String string) {
		super();
		this.name = name;
		this.string = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "FileItem [name=" + name + ", string=" + string + "]";
	}

}

public class FileTest {

	public static List<FileItem> parse() {
		List<FileItem> fList = new ArrayList<FileItem>();
		FileItem fi = new FileItem("tmName","신과 함께");
		fList.add(fi);
		fi = new FileItem("tcPrice","20000");
		fList.add(fi);
		fi = new FileItem("tcDesc","원작 웹툰");
		fList.add(fi);
		return fList;
	}

	public static void main(String[] args) {
		List<FileItem> fList = parse();
		for(FileItem fi : fList) {
			for(int i=0;i<fi.getClass().getMethods().length;i++) {
				int nameSep = fi.getClass().getMethods()[i].toString().lastIndexOf(".");
				String mName = fi.getClass().getMethods()[i].toString().substring(nameSep+1);
				if(mName.equals("getString")) {
				}
			}
			
		}
		System.out.println(fList.get(0).getClass().getFields().length);

	}

}
