package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String itemName;

	public Item(String itemName) {
		this.setitemName(itemName);
	}

	public Item(Long id, String itemName) {
		this.setId(id);
		this.setitemName(itemName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getitemName() {
		return itemName;
	}

	public void setitemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "id:" + id + " item name:" + itemName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (getitemName() == null) {
			if (other.getitemName() != null)
				return false;
		} else if (!getitemName().equals(other.getitemName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
