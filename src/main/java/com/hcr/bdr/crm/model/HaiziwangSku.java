/**
 * 
 */
package com.hcr.bdr.crm.model;

import java.util.Date;

/**
 * @author seraph
 *
 */
public class HaiziwangSku {

	private String gid;
	private String gname;
	private String brand;
	private String gline;
	private String category;
	private String subcategory;
	private String name;
	private String size;
	private String svalue;
	private String unit;
	private String other;
	private int ogn;
	private double amount;
	private int matched;
	private int changed;
	private Date createdDate;
	private Date changedDate;

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGline() {
		return gline;
	}

	public void setGline(String gline) {
		this.gline = gline;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSvalue() {
		return svalue;
	}

	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getOgn() {
		return ogn;
	}

	public void setOgn(int ogn) {
		this.ogn = ogn;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getMatched() {
		return matched;
	}

	public void setMatched(int matched) {
		this.matched = matched;
	}

	public int getChanged() {
		return changed;
	}

	public void setChanged(int changed) {
		this.changed = changed;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

}
