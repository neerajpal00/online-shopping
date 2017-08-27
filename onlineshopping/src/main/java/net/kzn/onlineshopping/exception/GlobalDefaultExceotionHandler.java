package net.kzn.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceotionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)

	public ModelAndView abchandlerNoHandlerFoundException111() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Page Not Constructed");
		mv.addObject("errorDescription", "Page is not available dear friend");
		mv.addObject("title", "404 error Page");

		return mv;

	}

	@ExceptionHandler(ProductNotFoundException.class)

	public ModelAndView abchandlerProductNotFoundException111() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product Not Available");
		mv.addObject("errorDescription", "Product is not available dear friend");
		mv.addObject("title", "Product unavailable");

		return mv;

	}
	
	@ExceptionHandler(Exception.class)

	public ModelAndView GlobalException111(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		e.printStackTrace(pw);
		mv.addObject("errorTitle", "contact your administrator");
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title", "Error");

		return mv;

	}

}
