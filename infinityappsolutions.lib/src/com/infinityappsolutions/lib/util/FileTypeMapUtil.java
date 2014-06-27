package com.infinityappsolutions.lib.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.infinityappsolutions.lib.interfaces.IFileMap;

/**
 * Maps file based off of a root file or path.You can map the files to objecs by
 * implementing the {@link IFileMap} interface and setting iFileMapType.
 * 
 * @author Jimmy Hardison
 * 
 */
public class FileTypeMapUtil<T> {
	private ArrayList<String> acceptExtenstions;
	private IFileMap<T> iFileMapType;
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
	public FileTypeMapUtil(String rootPath, IFileMap<T> fileMapType)
			throws NullPointerException {
		this.iFileMapType = fileMapType;
		this.rootPath=rootPath;
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
	public FileTypeMapUtil(File rootFile, IFileMap<T> iFileMapType)
			throws SecurityException {
		this.iFileMapType = iFileMapType;
		rootPath = rootFile.getAbsolutePath();
		init();
	}

	private void init() {
		if (!rootFile.isDirectory()) {
			rootFile = rootFile.getAbsoluteFile();
			rootPath = rootFile.getAbsolutePath();
		}
		rootFilePathIndex = rootPath.length();
	}

	/**
	 * Returns a HashMap of the files from the root directory onward. You can
	 * filter files by adding the file extenstion to the acceptExtenstions list.
	 * 
	 * @param parentDir
	 *            the parent directory
	 * @return a HashMap of type HashMap<String path, T t>
	 */
	public HashMap<String, T> generateFileMap() {
		HashMap<String, T> fileMap = new HashMap<>();
		File currentFileList[] = rootFile.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {
					fileMap.put(file.getAbsolutePath(),
							iFileMapType.getType(file));
					// errors.add("There was an error reading " + filename);
				}
			} else {
				fileMap.putAll(generateFileMap(file, fileMap));
			}
		}
		return fileMap;
	}

	private HashMap<String, T> generateFileMap(File parentDir,
			HashMap<String, T> fileMap) {
		File currentFileList[] = parentDir.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {
					fileMap.put(file.getAbsolutePath(),
							iFileMapType.getType(file));
					// errors.add("There was an error reading " + filename);
				}
			} else {
				fileMap.putAll(generateFileMap(file, fileMap));
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
	 * @return a HashMap of type HashMap<String path, T t>
	 */
	public HashMap<String, T> generateChildFileMap() {
		HashMap<String, T> fileMap = new HashMap<>();
		File currentFileList[] = rootFile.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {

					fileMap.put(file.getAbsolutePath(),
							iFileMapType.getType(file));
					// errors.add("There was an error reading " + filename);
				}
			} else {
				fileMap.put(file.getAbsolutePath(), iFileMapType.getType(file));
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
	 * @return a ArrayList of type ArrayList<T t>
	 */
	public ArrayList<T> generateChildFileList() {
		ArrayList<T> fileList = new ArrayList<T>();
		File currentFileList[] = rootFile.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {

					fileList.add(iFileMapType.getType(file));
					// errors.add("There was an error reading " + filename);
				}
			} else {
				fileList.add(iFileMapType.getType(file));
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
	 * @return a ArrayList of type ArrayList<T t>
	 */
	public ArrayList<T> generateFileList() {
		ArrayList<T> fileList = new ArrayList<T>();
		File currentFileList[] = rootFile.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase())) {

					fileList.add(iFileMapType.getType(file));
					// errors.add("There was an error reading " + filename);
				}
			} else {
				generateFileList(file, fileList);
			}
		}
		return fileList;
	}

	private ArrayList<T> generateFileList(File parentDir, ArrayList<T> fileList) {
		File currentFileList[] = parentDir.listFiles();
		for (File file : currentFileList) {
			if (file.isFile()) {
				String filePath = file.getAbsolutePath().substring(
						rootFilePathIndex);
				int extenstionIndex = filePath.lastIndexOf(".");
				System.out.println(filePath.toLowerCase().substring(extenstionIndex));
				if (acceptExtenstions == null
						|| acceptExtenstions.contains(filePath.toLowerCase().substring(extenstionIndex))) {

					fileList.add(iFileMapType.getType(file));
					// errors.add("There was an error reading " + filename);
				}
			} else {
				generateFileList(file, fileList);
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

	public IFileMap<T> getFileMapType() {
		return iFileMapType;
	}

	public void setFileMapType(IFileMap<T> fileMapType) {
		this.iFileMapType = fileMapType;
	}

}