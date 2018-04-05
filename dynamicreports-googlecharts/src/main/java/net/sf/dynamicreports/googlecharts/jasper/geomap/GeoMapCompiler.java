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

package net.sf.dynamicreports.googlecharts.jasper.geomap;

import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;
import net.sf.jasperreports.engine.component.Component;
import net.sf.jasperreports.engine.component.ComponentCompiler;
import net.sf.jasperreports.engine.design.JRVerifier;
import net.sf.jasperreports.engine.type.EvaluationTimeEnum;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GeoMapCompiler implements ComponentCompiler {

	@Override
	public void collectExpressions(Component component, JRExpressionCollector collector) {
		GeoMapComponent geoMap = (GeoMapComponent) component;
		collector.addExpression(geoMap.getRegionExpression());
		collector.addExpression(geoMap.getValueLabelExpression());
		collectExpressions(geoMap.getDataset(), collector);
	}

	public static void collectExpressions(GeoMapDataset dataset, JRExpressionCollector collector) {
		if (dataset != null) {
			collector.collect(dataset);
			JRExpressionCollector datasetCollector = collector.getCollector(dataset);
			datasetCollector.addExpression(dataset.getLocationExpression());
			datasetCollector.addExpression(dataset.getValueExpression());
			datasetCollector.addExpression(dataset.getLabelExpression());
		}
	}

	@Override
	public Component toCompiledComponent(Component component, JRBaseObjectFactory baseFactory) {
		GeoMapComponent geoMap = (GeoMapComponent) component;
		return new StandardGeoMapComponent(geoMap, baseFactory);
	}

	@Override
	public void verify(Component component, JRVerifier verifier) {
		GeoMapComponent geoMap = (GeoMapComponent) component;

		EvaluationTimeEnum evaluationTime = geoMap.getEvaluationTime();
		if (evaluationTime == EvaluationTimeEnum.AUTO) {
			verifier.addBrokenRule("Auto evaluation time is not supported for geo maps", geoMap);
		} else if (evaluationTime == EvaluationTimeEnum.GROUP) {
			String evaluationGroup = geoMap.getEvaluationGroup();
			if (evaluationGroup == null || evaluationGroup.length() == 0) {
				verifier.addBrokenRule("No evaluation group set for geo map", geoMap);
			} else if (!verifier.getReportDesign().getGroupsMap().containsKey(evaluationGroup)) {
				verifier.addBrokenRule("Map evalution group \"" + evaluationGroup + " not found", geoMap);
			}
		}

		GeoMapDataset dataset = geoMap.getDataset();
		if (dataset == null) {
			verifier.addBrokenRule("No dataset for geo map", geoMap);
		} else {
			verifier.verifyElementDataset(dataset);
		}
	}
}
