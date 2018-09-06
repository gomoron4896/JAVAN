package servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String realPath = getServletContext().getRealPath("/upload");
		if (!ServletFileUpload.isMultipartContent(req)) {
			throw new ServletException("WRONG ENCTYPE");
		}

		String path = System.getProperty("java.io.tmpdir");
		System.out.println("TEMP DIRECTORY : " + path);

		DiskFileItemFactory dfac = new DiskFileItemFactory();
		dfac.setRepository(new File(path));
		dfac.setSizeThreshold(1024 * 1024 * 5);

		ServletFileUpload sfu = new ServletFileUpload(dfac);
		try {
			List<FileItem> fList = sfu.parseRequest(req);
			Map<String, String> param = new HashMap<String, String>();
			for (FileItem fi : fList) {
				if (!fi.isFormField()) {
					param.put(fi.getFieldName(),fi.getName());
					File sFile = new File(realPath + File.separator + fi.getName());
					fi.write(sFile); 
				} else {
					param.put(fi.getFieldName(),fi.getString("UTF-8"));
				}
			}
			System.out.println(realPath);
			System.out.println(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(req, res);
	}

}
