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

package net.sf.dynamicreports.jasper.builder.export;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

import net.sf.dynamicreports.jasper.base.export.AbstractJasperExporter;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractJasperExporterBuilder<T extends AbstractJasperExporterBuilder<T, U>, U extends AbstractJasperExporter>
		extends AbstractBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected AbstractJasperExporterBuilder(U jasperExporter) {
		super(jasperExporter);
	}

	protected T setOutputWriter(Writer outputWriter) {
		getObject().setOutputWriter(outputWriter);
		return (T) this;
	}

	protected T setOutputStream(OutputStream outputStream) {
		getObject().setOutputStream(outputStream);
		return (T) this;
	}

	protected T setOutputFile(File outputFile) {
		getObject().setOutputFile(outputFile);
		return (T) this;
	}

	protected T setOutputFileName(String outputFileName) {
		getObject().setOutputFileName(outputFileName);
		return (T) this;
	}

	public T setPageIndex(Integer pageIndex) {
		getObject().setPageIndex(pageIndex);
		return (T) this;
	}

	public T setStartPageIndex(Integer startPageIndex) {
		getObject().setStartPageIndex(startPageIndex);
		return (T) this;
	}

	public T setEndPageIndex(Integer endPageIndex) {
		getObject().setEndPageIndex(endPageIndex);
		return (T) this;
	}

	public T setCharacterEncoding(String characterEncoding) {
		getObject().setCharacterEncoding(characterEncoding);
		return (T) this;
	}

	public T setOffsetX(Integer offsetX) {
		getObject().setOffsetX(offsetX);
		return (T) this;
	}

	public T setOffsetY(Integer offsetY) {
		getObject().setOffsetY(offsetY);
		return (T) this;
	}

	public U getExporter() {
		return build();
	}
}
