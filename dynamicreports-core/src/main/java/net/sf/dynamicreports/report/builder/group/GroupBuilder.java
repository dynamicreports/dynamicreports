/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public abstract class GroupBuilder<T extends GroupBuilder<T>> extends AbstractBuilder<T, DRGroup> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression valueExpression;

	protected GroupBuilder() {
		super(new DRGroup(new DRTextField()));
	}

	protected GroupBuilder(String name) {
		super(new DRGroup(name, new DRTextField()));
	}

	protected void setValueExpression(DRIExpression<?> valueExpression) {
		this.valueExpression = valueExpression;
	}

	public T setHeaderLayout(GroupHeaderLayout headerLayout) {
		getObject().setHeaderLayout(headerLayout);
		return (T) this;
	}

	public T showColumnHeaderAndFooter() {
		return setShowColumnHeaderAndFooter(true);
	}

	public T setShowColumnHeaderAndFooter(Boolean showColumnHeaderAndFooter) {
		getObject().setShowColumnHeaderAndFooter(showColumnHeaderAndFooter);
		return (T) this;
	}

	public T setAddToTableOfContents(Boolean addToTableOfContents) {
		getObject().setAddToTableOfContents(addToTableOfContents);
		return (T) this;
	}

	public T setPrintSubtotalsWhenExpression(DRIExpression<Boolean> printSubtotalsWhenExpression) {
		getObject().setPrintSubtotalsWhenExpression(printSubtotalsWhenExpression);
		return (T) this;
	}

	public T setPadding(Integer padding) {
		getObject().setPadding(padding);
		return (T) this;
	}

	public T startInNewPage() {
		return setStartInNewPage(true);
	}

	public T setStartInNewPage(Boolean startInNewPage) {
		getObject().setStartInNewPage(startInNewPage);
		return (T) this;
	}

	public T startInNewColumn() {
		return setStartInNewColumn(true);
	}

	public T setStartInNewColumn(Boolean startInNewColumn) {
		getObject().setStartInNewColumn(startInNewColumn);
		return (T) this;
	}

	public T reprintHeaderOnEachPage() {
		return setReprintHeaderOnEachPage(true);
	}

	public T setReprintHeaderOnEachPage(Boolean reprintHeaderOnEachPage) {
		getObject().setReprintHeaderOnEachPage(reprintHeaderOnEachPage);
		return (T) this;
	}

	public T resetPageNumber() {
		return setResetPageNumber(true);
	}

	public T setResetPageNumber(Boolean resetPageNumber) {
		getObject().setResetPageNumber(resetPageNumber);
		return (T) this;
	}

	public T setMinHeightToStartNewPage(Integer minHeightToStartNewPage) {
		getObject().setMinHeightToStartNewPage(minHeightToStartNewPage);
		return (T) this;
	}

	public T setFooterPosition(GroupFooterPosition footerPosition) {
		getObject().setFooterPosition(footerPosition);
		return (T) this;
	}

	public T keepTogether() {
		return setKeepTogether(true);
	}

	public T setKeepTogether(Boolean keepTogether) {
		getObject().setKeepTogether(keepTogether);
		return (T) this;
	}

	public T headerWithSubtotal() {
		return setHeaderWithSubtotal(true);
	}

	public T setHeaderWithSubtotal(Boolean headerWithSubtotal) {
		getObject().setHeaderWithSubtotal(headerWithSubtotal);
		return (T) this;
	}

	public T groupByDataType() {
		return setGroupByDataType(true);
	}

	public T setGroupByDataType(Boolean groupByDataType) {
		getObject().setGroupByDataType(groupByDataType);
		return (T) this;
	}

	public T setStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().getValueField().setStyle(style.getStyle());
		} else {
			getObject().getValueField().setStyle(null);
		}
		return (T) this;
	}

	/**
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

	public T setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		getObject().getValueField().setHorizontalTextAlignment(horizontalTextAlignment);
		return (T) this;
	}

	public T setTitleStyle(ReportStyleBuilder titleStyle) {
		if (titleStyle != null) {
			getObject().setTitleStyle(titleStyle.getStyle());
		} else {
			getObject().setTitleStyle(null);
		}
		return (T) this;
	}

	public T setTitleWidth(Integer titleWidth) {
		getObject().setTitleWidth(titleWidth);
		return (T) this;
	}

	// header
	public T setHeaderSplitType(SplitType splitType) {
		getObject().getHeaderBand().setSplitType(splitType);
		return (T) this;
	}

	public T setHeaderPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
		getObject().getHeaderBand().setPrintWhenExpression(printWhenExpression);
		return (T) this;
	}

	public T setHeaderStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().getHeaderBand().getList().setStyle(style.build());
		} else {
			getObject().getHeaderBand().getList().setStyle(null);
		}
		return (T) this;
	}

	public T setHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().getHeaderBand().getList().setBackgroundComponent(backgroundComponent.build());
		return (T) this;
	}

	public T addHeaderComponent(ComponentBuilder<?, ?>... components) {
		Validate.notNull(components, "components must not be null");
		Validate.noNullElements(components, "components must not contains null component");
		for (ComponentBuilder<?, ?> component : components) {
			getObject().getHeaderBand().addComponent(component.build());
		}
		return (T) this;
	}

	public T header(ComponentBuilder<?, ?>... components) {
		return addHeaderComponent(components);
	}

	// footer
	public T setFooterSplitType(SplitType splitType) {
		getObject().getFooterBand().setSplitType(splitType);
		return (T) this;
	}

	public T setFooterPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
		getObject().getFooterBand().setPrintWhenExpression(printWhenExpression);
		return (T) this;
	}

	public T setFooterStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().getFooterBand().getList().setStyle(style.build());
		} else {
			getObject().getFooterBand().getList().setStyle(null);
		}
		return (T) this;
	}

	public T setFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().getFooterBand().getList().setBackgroundComponent(backgroundComponent.build());
		return (T) this;
	}

	public T addFooterComponent(ComponentBuilder<?, ?>... components) {
		Validate.notNull(components, "components must not be null");
		Validate.noNullElements(components, "components must not contains null component");
		for (ComponentBuilder<?, ?> component : components) {
			getObject().getFooterBand().addComponent(component.build());
		}
		return (T) this;
	}

	public T footer(ComponentBuilder<?, ?>... components) {
		return addFooterComponent(components);
	}

	@Override
	protected void configure() {
		super.configure();
		getObject().getValueField().setValueExpression(valueExpression);
	}

	public DRGroup getGroup() {
		return build();
	}
}
