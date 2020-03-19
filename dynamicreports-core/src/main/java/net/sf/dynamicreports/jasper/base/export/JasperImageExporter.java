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
package net.sf.dynamicreports.jasper.base.export;

import net.sf.dynamicreports.jasper.constant.ImageType;
import net.sf.dynamicreports.jasper.definition.export.JasperIImageExporter;
import net.sf.dynamicreports.report.constant.Constants;
import org.apache.commons.lang3.Validate;

/**
 * <p>JasperImageExporter class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class JasperImageExporter extends AbstractJasperExporter implements JasperIImageExporter {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Integer pageGap;
    private ImageType imageType;
    private Float zoomRatio;

    /** {@inheritDoc} */
    @Override
    public Integer getPageGap() {
        return pageGap;
    }

    /**
     * <p>Setter for the field <code>pageGap</code>.</p>
     *
     * @param pageGap a {@link java.lang.Integer} object.
     */
    public void setPageGap(Integer pageGap) {
        this.pageGap = pageGap;
    }

    /** {@inheritDoc} */
    @Override
    public ImageType getImageType() {
        return imageType;
    }

    /**
     * <p>Setter for the field <code>imageType</code>.</p>
     *
     * @param imageType a {@link net.sf.dynamicreports.jasper.constant.ImageType} object.
     */
    public void setImageType(ImageType imageType) {
        Validate.notNull(imageType, "imageType must not be null");
        this.imageType = imageType;
    }

    /** {@inheritDoc} */
    @Override
    public Float getZoomRatio() {
        return zoomRatio;
    }

    /**
     * <p>Setter for the field <code>zoomRatio</code>.</p>
     *
     * @param zoomRatio a {@link java.lang.Float} object.
     */
    public void setZoomRatio(Float zoomRatio) {
        this.zoomRatio = zoomRatio;
    }
}
