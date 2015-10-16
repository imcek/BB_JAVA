/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.driver.kernel.device;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.embedded.beaglebone.driver.kernel.jssc.DeviceException;
import org.embedded.beaglebone.driver.kernel.jssc.SelectableFile;

/**
 * @author a168814
 * SimpleDeviceDriver.java added on Nov 27, 2014 11:52:10 PM
 */
public class SimpleDeviceDriver implements SelectableDeviceIntf {

	private static final int MAX_NUMBER_OF_BYTES_TO_READ = 2048;
	private SelectableFile device;
	private DeviceDataListener listener;
	
	public SimpleDeviceDriver(String fileName, int flags) {
		device = new SelectableFile();
		device.open(fileName, flags);
	}

	public void dataReceived(byte[] buffer) {
		if(listener!=null)
			listener.dataReceived(buffer);
	}

	public long getHandle() {
		if(device!=null)
			return device.getHandle();
		return -1;
	}

	public String getDeviceName() {
		if(device!=null)
			return device.getFileName();
		return null;
	}

	public byte[] readBytes() throws DeviceException {
		if(device!=null){
			ByteBuffer buf = ByteBuffer.allocate(MAX_NUMBER_OF_BYTES_TO_READ);
			byte [] receivedByte = device.readReadyBytes(MAX_NUMBER_OF_BYTES_TO_READ);
			while(receivedByte!=null){
				buf.put(receivedByte);
				receivedByte =device.readReadyBytes(MAX_NUMBER_OF_BYTES_TO_READ-buf.position());
			}
			return Arrays.copyOf(buf.array(),buf.position());
		}
		return null;
	}
	
	public void setListener(DeviceDataListener listener) {
		this.listener = listener;
	}
	
	public boolean close() {
		if(device!=null) {
			boolean ret = device.close();
			device = null;
			return ret;
		}
		return false;
	}
	
	public SelectableFile getDevice() {
		return device;
	}
	
	public boolean isOpen() {
		if(device!=null)
			return true;
		return false;
	}
}
