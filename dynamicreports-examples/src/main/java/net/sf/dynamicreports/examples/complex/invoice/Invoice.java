/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.examples.complex.invoice;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>Invoice class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class Invoice {
    private Integer id;
    private BigDecimal shipping;
    private Double tax;
    private Customer billTo;
    private Customer shipTo;
    private List<Item> items;

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>shipping</code>.</p>
     *
     * @return a {@link java.math.BigDecimal} object.
     */
    public BigDecimal getShipping() {
        return shipping;
    }

    /**
     * <p>Setter for the field <code>shipping</code>.</p>
     *
     * @param shipping a {@link java.math.BigDecimal} object.
     */
    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    /**
     * <p>Getter for the field <code>tax</code>.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getTax() {
        return tax;
    }

    /**
     * <p>Setter for the field <code>tax</code>.</p>
     *
     * @param tax a {@link java.lang.Double} object.
     */
    public void setTax(Double tax) {
        this.tax = tax;
    }

    /**
     * <p>Getter for the field <code>billTo</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.invoice.Customer} object.
     */
    public Customer getBillTo() {
        return billTo;
    }

    /**
     * <p>Setter for the field <code>billTo</code>.</p>
     *
     * @param billTo a {@link net.sf.dynamicreports.examples.complex.invoice.Customer} object.
     */
    public void setBillTo(Customer billTo) {
        this.billTo = billTo;
    }

    /**
     * <p>Getter for the field <code>shipTo</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.invoice.Customer} object.
     */
    public Customer getShipTo() {
        return shipTo;
    }

    /**
     * <p>Setter for the field <code>shipTo</code>.</p>
     *
     * @param shipTo a {@link net.sf.dynamicreports.examples.complex.invoice.Customer} object.
     */
    public void setShipTo(Customer shipTo) {
        this.shipTo = shipTo;
    }

    /**
     * <p>Getter for the field <code>items</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * <p>Setter for the field <code>items</code>.</p>
     *
     * @param items a {@link java.util.List} object.
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
