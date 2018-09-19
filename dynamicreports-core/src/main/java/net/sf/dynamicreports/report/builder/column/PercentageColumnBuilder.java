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

package net.sf.dynamicreports.report.builder.column;

import net.sf.dynamicreports.report.base.DRGroup;
import net.sf.dynamicreports.report.base.DRVariable;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.expression.PercentageExpression;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.PercentageTotalType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRReportException;
import org.apache.commons.lang3.Validate;

/**
 * It calculates percentage values from the field or column values.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class PercentageColumnBuilder extends ValueColumnBuilder<PercentageColumnBuilder, Double> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<? extends Number> actualExpression;
    private PercentageTotalType totalType;
    private DRGroup totalGroup;

    /**
     * <p>Constructor for PercentageColumnBuilder.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     */
    protected PercentageColumnBuilder(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        this.actualExpression = column.build();
    }

    /**
     * <p>Constructor for PercentageColumnBuilder.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     */
    protected PercentageColumnBuilder(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        this.actualExpression = field.getField();
    }

	/*protected PercentageColumnBuilder(DRISimpleExpression<? extends Number> valueExpression) {
		Validate.notNull(valueExpression, "valueExpression must not be null");
		this.actualExpression = valueExpression;
	}*/

    /**
     * Sets the total type. Has effect only when the report contains at least one group.
     *
     * @param totalType
     *          the total type
     * @return a column builder
     */
    public PercentageColumnBuilder setTotalType(PercentageTotalType totalType) {
        this.totalType = totalType;
        return this;
    }

    /**
     * Sets the total group. Has effect only when the report contains at least one group.
     *
     * @param totalGroup
     *          the total group
     * @return a column builder
     */
    public PercentageColumnBuilder setTotalGroup(GroupBuilder<?> totalGroup) {
        if (totalGroup != null) {
            this.totalGroup = totalGroup.getGroup();
            setTotalType(PercentageTotalType.GROUP);
        } else {
            this.totalGroup = null;
        }

        return this;
    }

    /** {@inheritDoc} */
    @Override
    protected void configure() {
        if (getComponent().getDataType() == null) {
            getComponent().setDataType(DataTypes.percentageType());
        }

        DRVariable<Number> totalExpression = new DRVariable<Number>(actualExpression, Calculation.SUM);
        if (totalType != null) {
            switch (totalType) {
                case REPORT:
                    totalExpression.setResetType(Evaluation.REPORT);
                    break;
                case GROUP:
                    totalExpression.setResetType(Evaluation.GROUP);
                    break;
                case FIRST_GROUP:
                    totalExpression.setResetType(Evaluation.FIRST_GROUP);
                    break;
                case LAST_GROUP:
                    totalExpression.setResetType(Evaluation.LAST_GROUP);
                    break;
                default:
                    throw new DRReportException("Percentage total type " + totalType.name() + " not supported.");
            }
        } else {
            totalExpression.setResetType(Evaluation.LAST_GROUP);
        }
        totalExpression.setResetGroup(totalGroup);

        setValueExpression(new PercentageExpression(actualExpression, totalExpression));
        super.configure();
    }
}
