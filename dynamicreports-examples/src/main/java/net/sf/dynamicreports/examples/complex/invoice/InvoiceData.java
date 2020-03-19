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

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>InvoiceData class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class InvoiceData {
    private Invoice invoice;

    /**
     * <p>Constructor for InvoiceData.</p>
     */
    public InvoiceData() {
        invoice = createInvoice();
    }

    private Invoice createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(5);
        invoice.setShipping(BigDecimal.valueOf(10));
        invoice.setTax(0.2);

        invoice.setBillTo(createCustomer("Mary Patterson", "151 Pompton St.", "Washington", "mpatterson@noemail.com"));
        invoice.setShipTo(createCustomer("Peter Marsh", "23 Baden Av.", "New York", null));

        List<Item> items = new ArrayList<Item>();
        items.add(createItem("Notebook", 1, BigDecimal.valueOf(1000)));
        items.add(createItem("DVD", 5, BigDecimal.valueOf(40)));
        items.add(createItem("Book", 2, BigDecimal.valueOf(10)));
        items.add(createItem("Phone", 1, BigDecimal.valueOf(200)));
        invoice.setItems(items);

        return invoice;
    }

    private Customer createCustomer(String name, String address, String city, String email) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setEmail(email);
        return customer;
    }

    private Item createItem(String description, Integer quantity, BigDecimal unitprice) {
        Item item = new Item();
        item.setDescription(description);
        item.setQuantity(quantity);
        item.setUnitprice(unitprice);
        return item;
    }

    /**
     * <p>Getter for the field <code>invoice</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.invoice.Invoice} object.
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * <p>createDataSource.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRDataSource} object.
     */
    public JRDataSource createDataSource() {
        return new JRBeanCollectionDataSource(invoice.getItems());
    }
}
