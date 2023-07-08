package org.kosta.icandoit.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CreateThumbnailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uploadPath = request.getSession().getServletContext().getRealPath("/"+"\\upload");
		 System.out.println("request getContentType : " + request.getContentType());
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 10 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());
		
		String fileName = "";
		
		Enumeration files = multi.getFileNames();
		String file = (String)files.nextElement(); 
		fileName = multi.getFilesystemName(file); 
		System.out.println(file);
		ParameterBlock pd = new ParameterBlock();	
		pd.add(uploadPath + "\\" + fileName);
		RenderedOp rOp = JAI.create("fileload", pd);
		BufferedImage bi = rOp.getAsBufferedImage();
		BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB); 
		Graphics2D g = thumb.createGraphics();
	    g.drawImage(bi, 0, 0, 100, 100, null);
	    File file2 = new File(uploadPath + "/sm_"+fileName);
	    ImageIO.write(thumb, "jpg", file2);
	    request.setAttribute("responsebody", fileName); 

		return "AjaxView";
	}


}
