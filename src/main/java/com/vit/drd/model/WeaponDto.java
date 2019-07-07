package com.vit.drd.model;

public class WeaponDto {

	String type;
	String name;
	String calibre;
	String desc;
	String country;

	public WeaponDto(String type, String name, String calibre, String country, String desc) {
		super();
		this.type = type;
		this.name = name;
		this.calibre = calibre;
		this.desc = desc;
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
