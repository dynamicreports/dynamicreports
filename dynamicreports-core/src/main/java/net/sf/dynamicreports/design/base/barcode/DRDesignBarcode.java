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
package net.sf.dynamicreports.design.base.barcode;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignBarcode;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>Abstract DRDesignBarcode class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class DRDesignBarcode extends DRDesignComponent implements DRIDesignBarcode {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression codeExpression;
    private EvaluationTime evaluationTime;
    private DRIDesignGroup evaluationGroup;

    /**
     * <p>Constructor for DRDesignBarcode.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public DRDesignBarcode(String name) {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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
