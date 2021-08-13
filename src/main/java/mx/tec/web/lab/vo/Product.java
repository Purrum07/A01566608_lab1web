package mx.tec.web.lab.vo;

import java.util.List;

public class Product {
	private String id;
	private String name;
	private String description;
	private String smallUrl;
	private String mediumUrl;
	private String largeUrl;
	private List<Sku> childSkus;

	public Product() {
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param smallUrl
	 * @param mediumUrl
	 * @param largeUrl
	 * @param childSkus
	 */
	public Product(String id, String name, String description, String smallUrl, String mediumUrl, String largeUrl, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.smallUrl = smallUrl;
		this.mediumUrl = mediumUrl;
		this.largeUrl = largeUrl;
		this.childSkus = childSkus;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the smallUrl
	 */
	public String getSmallUrl() {
		return smallUrl;
	}

	/**
	 * @param smallUrl the smallUrl to set
	 */
	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}

	/**
	 * @return the mediumUrl
	 */
	public String getMediumUrl() {
		return mediumUrl;
	}

	/**
	 * @param mediumUrl the mediumUrl to set
	 */
	public void setMediumUrl(String mediumUrl) {
		this.mediumUrl = mediumUrl;
	}

	/**
	 * @return the largeUrl
	 */
	public String getLargeUrl() {
		return largeUrl;
	}

	/**
	 * @param largeUrl the largeUrl to set
	 */
	public void setLargeUrl(String largeUrl) {
		this.largeUrl = largeUrl;
	}

	/**
	 * @return the childSkus
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}
	/**
	 * @param childSkus the childSkus to set
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}


}
