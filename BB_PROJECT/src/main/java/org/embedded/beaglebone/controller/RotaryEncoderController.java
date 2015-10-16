package org.embedded.beaglebone.controller;

import org.embedded.beaglebone.driver.kernel.chardev.BBNative;
import org.embedded.beaglebone.driver.kernel.rotaryEncoder.RotaryControllerInterface;
import org.embedded.beaglebone.messages.BBMessages;


public class RotaryEncoderController implements RotaryControllerInterface{
	
	/**
	 * 
	 * Then register listeners
	 * @return
	 */
	int value;
	
	public RotaryEncoderController(int val) {
		this.value= val;
	}
	
	public RotaryEncoderController() {
	}
	

	public void run() {
		DeviceManager.info("RotaryEncoder State = "+String.valueOf(value));
		LcdController.getInstance().lcdGoTo((byte)2, (byte)1);
		switch (value) {
		case 1:
			LcdController.getInstance().writeToLcd(BBMessages.getMessage("menu"), true);
			BBNative.writeLcdLine(BBMessages.getMessage("menu"));
			//BBNative.gpioSetValue(BBGpio.GPIO_26, BBGpio.HIGH);
			break;
		case 2:
			LcdController.getInstance().writeToLcd(BBMessages.getMessage("reports"), true);
			//BBNative.gpioSetValue(BBGpio.GPIO_26, BBGpio.HIGH);		
			break;
		case 3:
			LcdController.getInstance().writeToLcd(BBMessages.getMessage("settings"), true);
			break;
		case 4:
			LcdController.getInstance().writeToLcd(BBMessages.getMessage("program"), true);
			break;
		case -1:
			LcdController.getInstance().writeToLcd(BBMessages.getMessage("other"), true);
			break;
		default:
			break;
		}
		// TODO Auto-generated method stub
		
	}


	public void setValue(int value) {
		this.value = value;
	}
	
	
}
