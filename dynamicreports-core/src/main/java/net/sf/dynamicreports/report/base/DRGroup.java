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

package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import org.apache.commons.lang3.Validate;

/**
 * <p>DRGroup class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRGroup implements DRIGroup {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private DRTextField<?> valueField;
	private DRIExpression<?> titleExpression;
	private DRIReportStyle titleStyle;
	private Integer titleWidth;
	private GroupHeaderLayout headerLayout;
	private Boolean hideColumn;
	private Boolean groupByDataType;
	private Boolean showColumnHeaderAndFooter;
	private Boolean addToTableOfContents;
	private DRIExpression<Boolean> printSubtotalsWhenExpression;
	private Integer padding;
	private Boolean startInNewPage;
	private Boolean startInNewColumn;
	private Boolean reprintHeaderOnEachPage;
	private Boolean resetPageNumber;
	private Integer minHeightToStartNewPage;
	private GroupFooterPosition footerPosition;
	private Boolean keepTogether;
	private Boolean headerWithSubtotal;
	private DRBand headerBand;
	private DRBand footerBand;

	/**
	 * <p>Constructor for DRGroup.</p>
	 *
	 * @param valueField a {@link net.sf.dynamicreports.report.base.component.DRTextField} object.
	 */
	public DRGroup(DRTextField<?> valueField) {
		this(ReportUtils.generateUniqueName("group"), valueField);
	}

	/**
	 * <p>Constructor for DRGroup.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param valueField a {@link net.sf.dynamicreports.report.base.component.DRTextField} object.
	 */
	public DRGroup(String name, DRTextField<?> valueField) {
		Validate.notEmpty(name, "name must not be empty");
		Validate.notNull(valueField, "valueField must not be null");
		this.name = name;
		this.valueField = valueField;
		init();
	}

	private void init() {
		headerBand = new DRBand();
		footerBand = new DRBand();
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return name;
	}

	/** {@inheritDoc} */
	@Override
	public DRTextField<?> getValueField() {
		return valueField;
	}

	/** {@inheritDoc} */
	@Override
	public DRIExpression<?> getTitleExpression() {
		return titleExpression;
	}

	/**
	 * <p>Setter for the field <code>titleExpression</code>.</p>
	 *
	 * @param titleExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public void setTitleExpression(DRIExpression<?> titleExpression) {
		this.titleExpression = titleExpression;
	}

	/** {@inheritDoc} */
	@Override
	public DRIReportStyle getTitleStyle() {
		return titleStyle;
	}

	/**
	 * <p>Setter for the field <code>titleStyle</code>.</p>
	 *
	 * @param titleStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public void setTitleStyle(DRIReportStyle titleStyle) {
		this.titleStyle = titleStyle;
	}

	/** {@inheritDoc} */
	@Override
	public Integer getTitleWidth() {
		return titleWidth;
	}

	/**
	 * <p>Setter for the field <code>titleWidth</code>.</p>
	 *
	 * @param titleWidth a {@link java.lang.Integer} object.
	 */
	public void setTitleWidth(Integer titleWidth) {
		this.titleWidth = titleWidth;
	}

	/** {@inheritDoc} */
	@Override
	public GroupHeaderLayout getHeaderLayout() {
		return headerLayout;
	}

	/**
	 * <p>Setter for the field <code>headerLayout</code>.</p>
	 *
	 * @param headerLayout a {@link net.sf.dynamicreports.report.constant.GroupHeaderLayout} object.
	 */
	public void setHeaderLayout(GroupHeaderLayout headerLayout) {
		this.headerLayout = headerLayout;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getHideColumn() {
		return hideColumn;
	}

	/**
	 * <p>Setter for the field <code>hideColumn</code>.</p>
	 *
	 * @param hideColumn a {@link java.lang.Boolean} object.
	 */
	public void setHideColumn(Boolean hideColumn) {
		this.hideColumn = hideColumn;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getGroupByDataType() {
		return groupByDataType;
	}

	/**
	 * <p>Setter for the field <code>groupByDataType</code>.</p>
	 *
	 * @param groupByDataType a {@link java.lang.Boolean} object.
	 */
	public void setGroupByDataType(Boolean groupByDataType) {
		this.groupByDataType = groupByDataType;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getShowColumnHeaderAndFooter() {
		return showColumnHeaderAndFooter;
	}

	/**
	 * <p>Setter for the field <code>showColumnHeaderAndFooter</code>.</p>
	 *
	 * @param showColumnHeaderAndFooter a {@link java.lang.Boolean} object.
	 */
	public void setShowColumnHeaderAndFooter(Boolean showColumnHeaderAndFooter) {
		this.showColumnHeaderAndFooter = showColumnHeaderAndFooter;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getAddToTableOfContents() {
		return addToTableOfContents;
	}

	/**
	 * <p>Setter for the field <code>addToTableOfContents</code>.</p>
	 *
	 * @param addToTableOfContents a {@link java.lang.Boolean} object.
	 */
	public void setAddToTableOfContents(Boolean addToTableOfContents) {
		this.addToTableOfContents = addToTableOfContents;
	}

	/** {@inheritDoc} */
	@Override
	public DRIExpression<Boolean> getPrintSubtotalsWhenExpression() {
		return printSubtotalsWhenExpression;
	}

	/**
	 * <p>Setter for the field <code>printSubtotalsWhenExpression</code>.</p>
	 *
	 * @param printSubtotalsWhenExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public void setPrintSubtotalsWhenExpression(DRIExpression<Boolean> printSubtotalsWhenExpression) {
		this.printSubtotalsWhenExpression = printSubtotalsWhenExpression;
	}

	/** {@inheritDoc} */
	@Override
	public Integer getPadding() {
		return padding;
	}

	/**
	 * <p>Setter for the field <code>padding</code>.</p>
	 *
	 * @param padding a {@link java.lang.Integer} object.
	 */
	public void setPadding(Integer padding) {
		if (padding != null) {
			Validate.isTrue(padding >= 0, "padding must be >= 0");
		}
		this.padding = padding;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getStartInNewPage() {
		return startInNewPage;
	}

	/**
	 * <p>Setter for the field <code>startInNewPage</code>.</p>
	 *
	 * @param startInNewPage a {@link java.lang.Boolean} object.
	 */
	public void setStartInNewPage(Boolean startInNewPage) {
		this.startInNewPage = startInNewPage;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getStartInNewColumn() {
		return startInNewColumn;
	}

	/**
	 * <p>Setter for the field <code>startInNewColumn</code>.</p>
	 *
	 * @param startInNewColumn a {@link java.lang.Boolean} object.
	 */
	public void setStartInNewColumn(Boolean startInNewColumn) {
		this.startInNewColumn = startInNewColumn;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getReprintHeaderOnEachPage() {
		return reprintHeaderOnEachPage;
	}

	/**
	 * <p>Setter for the field <code>reprintHeaderOnEachPage</code>.</p>
	 *
	 * @param reprintHeaderOnEachPage a {@link java.lang.Boolean} object.
	 */
	public void setReprintHeaderOnEachPage(Boolean reprintHeaderOnEachPage) {
		this.reprintHeaderOnEachPage = reprintHeaderOnEachPage;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getResetPageNumber() {
		return resetPageNumber;
	}

	/**
	 * <p>Setter for the field <code>resetPageNumber</code>.</p>
	 *
	 * @param resetPageNumber a {@link java.lang.Boolean} object.
	 */
	public void setResetPageNumber(Boolean resetPageNumber) {
		this.resetPageNumber = resetPageNumber;
	}

	/** {@inheritDoc} */
	@Override
	public Integer getMinHeightToStartNewPage() {
		return minHeightToStartNewPage;
	}

	/**
	 * <p>Setter for the field <code>minHeightToStartNewPage</code>.</p>
	 *
	 * @param minHeightToStartNewPage a {@link java.lang.Integer} object.
	 */
	public void setMinHeightToStartNewPage(Integer minHeightToStartNewPage) {
		this.minHeightToStartNewPage = minHeightToStartNewPage;
	}

	/** {@inheritDoc} */
	@Override
	public GroupFooterPosition getFooterPosition() {
		return footerPosition;
	}

	/**
	 * <p>Setter for the field <code>footerPosition</code>.</p>
	 *
	 * @param footerPosition a {@link net.sf.dynamicreports.report.constant.GroupFooterPosition} object.
	 */
	public void setFooterPosition(GroupFooterPosition footerPosition) {
		this.footerPosition = footerPosition;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getKeepTogether() {
		return keepTogether;
	}

	/**
	 * <p>Setter for the field <code>keepTogether</code>.</p>
	 *
	 * @param keepTogether a {@link java.lang.Boolean} object.
	 */
	public void setKeepTogether(Boolean keepTogether) {
		this.keepTogether = keepTogether;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getHeaderWithSubtotal() {
		return headerWithSubtotal;
	}

	/**
	 * <p>Setter for the field <code>headerWithSubtotal</code>.</p>
	 *
	 * @param headerWithSubtotal a {@link java.lang.Boolean} object.
	 */
	public void setHeaderWithSubtotal(Boolean headerWithSubtotal) {
		this.headerWithSubtotal = headerWithSubtotal;
	}

	/** {@inheritDoc} */
	@Override
	public DRBand getHeaderBand() {
		return headerBand;
	}

	/** {@inheritDoc} */
	@Override
	public DRBand getFooterBand() {
		return footerBand;
	}
}
