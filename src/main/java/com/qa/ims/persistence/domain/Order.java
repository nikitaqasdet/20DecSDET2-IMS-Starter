package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Double orderValue;

	public Order() {
		this.setorderValue(orderValue);
	}

	public Order(Double orderValue) {
		this.setId(id);
		this.setorderValue(orderValue);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getorderValue() {
		return orderValue;
	}

	public void setorderValue(Double orderValue2) {
		this.orderValue = orderValue2;
	}

	@Override
	public int hashCode() {
		int result = 1;
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
		Order other = (Order) obj;
		if (getorderValue() == 0) {
			if (other.getorderValue() != 0)
				return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
		}
		return false;
		
	}
	
}
