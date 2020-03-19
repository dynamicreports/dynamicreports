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
package net.sf.dynamicreports.report.builder.group;

import net.sf.dynamicreports.report.base.DRGroup;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract GroupBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
@SuppressWarnings( {"unchecked", "rawtypes", "deprecation"})
public abstract class GroupBuilder<T extends GroupBuilder<T>> extends AbstractBuilder<T, DRGroup> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression valueExpression;

    /**
     * <p>Constructor for GroupBuilder.</p>
     */
    protected GroupBuilder() {
        super(new DRGroup(new DRTextField()));
    }

    /**
     * <p>Constructor for GroupBuilder.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    protected GroupBuilder(String name) {
        super(new DRGroup(name, new DRTextField()));
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected void setValueExpression(DRIExpression<?> valueExpression) {
        this.valueExpression = valueExpression;
    }

    /**
     * <p>setHeaderLayout.</p>
     *
     * @param headerLayout a {@link net.sf.dynamicreports.report.constant.GroupHeaderLayout} object.
     * @return a T object.
     */
    public T setHeaderLayout(GroupHeaderLayout headerLayout) {
        getObject().setHeaderLayout(headerLayout);
        return (T) this;
    }

    /**
     * <p>showColumnHeaderAndFooter.</p>
     *
     * @return a T object.
     */
    public T showColumnHeaderAndFooter() {
        return setShowColumnHeaderAndFooter(true);
    }

    /**
     * <p>setShowColumnHeaderAndFooter.</p>
     *
     * @param showColumnHeaderAndFooter a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setShowColumnHeaderAndFooter(Boolean showColumnHeaderAndFooter) {
        getObject().setShowColumnHeaderAndFooter(showColumnHeaderAndFooter);
        return (T) this;
    }

    /**
     * <p>setAddToTableOfContents.</p>
     *
     * @param addToTableOfContents a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setAddToTableOfContents(Boolean addToTableOfContents) {
        getObject().setAddToTableOfContents(addToTableOfContents);
        return (T) this;
    }

    /**
     * <p>setPrintSubtotalsWhenExpression.</p>
     *
     * @param printSubtotalsWhenExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setPrintSubtotalsWhenExpression(DRIExpression<Boolean> printSubtotalsWhenExpression) {
        getObject().setPrintSubtotalsWhenExpression(printSubtotalsWhenExpression);
        return (T) this;
    }

    /**
     * <p>setPadding.</p>
     *
     * @param padding a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setPadding(Integer padding) {
        getObject().setPadding(padding);
        return (T) this;
    }

    /**
     * <p>startInNewPage.</p>
     *
     * @return a T object.
     */
    public T startInNewPage() {
        return setStartInNewPage(true);
    }

    /**
     * <p>setStartInNewPage.</p>
     *
     * @param startInNewPage a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setStartInNewPage(Boolean startInNewPage) {
        getObject().setStartInNewPage(startInNewPage);
        return (T) this;
    }

    /**
     * <p>startInNewColumn.</p>
     *
     * @return a T object.
     */
    public T startInNewColumn() {
        return setStartInNewColumn(true);
    }

    /**
     * <p>setStartInNewColumn.</p>
     *
     * @param startInNewColumn a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setStartInNewColumn(Boolean startInNewColumn) {
        getObject().setStartInNewColumn(startInNewColumn);
        return (T) this;
    }

    /**
     * <p>reprintHeaderOnEachPage.</p>
     *
     * @return a T object.
     */
    public T reprintHeaderOnEachPage() {
        return setReprintHeaderOnEachPage(true);
    }

    /**
     * <p>setReprintHeaderOnEachPage.</p>
     *
     * @param reprintHeaderOnEachPage a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setReprintHeaderOnEachPage(Boolean reprintHeaderOnEachPage) {
        getObject().setReprintHeaderOnEachPage(reprintHeaderOnEachPage);
        return (T) this;
    }

    /**
     * <p>resetPageNumber.</p>
     *
     * @return a T object.
     */
    public T resetPageNumber() {
        return setResetPageNumber(true);
    }

    /**
     * <p>setResetPageNumber.</p>
     *
     * @param resetPageNumber a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setResetPageNumber(Boolean resetPageNumber) {
        getObject().setResetPageNumber(resetPageNumber);
        return (T) this;
    }

    /**
     * <p>setMinHeightToStartNewPage.</p>
     *
     * @param minHeightToStartNewPage a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setMinHeightToStartNewPage(Integer minHeightToStartNewPage) {
        getObject().setMinHeightToStartNewPage(minHeightToStartNewPage);
        return (T) this;
    }

    /**
     * <p>setFooterPosition.</p>
     *
     * @param footerPosition a {@link net.sf.dynamicreports.report.constant.GroupFooterPosition} object.
     * @return a T object.
     */
    public T setFooterPosition(GroupFooterPosition footerPosition) {
        getObject().setFooterPosition(footerPosition);
        return (T) this;
    }

    /**
     * <p>keepTogether.</p>
     *
     * @return a T object.
     */
    public T keepTogether() {
        return setKeepTogether(true);
    }

    /**
     * <p>setKeepTogether.</p>
     *
     * @param keepTogether a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setKeepTogether(Boolean keepTogether) {
        getObject().setKeepTogether(keepTogether);
        return (T) this;
    }

    /**
     * <p>headerWithSubtotal.</p>
     *
     * @return a T object.
     */
    public T headerWithSubtotal() {
        return setHeaderWithSubtotal(true);
    }

    /**
     * <p>setHeaderWithSubtotal.</p>
     *
     * @param headerWithSubtotal a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setHeaderWithSubtotal(Boolean headerWithSubtotal) {
        getObject().setHeaderWithSubtotal(headerWithSubtotal);
        return (T) this;
    }

    /**
     * <p>groupByDataType.</p>
     *
     * @return a T object.
     */
    public T groupByDataType() {
        return setGroupByDataType(true);
    }

    /**
     * <p>setGroupByDataType.</p>
     *
     * @param groupByDataType a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setGroupByDataType(Boolean groupByDataType) {
        getObject().setGroupByDataType(groupByDataType);
        return (T) this;
    }

    /**
     * <p>setStyle.</p>
     *
     * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a T object.
     */
    public T setStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getValueField().setStyle(style.getStyle());
        } else {
            getObject().getValueField().setStyle(null);
        }
        return (T) this;
    }

    /**
     * <p>setHorizontalAlignment.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalAlignment} object.
     * @return a T object.
     * @deprecated use setHorizontalTextAlignment instead
     */
    @Deprecated
    public T setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment != null) {
            getObject().getValueField().setHorizontalTextAlignment(HorizontalTextAlignment.valueOf(horizontalAlignment.name()));
        } else {
            getObject().getValueField().setHorizontalTextAlignment(null);
        }
        return (T) this;
    }

    /**
     * <p>setHorizontalTextAlignment.</p>
     *
     * @param horizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     * @return a T object.
     */
    public T setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
        getObject().getValueField().setHorizontalTextAlignment(horizontalTextAlignment);
        return (T) this;
    }

    /**
     * <p>setTitleStyle.</p>
     *
     * @param titleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a T object.
     */
    public T setTitleStyle(ReportStyleBuilder titleStyle) {
        if (titleStyle != null) {
            getObject().setTitleStyle(titleStyle.getStyle());
        } else {
            getObject().setTitleStyle(null);
        }
        return (T) this;
    }

    /**
     * <p>setTitleWidth.</p>
     *
     * @param titleWidth a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setTitleWidth(Integer titleWidth) {
        getObject().setTitleWidth(titleWidth);
        return (T) this;
    }

    // header

    /**
     * <p>setHeaderSplitType.</p>
     *
     * @param splitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     * @return a T object.
     */
    public T setHeaderSplitType(SplitType splitType) {
        getObject().getHeaderBand().setSplitType(splitType);
        return (T) this;
    }

    /**
     * <p>setHeaderPrintWhenExpression.</p>
     *
     * @param printWhenExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setHeaderPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getHeaderBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * <p>setHeaderStyle.</p>
     *
     * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a T object.
     */
    public T setHeaderStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getHeaderBand().getList().setStyle(style.build());
        } else {
            getObject().getHeaderBand().getList().setStyle(null);
        }
        return (T) this;
    }

    /**
     * <p>setHeaderBackgroundComponent.</p>
     *
     * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a T object.
     */
    public T setHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getHeaderBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * <p>addHeaderComponent.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a T object.
     */
    public T addHeaderComponent(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getHeaderBand().addComponent(component.build());
        }
        return (T) this;
    }

    /**
     * <p>header.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a T object.
     */
    public T header(ComponentBuilder<?, ?>... components) {
        return addHeaderComponent(components);
    }

    // footer

    /**
     * <p>setFooterSplitType.</p>
     *
     * @param splitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     * @return a T object.
     */
    public T setFooterSplitType(SplitType splitType) {
        getObject().getFooterBand().setSplitType(splitType);
        return (T) this;
    }

    /**
     * <p>setFooterPrintWhenExpression.</p>
     *
     * @param printWhenExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setFooterPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getFooterBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * <p>setFooterStyle.</p>
     *
     * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a T object.
     */
    public T setFooterStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getFooterBand().getList().setStyle(style.build());
        } else {
            getObject().getFooterBand().getList().setStyle(null);
        }
        return (T) this;
    }

    /**
     * <p>setFooterBackgroundComponent.</p>
     *
     * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a T object.
     */
    public T setFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getFooterBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * <p>addFooterComponent.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a T object.
     */
    public T addFooterComponent(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getFooterBand().addComponent(component.build());
        }
        return (T) this;
    }

    /**
     * <p>footer.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a T object.
     */
    public T footer(ComponentBuilder<?, ?>... components) {
        return addFooterComponent(components);
    }

    /** {@inheritDoc} */
    @Override
    protected void configure() {
        super.configure();
        getObject().getValueField().setValueExpression(valueExpression);
    }

    /**
     * <p>getGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.DRGroup} object.
     */
    public DRGroup getGroup() {
        return build();
    }
}
