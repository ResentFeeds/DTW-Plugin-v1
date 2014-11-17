package me.skylertyler.skylerpgm.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

	private static Logger logger = Logger.getLogger("Minecraft");

	public static void infoMSG(String message) {
		logger.log(Level.INFO, message);
	}

	public static void warningMSG(String message) {
		logger.log(Level.WARNING, message);
	}

	public static void severeMSG(String message) {
		logger.log(Level.SEVERE, message);
	}
}
