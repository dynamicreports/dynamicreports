/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
 * <p>ShippingLabel class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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

    /**
     * <p>Getter for the field <code>from</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.shippinglabel.Customer} object.
     */
    public Customer getFrom() {
        return from;
    }

    /**
     * <p>Setter for the field <code>from</code>.</p>
     *
     * @param from a {@link net.sf.dynamicreports.examples.complex.shippinglabel.Customer} object.
     */
    public void setFrom(Customer from) {
        this.from = from;
    }

    /**
     * <p>Getter for the field <code>to</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.shippinglabel.Customer} object.
     */
    public Customer getTo() {
        return to;
    }

    /**
     * <p>Setter for the field <code>to</code>.</p>
     *
     * @param to a {@link net.sf.dynamicreports.examples.complex.shippinglabel.Customer} object.
     */
    public void setTo(Customer to) {
        this.to = to;
    }

    /**
     * <p>Getter for the field <code>priority</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * <p>Setter for the field <code>priority</code>.</p>
     *
     * @param priority a {@link java.lang.Integer} object.
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * <p>Getter for the field <code>pod</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPod() {
        return pod;
    }

    /**
     * <p>Setter for the field <code>pod</code>.</p>
     *
     * @param pod a {@link java.lang.String} object.
     */
    public void setPod(String pod) {
        this.pod = pod;
    }

    /**
     * <p>Getter for the field <code>carrier</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * <p>Setter for the field <code>carrier</code>.</p>
     *
     * @param carrier a {@link java.lang.String} object.
     */
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    /**
     * <p>Getter for the field <code>dateShipped</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getDateShipped() {
        return dateShipped;
    }

    /**
     * <p>Setter for the field <code>dateShipped</code>.</p>
     *
     * @param dateShipped a {@link java.util.Date} object.
     */
    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    /**
     * <p>Getter for the field <code>weight</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * <p>Setter for the field <code>weight</code>.</p>
     *
     * @param weight a {@link java.lang.Integer} object.
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * <p>Getter for the field <code>quantity</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * <p>Setter for the field <code>quantity</code>.</p>
     *
     * @param quantity a {@link java.lang.Integer} object.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * <p>Getter for the field <code>shipToPostalCode</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getShipToPostalCode() {
        return shipToPostalCode;
    }

    /**
     * <p>Setter for the field <code>shipToPostalCode</code>.</p>
     *
     * @param shipToPostalCode a {@link java.lang.String} object.
     */
    public void setShipToPostalCode(String shipToPostalCode) {
        this.shipToPostalCode = shipToPostalCode;
    }

    /**
     * <p>Getter for the field <code>po</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPo() {
        return po;
    }

    /**
     * <p>Setter for the field <code>po</code>.</p>
     *
     * @param po a {@link java.lang.String} object.
     */
    public void setPo(String po) {
        this.po = po;
    }

    /**
     * <p>Getter for the field <code>serialShippingContainer</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSerialShippingContainer() {
        return serialShippingContainer;
    }

    /**
     * <p>Setter for the field <code>serialShippingContainer</code>.</p>
     *
     * @param serialShippingContainer a {@link java.lang.String} object.
     */
    public void setSerialShippingContainer(String serialShippingContainer) {
        this.serialShippingContainer = serialShippingContainer;
    }
}
