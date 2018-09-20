/*
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
package net.sf.dynamicreports.design.definition.component;

import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.expression.DRIDesignParameterExpression;

import java.util.List;

/**
 * <p>DRIDesignGenericElement interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDesignGenericElement extends DRIDesignComponent {

    /**
     * <p>getGenericElementNamespace.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getGenericElementNamespace();

    /**
     * <p>getGenericElementName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getGenericElementName();

    /**
     * <p>getEvaluationTime.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.constant.EvaluationTime} object.
     */
    public EvaluationTime getEvaluationTime();

    /**
     * <p>getEvaluationGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignGroup} object.
     */
    public DRIDesignGroup getEvaluationGroup();

    /**
     * <p>getParameterExpressions.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIDesignParameterExpression> getParameterExpressions();

}
