package com.iboxpay.hgm.wfc.test;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.springframework.stereotype.Component;

import com.google.code.yanf4j.core.impl.StandardSocketOption;

@Component("memcachedClientBuilder")
public class XmemcachedClientBuilderEx extends XMemcachedClientBuilder {

	private Class<XMemcachedClientBuilder> clazz = XMemcachedClientBuilder.class;

	private boolean weightFlag = true;

	private int[] weights = null;

	private List<InetSocketAddress> addressList = null;

	/**
	 * 初始化memcached client builder 
	 */
	@PostConstruct
	public void buildConfiguration(){
		try {
			String serverlist = "172.30.0.130:11211:1";
			List<String> cacheNodes = Arrays.asList(serverlist.split(","));
			
			buildCacheNodes(cacheNodes);
			
			this.setConnectionPoolSize(10);
			//Set the receive buffer is 32K, the default 16K
			this.setSocketOption(StandardSocketOption.SO_RCVBUF, 32 * 1024); 
			//Set the transmit buffer is 16K, the default is 8K
			this.setSocketOption(StandardSocketOption.SO_SNDBUF, 16 * 1024);
			//enable the Nagle algorithm to improve throughput, off by default;  
			this.setSocketOption(StandardSocketOption.TCP_NODELAY, false); 
			this.setOpTimeout(3000);
			this.setFailureMode(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 缓存节点
	 * 格式  IP:PORT:WEIGHT
	 * 如  192.168.137.2:11211:1
	 */
	public XmemcachedClientBuilderEx() {
		
	}
	
	/**
	 * 缓存节点
	 * 格式  IP:PORT:WEIGHT
	 * 如  192.168.137.2:11211:1
	 */
	public XmemcachedClientBuilderEx(List<String> cacheNodes) {
		buildCacheNodes(cacheNodes);
	}
	
	/**
	 * 缓存节点
	 * @param cacheNodes
	 */
	private void buildCacheNodes(List<String> cacheNodes) {
		List<Integer> weight = new ArrayList<Integer>();
		StringBuffer sb = new StringBuffer();
		for (String node : cacheNodes) {
			String[] nodeArgs = node.split(":");
			int len = nodeArgs.length;
			switch (len) {
				case 2://只有IP和端口的情况
					sb.append(nodeArgs[0].trim()).append(":").append(nodeArgs[1].trim());
					weightFlag = false;
					break;
				case 3:
					sb.append(nodeArgs[0].trim()).append(":").append(nodeArgs[1].trim());
					weight.add(Integer.parseInt(nodeArgs[2].trim()));
					break;
				default:
					break;
			}
			sb.append(" ");
		}
		addressList = getAddresses(sb.toString());
		weights = buildWeight(weight, weightFlag);
		init(addressList, weightFlag, weights);
	}

	private void init(List<InetSocketAddress> addressList, boolean weightFlag, int[] w) {
		setCacheNode(addressList, weightFlag, w);
		super.setCommandFactory(new net.rubyeye.xmemcached.command.TextCommandFactory());
		super.setSessionLocator(new net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator());
		super.setTranscoder(new net.rubyeye.xmemcached.transcoders.SerializingTranscoder());
	}

	private int[] buildWeight(List<Integer> weight, boolean weightFlag) {
		int[] w = null;
		if (weightFlag) {
			w = new int[weight.size()];
			int i = 0;
			for (Integer wi : weight) {
				w[i++] = wi;
			}
			System.out.println("weight : " + w);
		}
		return w;
	}

	private void setCacheNode(List<InetSocketAddress> addressList, boolean weightFlag, int[] w) {
		Map<InetSocketAddress, InetSocketAddress> addressMap = buildAddressMap(addressList);
		try {
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if (field.getName().equals("addressMap")) {
					field.setAccessible(true);
					field.set(this, addressMap);
				}
				if (weightFlag && field.getName().equals("weights")) {
					field.setAccessible(true);
					field.set(this, w);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<InetSocketAddress, InetSocketAddress> buildAddressMap(List<InetSocketAddress> addressList) {
		Map<InetSocketAddress, InetSocketAddress> addressMap = new LinkedHashMap<InetSocketAddress, InetSocketAddress>();
		if (addressList != null) {
			for (InetSocketAddress addr : addressList) {
				addressMap.put(addr, null);
			}
		}
		return addressMap;
	}

	private List<InetSocketAddress> getAddresses(String nodeInfo) {
		return AddrUtil.getAddresses(nodeInfo);
	}

}