package org.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "bms_cakecart")
@TableGenerator(name = "cakecart_tab_gen", allocationSize = 1, initialValue = 100, catalog = "test", table = "cartcart_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "cid")
public class CakeCart {
	@Id
	@GeneratedValue(generator = "cakecart_tab_gen", strategy = GenerationType.TABLE)
	@Column(name = "cid", length = 100, nullable = false)
	private int cid;
	@Column(name = "cemail", length = 100, nullable = false)
	private String cemail;
	@Column(name = "citem_id")
	private int citemId;
	@Column(name = "citem_name", length = 32, nullable = false)
	private String citemName;
	@Column(name = "citem_price", length = 32, nullable = false)
	private int citemPrice;
	@Column(name = "curl", length = 100, nullable = false)
	private String curl;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public int getCitemId() {
		return citemId;
	}
	public void setCitemId(int citemId) {
		this.citemId = citemId;
	}
	public String getCitemName() {
		return citemName;
	}
	public void setCitemName(String citemName) {
		this.citemName = citemName;
	}
	public int getCitemPrice() {
		return citemPrice;
	}
	public void setCitemPrice(int citemPrice) {
		this.citemPrice = citemPrice;
	}
	public String getCurl() {
		return curl;
	}
	public void setCurl(String curl) {
		this.curl = curl;
	}

}
