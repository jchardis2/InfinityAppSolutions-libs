package com.infinityappsolutions.lib.webvideo.beans;

public class ServerVideoBean extends VideoBean {
	private long servervideoid;
	private String serverpath;
	private String serverurl;

	public ServerVideoBean() {
		// TODO Auto-generated constructor stub
	}

//	public ServerVideoBean(long id, String name, String type, String url,
//			String file, String hash, String imageurl, long servervideoid,
//			String serverpath, String serverurl) {
//		super(id, name, type, url, file, hash, imageurl);
//		this.servervideoid = servervideoid;
//		this.serverpath = serverpath;
//		this.serverurl = serverurl;
//	}

	public ServerVideoBean(long id, long videofolderid, String name,
			String type, String url, String file, String hash, String imageurl,
			long servervideoid, String serverpath, String serverurl) {
		super(id, videofolderid, name, type, url, file, hash, imageurl);

		this.servervideoid = servervideoid;
		this.serverpath = serverpath;
		this.serverurl = serverurl;
	}

	public long getServervideoid() {
		return servervideoid;
	}

	public void setServervideoid(long servervideoid) {
		this.servervideoid = servervideoid;
	}

	public String getServerpath() {
		return serverpath;
	}

	public void setServerpath(String serverpath) {
		this.serverpath = serverpath;
	}

	public String getServerurl() {
		return serverurl;
	}

	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}

}
