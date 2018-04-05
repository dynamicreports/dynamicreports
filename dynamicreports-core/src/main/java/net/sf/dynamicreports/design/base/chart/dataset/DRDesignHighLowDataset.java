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

package net.sf.dynamicreports.design.base.chart.dataset;

import net.sf.dynamicreports.design.definition.DRIDesignHyperLink;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignHighLowDataset;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignHighLowDataset extends DRDesignChartDataset implements DRIDesignHighLowDataset {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIDesignExpression seriesExpression;
	private DRIDesignExpression dateExpression;
	private DRIDesignExpression highExpression;
	private DRIDesignExpression lowExpression;
	private DRIDesignExpression openExpression;
	private DRIDesignExpression closeExpression;
	private DRIDesignExpression volumeExpression;
	private DRIDesignHyperLink itemHyperLink;

	@Override
	public DRIDesignExpression getSeriesExpression() {
		return seriesExpression;
	}

	public void setSeriesExpression(DRIDesignExpression seriesExpression) {
		this.seriesExpression = seriesExpression;
	}

	@Override
	public DRIDesignExpression getDateExpression() {
		return dateExpression;
	}

	public void setDateExpression(DRIDesignExpression dateExpression) {
		this.dateExpression = dateExpression;
	}

	@Override
	public DRIDesignExpression getHighExpression() {
		return highExpression;
	}

	public void setHighExpression(DRIDesignExpression highExpression) {
		this.highExpression = highExpression;
	}

	@Override
	public DRIDesignExpression getLowExpression() {
		return lowExpression;
	}

	public void setLowExpression(DRIDesignExpression lowExpression) {
		this.lowExpression = lowExpression;
	}

	@Override
	public DRIDesignExpression getOpenExpression() {
		return openExpression;
	}

	public void setOpenExpression(DRIDesignExpression openExpression) {
		this.openExpression = openExpression;
	}

	@Override
	public DRIDesignExpression getCloseExpression() {
		return closeExpression;
	}

	public void setCloseExpression(DRIDesignExpression closeExpression) {
		this.closeExpression = closeExpression;
	}

	@Override
	public DRIDesignExpression getVolumeExpression() {
		return volumeExpression;
	}

	public void setVolumeExpression(DRIDesignExpression volumeExpression) {
		this.volumeExpression = volumeExpression;
	}

	@Override
	public DRIDesignHyperLink getItemHyperLink() {
		return itemHyperLink;
	}

	public void setItemHyperLink(DRIDesignHyperLink itemHyperLink) {
		this.itemHyperLink = itemHyperLink;
	}

}
