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

package net.sf.dynamicreports.jasper.definition.export;

import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface JasperIExporter extends Serializable {

	public Writer getOutputWriter();

	public OutputStream getOutputStream();

	public File getOutputFile();

	public String getOutputFileName();

	public Integer getPageIndex();

	public Integer getStartPageIndex();

	public Integer getEndPageIndex();

	public String getCharacterEncoding();

	public Integer getOffsetX();

	public Integer getOffsetY();

}
