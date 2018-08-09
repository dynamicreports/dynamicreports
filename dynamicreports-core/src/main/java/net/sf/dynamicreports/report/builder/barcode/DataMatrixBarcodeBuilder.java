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

package net.sf.dynamicreports.report.builder.barcode;

import net.sf.dynamicreports.report.base.barcode.DRDataMatrixBarcode;
import net.sf.dynamicreports.report.constant.BarcodeShape;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DataMatrixBarcodeBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DataMatrixBarcodeBuilder extends AbstractBarcode4jBuilder<DataMatrixBarcodeBuilder, DRDataMatrixBarcode> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for DataMatrixBarcodeBuilder.</p>
	 *
	 * @param code a {@link java.lang.String} object.
	 */
	protected DataMatrixBarcodeBuilder(String code) {
		super(code, new DRDataMatrixBarcode());
	}

	/**
	 * <p>Constructor for DataMatrixBarcodeBuilder.</p>
	 *
	 * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	protected DataMatrixBarcodeBuilder(DRIExpression<String> codeExpression) {
		super(codeExpression, new DRDataMatrixBarcode());
	}

	/**
	 * <p>setShape.</p>
	 *
	 * @param shape a {@link net.sf.dynamicreports.report.constant.BarcodeShape} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.barcode.DataMatrixBarcodeBuilder} object.
	 */
	public DataMatrixBarcodeBuilder setShape(BarcodeShape shape) {
		getObject().setShape(shape);
		return this;
	}
}
