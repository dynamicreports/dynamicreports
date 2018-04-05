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
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class PercentageCategoryDataset implements CategoryDataset, Serializable {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected CategoryDataset dataset;

	public PercentageCategoryDataset(CategoryDataset dataset) {
		this.dataset = dataset;
	}

	@Override
	public Comparable<?> getRowKey(int row) {
		return dataset.getRowKey(row);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public int getRowIndex(Comparable key) {
		return dataset.getRowIndex(key);
	}

	@Override
	public List<?> getRowKeys() {
		return dataset.getRowKeys();
	}

	@Override
	public Comparable<?> getColumnKey(int column) {
		return dataset.getColumnKey(column);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public int getColumnIndex(Comparable key) {
		return dataset.getColumnIndex(key);
	}

	@Override
	public List<?> getColumnKeys() {
		return dataset.getColumnKeys();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Number getValue(Comparable rowKey, Comparable columnKey) {
		return getValue(getRowIndex(rowKey), getColumnIndex(columnKey));
	}

	@Override
	public int getRowCount() {
		return dataset.getRowCount();
	}

	@Override
	public int getColumnCount() {
		return dataset.getColumnCount();
	}

	@Override
	public Number getValue(int row, int column) {
		double total = 0;
		for (int i = 0; i < getRowCount(); i++) {
			Number value = dataset.getValue(i, column);
			if (value != null) {
				total += value.doubleValue();
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

	@Override
	public void addChangeListener(DatasetChangeListener listener) {
		dataset.addChangeListener(listener);
	}

	@Override
	public void removeChangeListener(DatasetChangeListener listener) {
		dataset.removeChangeListener(listener);
	}

	@Override
	public DatasetGroup getGroup() {
		return dataset.getGroup();
	}

	@Override
	public void setGroup(DatasetGroup group) {
		dataset.setGroup(group);
	}

}
