package com.eboji.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmxClientUtil {
	private static final Logger logger = LoggerFactory.getLogger(JmxClientUtil.class);
	
	public static String getTomcatPortByMBean() {
		String httpPort = "";
		InetAddress addr = null;
		String ip = "";
		try {
			addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress().toString();
			
			logger.info("ip=" + ip);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		MBeanServer mBeanServer = null;
		List<MBeanServer> mBeanServers = MBeanServerFactory
				.findMBeanServer(null);
		if (mBeanServers.size() > 0) {
			for (MBeanServer _mBeanServer : mBeanServers) {
				mBeanServer = _mBeanServer;
				break;
			}
		}
		if (mBeanServer == null) {
			throw new IllegalStateException("没有发现JVM中关联的MBeanServer.");
		}
		Set<ObjectName> objectNames = null;
		try {

			objectNames = mBeanServer.queryNames(new ObjectName(
					"Catalina:type=Connector,*"), null);
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (objectNames == null || objectNames.size() <= 0) {
			throw new IllegalStateException("没有发现JVM中关联的MBeanServer : "
					+ mBeanServer.getDefaultDomain() + " 中的对象名称.");
		}
		try {
			for (ObjectName objectName : objectNames) {
				String protocol = (String) mBeanServer.getAttribute(objectName,
						"protocol");
				if (protocol.equals("HTTP/1.1")) {
					int port = (Integer) mBeanServer.getAttribute(objectName,
							"port");
					httpPort = String.valueOf(port);
					break;
				}
				// String scheme = (String) mBeanServer.getAttribute(objectName,
				// "scheme");
				// int port = (Integer) mBeanServer.getAttribute(objectName,
				// "port");

			}
		} catch (AttributeNotFoundException e) {
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		} catch (MBeanException e) {
			e.printStackTrace();
		} catch (ReflectionException e) {
			e.printStackTrace();
		}
		
		return httpPort;
	}
}
