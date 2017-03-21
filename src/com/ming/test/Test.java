package com.ming.test;

import java.io.IOException;
import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

public class Test {
	
	public static void main(String[] args) {
		String url = "http://localhost:18083/Hessian/service/remote";

		HessianProxyFactory factory = new HessianProxyFactory();
		com.caucho.hessian.test.Test basic = null;
		try {
			basic = (com.caucho.hessian.test.Test) factory.create(com.caucho.hessian.test.Test.class, url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("hello(): " + basic.hello());
		System.out.println(basic.subtract(1,3));
		try {
			basic.fault();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
