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

import net.sf.dynamicreports.report.base.barcode.DRInterleaved2Of5Barcode;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>Interleaved2Of5BarcodeBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Interleaved2Of5BarcodeBuilder extends AbstractChecksumBarcodeBuilder<Interleaved2Of5BarcodeBuilder, DRInterleaved2Of5Barcode> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for Interleaved2Of5BarcodeBuilder.</p>
	 *
	 * @param code a {@link java.lang.String} object.
	 */
	protected Interleaved2Of5BarcodeBuilder(String code) {
		super(code, new DRInterleaved2Of5Barcode());
	}

	/**
	 * <p>Constructor for Interleaved2Of5BarcodeBuilder.</p>
	 *
	 * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	protected Interleaved2Of5BarcodeBuilder(DRIExpression<String> codeExpression) {
		super(codeExpression, new DRInterleaved2Of5Barcode());
	}

	/**
	 * <p>setDisplayChecksum.</p>
	 *
	 * @param displayChecksum a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.barcode.Interleaved2Of5BarcodeBuilder} object.
	 */
	public Interleaved2Of5BarcodeBuilder setDisplayChecksum(Boolean displayChecksum) {
		getObject().setDisplayChecksum(displayChecksum);
		return this;
	}

	/**
	 * <p>setWideFactor.</p>
	 *
	 * @param wideFactor a {@link java.lang.Double} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.barcode.Interleaved2Of5BarcodeBuilder} object.
	 */
	public Interleaved2Of5BarcodeBuilder setWideFactor(Double wideFactor) {
		getObject().setWideFactor(wideFactor);
		return this;
	}
}
