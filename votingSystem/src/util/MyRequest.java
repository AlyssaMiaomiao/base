package util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	private String encode;

	public MyRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	@Override
	public String getParameter(String name) {
		byte[] bs;
		String value=null;
		try {
			bs = super.getParameter(name).getBytes("ISO-8859-1");
			value=new String(bs,this.encode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}

}
