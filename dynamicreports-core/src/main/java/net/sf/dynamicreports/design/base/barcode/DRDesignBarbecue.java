/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.design.base.barcode;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignBarbecue;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignBarbecue class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignBarbecue extends DRDesignComponent implements DRIDesignBarbecue {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private BarbecueType type;
    private DRIDesignExpression codeExpression;
    private DRIDesignExpression applicationIdentifierExpression;
    private Boolean drawText;
    private Boolean checksumRequired;
    private Integer barWidth;
    private Integer barHeight;
    private BarcodeOrientation orientation;
    private EvaluationTime evaluationTime;
    private DRIDesignGroup evaluationGroup;

    /**
     * <p>Constructor for DRDesignBarbecue.</p>
     */
    public DRDesignBarbecue() {
        super("barbecue");
    }

    /** {@inheritDoc} */
    @Override
    public BarbecueType getType() {
        return type;
    }

    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link net.sf.dynamicreports.report.constant.BarbecueType} object.
     */
    public void setType(BarbecueType type) {
        this.type = type;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getCodeExpression() {
        return codeExpression;
    }

    /**
     * <p>Setter for the field <code>codeExpression</code>.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setCodeExpression(DRIDesignExpression codeExpression) {
        this.codeExpression = codeExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getApplicationIdentifierExpression() {
        return applicationIdentifierExpression;
    }

    /**
     * <p>Setter for the field <code>applicationIdentifierExpression</code>.</p>
     *
     * @param applicationIdentifierExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setApplicationIdentifierExpression(DRIDesignExpression applicationIdentifierExpression) {
        this.applicationIdentifierExpression = applicationIdentifierExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getDrawText() {
        return drawText;
    }

    /**
     * <p>Setter for the field <code>drawText</code>.</p>
     *
     * @param drawText a {@link java.lang.Boolean} object.
     */
    public void setDrawText(Boolean drawText) {
        this.drawText = drawText;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getChecksumRequired() {
        return checksumRequired;
    }

    /**
     * <p>Setter for the field <code>checksumRequired</code>.</p>
     *
     * @param checksumRequired a {@link java.lang.Boolean} object.
     */
    public void setChecksumRequired(Boolean checksumRequired) {
        this.checksumRequired = checksumRequired;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBarWidth() {
        return barWidth;
    }

    /**
     * <p>Setter for the field <code>barWidth</code>.</p>
     *
     * @param barWidth a {@link java.lang.Integer} object.
     */
    public void setBarWidth(Integer barWidth) {
        this.barWidth = barWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBarHeight() {
        return barHeight;
    }

    /**
     * <p>Setter for the field <code>barHeight</code>.</p>
     *
     * @param barHeight a {@link java.lang.Integer} object.
     */
    public void setBarHeight(Integer barHeight) {
        this.barHeight = barHeight;
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeOrientation getOrientation() {
        return orientation;
    }

    /**
     * <p>Setter for the field <code>orientation</code>.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.report.constant.BarcodeOrientation} object.
     */
    public void setOrientation(BarcodeOrientation orientation) {
        this.orientation = orientation;
    }

    /** {@inheritDoc} */
    @Override
    public EvaluationTime getEvaluationTime() {
        return evaluationTime;
    }

    /**
     * <p>Setter for the field <code>evaluationTime</code>.</p>
     *
     * @param evaluationTime a {@link net.sf.dynamicreports.design.constant.EvaluationTime} object.
     */
    public void setEvaluationTime(EvaluationTime evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignGroup getEvaluationGroup() {
        return evaluationGroup;
    }

    /**
     * <p>Setter for the field <code>evaluationGroup</code>.</p>
     *
     * @param evaluationGroup a {@link net.sf.dynamicreports.design.definition.DRIDesignGroup} object.
     */
    public void setEvaluationGroup(DRIDesignGroup evaluationGroup) {
        this.evaluationGroup = evaluationGroup;
    }
}
