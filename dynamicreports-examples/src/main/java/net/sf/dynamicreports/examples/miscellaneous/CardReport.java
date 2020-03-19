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
package net.sf.dynamicreports.examples.miscellaneous;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * <p>CardReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class CardReport {

    /**
     * <p>Constructor for CardReport.</p>
     */
    public CardReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new CardReport();
    }

    private void build() {
        ComponentBuilder<?, ?> cardComponent = createCardComponent();
        HorizontalListBuilder cards = cmp.horizontalFlowList();
        for (int i = 0; i < 10; i++) {
            cards.add(cardComponent);
        }

        try {
            report().setTemplate(Templates.reportTemplate).setTextStyle(stl.style()).setPageFormat(PageType.A5).title(Templates.createTitleComponent("Card"), cards).show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private ComponentBuilder<?, ?> createCardComponent() {
        HorizontalListBuilder cardComponent = cmp.horizontalList();
        StyleBuilder cardStyle = stl.style(stl.pen1Point()).setPadding(10);
        cardComponent.setStyle(cardStyle);

        ImageBuilder image = cmp.image(Templates.class.getResource("images/user_male.png")).setFixedDimension(60, 60);
        cardComponent.add(cmp.hListCell(image).heightFixedOnMiddle());
        cardComponent.add(cmp.horizontalGap(10));

        StyleBuilder boldStyle = stl.style().bold();
        VerticalListBuilder content =
            cmp.verticalList(cmp.text("Name:").setStyle(boldStyle), cmp.text("Peter Marsh"), cmp.text("Address:").setStyle(boldStyle), cmp.text("23 Baden Av."), cmp.text("City:").setStyle(boldStyle),
                             cmp.text("New York"));

        cardComponent.add(content);
        return cardComponent;
    }
}
