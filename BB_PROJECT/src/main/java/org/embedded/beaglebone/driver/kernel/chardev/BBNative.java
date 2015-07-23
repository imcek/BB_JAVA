package org.embedded.beaglebone.driver.kernel.chardev;

public class BBNative {
	
	public native void initialize();
	public native void gpioSetValue(char port, char state);
	public native void shutDown();

}
