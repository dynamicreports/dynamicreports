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
package net.sf.dynamicreports.design.transformation.chartcustomizer;

import net.sf.dynamicreports.report.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.jfree.data.category.CategoryDataset;

/**
 * <p>PercentageGroupedCategoryDataset class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class PercentageGroupedCategoryDataset extends PercentageCategoryDataset {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for PercentageGroupedCategoryDataset.</p>
     *
     * @param dataset a {@link org.jfree.data.category.CategoryDataset} object.
     */
    public PercentageGroupedCategoryDataset(CategoryDataset dataset) {
        super(dataset);
    }

    /** {@inheritDoc} */
    @Override
    public Number getValue(int row, int column) {
        double total = 0;
        String group1 = StringUtils.substringBefore((String) getRowKey(row), GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY);
        for (int i = 0; i < getRowCount(); i++) {
            Number value = dataset.getValue(i, column);
            if (value != null) {
                String group2 = StringUtils.substringBefore((String) getRowKey(i), GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY);
                if (group1.equals(group2)) {
                    total += value.doubleValue();
                }
            }
        }
        Number value = dataset.getValue(row, column);
        if (value == null) {
            return 0;
        }
        double actual = value.doubleValue();
        if (total > 0) {
            return actual / total * 100;
        }
        return 0;
    }

}
