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
 * <p>DRDesignGroup class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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

	/**
	 * <p>Constructor for DRDesignGroup.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public DRDesignGroup(String name) {
		this.name = name;
		init();
	}

	private void init() {
		headerBands = new ArrayList<DRDesignBand>();
		footerBands = new ArrayList<DRDesignBand>();
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return name;
	}

	/** {@inheritDoc} */
	@Override
	public DRIDesignExpression getGroupExpression() {
		return groupExpression;
	}

	/**
	 * <p>Setter for the field <code>groupExpression</code>.</p>
	 *
	 * @param groupExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
	 */
	public void setGroupExpression(DRIDesignExpression groupExpression) {
		this.groupExpression = groupExpression;
	}

	/** {@inheritDoc} */
	@Override
	public List<DRDesignBand> getHeaderBands() {
		return headerBands;
	}

	/**
	 * <p>Setter for the field <code>headerBands</code>.</p>
	 *
	 * @param headerBands a {@link java.util.List} object.
	 */
	public void setHeaderBands(List<DRDesignBand> headerBands) {
		this.headerBands = headerBands;
	}

	/**
	 * <p>addHeaderBand.</p>
	 *
	 * @param headerBand a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
	 */
	public void addHeaderBand(DRDesignBand headerBand) {
		this.headerBands.add(headerBand);
	}

	/** {@inheritDoc} */
	@Override
	public List<DRDesignBand> getFooterBands() {
		return footerBands;
	}

	/**
	 * <p>Setter for the field <code>footerBands</code>.</p>
	 *
	 * @param footerBands a {@link java.util.List} object.
	 */
	public void setFooterBands(List<DRDesignBand> footerBands) {
		this.footerBands = footerBands;
	}

	/**
	 * <p>addFooterBand.</p>
	 *
	 * @param footerBand a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
	 */
	public void addFooterBand(DRDesignBand footerBand) {
		this.footerBands.add(footerBand);
	}

	/**
	 * <p>addFooterBand.</p>
	 *
	 * @param index a int.
	 * @param footerBand a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
	 */
	public void addFooterBand(int index, DRDesignBand footerBand) {
		this.footerBands.add(index, footerBand);
	}

	/** {@inheritDoc} */
	@Override
	public boolean isStartInNewPage() {
		return startInNewPage;
	}

	/**
	 * <p>Setter for the field <code>startInNewPage</code>.</p>
	 *
	 * @param startInNewPage a boolean.
	 */
	public void setStartInNewPage(boolean startInNewPage) {
		this.startInNewPage = startInNewPage;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isStartInNewColumn() {
		return startInNewColumn;
	}

	/**
	 * <p>Setter for the field <code>startInNewColumn</code>.</p>
	 *
	 * @param startInNewColumn a boolean.
	 */
	public void setStartInNewColumn(boolean startInNewColumn) {
		this.startInNewColumn = startInNewColumn;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isReprintHeaderOnEachPage() {
		return reprintHeaderOnEachPage;
	}

	/**
	 * <p>Setter for the field <code>reprintHeaderOnEachPage</code>.</p>
	 *
	 * @param reprintHeaderOnEachPage a boolean.
	 */
	public void setReprintHeaderOnEachPage(boolean reprintHeaderOnEachPage) {
		this.reprintHeaderOnEachPage = reprintHeaderOnEachPage;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isResetPageNumber() {
		return resetPageNumber;
	}

	/**
	 * <p>Setter for the field <code>resetPageNumber</code>.</p>
	 *
	 * @param resetPageNumber a boolean.
	 */
	public void setResetPageNumber(boolean resetPageNumber) {
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
	public boolean isKeepTogether() {
		return keepTogether;
	}

	/**
	 * <p>Setter for the field <code>keepTogether</code>.</p>
	 *
	 * @param keepTogether a boolean.
	 */
	public void setKeepTogether(boolean keepTogether) {
		this.keepTogether = keepTogether;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isHeaderWithSubtotal() {
		return headerWithSubtotal;
	}

	/**
	 * <p>Setter for the field <code>headerWithSubtotal</code>.</p>
	 *
	 * @param headerWithSubtotal a boolean.
	 */
	public void setHeaderWithSubtotal(boolean headerWithSubtotal) {
		this.headerWithSubtotal = headerWithSubtotal;
	}

}
