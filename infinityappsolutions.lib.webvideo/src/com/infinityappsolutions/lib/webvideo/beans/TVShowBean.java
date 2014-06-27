package com.infinityappsolutions.lib.webvideo.beans;

public class TVShowBean extends VideoBean {
	public Long seasonID;
	public Long showID;

	public TVShowBean() {
	}

	public TVShowBean(long id, String name, String type, String url,
			String file, String hash, String imageurl, Long seasonID,
			Long showID) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.url = url;
		this.file = file;
		this.hash = hash;
		this.imageurl = imageurl;
		this.seasonID = seasonID;
		this.showID = showID;
	}

	public TVShowBean(Long seasonID, Long showID) {
		super();
		this.seasonID = seasonID;
		this.showID = showID;
	}

	public Long getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(Long seasonID) {
		this.seasonID = seasonID;
	}

	public Long getShowID() {
		return showID;
	}

	public void setShowID(Long showID) {
		this.showID = showID;
	}

}