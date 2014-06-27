package com.infinityappsolutions.lib.webvideo.beans;

public class MovieBean extends VideoBean {

	public MovieBean() {
	}

	public MovieBean(long id, long videofolderid, String name, String type,
			String url, String file, String hash, String imageurl) {
		super(id, videofolderid, name, type, url, file, hash, imageurl);
	}

	
}