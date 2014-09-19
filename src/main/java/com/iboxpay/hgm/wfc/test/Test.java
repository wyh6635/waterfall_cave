package com.iboxpay.hgm.wfc.test;

import net.rubyeye.xmemcached.MemcachedClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String...strings) {
		MemcachedClient memcachedClient = null;
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_memcached.xml");
		try {
			memcachedClient = (MemcachedClient)applicationContext.getBean("memcachedClient");
			memcachedClient.delete("spring");
			memcachedClient.delete("springversion");
			memcachedClient.set("spring", 0, "3.1.1.RELEASE");
			
			System.out.println("spring, {" + memcachedClient.get("spring") + "}");
			memcachedClient.replace("spring", 0, "4.0.0.RELEASE is coming");
			System.out.println("spring, {" + memcachedClient.get("spring") + "}");
			memcachedClient.add("springversion", 0, 1);
			System.out.println("springversion, {" + memcachedClient.get("springversion") + "}" );
			System.out.println("test not exists: " + memcachedClient.gets("testss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	