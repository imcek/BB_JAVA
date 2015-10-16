/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.constants;


/**
 * @author a168814
 * DeviceMaximum.java added on May 13, 2014 1:07:46 PM
 */
public interface DeviceConstants {

	public static final byte[] FISCAL_SYMBOL = {0x00,0x40,0x00,0x7f,(byte)0xff,0x00,0x40,0x00,(byte)0xff,(byte)0xfe,0x00,(byte)0xe0,0x01,(byte)0xb0,0x00,0x00,(byte)0xe0,0x03,0x30,0x00,0x01,(byte)0xb0,0x06,0x60,0x00,0x01,(byte)0xb0,0x0c,0x60,0x00,0x03,0x18,0x18,(byte)0xc0,0x00,0x03,0x18,0x30,(byte)0xc0,0x00,0x06,0x0c,0x61,(byte)0xff,(byte)0xf0,0x06,0x0c,(byte)0xc1,(byte)0xff,(byte)0xe0,0x0c,0x07,(byte)0x83,0x00,0x00,0x0c,0x07,0x03,0x00,0x00,0x18,0x02,0x06,0x00,0x00,0x18,0x00,0x06,0x00,0x00,0x30,0x00,0x0c,0x00,0x00,0x30,0x00,0x0c,0x00,0x00,0x60,0x00,0x18,0x00,0x00,0x60,0x00,0x18,0x00,0x00,(byte)0xc0,0x00,0x30,0x00,0x00,(byte)0xc0,0x00,0x30,0x00,0x00};
	public static final String DEFAULT_IPv4 = "0.0.0.0";
	public static final String DEFAULT_IPv6 = "0:0:0:0:0:0:0:0";
	public static final int SEQUENTIAL_KEY_TIMEOUT = 1000;
	public static final long LCD_ERROR_MESSAGE_SLEEP_TIME = 1500;
	public static final long LCD_TIME_REFRESH = 60000;
	public static final long LCD_MESSAGE_WAIT_TIME = 3000;
	public static final int NUMBER_OF_KEY_READERS = 2;
	public static final int PASSWORD_MIN_SIZE = 4;
	public static final int PRINT_THREAD_QUEUE_SIZE = 10;
	public static final int ROLLING_KEY_EXPIRY_SECOND=600;
	public static final int UPDATER_UDP_PORT_NUMBER = 7000;
	public static final int ECR_MANAGER_UDP_PORT_NUMBER = 7001;
	public static final int SOCKET_RECEIVE_BUF_LENGHT = 5;
	public static final int SOCKET_RECEIVE_TIMEOUT = 3000;
	public static final int SERVICE_MENU_OPEN_PERIOD = 5000;
	public static final int SERVICE_MENU_EXPIRATION_TIME = 5;
	public static final int SERVICE_MENU_KEYBOARD_TEST_TIME = 5000;
	public static final int ERROR_MODE_EXPIRATION_TIME = 24;
	public static final int TAX_ID_SIZE = 12;
	public static final int TAX_NAME_SIZE = 20;
	/**
	 * Total waiting time to process the second key press is
	 * KEY_PROCESS_WAIT_CNT * KEY_PROCESS_WAIT_PERIOD
	 * in milliseconds
	 */
	public static final int KEY_PROCESS_WAIT_CNT = 20;
	public static final long KEY_PROCESS_WAIT_PERIOD = 10;
	public static final long MAX_SLEEP_TIME_FOR_READ_UART = 30;
	public static final long MIN_SLEEP_TIME_FOR_READ_UART = 10;
	public static final int LIST_LENGTH_PER_SEND_FOR_PC = 10;
	public static final int NTP_TIMEOUT = 15000;
	public static final int SYSTEM_COMMAND_TIMEOUT = 1000;
	public static final int KEYSTORE_PASSWORD_SIZE = 32;
	
	public static final int MERSIS_NUMBER_SIZE = 16;
	public static final int TRADE_REGISTRY_NUMBER_SIZE = 8;
	public static final int SECTION_NAME_SIZE = 20; //menulerde ve db de 20 karakter.(fise basilirken sigdigi kadar)
	public static final int SECTION_NAME_MIN_DIGIT = 5;
	public static final int SECTION_PRICE_DIGIT = 8; //99.999,99 TL girebilmeli (. ayraci konulmadan 8 )
	public static final int SECTION_LIMIT_DIGIT = 10;
	public static final int SLIP_LIMIT_DIGIT = 5;
	public static final int INC_DEC_DIGIT = 5;
	public static final int GPRS_APN_DIGIT = 10;
	public static final int GPRS_USERNAME_DIGIT = 10;
	public static final int VAT_DIGIT = 5;
	public static final int BARCODE_DIGIT = 13;
	public static final int PLU_NAME_DIGIT = 10 ;
	public static final int PLU_PRICE_DIGIT = 8; //99.999,99 TL girebilmeli (. ayraci konulmadan 8 )
	public static final int CURRENCY_NAME_DIGIT = 3;
	public static final int CURRENCY_RATE_DIGIT = 5;
	public static final int INVOICE_ORDER_DIGIT = 6;
	public static final int INVOICE_SERIAL_DIGIT =1;
	public static final long SLEEP_TIME_AFTER_SALES = 3000;
	public static final int CASHIER_NAME_SIZE = 9; // --------- 23.03.2015 Satis Ana ekranina 9 + 1 bosluk sigabilir
	
	public static final int COMPANY_CODE_LENGTH = 16;
	public static final int DEVICE_SERIAL_NUMBER_LENGTH = 12;
	public static final long SLEEP_TIME_FOR_GPRS_CONNECT_WAIT = 100;
	public static final long GPRS_CONNECTION_TIMEOUT_IN_MS = 10000; //10 sec wait for connect
	public static final int GPRS_SIM_PIN_LENGTH = 4;
	
	public static final short FM_CHANGE_Z_AREA = 1;
	public static final short DM_CHANGE_Z_AREA = 2;
	public static final short FM_CHANGE_CUMULATIVES_AREA = 3;
	/**
	 * Default sleep time for events
	 */
	public static final long MIN_SLEEP_TIME = 250;
	public static final int MAC_LENGTH = 6;
	public static final int DM_SIZE = 565;
	public static final int DM_BASE_SIZE = 138;
	public static final long UPDATER_PING_PERIOD = 25000; // in milliseconds
	public static final long SALE_KEY_PRESS_MAX_WAIT = 3000; // milisaniye cinsinden sale tusuna basilip isleme suresi
	public static final long Z_REPORT_CHECK_TIME_MILLISECONDS = 1000*60*10; // zraporu otomatik basmak icin
	public static final long PING_CHECK_TIME_MILLISECONDS = 1000*30; // alt kartlari pinglemek icin
	public static final long UART_DATA_EXPIRY_PERIOD = PING_CHECK_TIME_MILLISECONDS;
	public static final long LCD_IDLE_DECISION_TIME = 3000; // LCD kac ms sonra idle kabul edilebilir
	public static final int UPDATER_MESSAGE_SIZE = 10;
	public static final char NON_FISCAL_CHAR_INDICATOR = (byte)0x1a;
	public static final char SALE_SLIP_INDICATOR = (byte)0x1b;
	public static final char REPORT_INDICATOR = (byte)0x1c;
	public static final int EJ_VERSION_LENGTH = 5;
	
	public static final int TAMPER_A_ACTIVE = 1;
	public static final int TAMPER_B_ACTIVE = 2;
	public static final int TAMPER_A_AND_B_ACTIVE = 3;
	public static final byte POWER_OFF_TIMEOUT = (byte)15;
}
