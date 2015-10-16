package org.embedded.beaglebone.driver.kernel.rotaryEncoder;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.embedded.beaglebone.constants.DeviceConstants;
import org.embedded.beaglebone.controller.DeviceManager;
import org.embedded.beaglebone.controller.JobController;
import org.embedded.beaglebone.driver.kernel.event.InputEvent;
import org.embedded.beaglebone.main.BBMain;

public class RotaryEncoderReader implements Runnable{

	private FileChannel channel;
	private ByteBuffer buffer;
	private InputEvent event = new InputEvent();
	String threadName="rotaryEncoderThread";
	private JobController keyReaderJob;
	private static RotaryControllerInterface rotInferface;
	
	public RotaryEncoderReader() throws Exception {
		keyReaderJob = new JobController(DeviceConstants.NUMBER_OF_KEY_READERS);
		buffer = ByteBuffer.allocateDirect(32);
		channel = FileChannel.open(Paths.get("/dev/input/event0"), StandardOpenOption.READ);
		keyReaderJob.submitJob(this);
	}

	public void run() {
		while(!Thread.interrupted()) {
			try {
				int bytesRead = channel.read(buffer);
				parseEvents(bytesRead, buffer);
			} catch (Throwable e) {
				if(!(e instanceof InterruptedException))
					DeviceManager.debug("InterruptedException");
			}
		}
		
	}
		
	public void parseEvents(Integer result, ByteBuffer attachment) throws  InterruptedException {
		// should read 16 bytes struct input_event ev[64]; linux/input.h
		if (result > 0 && result % 16 == 0) {
			int cnt = result / 16;
			for (int i = 0; i < cnt; i++) {
				int offset = i * 16;
				event.parseInputEvent(attachment, offset);
				if (event.getType() == InputEvent.EV_ABS && event.getValue() > 0) {
					//DeviceManager.info("code " + event.getCode() + " pressed " + event.getValue() + " mode:");
					RotaryControllerInterface rotarInt = BBMain.getRotarEncoderController();
					rotarInt.setValue(event.getValue());
					keyReaderJob.submitJob(rotarInt);
				}else if(event.getType() == InputEvent.EV_KEY && event.getValue() > 0){
					RotaryControllerInterface rotarInt = BBMain.getRotarEncoderController();
					rotarInt.setValue(-1);
					keyReaderJob.submitJob(rotarInt);
				}
			}
			attachment.clear();
		} else {
//				filePos += result;
		}
//			channel.read(buffer, filePos, buffer, this);
	}
	
}

