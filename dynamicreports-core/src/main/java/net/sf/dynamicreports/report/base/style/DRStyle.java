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

package net.sf.dynamicreports.report.base.style;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.definition.style.DRIStyle;

import org.apache.commons.lang3.Validate;

/**
 * <p>DRStyle class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRStyle extends DRBaseStyle implements DRIStyle {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private DRIReportStyle parentStyle;
	private List<DRConditionalStyle> conditionalStyles;

	/** {@inheritDoc} */
	@Override
	protected void init() {
		super.init();
		conditionalStyles = new ArrayList<DRConditionalStyle>();
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** {@inheritDoc} */
	@Override
	public DRIReportStyle getParentStyle() {
		return parentStyle;
	}

	/**
	 * <p>Setter for the field <code>parentStyle</code>.</p>
	 *
	 * @param parentStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public void setParentStyle(DRIReportStyle parentStyle) {
		this.parentStyle = parentStyle;
	}

	/** {@inheritDoc} */
	@Override
	public List<DRConditionalStyle> getConditionalStyles() {
		return conditionalStyles;
	}

	/**
	 * <p>Setter for the field <code>conditionalStyles</code>.</p>
	 *
	 * @param conditionalStyles a {@link java.util.List} object.
	 */
	public void setConditionalStyles(List<DRConditionalStyle> conditionalStyles) {
		Validate.notNull(conditionalStyles, "conditionalStyles must not be null");
		Validate.noNullElements(conditionalStyles, "conditionalStyles must not contains null conditionalStyle");
		this.conditionalStyles = conditionalStyles;
	}

	/**
	 * <p>addConditionalStyle.</p>
	 *
	 * @param conditionalStyle a {@link net.sf.dynamicreports.report.base.style.DRConditionalStyle} object.
	 */
	public void addConditionalStyle(DRConditionalStyle conditionalStyle) {
		Validate.notNull(conditionalStyle, "conditionalStyle must not be null");
		this.conditionalStyles.add(conditionalStyle);
	}
}
