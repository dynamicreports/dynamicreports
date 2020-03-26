/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.design.transformation.expressions;

import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.design.transformation.CustomBatikRenderer;
import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.component.DRIBooleanField;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.renderers.Renderable;

import java.util.List;

/**
 * <p>BooleanImageExpression class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class BooleanImageExpression extends AbstractComplexExpression<Renderable> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Renderable imageTrue;
    private Renderable imageFalse;
    private boolean emptyWhenNullValue;

    /**
     * <p>Constructor for BooleanImageExpression.</p>
     *
     * @param booleanField       a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @param emptyWhenNullValue a boolean.
     * @param width              a int.
     * @param height             a int.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public BooleanImageExpression(DRIBooleanField booleanField, boolean emptyWhenNullValue, int width, int height) throws DRException {
        this.emptyWhenNullValue = emptyWhenNullValue;
        addExpression(booleanField.getValueExpression());
        String fileNameTrue;
        String fileNameFalse;
        switch (booleanField.getComponentType()) {
            case IMAGE_STYLE_1:
                fileNameTrue = "boolean1_true";
                fileNameFalse = "boolean1_false";
                break;
            case IMAGE_STYLE_2:
                fileNameTrue = "boolean2_true";
                fileNameFalse = "boolean2_false";
                break;
            case IMAGE_STYLE_3:
                fileNameTrue = "boolean3_true";
                fileNameFalse = "boolean3_false";
                break;
            case IMAGE_STYLE_4:
                fileNameTrue = "boolean1_true";
                fileNameFalse = "boolean4_false";
                break;
            case IMAGE_CHECKBOX_1:
                fileNameTrue = "checkbox1_true";
                fileNameFalse = "checkbox_false";
                break;
            case IMAGE_CHECKBOX_2:
                fileNameTrue = "checkbox2_true";
                fileNameFalse = "checkbox_false";
                break;
            case IMAGE_BALL:
                fileNameTrue = "ball_green";
                fileNameFalse = "ball_red";
                break;
            default:
                throw new DRDesignReportException("BooleanComponentType " + booleanField.getComponentType().name() + " not supported");
        }
        try {
            imageTrue = new CustomBatikRenderer(ReportUtils.class.getResource("images/" + fileNameTrue + ".svg"), width, height);
            imageFalse = new CustomBatikRenderer(ReportUtils.class.getResource("images/" + fileNameFalse + ".svg"), width, height);
        } catch (JRException e) {
            throw new DRException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public Renderable evaluate(List<?> values, ReportParameters reportParameters) {
        Boolean value = (Boolean) values.get(0);
        if (emptyWhenNullValue && value == null) {
            return null;
        }
        if (value != null && value) {
            return imageTrue;
        } else {
            return imageFalse;
        }
    }
}
