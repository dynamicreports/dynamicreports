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

package net.sf.dynamicreports.jasper.base.export;

import net.sf.dynamicreports.jasper.constant.ImageType;
import net.sf.dynamicreports.jasper.definition.export.JasperIImageExporter;
import net.sf.dynamicreports.report.constant.Constants;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperImageExporter extends AbstractJasperExporter implements JasperIImageExporter {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Integer pageGap;
	private ImageType imageType;
	private Float zoomRatio;

	@Override
	public Integer getPageGap() {
		return pageGap;
	}

	public void setPageGap(Integer pageGap) {
		this.pageGap = pageGap;
	}

	@Override
	public ImageType getImageType() {
		return imageType;
	}

	public void setImageType(ImageType imageType) {
		Validate.notNull(imageType, "imageType must not be null");
		this.imageType = imageType;
	}

	@Override
	public Float getZoomRatio() {
		return zoomRatio;
	}

	public void setZoomRatio(Float zoomRatio) {
		this.zoomRatio = zoomRatio;
	}
}
