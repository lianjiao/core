package com.lianjiao.core.net;

import java.util.HashMap;

public class RequestParams extends HashMap<String, String>{
	
	/**
	 * 实例变量类型：long
	 * 实例变量名：serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public RequestParams(){
		this.put("platform", "1");//平台
	}

}
