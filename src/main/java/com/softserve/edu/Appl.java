package com.softserve.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Appl {
	public static final Logger logger = LoggerFactory.getLogger(App.class); // LoggerFactory

	public static void main(String[] args) {
		System.out.println("Hello from App:");
		Appl appl = new Appl();
		Calc calc = new Calc();
		Some some = new Some();

		appl.appMethod();
		calc.calcMethod();
		some.someMethod();
	}

	public void appMethod() {
		logger.error("App Error");
		logger.warn("App Warning");
		logger.info("App Info");
		logger.debug("App Debug");
	}
}
