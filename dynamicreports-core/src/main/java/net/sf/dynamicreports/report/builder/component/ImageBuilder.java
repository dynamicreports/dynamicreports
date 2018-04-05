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

package net.sf.dynamicreports.report.builder.component;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;

import net.sf.dynamicreports.report.base.component.DRImage;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("deprecation")
public class ImageBuilder extends HyperLinkComponentBuilder<ImageBuilder, DRImage> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected ImageBuilder() {
		super(new DRImage());
	}

	public ImageBuilder setImage(DRIExpression<?> imageExpression) {
		getObject().setImageExpression(imageExpression);
		return this;
	}

	public ImageBuilder setImage(String imagePath) {
		getObject().setImageExpression(Expressions.text(imagePath));
		getObject().setUsingCache(true);
		return this;
	}

	public ImageBuilder setImage(Image image) {
		getObject().setImageExpression(Expressions.image(image));
		getObject().setUsingCache(true);
		return this;
	}

	public ImageBuilder setImage(InputStream imageInputStream) {
		getObject().setImageExpression(Expressions.inputStream(imageInputStream));
		getObject().setUsingCache(true);
		return this;
	}

	public ImageBuilder setImage(URL imageUrl) {
		getObject().setImageExpression(Expressions.url(imageUrl));
		getObject().setUsingCache(true);
		return this;
	}

	public ImageBuilder setImageScale(ImageScale imageScale) {
		getObject().setImageScale(imageScale);
		return this;
	}

	public ImageBuilder setUsingCache(Boolean usingCache) {
		getObject().setUsingCache(usingCache);
		return this;
	}

	public ImageBuilder setLazy(Boolean lazy) {
		getObject().setLazy(lazy);
		return this;
	}

	/**
	 * @deprecated use setHorizontalImageAlignment instead
	 */
	@Deprecated
	public ImageBuilder setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		if (horizontalAlignment != null) {
			getObject().setHorizontalImageAlignment(HorizontalImageAlignment.valueOf(horizontalAlignment.name()));
		} else {
			getObject().setHorizontalImageAlignment(null);
		}
		return this;
	}

	public ImageBuilder setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
		getObject().setHorizontalImageAlignment(horizontalImageAlignment);
		return this;
	}
}
