package com.vit.drd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "weapons")
public class Weapon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Field
	@NotNull
	String type;

	/*
	 * You have to mark the fields you want to make searchable annotating them 
	 * with Field. The parameter Store.NO ensures that the actual data will not
	 * be stored in // the index (maintaining the ability to search for it):
	 * Hibernate Search // will execute a Lucene query in order to find the database
	 * identifiers of // the entities matching the query and use these identifiers
	 * to retrieve // managed objects from the database.
	 */
	@Field(store = Store.NO)
	@NotNull
	String name;

	@Field
	@NotNull
	String calibre;

	@Field
	@NotNull
	String stockType;

	@Field
	@NotNull
	String gripType;
	
	

	@Field
	@NotNull
	String stockMaterial;

	@Field
	@NotNull
	String gripMaterial;

	@Field
	@NotNull
	String fixedAccessories;

	@Field
	@NotNull
	String muzzleDevice;

	@Field
	@NotNull
	String magazine;

	@Field
	@NotNull
	String countryOfManufacture;
	
	
	
	public Weapon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weapon(long id, @NotNull String type, @NotNull String name, @NotNull String calibre, @NotNull String stockType, @NotNull String gripType, @NotNull String stockMaterial,
			@NotNull String gripMaterial, @NotNull String fixedAccessories, @NotNull String muzzleDevice, @NotNull String magazine,
			@NotNull String countryOfManufacture) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.calibre = calibre;
		this.stockType = stockType;
		this.gripType = gripType;
		this.stockMaterial = stockMaterial;
		this.gripMaterial = gripMaterial;
		this.fixedAccessories = fixedAccessories;
		this.muzzleDevice = muzzleDevice;
		this.magazine = magazine;
		this.countryOfManufacture = countryOfManufacture;
	}

	//Getter Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getStockMaterial() {
		return stockMaterial;
	}

	public void setStockMaterial(String stockMaterial) {
		this.stockMaterial = stockMaterial;
	}

	public String getGripMaterial() {
		return gripMaterial;
	}

	public void setGripMaterial(String gripMaterial) {
		this.gripMaterial = gripMaterial;
	}

	public String getFixedAccessories() {
		return fixedAccessories;
	}

	public void setFixedAccessories(String fixedAccessories) {
		this.fixedAccessories = fixedAccessories;
	}

	public String getMuzzleDevice() {
		return muzzleDevice;
	}

	public void setMuzzleDevice(String muzzleDevice) {
		this.muzzleDevice = muzzleDevice;
	}

	public String getMagazine() {
		return magazine;
	}

	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	public String getCountryOfManufacture() {
		return countryOfManufacture;
	}

	public void setCountryOfManufacture(String countryOfManufacture) {
		this.countryOfManufacture = countryOfManufacture;
	}
	
	public String getGripType() {
		return gripType;
	}

	public void setGripType(String gripType) {
		this.gripType = gripType;
	}
	
	
}
