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
package net.sf.dynamicreports.examples.column;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.InputStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.bcode;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ComponentColumnReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class ComponentColumnReport {

    /**
     * <p>Constructor for ComponentColumnReport.</p>
     */
    public ComponentColumnReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ComponentColumnReport();
    }

    private void build() {
        try {
            ImageBuilder image = cmp.image(new ImageExpression()).setFixedDimension(48, 48);
            HorizontalListBuilder itemComponent = cmp.horizontalList(image, cmp.verticalList(cmp.text(new ItemExpression()), bcode.ean128(new BarcodeExpression()).setFixedHeight(24)));

            report().setTemplate(Templates.reportTemplate)
                    .fields(field("image", String.class), field("barcode", String.class))
                    .columns(col.componentColumn("Image", image), col.column("Item", "item", type.stringType()), col.componentColumn("Item", itemComponent))
                    .title(Templates.createTitleComponent("ComponentColumn"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "image", "barcode");
        dataSource.add("PDA", "pda", "100264832717658");
        dataSource.add("Camera", "camera", "100364875790352");
        dataSource.add("Camera", "camera", "100764935316351");
        dataSource.add("USB", "usb", "100864565780343");
        dataSource.add("PDA", "pda", "100264865712551");
        dataSource.add("USB", "usb", "100268834723431");
        return dataSource;
    }

    public class ImageExpression extends AbstractSimpleExpression<InputStream> {
        private static final long serialVersionUID = 1L;

        @Override
        public InputStream evaluate(ReportParameters reportParameters) {
            return Templates.class.getResourceAsStream("images/" + reportParameters.getValue("image") + ".png");
        }
    }

    public class ItemExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue("item");
        }
    }

    public class BarcodeExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue("barcode");
        }
    }
}
