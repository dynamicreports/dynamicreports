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
package net.sf.dynamicreports.report.constant;

/**
 * <p>ImageScale class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public enum ImageScale {

    /**
     * Use CLIP instead
     */
    @Deprecated NO_RESIZE, /**
     * Use FILL_FRAME instead
     */
    @Deprecated FILL, /**
     * Use RETAIN_SHAPE instead
     */
    @Deprecated FILL_PROPORTIONALLY, /**
     * A constant value specifying that if the actual image is larger than the image element size, it will be cut off so that it keeps its original resolution, and only the region that fits the
     * specified size will be displayed.
     */
    CLIP, /**
     * A constant value specifying that if the dimensions of the actual image do not fit those specified for the image element that displays it, the image can be forced to obey them and stretch itself
     * so that it fits in the designated output area.
     */
    FILL_FRAME, /**
     * A constant value specifying that if the actual image does not fit into the image element, it can be adapted to those dimensions without needing to change its original proportions.
     */
    RETAIN_SHAPE, /**
     * A scale image type that instructs the engine to stretch the image height to fit the actual height of the image.
     */
    REAL_HEIGHT, /**
     * A scale image type that stretches the images height in the same way as {@link #REAL_HEIGHT}, and in addition it changes the image width to the actual with of the image.
     */
    REAL_SIZE
}
