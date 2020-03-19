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
package net.sf.dynamicreports.examples;

import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;

import java.awt.Color;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsCustomizer;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * <p>Templates class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class Templates {
    /**
     * Constant <code>rootStyle</code>
     */
    public static final StyleBuilder rootStyle;
    /**
     * Constant <code>boldStyle</code>
     */
    public static final StyleBuilder boldStyle;
    /**
     * Constant <code>italicStyle</code>
     */
    public static final StyleBuilder italicStyle;
    /**
     * Constant <code>boldCenteredStyle</code>
     */
    public static final StyleBuilder boldCenteredStyle;
    /**
     * Constant <code>bold12CenteredStyle</code>
     */
    public static final StyleBuilder bold12CenteredStyle;
    /**
     * Constant <code>bold18CenteredStyle</code>
     */
    public static final StyleBuilder bold18CenteredStyle;
    /**
     * Constant <code>bold22CenteredStyle</code>
     */
    public static final StyleBuilder bold22CenteredStyle;
    /**
     * Constant <code>columnStyle</code>
     */
    public static final StyleBuilder columnStyle;
    /**
     * Constant <code>columnTitleStyle</code>
     */
    public static final StyleBuilder columnTitleStyle;
    /**
     * Constant <code>groupStyle</code>
     */
    public static final StyleBuilder groupStyle;
    /**
     * Constant <code>subtotalStyle</code>
     */
    public static final StyleBuilder subtotalStyle;

    /**
     * Constant <code>reportTemplate</code>
     */
    public static final ReportTemplateBuilder reportTemplate;
    /**
     * Constant <code>currencyType</code>
     */
    public static final CurrencyType currencyType;
    /**
     * Constant <code>dynamicReportsComponent</code>
     */
    public static final ComponentBuilder<?, ?> dynamicReportsComponent;
    /**
     * Constant <code>footerComponent</code>
     */
    public static final ComponentBuilder<?, ?> footerComponent;

    static {
        rootStyle = stl.style().setPadding(2);
        boldStyle = stl.style(rootStyle).bold();
        italicStyle = stl.style(rootStyle).italic();
        boldCenteredStyle = stl.style(boldStyle).setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.MIDDLE);
        bold12CenteredStyle = stl.style(boldCenteredStyle).setFontSize(12);
        bold18CenteredStyle = stl.style(boldCenteredStyle).setFontSize(18);
        bold22CenteredStyle = stl.style(boldCenteredStyle).setFontSize(22);
        columnStyle = stl.style(rootStyle).setVerticalTextAlignment(VerticalTextAlignment.MIDDLE);
        columnTitleStyle = stl.style(columnStyle).setBorder(stl.pen1Point()).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER).setBackgroundColor(Color.LIGHT_GRAY).bold();
        groupStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        subtotalStyle = stl.style(boldStyle).setTopBorder(stl.pen1Point());

        StyleBuilder crosstabGroupStyle = stl.style(columnTitleStyle);
        StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle).setBackgroundColor(new Color(170, 170, 170));
        StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle).setBackgroundColor(new Color(140, 140, 140));
        StyleBuilder crosstabCellStyle = stl.style(columnStyle).setBorder(stl.pen1Point());

        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer().setHeadingStyle(0, stl.style(rootStyle).bold());

        reportTemplate = template().setLocale(Locale.ENGLISH)
                                   .setColumnStyle(columnStyle)
                                   .setColumnTitleStyle(columnTitleStyle)
                                   .setGroupStyle(groupStyle)
                                   .setGroupTitleStyle(groupStyle)
                                   .setSubtotalStyle(subtotalStyle)
                                   .highlightDetailEvenRows()
                                   .crosstabHighlightEvenRows()
                                   .setCrosstabGroupStyle(crosstabGroupStyle)
                                   .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
                                   .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
                                   .setCrosstabCellStyle(crosstabCellStyle)
                                   .setTableOfContentsCustomizer(tableOfContentsCustomizer);

        currencyType = new CurrencyType();

        HyperLinkBuilder link = hyperLink("http://www.dynamicreports.org");
        dynamicReportsComponent = cmp.horizontalList(cmp.image(Templates.class.getResource("images/dynamicreports.png")).setFixedDimension(60, 60),
                                                     cmp.verticalList(cmp.text("DynamicReports").setStyle(bold22CenteredStyle).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT),
                                                                      cmp.text("http://www.dynamicreports.org").setStyle(italicStyle).setHyperLink(link))).setFixedWidth(300);

        footerComponent = cmp.pageXofY().setStyle(stl.style(boldCenteredStyle).setTopBorder(stl.pen1Point()));
    }

    /**
     * Creates custom component which is possible to add to any report band component
     *
     * @param label a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     */
    public static ComponentBuilder<?, ?> createTitleComponent(String label) {
        return cmp.horizontalList()
                  .add(dynamicReportsComponent, cmp.text(label).setStyle(bold18CenteredStyle).setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT))
                  .newRow()
                  .add(cmp.line())
                  .newRow()
                  .add(cmp.verticalGap(10));
    }

    /**
     * <p>createCurrencyValueFormatter.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.examples.Templates.CurrencyValueFormatter} object.
     */
    public static CurrencyValueFormatter createCurrencyValueFormatter(String label) {
        return new CurrencyValueFormatter(label);
    }

    public static class CurrencyType extends BigDecimalType {
        private static final long serialVersionUID = 1L;

        @Override
        public String getPattern() {
            return "$ #,###.00";
        }
    }

    private static class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {
        private static final long serialVersionUID = 1L;

        private String label;

        public CurrencyValueFormatter(String label) {
            this.label = label;
        }

        @Override
        public String format(Number value, ReportParameters reportParameters) {
            return label + currencyType.valueToString(value, reportParameters.getLocale());
        }
    }
}
