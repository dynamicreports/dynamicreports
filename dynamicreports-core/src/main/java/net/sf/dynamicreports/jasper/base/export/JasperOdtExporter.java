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

package net.sf.dynamicreports.jasper.base.export;

import net.sf.dynamicreports.jasper.definition.export.JasperIOdtExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>JasperOdtExporter class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperOdtExporter extends AbstractJasperExporter implements JasperIOdtExporter {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Boolean flexibleRowHeight;
	private Boolean ignoreHyperLink;

	/** {@inheritDoc} */
	@Override
	public Boolean getFlexibleRowHeight() {
		return flexibleRowHeight;
	}

	/**
	 * <p>Setter for the field <code>flexibleRowHeight</code>.</p>
	 *
	 * @param flexibleRowHeight a {@link java.lang.Boolean} object.
	 */
	public void setFlexibleRowHeight(Boolean flexibleRowHeight) {
		this.flexibleRowHeight = flexibleRowHeight;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getIgnoreHyperLink() {
		return ignoreHyperLink;
	}

	/**
	 * <p>Setter for the field <code>ignoreHyperLink</code>.</p>
	 *
	 * @param ignoreHyperLink a {@link java.lang.Boolean} object.
	 */
	public void setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.ignoreHyperLink = ignoreHyperLink;
	}
}
