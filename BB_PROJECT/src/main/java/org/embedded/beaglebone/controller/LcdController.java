package org.embedded.beaglebone.controller;

import org.embedded.beaglebone.driver.kernel.chardev.BBNative;
import org.embedded.beaglebone.messages.BBMessages;

	public class LcdController {
		
		private static LcdController instance  = new LcdController();

	public static LcdController getInstance() {
		return instance;
	}
	
	public void lcdGoTo(byte x, byte y){
		if(x==1)
			BBNative.sendLcdCommand((char) (0x80+((y-1)%16)));
		else
			BBNative.sendLcdCommand((char) (0xC0+((y-1)%16)));
	}
	
	public void writeToLcd(String line, boolean isPadding){
		int length = line.length();
		if(isPadding){
			if(length<16){
				for (int i = 0; i <16-length; i++) {
					line=line + " ";
				}
			}else if(length>16){
				line.substring(0, 16);
			}
		}else{
			if(length>16){
				line.substring(0, 16);
			}
		}
		BBNative.writeLcdLine(line);
	}
	
}
