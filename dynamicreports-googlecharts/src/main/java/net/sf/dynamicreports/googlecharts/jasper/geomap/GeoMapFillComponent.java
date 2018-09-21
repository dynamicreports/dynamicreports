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
package net.sf.dynamicreports.googlecharts.jasper.geomap;

import net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode;
import net.sf.jasperreports.engine.JRComponentElement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRGenericPrintElement;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.component.BaseFillComponent;
import net.sf.jasperreports.engine.component.FillPrepareResult;
import net.sf.jasperreports.engine.fill.JRFillObjectFactory;
import net.sf.jasperreports.engine.fill.JRTemplateGenericElement;
import net.sf.jasperreports.engine.fill.JRTemplateGenericPrintElement;
import net.sf.jasperreports.engine.type.EvaluationTimeEnum;
import net.sf.jasperreports.engine.util.JRStringUtil;

import java.awt.Color;
import java.util.List;

/**
 * <p>GeoMapFillComponent class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GeoMapFillComponent extends BaseFillComponent {

    private GeoMapComponent geoMapComponent;
    private Boolean showLegend;
    private GeoMapDataMode dataMode;
    private String region;
    private String valueLabel;
    private List<Color> colors;
    private GeoMapFillDataset dataset;

    /**
     * <p>Constructor for GeoMapFillComponent.</p>
     *
     * @param component a {@link net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapComponent} object.
     * @param factory   a {@link net.sf.jasperreports.engine.fill.JRFillObjectFactory} object.
     */
    public GeoMapFillComponent(GeoMapComponent component, JRFillObjectFactory factory) {
        this.geoMapComponent = component;
        this.dataset = new GeoMapFillDataset(component.getDataset(), factory);
        factory.registerElementDataset(this.dataset);
    }

    /**
     * <p>getGeoMap.</p>
     *
     * @return a {@link net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapComponent} object.
     */
    protected GeoMapComponent getGeoMap() {
        return geoMapComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void evaluate(byte evaluation) throws JRException {
        if (isEvaluateNow()) {
            evaluateGeoMap(evaluation);
        }
    }

    private void evaluateGeoMap(byte evaluation) throws JRException {
        showLegend = geoMapComponent.getShowLegend();
        dataMode = geoMapComponent.getDataMode();
        region = JRStringUtil.getString(fillContext.evaluate(geoMapComponent.getRegionExpression(), evaluation));
        valueLabel = JRStringUtil.getString(fillContext.evaluate(geoMapComponent.getValueLabelExpression(), evaluation));
        colors = geoMapComponent.getColors();

        dataset.evaluateDatasetRun(evaluation);
        dataset.finishDataset();
    }

    private boolean isEvaluateNow() {
        return geoMapComponent.getEvaluationTime() == EvaluationTimeEnum.NOW;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FillPrepareResult prepare(int availableHeight) {
        return FillPrepareResult.PRINT_NO_STRETCH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRPrintElement fill() {
        JRComponentElement element = fillContext.getComponentElement();
        JRTemplateGenericElement template = new JRTemplateGenericElement(fillContext.getElementOrigin(), fillContext.getDefaultStyleProvider(), GeoMapPrintElement.GEOMAP_ELEMENT_TYPE);

        JRTemplateGenericPrintElement printElement = new JRTemplateGenericPrintElement(template, printElementOriginator);
        printElement.setX(element.getX());
        printElement.setY(fillContext.getElementPrintY());
        printElement.setWidth(element.getWidth());
        printElement.setHeight(element.getHeight());

        if (isEvaluateNow()) {
            copy(printElement);
        } else {
            fillContext.registerDelayedEvaluation(printElement, geoMapComponent.getEvaluationTime(), geoMapComponent.getEvaluationGroup());
        }

        return printElement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void evaluateDelayedElement(JRPrintElement element, byte evaluation) throws JRException {
        evaluateGeoMap(evaluation);
        copy((JRGenericPrintElement) element);
    }

    private void copy(JRGenericPrintElement printElement) {
        printElement.setParameterValue(GeoMapPrintElement.PARAMETER_SHOW_LEGEND, showLegend);
        printElement.setParameterValue(GeoMapPrintElement.PARAMETER_DATA_MODE, dataMode);
        printElement.setParameterValue(GeoMapPrintElement.PARAMETER_REGION, region);
        printElement.setParameterValue(GeoMapPrintElement.PARAMETER_VALUE_LABEL, valueLabel);
        printElement.setParameterValue(GeoMapPrintElement.PARAMETER_COLORS, colors);
        printElement.setParameterValue(GeoMapPrintElement.PARAMETER_DATASET, dataset.getCustomDataset());
    }
}
