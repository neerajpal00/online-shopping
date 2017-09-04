package net.kzn.omlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	//D:\\app\\git\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\
	//private static final String ABS_PATH="D:\\spring\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static final String ABS_PATH="D:\\app\\git\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";

	private static String REAL_PATH="";
	
	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file1, String code) {
		// get the real path
		REAL_PATH=request.getSession().getServletContext().getRealPath("assets/images");
		
		System.out.println("ABS_PATH : =" + ABS_PATH);
		System.out.println("REAL_PATH : =" + REAL_PATH);
		
		//to make sure all directory exists
		//if not than create directory
		
		if(!new File(ABS_PATH).exists()) {
			//create the directory
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			//create the directory
			new File(REAL_PATH).mkdirs();
		}
		
		try{
			//file transfer two places 1 server and 1 under project directory do use 2 transferTo() method
			//server upload
			file1.transferTo(new File(REAL_PATH +code+ ".jpg"));
			
			//project Directory upload
			file1.transferTo(new File(ABS_PATH+code+ ".jpg"));
			
			
		}catch(IOException e) {
			
		}
		
		
	}

}
