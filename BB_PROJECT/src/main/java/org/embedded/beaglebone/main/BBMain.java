package org.embedded.beaglebone.main;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.embedded.beaglebone.controller.LcdController;
import org.embedded.beaglebone.controller.RotaryEncoderController;
import org.embedded.beaglebone.driver.kernel.chardev.BBNative;
import org.embedded.beaglebone.driver.kernel.rotaryEncoder.RotaryControllerInterface;
import org.embedded.beaglebone.driver.kernel.rotaryEncoder.RotaryEncoderReader;
import org.embedded.beaglebone.messages.BBMessages;


public class BBMain {
	
	private static RotaryEncoderController rotarEncoderController = new RotaryEncoderController();

	public static void main(String[] args) {
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
		BBNative.initialize();
		BBNative.sendLcdCommand((char)1);
		BBNative.sendLcdCommand((char)0x0c);
		LcdController.getInstance().lcdGoTo((byte)1, (byte)1);
		LcdController.getInstance().writeToLcd(BBMessages.getMessage("menu"), true);
		try {
			System.err.println("Rotary ENcoder Reader\n");
			RotaryEncoderReader rot_reader = new RotaryEncoderReader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//		while(true){
//			first.gpioSetValue(BBGpio.GPIO_26, BBGpio.HIGH);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			first.gpioSetValue(BBGpio.GPIO_26, BBGpio.LOW);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	//	first.shutDown();
		
	}

	public static RotaryControllerInterface getRotarEncoderController() {
		return rotarEncoderController;
	}

}
