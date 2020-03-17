package com.zensar.imagems.entities;

public class Image {
	
	private int imageId;
	
	private String imageName;
	
	private String imageUrl;

	public Image() {
		super();
	}

	public Image(int imageId, String imageName, String imageUrl) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageUrl = imageUrl;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
