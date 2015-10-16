/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.driver.kernel.event;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is the event type from event drivers in Linux
 * @author a168814
 * InputEvent.java added on Nov 26, 2014 10:51:50 PM
 */
public class InputEvent {

	/**
	linux/input.h InputEvent {
		struct timeval time; 4 byte sec, 4 byte microsec
		__u16 type; 2 byte
		__u16 code; 2 byte
		__s32 value; 4 byte
	};
	*/
	
	private short type = -1;
	private short code = -1;
	private int value = -1;
	private int seconds = -1;
	private int microseconds = -1;
	
	public static final short TYPE_EV_PWR 		= 0x16;
	public static final short CODE_SND_TONE	= 0x02;
	public static final short CODE_SND_BELL	= 0x01;
	public static final short TYPE_EV_SND 		= 0x12;
	
	public final static short EVENT_EJ = 2; //ej
	public final static short EVENT_FM = 1; //fm
	public final static short EVENT_TAMPER = 0; //Tamper
	public final static short EV_CUSTOM = 0x04;
	public final static short EV_KEY = 0x01;
	public final static short EV_ABS = 0x03;
	
	public InputEvent parseInputEvent(ByteBuffer attachment, int offset) {
		attachment.order(ByteOrder.LITTLE_ENDIAN);
		seconds = attachment.getInt(offset + 0);
		microseconds = attachment.getInt(offset + 4);
		type = attachment.getShort(offset + 8);
		code = attachment.getShort(offset + 10);
		value = attachment.getInt(offset + 12);
		return this;
	}
	
	public static List<InputEvent> parseInputEvents(byte[] buffer) {
		int size = buffer.length;
		ByteBuffer attachment = ByteBuffer.wrap(buffer);
		List<InputEvent> events = new ArrayList<InputEvent>();;
		if (size > 0 && size % 16 == 0) {
			int cnt = size / 16;
			for (int i = 0; i < cnt; i++) {
				int offset = i * 16;
				events.add(new InputEvent().parseInputEvent(attachment, offset));
			}
		}
		return events;
	}
	
	public static byte[] getInputEventAsArray(short type, short code, int value) {
		ByteBuffer event = ByteBuffer.allocate(16);
		return getInputEventAsArray(event, type, code, value);
	}
	
	public static byte[] getInputEventAsArray(ByteBuffer event, short type, short code, int value) {
		event.order(ByteOrder.LITTLE_ENDIAN);
		event.clear();
		event.putInt(0);
		event.putInt(0);
		event.putShort(type);
		event.putShort(code);
		event.putInt(value);
		return event.array();
	}
	
	public Date getEventDate() {
		if(seconds<0 || microseconds<0)
			return null;
		return new Date(((long)seconds)*1000L + microseconds/1000);
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public short getCode() {
		return code;
	}

	public void setCode(short code) {
		this.code = code;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMicroseconds() {
		return microseconds;
	}

	public void setMicroseconds(int microseconds) {
		this.microseconds = microseconds;
	}

	public static String parseInputEventsForBarcodeReader(byte[] buffer) {
		InputEvent event = new InputEvent();
		int size = buffer.length;
		ByteBuffer attachment = ByteBuffer.wrap(buffer);
		if (size > 0 && size % 16 == 0) {
			int cnt = size / 16;
			StringBuilder stringBuilder = new StringBuilder(cnt);
			for (int i = 0; i < cnt; i++) {
				int offset = i * 16;
				event.parseInputEvent(attachment, offset);
				if(event.getType()==EV_KEY && event.getValue()==1) {
					KeyCodes code = KeyCodes.get(event.getCode());
					if(code == KeyCodes.KEY_ENTER){
						break;
					}
					if(code != KeyCodes.UNDEFINED_CODE)
						stringBuilder.append(code.getCharacterCode());
				}
			}
			
			return stringBuilder.toString();
		}
		return null;
	}
	
	
}
