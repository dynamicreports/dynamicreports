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
package net.sf.dynamicreports.examples.complex.invoice;

import java.math.BigDecimal;

/**
 * <p>Item class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class Item {
    private String description;
    private Integer quantity;
    private BigDecimal unitprice;

    /**
     * <p>Getter for the field <code>description</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>Setter for the field <code>description</code>.</p>
     *
     * @param description a {@link java.lang.String} object.
     */
    public void setDescription(String description) {
        this.description = description;
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
     * <p>Getter for the field <code>unitprice</code>.</p>
     *
     * @return a {@link java.math.BigDecimal} object.
     */
    public BigDecimal getUnitprice() {
        return unitprice;
    }

    /**
     * <p>Setter for the field <code>unitprice</code>.</p>
     *
     * @param unitprice a {@link java.math.BigDecimal} object.
     */
    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }
}
