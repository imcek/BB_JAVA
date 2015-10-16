/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.driver.kernel.event;


/**
 * @author a168814
 * KeyCodes.java added on Dec 29, 2014 7:03:32 PM
 */
public enum KeyCodes {

	KEY_1((short)2, '1'),
	KEY_2((short)3, '2'),
	KEY_3((short)4, '3'),
	KEY_4((short)5, '4'),
	KEY_5((short)6, '5'),
	KEY_6((short)7, '6'),
	KEY_7((short)8, '7'),
	KEY_8((short)9, '8'),
	KEY_9((short)10, '9'),
	KEY_0((short)11, '0'),
	KEY_Q((short)16, 'Q'),
	KEY_W((short)17, 'W'),
	KEY_E((short)18, 'E'),
	KEY_R((short)19, 'R'),
	KEY_T((short)20, 'T'),
	KEY_Y((short)21, 'Y'),
	KEY_U((short)22, 'U'),
	KEY_I((short)23, 'I'),
	KEY_O((short)24, 'O'),
	KEY_P((short)25, 'P'),
	KEY_ENTER((short)28, ' '),
	KEY_A((short)30, 'A'),
	KEY_S((short)31, 'S'),
	KEY_D((short)32, 'D'),
	KEY_F((short)33, 'F'),
	KEY_G((short)34, 'G'),
	KEY_H((short)35, 'H'),
	KEY_J((short)36, 'J'),
	KEY_K((short)37, 'K'),
	KEY_L((short)38, 'L'),
	KEY_Z((short)44, 'Z'),
	KEY_X((short)45, 'X'),
	KEY_C((short)46, 'C'),
	KEY_V((short)47, 'V'),
	KEY_B((short)48, 'B'),
	KEY_N((short)49, 'N'),
	KEY_M((short)50, 'M'),
	UNDEFINED_CODE((short)-1, ' ');
	
	private final short keyCode;
	private final char characterCode;
	KeyCodes(short keyCode, char characterCode){
		this.keyCode = keyCode;
		this.characterCode = characterCode;
	}
	
	public static KeyCodes get(short keyCode){
		for (KeyCodes kcode : KeyCodes.values()) {
			if(kcode.getKeyCode()==keyCode)
				return kcode;
		}
		return UNDEFINED_CODE;
	}
	
	public short getKeyCode() {
		return keyCode;
	}
	
	public char getCharacterCode() {
		return characterCode;
	}
}
