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

package net.sf.dynamicreports.design.base;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignGroup implements DRIDesignGroup {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private DRIDesignExpression groupExpression;
	private List<DRDesignBand> headerBands;
	private List<DRDesignBand> footerBands;
	private boolean startInNewPage;
	private boolean startInNewColumn;
	private boolean reprintHeaderOnEachPage;
	private boolean resetPageNumber;
	private Integer minHeightToStartNewPage;
	private GroupFooterPosition footerPosition;
	private boolean keepTogether;
	private boolean headerWithSubtotal;

	public DRDesignGroup(String name) {
		this.name = name;
		init();
	}

	private void init() {
		headerBands = new ArrayList<DRDesignBand>();
		footerBands = new ArrayList<DRDesignBand>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public DRIDesignExpression getGroupExpression() {
		return groupExpression;
	}

	public void setGroupExpression(DRIDesignExpression groupExpression) {
		this.groupExpression = groupExpression;
	}

	@Override
	public List<DRDesignBand> getHeaderBands() {
		return headerBands;
	}

	public void setHeaderBands(List<DRDesignBand> headerBands) {
		this.headerBands = headerBands;
	}

	public void addHeaderBand(DRDesignBand headerBand) {
		this.headerBands.add(headerBand);
	}

	@Override
	public List<DRDesignBand> getFooterBands() {
		return footerBands;
	}

	public void setFooterBands(List<DRDesignBand> footerBands) {
		this.footerBands = footerBands;
	}

	public void addFooterBand(DRDesignBand footerBand) {
		this.footerBands.add(footerBand);
	}

	public void addFooterBand(int index, DRDesignBand footerBand) {
		this.footerBands.add(index, footerBand);
	}

	@Override
	public boolean isStartInNewPage() {
		return startInNewPage;
	}

	public void setStartInNewPage(boolean startInNewPage) {
		this.startInNewPage = startInNewPage;
	}

	@Override
	public boolean isStartInNewColumn() {
		return startInNewColumn;
	}

	public void setStartInNewColumn(boolean startInNewColumn) {
		this.startInNewColumn = startInNewColumn;
	}

	@Override
	public boolean isReprintHeaderOnEachPage() {
		return reprintHeaderOnEachPage;
	}

	public void setReprintHeaderOnEachPage(boolean reprintHeaderOnEachPage) {
		this.reprintHeaderOnEachPage = reprintHeaderOnEachPage;
	}

	@Override
	public boolean isResetPageNumber() {
		return resetPageNumber;
	}

	public void setResetPageNumber(boolean resetPageNumber) {
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
	public boolean isKeepTogether() {
		return keepTogether;
	}

	public void setKeepTogether(boolean keepTogether) {
		this.keepTogether = keepTogether;
	}

	@Override
	public boolean isHeaderWithSubtotal() {
		return headerWithSubtotal;
	}

	public void setHeaderWithSubtotal(boolean headerWithSubtotal) {
		this.headerWithSubtotal = headerWithSubtotal;
	}

}
