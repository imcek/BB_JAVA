/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.driver.kernel.device;

import org.embedded.beaglebone.driver.kernel.jssc.DeviceException;

/**
 * @author a168814
 * GenericDeviceListener.java added on Nov 27, 2014 11:32:46 PM
 */
public interface SelectableDeviceIntf {

	public void dataReceived(byte[] buffer);
	public long getHandle();
	public String getDeviceName();
	public byte[] readBytes() throws DeviceException;
	public boolean isOpen();
	
}
