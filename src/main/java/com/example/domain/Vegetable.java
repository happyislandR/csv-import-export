package com.example.domain;

public class Vegetable {

	/**  ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** 説明 */
	private String description;
	/**　値段 */
	private Integer price;
	/**　色 */
	private String color;
	/**　削除判断*/
	private Boolean deleted;
	
	public Vegetable() {
	}

	public Vegetable(Integer id, String name, String description, Integer price, String color, Boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.color = color;
		this.deleted = deleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Vegetable [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", color=" + color + ", deleted=" + deleted + "]";
	}
	
}
