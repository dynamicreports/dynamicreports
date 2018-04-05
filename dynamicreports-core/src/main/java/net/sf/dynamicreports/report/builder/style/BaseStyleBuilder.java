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

package net.sf.dynamicreports.report.builder.style;

import java.awt.Color;

import net.sf.dynamicreports.report.base.style.DRBaseStyle;
import net.sf.dynamicreports.report.base.style.DRTabStop;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.LineSpacing;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.TabStopAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.constant.VerticalImageAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings({ "unchecked", "deprecation" })
public abstract class BaseStyleBuilder<T extends BaseStyleBuilder<T, U>, U extends DRBaseStyle> extends AbstractBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected BaseStyleBuilder(U baseStyle) {
		super(baseStyle);
	}

	public T setBackgroundColor(Color backgroundColor) {
		getObject().setBackgroundColor(backgroundColor);
		return (T) this;
	}

	public T setBorder(BorderBuilder border) {
		if (border != null) {
			getObject().setBorder(border.build());
		} else {
			getObject().setBorder(null);
		}
		return (T) this;
	}

	public T setBorder(PenBuilder pen) {
		return setBorder(pen != null ? Styles.border(pen) : null);
	}

	public T setTopBorder(PenBuilder topPen) {
		if (topPen != null) {
			getObject().getBorder().setTopPen(topPen.build());
		} else {
			getObject().getBorder().setTopPen(null);
		}
		return (T) this;
	}

	public T setLeftBorder(PenBuilder leftPen) {
		if (leftPen != null) {
			getObject().getBorder().setLeftPen(leftPen.build());
		} else {
			getObject().getBorder().setLeftPen(null);
		}
		return (T) this;
	}

	public T setBottomBorder(PenBuilder bottomPen) {
		if (bottomPen != null) {
			getObject().getBorder().setBottomPen(bottomPen.build());
		} else {
			getObject().getBorder().setBottomPen(null);
		}
		return (T) this;
	}

	public T setRightBorder(PenBuilder rightPen) {
		if (rightPen != null) {
			getObject().getBorder().setRightPen(rightPen.build());
		} else {
			getObject().getBorder().setRightPen(null);
		}
		return (T) this;
	}

	public T setFont(FontBuilder font) {
		if (font != null) {
			getObject().setFont(font.build());
		} else {
			getObject().setFont(null);
		}
		return (T) this;
	}

	public T bold() {
		return setBold(true);
	}

	public T setBold(Boolean bold) {
		getObject().getFont().setBold(bold);
		return (T) this;
	}

	public T setFontName(String fontName) {
		getObject().getFont().setFontName(fontName);
		return (T) this;
	}

	public T setFontSize(Integer fontSize) {
		getObject().getFont().setFontSize(fontSize);
		return (T) this;
	}

	public T italic() {
		return setItalic(true);
	}

	public T setItalic(Boolean italic) {
		getObject().getFont().setItalic(italic);
		return (T) this;
	}

	public T boldItalic() {
		setBold(true);
		return setItalic(true);
	}

	@Deprecated
	/**
	 * You should configure the fonts.xml file
	 */
	public T setPdfEmbedded(Boolean pdfEmbedded) {
		getObject().getFont().setPdfEmbedded(pdfEmbedded);
		return (T) this;
	}

	@Deprecated
	/**
	 * You should configure the fonts.xml file
	 */
	public T setPdfEncoding(String pdfEncoding) {
		getObject().getFont().setPdfEncoding(pdfEncoding);
		return (T) this;
	}

	@Deprecated
	/**
	 * You should configure the fonts.xml file
	 */
	public T setPdfFontName(String pdfFontName) {
		getObject().getFont().setPdfFontName(pdfFontName);
		return (T) this;
	}

	public T strikeThrough() {
		return setStrikeThrough(true);
	}

	public T setStrikeThrough(Boolean strikeThrough) {
		getObject().getFont().setStrikeThrough(strikeThrough);
		return (T) this;
	}

	public T underline() {
		return setUnderline(true);
	}

	public T setUnderline(Boolean underline) {
		getObject().getFont().setUnderline(underline);
		return (T) this;
	}

	public T setForegroundColor(Color foregroudColor) {
		getObject().setForegroundColor(foregroudColor);
		return (T) this;
	}

	/**
	 * @deprecated use setHorizontalTextAlignment instead
	 */
	@Deprecated
	public T setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		if (horizontalAlignment != null) {
			getObject().setHorizontalTextAlignment(HorizontalTextAlignment.valueOf(horizontalAlignment.name()));
		} else {
			getObject().setHorizontalTextAlignment(null);
		}
		return (T) this;
	}

	public T setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		getObject().setHorizontalTextAlignment(horizontalTextAlignment);
		return (T) this;
	}

	public T setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
		getObject().setHorizontalImageAlignment(horizontalImageAlignment);
		return (T) this;
	}

	public T setImageScale(ImageScale imageScale) {
		getObject().setImageScale(imageScale);
		return (T) this;
	}

	public T setPadding(PaddingBuilder padding) {
		if (padding != null) {
			getObject().setPadding(padding.build());
		} else {
			getObject().setPadding(null);
		}
		return (T) this;
	}

	public T setPadding(Integer padding) {
		return setPadding(Styles.padding(padding));
	}

	public T setTopPadding(Integer top) {
		getObject().getPadding().setTop(top);
		return (T) this;
	}

	public T setLeftPadding(Integer left) {
		getObject().getPadding().setLeft(left);
		return (T) this;
	}

	public T setBottomPadding(Integer bottom) {
		getObject().getPadding().setBottom(bottom);
		return (T) this;
	}

	public T setRightPadding(Integer right) {
		getObject().getPadding().setRight(right);
		return (T) this;
	}

	public T setPattern(String pattern) {
		getObject().setPattern(pattern);
		return (T) this;
	}

	public T setRadius(Integer radius) {
		getObject().setRadius(radius);
		return (T) this;
	}

	public T setRotation(Rotation rotation) {
		getObject().setRotation(rotation);
		return (T) this;
	}

	/**
	 * @deprecated use setTextAlignment instead
	 */
	@Deprecated
	public T setAlignment(HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
		if (horizontalAlignment != null) {
			getObject().setHorizontalTextAlignment(HorizontalTextAlignment.valueOf(horizontalAlignment.name()));
		} else {
			getObject().setHorizontalTextAlignment(null);
		}
		if (verticalAlignment != null) {
			getObject().setVerticalTextAlignment(VerticalTextAlignment.valueOf(verticalAlignment.name()));
		} else {
			getObject().setVerticalTextAlignment(null);
		}
		return (T) this;
	}

	public T setTextAlignment(HorizontalTextAlignment horizontalTextAlignment, VerticalTextAlignment verticalTextAlignment) {
		getObject().setHorizontalTextAlignment(horizontalTextAlignment);
		getObject().setVerticalTextAlignment(verticalTextAlignment);
		return (T) this;
	}

	public T setImageAlignment(HorizontalImageAlignment horizontalImageAlignment, VerticalImageAlignment verticalImageAlignment) {
		getObject().setHorizontalImageAlignment(horizontalImageAlignment);
		getObject().setVerticalImageAlignment(verticalImageAlignment);
		return (T) this;
	}

	/**
	 * @deprecated use setVerticalTextAlignment instead
	 */
	@Deprecated
	public T setVerticalAlignment(VerticalAlignment verticalAlignment) {
		if (verticalAlignment != null) {
			getObject().setVerticalTextAlignment(VerticalTextAlignment.valueOf(verticalAlignment.name()));
		} else {
			getObject().setVerticalTextAlignment(null);
		}
		return (T) this;
	}

	public T setVerticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
		getObject().setVerticalTextAlignment(verticalTextAlignment);
		return (T) this;
	}

	public T setVerticalImageAlignment(VerticalImageAlignment verticalImageAlignment) {
		getObject().setVerticalImageAlignment(verticalImageAlignment);
		return (T) this;
	}

	public T setMarkup(Markup markup) {
		getObject().setMarkup(markup);
		return (T) this;
	}

	public T setLineSpacing(LineSpacing lineSpacing) {
		getObject().getParagraph().setLineSpacing(lineSpacing);
		return (T) this;
	}

	public T setLineSpacingSize(Float lineSpacingSize) {
		getObject().getParagraph().setLineSpacingSize(lineSpacingSize);
		return (T) this;
	}

	public T setFirstLineIndent(Integer firstLineIndent) {
		getObject().getParagraph().setFirstLineIndent(firstLineIndent);
		return (T) this;
	}

	public T setLeftIndent(Integer leftIndent) {
		getObject().getParagraph().setLeftIndent(leftIndent);
		return (T) this;
	}

	public T setRightIndent(Integer rightIndent) {
		getObject().getParagraph().setRightIndent(rightIndent);
		return (T) this;
	}

	public T setSpacingBefore(Integer spacingBefore) {
		getObject().getParagraph().setSpacingBefore(spacingBefore);
		return (T) this;
	}

	public T setSpacingAfter(Integer spacingAfter) {
		getObject().getParagraph().setSpacingAfter(spacingAfter);
		return (T) this;
	}

	public T setTabStopWidth(Integer tabStopWidth) {
		getObject().getParagraph().setTabStopWidth(tabStopWidth);
		return (T) this;
	}

	public T addTabStop(int position, TabStopAlignment alignment) {
		Validate.notNull(alignment, "alignment must not be null");
		DRTabStop tabStop = new DRTabStop();
		tabStop.setPosition(position);
		tabStop.setAlignment(alignment);
		getObject().getParagraph().getTabStops().add(tabStop);
		return (T) this;
	}

	public T setLinePen(PenBuilder linePen) {
		if (linePen != null) {
			getObject().setLinePen(linePen.build());
		} else {
			getObject().setLinePen(null);
		}
		return (T) this;
	}

	public U getStyle() {
		return build();
	}
}
