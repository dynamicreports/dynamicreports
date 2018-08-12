/**
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

package net.sf.dynamicreports.design.transformation.chartcustomizer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.OrderType;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

/**
 * <p>SeriesOrderCategoryDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SeriesOrderCategoryDataset implements CategoryDataset, Serializable {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected List<String> rowKeys;
	protected CategoryDataset dataset;

	/**
	 * <p>Constructor for SeriesOrderCategoryDataset.</p>
	 *
	 * @param dataset a {@link org.jfree.data.category.CategoryDataset} object.
	 * @param seriesOrderBy a {@link java.util.Comparator} object.
	 * @param seriesOrderType a {@link net.sf.dynamicreports.report.constant.OrderType} object.
	 */
	public SeriesOrderCategoryDataset(CategoryDataset dataset, Comparator<String> seriesOrderBy, OrderType seriesOrderType) {
		this.dataset = dataset;
		this.rowKeys = new ArrayList<String>();
		for (int i = 0; i < dataset.getRowCount(); i++) {
			String serieName = (String) dataset.getRowKey(i);
			this.rowKeys.add(serieName);
		}
		if (seriesOrderBy != null) {
			Collections.sort(this.rowKeys, seriesOrderBy);
		} else {
			Collections.sort(this.rowKeys, new SeriesComparator());
		}
		if (seriesOrderType != null && seriesOrderType.equals(OrderType.DESCENDING)) {
			Collections.reverse(this.rowKeys);
		}
	}

	/** {@inheritDoc} */
	@Override
	public Comparable<?> getRowKey(int row) {
		return rowKeys.get(row);
	}

	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("rawtypes")
	public int getRowIndex(Comparable key) {
		return rowKeys.indexOf(key);
	}

	/** {@inheritDoc} */
	@Override
	public List<?> getRowKeys() {
		return rowKeys;
	}

	/** {@inheritDoc} */
	@Override
	public Comparable<?> getColumnKey(int column) {
		return dataset.getColumnKey(column);
	}

	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("rawtypes")
	public int getColumnIndex(Comparable key) {
		return dataset.getColumnIndex(key);
	}

	/** {@inheritDoc} */
	@Override
	public List<?> getColumnKeys() {
		return dataset.getColumnKeys();
	}

	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("rawtypes")
	public Number getValue(Comparable rowKey, Comparable columnKey) {
		return getValue(getRowIndex(rowKey), getColumnIndex(columnKey));
	}

	/** {@inheritDoc} */
	@Override
	public int getRowCount() {
		return dataset.getRowCount();
	}

	/** {@inheritDoc} */
	@Override
	public int getColumnCount() {
		return dataset.getColumnCount();
	}

	/** {@inheritDoc} */
	@Override
	public Number getValue(int row, int column) {
		int rowIndex = dataset.getRowIndex(rowKeys.get(row));
		return dataset.getValue(rowIndex, column);
	}

	/** {@inheritDoc} */
	@Override
	public void addChangeListener(DatasetChangeListener listener) {
		dataset.addChangeListener(listener);
	}

	/** {@inheritDoc} */
	@Override
	public void removeChangeListener(DatasetChangeListener listener) {
		dataset.removeChangeListener(listener);
	}

	/** {@inheritDoc} */
	@Override
	public DatasetGroup getGroup() {
		return dataset.getGroup();
	}

	/** {@inheritDoc} */
	@Override
	public void setGroup(DatasetGroup group) {
		dataset.setGroup(group);
	}

	private class SeriesComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	}
}
