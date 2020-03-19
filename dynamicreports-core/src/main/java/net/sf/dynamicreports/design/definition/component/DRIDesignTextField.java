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
package net.sf.dynamicreports.design.definition.component;

import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.TextAdjust;

/**
 * <p>DRIDesignTextField interface.</p>
 *
 * @author Ricardo Mariaca, Jan Moxter
 *
 */
public interface DRIDesignTextField extends DRIDesignHyperLinkComponent {

    /**
     * <p>getPattern.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    String getPattern();

    /**
     * <p>getPatternExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    DRIDesignExpression getPatternExpression();

    /**
     * <p>getHorizontalTextAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    HorizontalTextAlignment getHorizontalTextAlignment();

    /**
     * <p>getValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    DRIDesignExpression getValueExpression();

    /**
     * <p>isPrintRepeatedValues.</p>
     *
     * @return a boolean.
     */
    boolean isPrintRepeatedValues();

    /**
     * <p>getEvaluationTime.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.constant.EvaluationTime} object.
     */
    EvaluationTime getEvaluationTime();

    /**
     * <p>getEvaluationGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignGroup} object.
     */
    DRIDesignGroup getEvaluationGroup();

    /**
     * <p>getMarkup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Markup} object.
     */
    Markup getMarkup();

    /**
     * <p>isStretchWithOverflow.</p>
     *
     * @return a boolean.
     * @deprecated Replaced by {@link #getTextAdjust()}.
     */
    @Deprecated
    boolean isStretchWithOverflow();

    /**
     * @return a {@link net.sf.dynamicreports.report.constant.TextAdjust} object.
     */
    TextAdjust getTextAdjust();
}
