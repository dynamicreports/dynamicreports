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

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartSerie;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignSeriesDataset;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignSeriesDataset extends DRDesignChartDataset implements DRIDesignSeriesDataset {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIDesignExpression valueExpression;
	private List<DRIDesignChartSerie> series;

	public DRDesignSeriesDataset() {
		series = new ArrayList<DRIDesignChartSerie>();
	}

	@Override
	public DRIDesignExpression getValueExpression() {
		return valueExpression;
	}

	public void setValueExpression(DRIDesignExpression valueExpression) {
		this.valueExpression = valueExpression;
	}

	public void addSerie(DRIDesignChartSerie serie) {
		series.add(serie);
	}

	@Override
	public List<DRIDesignChartSerie> getSeries() {
		return series;
	}

}
