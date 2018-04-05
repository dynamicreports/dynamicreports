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
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
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

	public DRGroup(DRTextField<?> valueField) {
		this(ReportUtils.generateUniqueName("group"), valueField);
	}

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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public DRTextField<?> getValueField() {
		return valueField;
	}

	@Override
	public DRIExpression<?> getTitleExpression() {
		return titleExpression;
	}

	public void setTitleExpression(DRIExpression<?> titleExpression) {
		this.titleExpression = titleExpression;
	}

	@Override
	public DRIReportStyle getTitleStyle() {
		return titleStyle;
	}

	public void setTitleStyle(DRIReportStyle titleStyle) {
		this.titleStyle = titleStyle;
	}

	@Override
	public Integer getTitleWidth() {
		return titleWidth;
	}

	public void setTitleWidth(Integer titleWidth) {
		this.titleWidth = titleWidth;
	}

	@Override
	public GroupHeaderLayout getHeaderLayout() {
		return headerLayout;
	}

	public void setHeaderLayout(GroupHeaderLayout headerLayout) {
		this.headerLayout = headerLayout;
	}

	@Override
	public Boolean getHideColumn() {
		return hideColumn;
	}

	public void setHideColumn(Boolean hideColumn) {
		this.hideColumn = hideColumn;
	}

	@Override
	public Boolean getGroupByDataType() {
		return groupByDataType;
	}

	public void setGroupByDataType(Boolean groupByDataType) {
		this.groupByDataType = groupByDataType;
	}

	@Override
	public Boolean getShowColumnHeaderAndFooter() {
		return showColumnHeaderAndFooter;
	}

	public void setShowColumnHeaderAndFooter(Boolean showColumnHeaderAndFooter) {
		this.showColumnHeaderAndFooter = showColumnHeaderAndFooter;
	}

	@Override
	public Boolean getAddToTableOfContents() {
		return addToTableOfContents;
	}

	public void setAddToTableOfContents(Boolean addToTableOfContents) {
		this.addToTableOfContents = addToTableOfContents;
	}

	@Override
	public DRIExpression<Boolean> getPrintSubtotalsWhenExpression() {
		return printSubtotalsWhenExpression;
	}

	public void setPrintSubtotalsWhenExpression(DRIExpression<Boolean> printSubtotalsWhenExpression) {
		this.printSubtotalsWhenExpression = printSubtotalsWhenExpression;
	}

	@Override
	public Integer getPadding() {
		return padding;
	}

	public void setPadding(Integer padding) {
		if (padding != null) {
			Validate.isTrue(padding >= 0, "padding must be >= 0");
		}
		this.padding = padding;
	}

	@Override
	public Boolean getStartInNewPage() {
		return startInNewPage;
	}

	public void setStartInNewPage(Boolean startInNewPage) {
		this.startInNewPage = startInNewPage;
	}

	@Override
	public Boolean getStartInNewColumn() {
		return startInNewColumn;
	}

	public void setStartInNewColumn(Boolean startInNewColumn) {
		this.startInNewColumn = startInNewColumn;
	}

	@Override
	public Boolean getReprintHeaderOnEachPage() {
		return reprintHeaderOnEachPage;
	}

	public void setReprintHeaderOnEachPage(Boolean reprintHeaderOnEachPage) {
		this.reprintHeaderOnEachPage = reprintHeaderOnEachPage;
	}

	@Override
	public Boolean getResetPageNumber() {
		return resetPageNumber;
	}

	public void setResetPageNumber(Boolean resetPageNumber) {
		this.resetPageNumber = resetPageNumber;
	}

	@Override
	public Integer getMinHeightToStartNewPage() {
		return minHeightToStartNewPage;
	}

	public void setMinHeightToStartNewPage(Integer minHeightToStartNewPage) {
		this.minHeightToStartNewPage = minHeightToStartNewPage;
	}

	@Override
	public GroupFooterPosition getFooterPosition() {
		return footerPosition;
	}

	public void setFooterPosition(GroupFooterPosition footerPosition) {
		this.footerPosition = footerPosition;
	}

	@Override
	public Boolean getKeepTogether() {
		return keepTogether;
	}

	public void setKeepTogether(Boolean keepTogether) {
		this.keepTogether = keepTogether;
	}

	@Override
	public Boolean getHeaderWithSubtotal() {
		return headerWithSubtotal;
	}

	public void setHeaderWithSubtotal(Boolean headerWithSubtotal) {
		this.headerWithSubtotal = headerWithSubtotal;
	}

	@Override
	public DRBand getHeaderBand() {
		return headerBand;
	}

	@Override
	public DRBand getFooterBand() {
		return footerBand;
	}
}
