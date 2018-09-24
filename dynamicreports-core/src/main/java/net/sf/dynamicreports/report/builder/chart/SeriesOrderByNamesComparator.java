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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.design.transformation.chartcustomizer.GroupedStackedBarRendererCustomizer;
import net.sf.dynamicreports.report.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/**
 * <p>SeriesOrderByNamesComparator class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SeriesOrderByNamesComparator implements Comparator<String>, Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private List<String> seriesNames;

    /**
     * <p>Constructor for SeriesOrderByNamesComparator.</p>
     *
     * @param seriesNames a {@link java.util.List} object.
     */
    public SeriesOrderByNamesComparator(List<String> seriesNames) {
        Validate.notNull(seriesNames, "seriesNames must not be null");
        Validate.noNullElements(seriesNames, "seriesNames must not contains null seriesName");
        this.seriesNames = seriesNames;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compare(String o1, String o2) {
        String row1;
        String row2;
        if (StringUtils.countMatches(o1, GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY) == 1 && StringUtils.countMatches(o2, GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY) == 1) {
            String group1 = StringUtils.substringBefore(o1, GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY);
            String group2 = StringUtils.substringBefore(o2, GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY);
            int compare = group1.compareTo(group2);
            if (compare != 0) {
                return compare;
            }
            row1 = StringUtils.substringAfter(o1, GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY);
            row2 = StringUtils.substringAfter(o2, GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY);
        } else {
            row1 = o1;
            row2 = o2;
        }
        int index1 = seriesNames.indexOf(row1);
        int index2 = seriesNames.indexOf(row2);
        if (index1 < 0 && index2 < 0) {
            return row1.compareTo(row2);
        }
        if (index1 == index2) {
            return 0;
        }
        if (index1 < 0) {
            return index1 * -1;
        }
        if (index2 < 0) {
            return index2;
        }
        return index1 - index2;
    }
}
