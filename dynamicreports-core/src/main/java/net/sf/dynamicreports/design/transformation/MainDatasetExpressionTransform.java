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
package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.DRDesignField;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.DRIReport;
import net.sf.dynamicreports.report.definition.DRISort;
import net.sf.dynamicreports.report.definition.DRIVariable;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.List;

/**
 * <p>MainDatasetExpressionTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class MainDatasetExpressionTransform extends AbstractExpressionTransform {

    /**
     * <p>Constructor for MainDatasetExpressionTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public MainDatasetExpressionTransform(DesignTransformAccessor accessor) {
        super(accessor);
    }

    /** {@inheritDoc} */
    @Override
    public void transform() throws DRException {
        DRIReport report = accessor.getReport();
        List<DRIField<?>> templateDesignFields = report.getTemplateDesign()
                                                       .getFields();
        if (templateDesignFields != null) {
            for (DRIField<?> field : templateDesignFields) {
                DRDesignField designField = (DRDesignField) transformExpression(field);
                designField.setExternal(true);
            }
        }
        super.transform();
    }

    /** {@inheritDoc} */
    @Override
    protected ResetType getVariableResetType(DRIVariable<?> variable) {
        return ConstantTransform.variableResetType(variable.getResetType(), variable.getResetGroup(), accessor);
    }

    /** {@inheritDoc} */
    @Override
    protected DRDesignGroup getVariableResetGroup(DRIVariable<?> variable) throws DRException {
        return accessor.getGroupTransform()
                       .getGroup(ConstantTransform.variableResetGroup(variable.getName(), variable.getResetType(), variable.getResetGroup(), accessor));
    }

    /** {@inheritDoc} */
    @Override
    protected List<? extends DRIField<?>> transformFields() {
        return accessor.getReport()
                       .getFields();
    }

    /** {@inheritDoc} */
    @Override
    protected List<? extends DRIVariable<?>> transformVariables() {
        return accessor.getReport()
                       .getVariables();
    }

    /** {@inheritDoc} */
    @Override
    protected List<? extends DRISort> transformSorts() {
        return accessor.getReport()
                       .getSorts();
    }

    /** {@inheritDoc} */
    @Override
    protected DRIDesignDataset getDataset() {
        return null;
    }
}
