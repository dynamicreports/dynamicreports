/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.examples.datasource;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>CollectionDatasourceReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CollectionDatasourceReport {

    /**
     * <p>Constructor for CollectionDatasourceReport.</p>
     */
    public CollectionDatasourceReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new CollectionDatasourceReport();
    }

    private void build() {
        SubreportBuilder subreport = cmp.subreport(createSubreport())
                                        .setDataSource(exp.subDatasourceBeanCollection("subData"));

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(col.column("Item", "item", type.stringType()), col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitPrice", type.bigDecimalType()))
                    .title(Templates.createTitleComponent("CollectionDatasource"))
                    .detailFooter(cmp.horizontalList(cmp.horizontalGap(150), subreport, cmp.horizontalGap(150)), cmp.line())
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JasperReportBuilder createSubreport() {
        JasperReportBuilder report = report();
        report.setTemplate(Templates.reportTemplate)
              .title(cmp.text("SubData")
                        .setStyle(Templates.boldCenteredStyle))
              .columns(col.column("Order date", "orderDate", type.dateType()), col.column("Quantity", "quantity", type.integerType()));

        return report;
    }

    private JRDataSource createDataSource() {
        List<Data> data = new ArrayList<Data>();

        List<SubData> subData = new ArrayList<SubData>();
        subData.add(new SubData(toDate(2011, 0, 10), 2));
        subData.add(new SubData(toDate(2011, 0, 15), 3));
        data.add(new Data("DVD", 5, new BigDecimal(30), subData));

        subData = new ArrayList<SubData>();
        subData.add(new SubData(toDate(2011, 0, 11), 1));
        subData.add(new SubData(toDate(2011, 0, 12), 3));
        subData.add(new SubData(toDate(2011, 0, 16), 4));
        data.add(new Data("Book", 8, new BigDecimal(11), subData));

        subData = new ArrayList<SubData>();
        subData.add(new SubData(toDate(2011, 0, 9), 1));
        subData.add(new SubData(toDate(2011, 0, 18), 1));
        data.add(new Data("PDA", 2, new BigDecimal(15), subData));

        return new JRBeanCollectionDataSource(data);
    }

    private Date toDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    public class Data {
        private String item;
        private Integer quantity;
        private BigDecimal unitPrice;
        private List<SubData> subData;

        public Data(String item, Integer quantity, BigDecimal unitPrice, List<SubData> subData) {
            this.item = item;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.subData = subData;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
        }

        public List<SubData> getSubData() {
            return subData;
        }

        public void setSubData(List<SubData> subData) {
            this.subData = subData;
        }
    }

    public class SubData {
        private Date orderDate;
        private Integer quantity;

        public SubData(Date orderDate, Integer quantity) {
            this.orderDate = orderDate;
            this.quantity = quantity;
        }

        public Date getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
