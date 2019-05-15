package com.briup.bean;
public class Goods {
     private String name;
     private String address;
     private int num;
     private String sort;
     private String price;
     private int goodsid;
     /**
 	 * @return the goodsid
 	 */
 	public int getGoodsid() {
 		return goodsid;
 	}
 	/**
 	 * @param goodsid the goodsid to set
 	 */
 	public void setGoodsid(int goodsid) {
 		this.goodsid = goodsid;
 	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the number
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param number the number to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goods  name=" + name + ", address=" + address + ", goodsid=" + goodsid + ", num=" + num
				+ ", sort=" + sort + ", price=" + price + " ";
	}
     
}
