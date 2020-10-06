package ch02.main;



import org.springframework.context.support.GenericXmlApplicationContext;

import ch02.sensor.Monitor;

public class MainForSensor {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/config-sensor.xml");
		Monitor monitor = ctx.getBean(Monitor.class);
		System.out.println(monitor);
		ctx.close();
		
	}
}
