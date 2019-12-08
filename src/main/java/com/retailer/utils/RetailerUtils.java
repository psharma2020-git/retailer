package com.retailer.utils;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RetailerUtils {

    private final static Logger logger = LoggerFactory.getLogger(RetailerUtils.class);

    private RetailerUtils() {

    }

    public static void logException(Throwable exObject) {
	logger.error("Exception caught Type={}, Message:{}, Class={}, Method={}, Line={}, ",
		exObject.getClass().getSimpleName(), exObject.getMessage(), (exObject.getStackTrace())[0].getFileName(),
		(exObject.getStackTrace())[0].getMethodName(), (exObject.getStackTrace())[0].getLineNumber());
	exObject.printStackTrace();

    }

    public static void logWarn(Throwable exObject) {
	logger.warn("Exception caught Type={}, Message:{}, Class={}, Method={}, Line={}, ",
		exObject.getClass().getSimpleName(), exObject.getMessage(), (exObject.getStackTrace())[0].getFileName(),
		(exObject.getStackTrace())[0].getMethodName(), (exObject.getStackTrace())[0].getLineNumber());

    }

    // Check for Empty string
    public static boolean isNullOrEmpty(String str) {
	return (str == null || str.trim().isEmpty());
    }

    // Check for Empty Collection
    public static boolean isNullOrEmpty(final Collection<?> c) {
	return (c == null || c.isEmpty());
    }
}