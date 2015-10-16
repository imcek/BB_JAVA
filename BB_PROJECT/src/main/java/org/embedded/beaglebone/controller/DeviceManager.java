/**
 * COPYRIGHT (C) 2015 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author a168814
 * DeviceManager.java added on May 21, 2015 5:36:59 PM
 */
public class DeviceManager {
	public static final Logger logger = Logger.getLogger(DeviceManager.class.getName());
	public static final boolean DEBUG_MODE = true;
	
	public static void debug(String message) {
		logger.finest(getCurrentThreadName() + ":" + message);
	}
	public static boolean isDebugEnabled() {
		return Level.FINEST.equals(getLevel(logger));
	}
	public static Level getLevel(Logger logger) {
	    Level level = logger.getLevel();
	    if (level == null && logger.getParent() != null) {
	        level = logger.getParent().getLevel();
	    }
	    return level;
	}
	public static void info(String message) {
		logger.info(getCurrentThreadName() + ":" + message);
	}
	public static void error(String msg) {
		logger.log(Level.SEVERE, msg);
	}
	public static void error(String msg, Throwable e) {
		logger.log(Level.SEVERE, msg, e);
	}
	public static String getCurrentThreadName() {
		return Thread.currentThread().getName();
	}

}
