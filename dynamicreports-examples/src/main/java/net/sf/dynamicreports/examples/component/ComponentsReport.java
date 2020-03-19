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
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.exception.DRException;

import java.net.URL;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * <p>ComponentsReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class ComponentsReport {

    /**
     * <p>Constructor for ComponentsReport.</p>
     */
    public ComponentsReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ComponentsReport();
    }

    private void build() {
        URL image = Templates.class.getResource("images/pda.png");

        try {
            report().setTemplate(template().setBarcodeHeight(50))
                    .setTextStyle(stl.style(stl.pen1Point()))
                    .title(Templates.createTitleComponent("Components"), components("rectangle", cmp.rectangle(), "round rectangle", cmp.roundRectangle(10), "ellipse", cmp.ellipse()),
                           cmp.verticalGap(10), components("text field", cmp.text("text"), "image", cmp.image(image).setFixedDimension(30, 30), "line", cmp.line()), cmp.verticalGap(10),
                           components("boolean field", cmp.booleanField(true).setComponentType(BooleanComponentType.IMAGE_CHECKBOX_2).setFixedDimension(20, 20), "center horizontal",
                                      cmp.centerHorizontal(cmp.image(image).setFixedDimension(50, 50)), "center vertical", cmp.centerVertical(cmp.text("text").setFixedRows(1))), cmp.verticalGap(10),
                           components("text field", cmp.text("text"), "empty space", cmp.filler(), "text field", cmp.text("text")), cmp.verticalGap(50),
                           cmp.horizontalList(cmp.text("text"), cmp.horizontalGap(100), cmp.text("text")),
                           cmp.xyList().add(50, 15, cmp.text("text")).add(110, 20, cmp.text("text")).add(170, 25, cmp.text("text")))
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private ComponentBuilder<?, ?> components(String label1, ComponentBuilder<?, ?> component1, String label2, ComponentBuilder<?, ?> component2, String label3, ComponentBuilder<?, ?> component3) {
        HorizontalListBuilder list = cmp.horizontalList().setGap(10);
        list.add(component(label1, component1));
        list.add(component(label2, component2));
        list.add(component(label3, component3));
        return list;
    }

    private ComponentBuilder<?, ?> component(String label, ComponentBuilder<?, ?> component) {
        TextFieldBuilder<String> labelField = cmp.text(label).setFixedRows(1).setStyle(Templates.bold12CenteredStyle);
        return cmp.verticalList(labelField, component);
    }
}
