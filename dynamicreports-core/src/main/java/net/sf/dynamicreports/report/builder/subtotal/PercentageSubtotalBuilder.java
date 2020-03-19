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
package net.sf.dynamicreports.report.builder.subtotal;

import net.sf.dynamicreports.report.base.DRGroup;
import net.sf.dynamicreports.report.base.DRVariable;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.expression.PercentageExpression;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.PercentageTotalType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRReportException;

/**
 * <p>PercentageSubtotalBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class PercentageSubtotalBuilder extends BaseSubtotalBuilder<PercentageSubtotalBuilder, Double> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<? extends Number> expression;
    private PercentageTotalType totalType;
    private DRGroup totalGroup;

    // column

    /**
     * <p>Constructor for PercentageSubtotalBuilder.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     */
    protected PercentageSubtotalBuilder(ValueColumnBuilder<?, ? extends Number> column) {
        this(column.build(), column);
    }

    // field

    /**
     * <p>Constructor for PercentageSubtotalBuilder.</p>
     *
     * @param field        a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
     */
    protected PercentageSubtotalBuilder(FieldBuilder<? extends Number> field, ColumnBuilder<?, ?> showInColumn) {
        this(field.getField(), showInColumn);
    }

    // expression

    /**
     * <p>Constructor for PercentageSubtotalBuilder.</p>
     *
     * @param expression   a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
     */
    protected PercentageSubtotalBuilder(DRIExpression<? extends Number> expression, ColumnBuilder<?, ?> showInColumn) {
        super(showInColumn);
        this.expression = expression;
    }

    /**
     * <p>Setter for the field <code>totalType</code>.</p>
     *
     * @param totalType a {@link net.sf.dynamicreports.report.constant.PercentageTotalType} object.
     * @return a {@link net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder} object.
     */
    public PercentageSubtotalBuilder setTotalType(PercentageTotalType totalType) {
        this.totalType = totalType;
        return this;
    }

    /**
     * <p>Setter for the field <code>totalGroup</code>.</p>
     *
     * @param totalGroup a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder} object.
     */
    public PercentageSubtotalBuilder setTotalGroup(GroupBuilder<?> totalGroup) {
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
        if (getObject().getValueField().getDataType() == null) {
            getObject().getValueField().setDataType(DataTypes.percentageType());
        }

        DRVariable<Number> actualExpression = new DRVariable<Number>(expression, Calculation.SUM);
        actualExpression.setResetType(Evaluation.GROUP);
        actualExpression.setResetGroup(getObject().getGroup());

        DRVariable<Number> totalExpression = new DRVariable<Number>(expression, Calculation.SUM);
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
            totalExpression.setResetType(Evaluation.BEFORE_GROUP);
            totalGroup = getObject().getGroup();
        }
        totalExpression.setResetGroup(totalGroup);

        setValueExpression(new PercentageExpression(actualExpression, totalExpression));

        super.configure();
    }
}
