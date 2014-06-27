package com.infinityappsolutions.lib.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads system propeties from a given file. Default is config.properties
 * 
 * @author jchardis
 * 
 */
public class LocalProperties {

	public LocalProperties() {
	}

	/**
	 * Loads the system propeties from a local file named config.properties
	 * 
	 * @throws FileNotFoundException
	 *             - if the file does not exist, is a directory rather than a
	 *             regular file, or for some other reason cannot be opened for
	 *             reading.
	 * @throws SecurityException
	 *             - if a security manager exists and its checkRead method
	 *             denies read access to the file.
	 * @throws IOException
	 *             - if an error occurred when reading from the input stream.
	 * @throws IllegalArgumentException
	 *             - if the input stream contains a malformed Unicode escape
	 *             sequence.
	 */
	public void loadSystemProperties() throws IOException {
		loadSystemProperties("config.properties");
	}

	/**
	 * 
	 * @param path
	 *            The path to the properties file, Call {@link
	 *            #loadSystemProperties() loadSystemProperties} for default
	 * @throws FileNotFoundException
	 *             - if the file does not exist, is a directory rather than a
	 *             regular file, or for some other reason cannot be opened for
	 *             reading.
	 * @throws SecurityException
	 *             - if a security manager exists and its checkRead method
	 *             denies read access to the file.
	 * @throws IOException
	 *             - if an error occurred when reading from the input stream.
	 * @throws IllegalArgumentException
	 *             - if the input stream contains a malformed Unicode escape
	 *             sequence.
	 */
	public void loadSystemProperties(String path) throws FileNotFoundException,
			SecurityException, IOException, IllegalArgumentException {
		FileInputStream propFile = new FileInputStream("config.properties");
		Properties p = new Properties(System.getProperties());
		p.load(propFile);
		System.setProperties(p);
	}
}
