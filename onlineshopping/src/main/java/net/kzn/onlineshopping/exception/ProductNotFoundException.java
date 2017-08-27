package net.kzn.onlineshopping.exception;

public class ProductNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	/*public ProductNotFoundException() {
		this("product not available neerah bhaI");
	}

	public ProductNotFoundException(String msg) {
		this.msg=System.currentTimeMillis() + ":" +msg;
	}*/

	

	public String getMsg() {
		return msg;
	}
	
	

}
