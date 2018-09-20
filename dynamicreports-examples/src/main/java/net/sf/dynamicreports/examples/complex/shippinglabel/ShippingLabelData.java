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

import net.sf.jasperreports.engine.JRDataSource;

import java.util.Date;

/**
 * <p>ShippingLabelData class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ShippingLabelData {
    private ShippingLabel shippingLabel;

    /**
     * <p>Constructor for ShippingLabelData.</p>
     */
    public ShippingLabelData() {
        shippingLabel = createShippingLabel();
    }

    private ShippingLabel createShippingLabel() {
        ShippingLabel shippingLabel = new ShippingLabel();

        shippingLabel.setFrom(createCustomer("Mary Patterson", "151 Pompton St.", "Washington"));
        shippingLabel.setTo(createCustomer("Peter Marsh", "23 Baden Av.", "New York"));
        shippingLabel.setPriority(1);
        shippingLabel.setPod("RJX");
        shippingLabel.setCarrier("849263");
        shippingLabel.setDateShipped(new Date());
        shippingLabel.setWeight(1290);
        shippingLabel.setQuantity(26);
        shippingLabel.setShipToPostalCode("09820");
        shippingLabel.setPo("8492640276542");
        shippingLabel.setSerialShippingContainer("100264835710351");

        return shippingLabel;
    }

    private Customer createCustomer(String name, String address, String city) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setCity(city);
        return customer;
    }

    /**
     * <p>Getter for the field <code>shippingLabel</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.shippinglabel.ShippingLabel} object.
     */
    public ShippingLabel getShippingLabel() {
        return shippingLabel;
    }

    /**
     * <p>createDataSource.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRDataSource} object.
     */
    public JRDataSource createDataSource() {
        return null;
    }
}
