package org.embedded.beaglebone.main;

import org.embedded.beaglebone.constants.BBGpio;
import org.embedded.beaglebone.driver.kernel.chardev.BBNative;


public class BBMain {

	public static void main(String[] args) {
		BBNative first = new BBNative();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from the BeagleBone Blackkkkkkkkkkkkk!");
		try {
			System.out.println(System.getProperty("java.library.path"));
			System.load("/userarea/BB_PROJECT-1.0/lib/libbbnative.so");
		} catch (UnsatisfiedLinkError e) {
			System.err.println("Native code library failed to load.\n" + e);
			System.exit(1);
		}
		first.initialize();
		first.gpioSetValue(BBGpio.GPIO_67, BBGpio.HIGH);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		first.gpioSetValue(BBGpio.GPIO_67, BBGpio.LOW);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		first.gpioSetValue(BBGpio.GPIO_67, BBGpio.HIGH);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		first.gpioSetValue(BBGpio.GPIO_67, BBGpio.LOW);
		first.gpioSetValue(BBGpio.GPIO_68, BBGpio.HIGH);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		first.gpioSetValue(BBGpio.GPIO_68, BBGpio.LOW);
		first.gpioSetValue(BBGpio.GPIO_44, BBGpio.HIGH);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		first.gpioSetValue(BBGpio.GPIO_44, BBGpio.LOW);
		
		first.shutDown();
		
//		System.out.println(System.getProperty("os.arch"));
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("os.version"));
//		System.out.println(System.getProperty("user.name"));
	}

}
