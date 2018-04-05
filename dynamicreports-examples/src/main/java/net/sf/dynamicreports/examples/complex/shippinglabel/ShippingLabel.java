/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.examples.complex.shippinglabel;

import java.util.Date;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ShippingLabel {
	private Customer from;
	private Customer to;
	private Integer priority;
	private String pod;
	private String carrier;
	private Date dateShipped;
	private Integer weight;
	private Integer quantity;
	private String shipToPostalCode;
	private String po;
	private String serialShippingContainer;

	public Customer getFrom() {
		return from;
	}

	public void setFrom(Customer from) {
		this.from = from;
	}

	public Customer getTo() {
		return to;
	}

	public void setTo(Customer to) {
		this.to = to;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Date getDateShipped() {
		return dateShipped;
	}

	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getShipToPostalCode() {
		return shipToPostalCode;
	}

	public void setShipToPostalCode(String shipToPostalCode) {
		this.shipToPostalCode = shipToPostalCode;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getSerialShippingContainer() {
		return serialShippingContainer;
	}

	public void setSerialShippingContainer(String serialShippingContainer) {
		this.serialShippingContainer = serialShippingContainer;
	}
}
