package com.infinityappsolutions.lib.webvideo.beans;

public class VideoBean {
	protected long id;
	protected long videofolderid;
	protected String name;
	protected String type;
	protected String url;
	protected String file;
	protected String hash;
	protected String imageurl;

	public VideoBean() {
	}

	// public VideoBean(long id, String name, String type, String url,
	// String file, String hash, String imageurl) {
	// super();
	// this.id = id;
	// this.name = name;
	// this.type = type;
	// this.url = url;
	// this.file = file;
	// this.hash = hash;
	// this.imageurl = imageurl;
	// }

	public VideoBean(long id, long videofolderid, String name, String type,
			String url, String file, String hash, String imageurl) {
		super();
		this.id = id;
		this.videofolderid = videofolderid;
		this.name = name;
		this.type = type;
		this.url = url;
		this.file = file;
		this.hash = hash;
		this.imageurl = imageurl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

}
