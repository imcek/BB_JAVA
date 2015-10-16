package org.embedded.beaglebone.driver.kernel.chardev;

public class BBNative {
	
	public native static void initialize();
	public native static void gpioSetValue(char port, char state);
	public native static void sendLcdCommand(char cmd);
	public native static void writeLcdLine(String line);
	public native static void shutDown();

}
