/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.constants;

/**
 * @author a168814
 * ThreadNames.java added on Nov 8, 2014 1:58:07 PM
 */
public interface ThreadNames {

	public static final String MAIN_THREAD = "EcrManager";
	public static final String OUT_OF_PAPER_THREAD = "OutOfPaperThread";
	public static final String PRINTER_THREAD = "PrinterThread";
	public static final String PAPER_INSERTED_THREAD = "PaperInsertedThread";
	public static final String BEEPER_THREAD = "BeeperThread";
	public static final String MELODY_THREAD = "MelodyThread";
	public static final String KEYPAD_CONTROLLER_THREAD = "KeypadControlThread";
	public static final String KEYPAD_READER_THREAD = "KeypadReaderThread";
	public static final String SHUTDOWN_THREAD = "ShutdownThread";
	public static final String UART_LISTENER = "UartListener_";
	public static final String UPDATER_PING = "UpdaterPing";
	public static final String DRAWER_OPENER = "DrawerOpener";
	public static final String POWER_OFF = "PowerOff";
}
