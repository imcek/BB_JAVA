/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.driver.kernel.device;

/**
 * @author a168814
 * DeviceDataListener.java added on Nov 27, 2014 11:56:53 PM
 */
public interface DeviceDataListener {
	public void dataReceived(byte[] buffer);
}
