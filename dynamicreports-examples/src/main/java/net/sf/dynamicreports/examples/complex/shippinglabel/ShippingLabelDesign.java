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

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.barcode.Code128BarcodeBuilder;
import net.sf.dynamicreports.report.builder.barcode.Ean128BarcodeBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.bcode;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ShippingLabelDesign class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class ShippingLabelDesign {
    private ShippingLabelData data = new ShippingLabelData();
    private StyleBuilder bold14Style;

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        ShippingLabelDesign design = new ShippingLabelDesign();
        try {
            JasperReportBuilder report = design.build();
            report.show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>build.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperReportBuilder build() throws DRException {
        JasperReportBuilder report = report();

        ShippingLabel shippingLabel = data.getShippingLabel();

        StyleBuilder textStyle = stl.style().setFontSize(12);
        bold14Style = stl.style(Templates.boldStyle).setFontSize(14);
        StyleBuilder boldCentered30Style = stl.style(bold14Style).setFontSize(30).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        StyleBuilder boldCentered100Style = stl.style(boldCentered30Style).setFontSize(100);

        Ean128BarcodeBuilder shippingContainerCode = bcode.ean128("100264835710351").setModuleWidth(2.5).setStyle(bold14Style);
        Code128BarcodeBuilder shipToPostalCode = bcode.code128("09820").setModuleWidth(3d).setStyle(bold14Style);
        TextFieldBuilder<Integer> priority = cmp.text(shippingLabel.getPriority()).setStyle(boldCentered100Style);
        TextFieldBuilder<String> pod = cmp.text(shippingLabel.getPod()).setStyle(boldCentered30Style);
        TextFieldBuilder<Date> dateShipped = cmp.text(exp.date(shippingLabel.getDateShipped())).setDataType(type.dateType());
        TextFieldBuilder<String> po = cmp.text(shippingLabel.getPo()).setStyle(boldCentered30Style);

        report.setTemplate(Templates.reportTemplate)
              .setPageFormat(PageType.A5)
              .setTextStyle(textStyle)
              .title(Templates.createTitleComponent("ShippingLabel"),
                     cmp.horizontalList(createCustomerComponent("From", shippingLabel.getFrom()), createCustomerComponent("To", shippingLabel.getTo())),
                     cmp.horizontalList(cmp.verticalList(createCellComponent("Priority", priority), createCellComponent("POD", pod)),
                                        cmp.verticalList(cmp.horizontalList(createCellComponent("Carrier", cmp.text(shippingLabel.getCarrier())), createCellComponent("Date shipped", dateShipped)),
                                                         cmp.horizontalList(createCellComponent("Weight", cmp.text(shippingLabel.getWeight())),
                                                                            createCellComponent("Quantity", cmp.text(shippingLabel.getQuantity()))),
                                                         createCellComponent("Ship to postal code", shipToPostalCode))), createCellComponent("PO", po),
                     createCellComponent("Serial shipping container", shippingContainerCode));

        return report;
    }

    private ComponentBuilder<?, ?> createCustomerComponent(String label, Customer customer) {
        VerticalListBuilder content = cmp.verticalList(cmp.text(customer.getName()), cmp.text(customer.getAddress()), cmp.text(customer.getCity()));
        return createCellComponent(label, content);
    }

    private ComponentBuilder<?, ?> createCellComponent(String label, ComponentBuilder<?, ?> content) {
        VerticalListBuilder cell = cmp.verticalList(cmp.text(label).setStyle(bold14Style), cmp.horizontalList(cmp.horizontalGap(20), content, cmp.horizontalGap(5)));
        cell.setStyle(stl.style(stl.pen2Point()));
        return cell;
    }
}
