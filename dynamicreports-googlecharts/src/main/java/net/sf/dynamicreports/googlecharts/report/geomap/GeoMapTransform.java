/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.googlecharts.report.geomap;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.transformation.DesignTransformAccessor;
import net.sf.dynamicreports.googlecharts.jasper.GoogleChartsExtensionsRegistryFactory;
import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapPrintElement;
import net.sf.dynamicreports.googlecharts.jasper.geomap.StandardGeoMapComponent;
import net.sf.dynamicreports.googlecharts.jasper.geomap.StandardGeoMapDataset;
import net.sf.dynamicreports.jasper.transformation.ConstantTransform;
import net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor;
import net.sf.dynamicreports.report.component.CustomComponentTransform;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRComponentElement;
import net.sf.jasperreports.engine.component.ComponentKey;
import net.sf.jasperreports.engine.design.JRDesignComponentElement;

/**
 * <p>GeoMapTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GeoMapTransform implements CustomComponentTransform<DRIGeoMap, DRIDesignGeoMap> {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTransform(Object component) {
        return component instanceof DRIGeoMap || component instanceof DRIDesignGeoMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignGeoMap designComponent(DesignTransformAccessor accessor, DRIGeoMap geoMap, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignGeoMap designGeoMap = new DRDesignGeoMap();
        designGeoMap.setEvaluationTime(accessor.getComponentTransform().evaluationTimeFromResetType(resetType));
        designGeoMap.setEvaluationGroup(resetGroup);

        designGeoMap.setShowLegend(geoMap.getShowLegend());
        designGeoMap.setDataMode(geoMap.getDataMode());
        designGeoMap.setRegionExpression(accessor.getExpressionTransform().transformExpression(geoMap.getRegionExpression()));
        designGeoMap.setValueLabelExpression(accessor.getExpressionTransform().transformExpression(geoMap.getValueLabelExpression()));
        designGeoMap.setColors(geoMap.getColors());
        designGeoMap.setDataset(dataset(accessor, geoMap.getDataset(), resetType, resetGroup));

        return designGeoMap;
    }

    private DRDesignGeoMapDataset dataset(DesignTransformAccessor accessor, DRIGeoMapDataset dataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignGeoMapDataset designDataset = new DRDesignGeoMapDataset();

        designDataset.setSubDataset(accessor.getDatasetTransform().transform(dataset.getSubDataset()));
        accessor.transformToDataset(dataset.getSubDataset());
        designDataset.setLocationExpression(accessor.getExpressionTransform().transformExpression(dataset.getLocationExpression()));
        designDataset.setValueExpression(accessor.getExpressionTransform().transformExpression(dataset.getValueExpression()));
        designDataset.setLabelExpression(accessor.getExpressionTransform().transformExpression(dataset.getLabelExpression()));
        if (resetType != null && resetType.equals(ResetType.NONE)) {
            designDataset.setResetType(ResetType.REPORT);
        } else {
            designDataset.setResetType(resetType);
        }
        designDataset.setResetGroup(resetGroup);
        accessor.transformToMainDataset();

        return designDataset;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRComponentElement jasperComponent(JasperTransformAccessor accessor, DRIDesignGeoMap geoMap) {
        StandardGeoMapComponent jrGeoMap = new StandardGeoMapComponent();
        EvaluationTime evaluationTime = geoMap.getEvaluationTime();
        jrGeoMap.setEvaluationTime(ConstantTransform.evaluationTime(evaluationTime));
        if (evaluationTime != null && evaluationTime.equals(EvaluationTime.GROUP) && geoMap.getEvaluationGroup() != null) {
            jrGeoMap.setEvaluationGroup(accessor.getGroupTransform().getGroup(geoMap.getEvaluationGroup()).getName());
        }
        jrGeoMap.setShowLegend(geoMap.getShowLegend());
        jrGeoMap.setDataMode(geoMap.getDataMode());
        jrGeoMap.setRegionExpression(accessor.getExpressionTransform().getExpression(geoMap.getRegionExpression()));
        jrGeoMap.setValueLabelExpression(accessor.getExpressionTransform().getExpression(geoMap.getValueLabelExpression()));
        jrGeoMap.setColors(geoMap.getColors());
        StandardGeoMapDataset jrDataset = new StandardGeoMapDataset();
        dataset(accessor, geoMap.getDataset(), jrDataset);
        jrGeoMap.setDataset(jrDataset);

        JRDesignComponentElement jrComponent = new JRDesignComponentElement();
        jrComponent.setComponent(jrGeoMap);
        jrComponent.setComponentKey(new ComponentKey(GoogleChartsExtensionsRegistryFactory.NAMESPACE, "jr", GeoMapPrintElement.GEOMAP_ELEMENT_NAME));

        return jrComponent;
    }

    private void dataset(JasperTransformAccessor accessor, DRIDesignGeoMapDataset dataset, StandardGeoMapDataset jrDataset) {
        jrDataset.setDatasetRun(accessor.getDatasetTransform().datasetRun(dataset.getSubDataset()));
        ResetType resetType = dataset.getResetType();
        jrDataset.setResetType(ConstantTransform.variableResetType(resetType));
        if (resetType.equals(ResetType.GROUP) && dataset.getResetGroup() != null) {
            jrDataset.setResetGroup(accessor.getGroupTransform().getGroup(dataset.getResetGroup()));
        }

        accessor.transformToDataset(dataset.getSubDataset());
        jrDataset.setLocationExpression(accessor.getExpressionTransform().getExpression(dataset.getLocationExpression()));
        jrDataset.setValueExpression(accessor.getExpressionTransform().getExpression(dataset.getValueExpression()));
        jrDataset.setLabelExpression(accessor.getExpressionTransform().getExpression(dataset.getLabelExpression()));
        accessor.transformToMainDataset();
    }
}
