package org.embedded.beaglebone.driver.kernel.rotaryEncoder;

public interface RotaryControllerInterface  extends Runnable {

	public void setValue(int value);
	
}
