/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.report.builder.tableofcontents;

import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.expression.SystemMessageExpression;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.HyperLinkType;
import net.sf.dynamicreports.report.constant.TableOfContentsPosition;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.definition.ReportParameters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>TableOfContentsCustomizer class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class TableOfContentsCustomizer implements DRITableOfContentsCustomizer {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * Constant <code>dots=""</code>
     */
    protected static String dots;

    static {
        StringBuilder dots = new StringBuilder(200);
        for (int i = 0; i < dots.capacity(); i++) {
            dots.append(".");
        }
        TableOfContentsCustomizer.dots = dots.toString();
    }

    protected ReportBuilder<?> report;
    protected List<JasperTocHeading> headingList;
    protected int headings;
    protected int levels;
    protected FieldBuilder<Integer> levelField;
    protected FieldBuilder<String> textField;
    protected FieldBuilder<String> referenceField;
    protected FieldBuilder<Integer> pageIndexField;
    protected HyperLinkBuilder referenceHyperLink;
    protected int pageIndexDigits;
    protected ReportStyleBuilder titleStyle;
    protected ReportStyleBuilder headingStyle;
    protected Map<Integer, ReportStyleBuilder> headingStyles;
    protected Integer textFixedWidth;
    protected Integer dotsFixedWidth;
    protected Integer pageIndexFixedWidth;
    protected TableOfContentsPosition position;

    /**
     * <p>Constructor for TableOfContentsCustomizer.</p>
     */
    public TableOfContentsCustomizer() {
        headingStyles = new HashMap<Integer, ReportStyleBuilder>();
    }

    /**
     * <p>init.</p>
     */
    protected void init() {
        levelField = field("level", type.integerType());
        textField = field("text", type.stringType());
        referenceField = field("reference", type.stringType());
        pageIndexField = field("pageIndex", type.integerType());

        referenceHyperLink = hyperLink();
        referenceHyperLink.setAnchor(new ReferenceExpression());
        referenceHyperLink.setType(HyperLinkType.LOCAL_ANCHOR);

        pageIndexDigits = String.valueOf(headings).length();

        if (titleStyle == null) {
            titleStyle = stl.style().bold().setFontSize(16).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setReport(ReportBuilder<?> report) {
        this.report = report;
    }

    /** {@inheritDoc} */
    @Override
    public void setHeadingList(List<JasperTocHeading> headingList) {
        this.headingList = headingList;
    }

    /** {@inheritDoc} */
    @Override
    public void setHeadings(int headings) {
        this.headings = headings;
    }

    /** {@inheritDoc} */
    @Override
    public void setLevels(int levels) {
        this.levels = levels;
    }

    /** {@inheritDoc} */
    @Override
    public void customize() {
        init();

        report.title(title(), cmp.filler().setFixedHeight(20)).fields(levelField, textField, referenceField, pageIndexField).detail(detailComponent());
    }

    /**
     * <p>title.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     */
    protected ComponentBuilder<?, ?> title() {
        return cmp.text(new SystemMessageExpression("table_of_contents")).setStyle(titleStyle);
    }

    /**
     * <p>detailComponent.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     */
    protected ComponentBuilder<?, ?> detailComponent() {
        VerticalListBuilder detailComponent = cmp.verticalList();
        for (int i = 0; i < levels; i++) {
            ComponentBuilder<?, ?> headingComponent = headingComponent(i);
            headingComponent.setPrintWhenExpression(new PrintHeadingExpression(i));
            headingComponent.removeLineWhenBlank();
            detailComponent.add(headingComponent);
        }
        return detailComponent;
    }

    /**
     * <p>headingComponent.</p>
     *
     * @param level a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     */
    protected ComponentBuilder<?, ?> headingComponent(int level) {
        HorizontalListBuilder headingComponent = cmp.horizontalList();

        if (level > 0) {
            headingComponent.add(cmp.filler().setFixedWidth(level * 10));
        }

        TextFieldBuilder<String> textComponent = cmp.text(textField).setHyperLink(referenceHyperLink);
        if (textFixedWidth != null) {
            textComponent.setFixedWidth(textFixedWidth);
        }
        headingComponent.add(textComponent);

        if (level > 0) {
            headingComponent.add(cmp.filler().setFixedWidth(level * 10));
        }

        TextFieldBuilder<String> dotsComponent = cmp.text(dots.toString()).setStretchWithOverflow(false).setHyperLink(referenceHyperLink);
        if (dotsFixedWidth != null) {
            dotsComponent.setFixedWidth(dotsFixedWidth);
        }
        headingComponent.add(dotsComponent);

        TextFieldBuilder<Integer> pageIndexComponent = cmp.text(pageIndexField).setHyperLink(referenceHyperLink);
        if (pageIndexFixedWidth != null) {
            pageIndexComponent.setFixedWidth(pageIndexFixedWidth);
        } else {
            pageIndexComponent.setFixedColumns(pageIndexDigits);
        }
        headingComponent.add(pageIndexComponent);

        ReportStyleBuilder headingStyle = headingStyles.get(level);
        if (headingStyle == null) {
            headingStyle = this.headingStyle;
        }
        if (headingStyle != null) {
            textComponent.setStyle(headingStyle);
            dotsComponent.setStyle(headingStyle);
            pageIndexComponent.setStyle(headingStyle);
        }

        return headingComponent;
    }

    /**
     * <p>Setter for the field <code>titleStyle</code>.</p>
     *
     * @param titleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     */
    public void setTitleStyle(ReportStyleBuilder titleStyle) {
        this.titleStyle = titleStyle;
    }

    /**
     * <p>Setter for the field <code>headingStyle</code>.</p>
     *
     * @param headingStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     */
    public void setHeadingStyle(ReportStyleBuilder headingStyle) {
        this.headingStyle = headingStyle;
    }

    /**
     * <p>Setter for the field <code>headingStyle</code>.</p>
     *
     * @param level        a int.
     * @param headingStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     */
    public void setHeadingStyle(int level, ReportStyleBuilder headingStyle) {
        this.headingStyles.put(level, headingStyle);
    }

    /**
     * <p>Setter for the field <code>textFixedWidth</code>.</p>
     *
     * @param textFixedWidth a {@link java.lang.Integer} object.
     */
    public void setTextFixedWidth(Integer textFixedWidth) {
        this.textFixedWidth = textFixedWidth;
    }

    /**
     * <p>Setter for the field <code>dotsFixedWidth</code>.</p>
     *
     * @param dotsFixedWidth a {@link java.lang.Integer} object.
     */
    public void setDotsFixedWidth(Integer dotsFixedWidth) {
        this.dotsFixedWidth = dotsFixedWidth;
    }

    /**
     * <p>Setter for the field <code>pageIndexFixedWidth</code>.</p>
     *
     * @param pageIndexFixedWidth a {@link java.lang.Integer} object.
     */
    public void setPageIndexFixedWidth(Integer pageIndexFixedWidth) {
        this.pageIndexFixedWidth = pageIndexFixedWidth;
    }

    /** {@inheritDoc} */
    @Override
    public TableOfContentsPosition getPosition() {
        return position;
    }

    /**
     * <p>Setter for the field <code>position</code>.</p>
     *
     * @param position a {@link net.sf.dynamicreports.report.constant.TableOfContentsPosition} object.
     */
    public void setPosition(TableOfContentsPosition position) {
        this.position = position;
    }

    protected class ReferenceExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue(referenceField);
        }
    }

    protected class PrintHeadingExpression extends AbstractSimpleExpression<Boolean> {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

        private int level;

        public PrintHeadingExpression(int level) {
            this.level = level;
        }

        @Override
        public Boolean evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue(levelField) == level;
        }
    }
}
