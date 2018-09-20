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

/**
 * <p>Customer class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Customer {
    private String name;
    private String address;
    private String city;
    private String email;

    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter for the field <code>address</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>Setter for the field <code>address</code>.</p>
     *
     * @param address a {@link java.lang.String} object.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <p>Getter for the field <code>city</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCity() {
        return city;
    }

    /**
     * <p>Setter for the field <code>city</code>.</p>
     *
     * @param city a {@link java.lang.String} object.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * <p>Getter for the field <code>email</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>Setter for the field <code>email</code>.</p>
     *
     * @param email a {@link java.lang.String} object.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
