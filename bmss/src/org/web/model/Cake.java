package org.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bms_cake")

public class Cake {

	@Id
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "item_name", length = 32, nullable = false)
	private String itemName;
	@Column(name = "item_price", length = 32, nullable = false)
	private String itemPrice;
	@Column(name = "url", length = 100, nullable = false)
	private String url;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
