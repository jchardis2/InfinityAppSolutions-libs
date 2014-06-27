package com.infinityappsolutions.lib.webvideo.beans;

public class VideoFolderBean {
	private long videofolderid;
	private long parentfolderid = 1;
	private String name;
	private String path;
	private boolean isMovie = false;
	private boolean isShow = false;
	private boolean isSeason = false;

	public VideoFolderBean() {
	}

	public VideoFolderBean(long videofolderid, long parentfolderid,
			String name, String path, boolean isMovie, boolean isShow,
			boolean isSeason) {
		super();
		this.videofolderid = videofolderid;
		this.parentfolderid = parentfolderid;
		this.name = name;
		this.path = path;
		this.isMovie = isMovie;
		this.isShow = isShow;
		this.isSeason = isSeason;
	}

	public long getVideofolderid() {
		return videofolderid;
	}

	public void setVideofolderid(long videofolderid) {
		this.videofolderid = videofolderid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	public boolean isSeason() {
		return isSeason;
	}

	public void setSeason(boolean isSeason) {
		this.isSeason = isSeason;
	}

	public boolean isMovie() {
		return isMovie;
	}

	public void setMovie(boolean isMovie) {
		this.isMovie = isMovie;
	}

	public long getParentfolderid() {
		return parentfolderid;
	}

	public void setParentfolderid(long parentfolderid) {
		this.parentfolderid = parentfolderid;
	}

}
