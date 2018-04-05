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

import net.sf.dynamicreports.design.definition.DRIDesignHyperLink;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignHyperLink implements DRIDesignHyperLink {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIDesignExpression anchorExpression;
	private DRIDesignExpression pageExpression;
	private DRIDesignExpression referenceExpression;
	private DRIDesignExpression tooltipExpression;
	private String hyperLinkType;
	private String hyperLinkTarget;

	@Override
	public DRIDesignExpression getAnchorExpression() {
		return anchorExpression;
	}

	public void setAnchorExpression(DRIDesignExpression anchorExpression) {
		this.anchorExpression = anchorExpression;
	}

	@Override
	public DRIDesignExpression getPageExpression() {
		return pageExpression;
	}

	public void setPageExpression(DRIDesignExpression pageExpression) {
		this.pageExpression = pageExpression;
	}

	@Override
	public DRIDesignExpression getReferenceExpression() {
		return referenceExpression;
	}

	public void setReferenceExpression(DRIDesignExpression referenceExpression) {
		this.referenceExpression = referenceExpression;
	}

	@Override
	public DRIDesignExpression getTooltipExpression() {
		return tooltipExpression;
	}

	public void setTooltipExpression(DRIDesignExpression tooltipExpression) {
		this.tooltipExpression = tooltipExpression;
	}

	@Override
	public String getType() {
		return hyperLinkType;
	}

	public void setType(String hyperLinkType) {
		this.hyperLinkType = hyperLinkType;
	}

	@Override
	public String getTarget() {
		return hyperLinkTarget;
	}

	public void setTarget(String hyperLinkTarget) {
		this.hyperLinkTarget = hyperLinkTarget;
	}

}
