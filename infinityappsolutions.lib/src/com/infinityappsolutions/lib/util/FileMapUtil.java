package com.infinityappsolutions.lib.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.infinityappsolutions.lib.interfaces.IFileMap;

/**
 * Maps file based off of a root file or path.
 * 
 * @author Jimmy Hardison
 * 
 */
public class FileMapUtil {
	private ArrayList<String> acceptExtenstions;
	private File rootFile;
	private String rootPath;
	private int rootFilePathIndex;

	/**
	 * 
	 * @param rootPath
	 *            The root Path to map files from
	 * @throws NullPointerException
	 *             - If the rootPath argument is null
	 */
	public FileMapUtil(String rootPath) throws NullPointerException {
		rootFile = new File(rootPath);
		init();
	}

	/**
	 * 
	 * @param rootFile
	 *            the root File to map files from
	 * @throws SecurityException
	 *             - If a required system property value cannot be
	 *             accessedException
	 */
	public FileMapUtil(File rootFile) throws SecurityException {
		rootPath = rootFile.getAbsolutePath();
		init();
	}

	private void init() {
		rootFilePathIndex = rootPath.length();
	}

	/**
	 * Returns a HashMap of the files from the root directory onward. You can
	 * filter files by adding the file extenstion to the acceptExtenstions list.
	 * 
	 * @param parentDir
	 *            the parent directory
	 * @return a HashMap of type HashMap<String path, File file>
	 */
	public HashMap<String, File> generateFileMap(File parentDir) {
		HashMap<String, File> fileMap = new HashMap<>();
		if (!parentDir.isDirectory()) {
			parentDir = parentDir.getAbsoluteFile();
		}
		File currentFileList[] = parentDir.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {

					fileMap.put(file.getAbsolutePath(), file);
					// errors.add("There was an error reading " + filename);
				}
			} else {
				fileMap.putAll(generateFileMap(file));
			}
		}
		return fileMap;
	}

	/**
	 * Returns a HashMap of the files from the root directory's children. You
	 * can filter files by adding the file extenstion to the acceptExtenstions
	 * list.
	 * 
	 * @param parentDir
	 *            the parent directory
	 * @return a HashMap of type HashMap<String path, File file>
	 */
	public HashMap<String, File> generateChildFileMap(File parentDir) {
		HashMap<String, File> fileMap = new HashMap<>();
		if (!parentDir.isDirectory()) {
			parentDir = parentDir.getAbsoluteFile();
		}
		File currentFileList[] = parentDir.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {

					fileMap.put(file.getAbsolutePath(), file);
					// errors.add("There was an error reading " + filename);
				}
			} else {
				fileMap.put(file.getAbsolutePath(), file);
			}
		}
		return fileMap;
	}

	/**
	 * Returns a ArrayList of the files from the root directory's children. You
	 * can filter files by adding the file extenstion to the acceptExtenstions
	 * list.
	 * 
	 * The list has no ordering
	 * 
	 * @param parentDir
	 *            the parent directory
	 * @return a ArrayList of type ArrayList<File file>
	 */
	public ArrayList<File> generateChildFileList(File parentDir) {
		ArrayList<File> fileList = new ArrayList<File>();
		if (!parentDir.isDirectory()) {
			parentDir = parentDir.getAbsoluteFile();
		}
		File currentFileList[] = parentDir.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {

					fileList.add(file);
					// errors.add("There was an error reading " + filename);
				}
			} else {
				fileList.add(file);
			}
		}
		return fileList;
	}

	/**
	 * Returns a ArrayList of the files from the root directory onward. You can
	 * filter files by adding the file extenstion to the acceptExtenstions list.
	 * 
	 * The list has no ordering
	 * 
	 * @param parentDir
	 *            the parent directory
	 * @return a ArrayList of type ArrayList<File file>
	 */
	public ArrayList<File> generateFileList(File parentDir) {
		ArrayList<File> fileList = new ArrayList<File>();
		if (!parentDir.isDirectory()) {
			parentDir = parentDir.getAbsoluteFile();
		}
		File currentFileList[] = parentDir.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {

					fileList.add(file);
					// errors.add("There was an error reading " + filename);
				}
			} else {
				generateFileList(file);
			}
		}
		return fileList;
	}

	public ArrayList<String> getAcceptExtenstions() {
		return acceptExtenstions;
	}

	public void setAcceptExtenstions(ArrayList<String> acceptExtenstions) {
		this.acceptExtenstions = acceptExtenstions;
	}
}
