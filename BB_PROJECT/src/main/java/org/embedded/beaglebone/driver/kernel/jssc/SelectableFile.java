/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.driver.kernel.jssc;

import org.embedded.beaglebone.driver.kernel.serial.SerialNativeInterface;
import org.embedded.beaglebone.driver.kernel.serial.SerialPortException;

/**
 * @author a168814
 * SelectableDevice.java added on Nov 25, 2014 7:46:29 PM
 */
public class SelectableFile {

	private static final SerialNativeInterface serialInterface = new SerialNativeInterface();
	private long handle = -1;
	private String fileName;
	
	public long open(String fileName, int flags) {
		handle = serialInterface.open(fileName, flags);
		return handle;
	}
	
	public boolean close() {
		return serialInterface.close(handle);
	}
	
    public boolean writeBytes(byte[] buffer) throws DeviceException {
        return serialInterface.writeBytes(handle, buffer);
    }
    
    public boolean writeBytes(byte[] buffer, int length) throws DeviceException {
        return serialInterface.writeBytesWithLength(handle, buffer, length);
    }
    
    public byte[] readBytes(int byteCount) throws DeviceException {
        return serialInterface.readBytes(handle, byteCount);
    }
    
    public byte[] readReadyBytes(int byteCount) throws DeviceException {
        return serialInterface.readReadyBytes(handle, byteCount);
    }
    
    public byte[] readBytes(long timeout) throws DeviceException {
        return serialInterface.readBytesWithTimeout(handle, timeout);
    }
    
    public String readString(int byteCount) throws DeviceException {
        return new String(readBytes(byteCount));
    }
    
    public byte[] readBytes() throws DeviceException {
    	int byteCount = getInputBufferBytesCount();
        if(byteCount <= 0){
            return null;
        }
        return readBytes(byteCount);
    }
    
    public int getInputBufferBytesCount() throws SerialPortException {
        return serialInterface.getBuffersBytesCount(handle)[0];
    }
    
    public String getFileName() {
		return fileName;
	}
    
    public long getHandle() {
		return handle;
	}
}
