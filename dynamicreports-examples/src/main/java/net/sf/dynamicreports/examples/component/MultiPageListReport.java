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
package net.sf.dynamicreports.examples.component;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.component.MultiPageListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.exception.DRException;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * <p>MultiPageListReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class MultiPageListReport {

    /**
     * <p>Constructor for MultiPageListReport.</p>
     */
    public MultiPageListReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new MultiPageListReport();
    }

    private void build() {
        StyleBuilder style = stl.style(stl.pen1Point()).setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.MIDDLE);

        MultiPageListBuilder multiPageList = cmp.multiPageList();
        for (int i = 0; i < 10; i++) {
            TextFieldBuilder<String> textField = cmp.text("Title component " + (i + 1)).setFixedHeight(100).setStyle(style);
            multiPageList.add(textField);
        }

        try {
            report().setTemplate(Templates.reportTemplate).title(Templates.createTitleComponent("MultiPageList")).summary(multiPageList).pageFooter(Templates.footerComponent).show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }
}
