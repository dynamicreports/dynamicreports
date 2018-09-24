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
package net.sf.dynamicreports.report.builder.style;

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

import java.awt.Color;

/**
 * <p>Abstract BaseStyleBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
@SuppressWarnings( {"unchecked", "deprecation"})
public abstract class BaseStyleBuilder<T extends BaseStyleBuilder<T, U>, U extends DRBaseStyle> extends AbstractBuilder<T, U> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for BaseStyleBuilder.</p>
     *
     * @param baseStyle a U object.
     */
    protected BaseStyleBuilder(U baseStyle) {
        super(baseStyle);
    }

    /**
     * <p>setBackgroundColor.</p>
     *
     * @param backgroundColor a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T setBackgroundColor(Color backgroundColor) {
        getObject().setBackgroundColor(backgroundColor);
        return (T) this;
    }

    /**
     * <p>setBorder.</p>
     *
     * @param border a {@link net.sf.dynamicreports.report.builder.style.BorderBuilder} object.
     * @return a T object.
     */
    public T setBorder(BorderBuilder border) {
        if (border != null) {
            getObject().setBorder(border.build());
        } else {
            getObject().setBorder(null);
        }
        return (T) this;
    }

    /**
     * <p>setBorder.</p>
     *
     * @param pen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a T object.
     */
    public T setBorder(PenBuilder pen) {
        return setBorder(pen != null ? Styles.border(pen) : null);
    }

    /**
     * <p>setTopBorder.</p>
     *
     * @param topPen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a T object.
     */
    public T setTopBorder(PenBuilder topPen) {
        if (topPen != null) {
            getObject().getBorder().setTopPen(topPen.build());
        } else {
            getObject().getBorder().setTopPen(null);
        }
        return (T) this;
    }

    /**
     * <p>setLeftBorder.</p>
     *
     * @param leftPen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a T object.
     */
    public T setLeftBorder(PenBuilder leftPen) {
        if (leftPen != null) {
            getObject().getBorder().setLeftPen(leftPen.build());
        } else {
            getObject().getBorder().setLeftPen(null);
        }
        return (T) this;
    }

    /**
     * <p>setBottomBorder.</p>
     *
     * @param bottomPen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a T object.
     */
    public T setBottomBorder(PenBuilder bottomPen) {
        if (bottomPen != null) {
            getObject().getBorder().setBottomPen(bottomPen.build());
        } else {
            getObject().getBorder().setBottomPen(null);
        }
        return (T) this;
    }

    /**
     * <p>setRightBorder.</p>
     *
     * @param rightPen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a T object.
     */
    public T setRightBorder(PenBuilder rightPen) {
        if (rightPen != null) {
            getObject().getBorder().setRightPen(rightPen.build());
        } else {
            getObject().getBorder().setRightPen(null);
        }
        return (T) this;
    }

    /**
     * <p>setFont.</p>
     *
     * @param font a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a T object.
     */
    public T setFont(FontBuilder font) {
        if (font != null) {
            getObject().setFont(font.build());
        } else {
            getObject().setFont(null);
        }
        return (T) this;
    }

    /**
     * <p>bold.</p>
     *
     * @return a T object.
     */
    public T bold() {
        return setBold(true);
    }

    /**
     * <p>setBold.</p>
     *
     * @param bold a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setBold(Boolean bold) {
        getObject().getFont().setBold(bold);
        return (T) this;
    }

    /**
     * <p>setFontName.</p>
     *
     * @param fontName a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setFontName(String fontName) {
        getObject().getFont().setFontName(fontName);
        return (T) this;
    }

    /**
     * <p>setFontSize.</p>
     *
     * @param fontSize a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setFontSize(Integer fontSize) {
        getObject().getFont().setFontSize(fontSize);
        return (T) this;
    }

    /**
     * <p>italic.</p>
     *
     * @return a T object.
     */
    public T italic() {
        return setItalic(true);
    }

    /**
     * <p>setItalic.</p>
     *
     * @param italic a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setItalic(Boolean italic) {
        getObject().getFont().setItalic(italic);
        return (T) this;
    }

    /**
     * <p>boldItalic.</p>
     *
     * @return a T object.
     */
    public T boldItalic() {
        setBold(true);
        return setItalic(true);
    }

    @Deprecated
    /**
     * You should configure the fonts.xml file
     *
     * @param pdfEmbedded a {@link java.lang.Boolean} object.
     * @return a T object.
     */ public T setPdfEmbedded(Boolean pdfEmbedded) {
        getObject().getFont().setPdfEmbedded(pdfEmbedded);
        return (T) this;
    }

    @Deprecated
    /**
     * You should configure the fonts.xml file
     *
     * @param pdfEncoding a {@link java.lang.String} object.
     * @return a T object.
     */ public T setPdfEncoding(String pdfEncoding) {
        getObject().getFont().setPdfEncoding(pdfEncoding);
        return (T) this;
    }

    @Deprecated
    /**
     * You should configure the fonts.xml file
     *
     * @param pdfFontName a {@link java.lang.String} object.
     * @return a T object.
     */ public T setPdfFontName(String pdfFontName) {
        getObject().getFont().setPdfFontName(pdfFontName);
        return (T) this;
    }

    /**
     * <p>strikeThrough.</p>
     *
     * @return a T object.
     */
    public T strikeThrough() {
        return setStrikeThrough(true);
    }

    /**
     * <p>setStrikeThrough.</p>
     *
     * @param strikeThrough a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setStrikeThrough(Boolean strikeThrough) {
        getObject().getFont().setStrikeThrough(strikeThrough);
        return (T) this;
    }

    /**
     * <p>underline.</p>
     *
     * @return a T object.
     */
    public T underline() {
        return setUnderline(true);
    }

    /**
     * <p>setUnderline.</p>
     *
     * @param underline a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setUnderline(Boolean underline) {
        getObject().getFont().setUnderline(underline);
        return (T) this;
    }

    /**
     * <p>setForegroundColor.</p>
     *
     * @param foregroudColor a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T setForegroundColor(Color foregroudColor) {
        getObject().setForegroundColor(foregroudColor);
        return (T) this;
    }

    /**
     * <p>setHorizontalAlignment.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalAlignment} object.
     * @return a T object.
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

    /**
     * <p>setHorizontalTextAlignment.</p>
     *
     * @param horizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     * @return a T object.
     */
    public T setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
        getObject().setHorizontalTextAlignment(horizontalTextAlignment);
        return (T) this;
    }

    /**
     * <p>setHorizontalImageAlignment.</p>
     *
     * @param horizontalImageAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     * @return a T object.
     */
    public T setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
        getObject().setHorizontalImageAlignment(horizontalImageAlignment);
        return (T) this;
    }

    /**
     * <p>setImageScale.</p>
     *
     * @param imageScale a {@link net.sf.dynamicreports.report.constant.ImageScale} object.
     * @return a T object.
     */
    public T setImageScale(ImageScale imageScale) {
        getObject().setImageScale(imageScale);
        return (T) this;
    }

    /**
     * <p>setPadding.</p>
     *
     * @param padding a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
     * @return a T object.
     */
    public T setPadding(PaddingBuilder padding) {
        if (padding != null) {
            getObject().setPadding(padding.build());
        } else {
            getObject().setPadding(null);
        }
        return (T) this;
    }

    /**
     * <p>setPadding.</p>
     *
     * @param padding a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setPadding(Integer padding) {
        return setPadding(Styles.padding(padding));
    }

    /**
     * <p>setTopPadding.</p>
     *
     * @param top a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setTopPadding(Integer top) {
        getObject().getPadding().setTop(top);
        return (T) this;
    }

    /**
     * <p>setLeftPadding.</p>
     *
     * @param left a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setLeftPadding(Integer left) {
        getObject().getPadding().setLeft(left);
        return (T) this;
    }

    /**
     * <p>setBottomPadding.</p>
     *
     * @param bottom a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setBottomPadding(Integer bottom) {
        getObject().getPadding().setBottom(bottom);
        return (T) this;
    }

    /**
     * <p>setRightPadding.</p>
     *
     * @param right a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setRightPadding(Integer right) {
        getObject().getPadding().setRight(right);
        return (T) this;
    }

    /**
     * <p>setPattern.</p>
     *
     * @param pattern a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setPattern(String pattern) {
        getObject().setPattern(pattern);
        return (T) this;
    }

    /**
     * <p>setRadius.</p>
     *
     * @param radius a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setRadius(Integer radius) {
        getObject().setRadius(radius);
        return (T) this;
    }

    /**
     * <p>setRotation.</p>
     *
     * @param rotation a {@link net.sf.dynamicreports.report.constant.Rotation} object.
     * @return a T object.
     */
    public T setRotation(Rotation rotation) {
        getObject().setRotation(rotation);
        return (T) this;
    }

    /**
     * <p>setAlignment.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalAlignment} object.
     * @param verticalAlignment   a {@link net.sf.dynamicreports.report.constant.VerticalAlignment} object.
     * @return a T object.
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

    /**
     * <p>setTextAlignment.</p>
     *
     * @param horizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     * @param verticalTextAlignment   a {@link net.sf.dynamicreports.report.constant.VerticalTextAlignment} object.
     * @return a T object.
     */
    public T setTextAlignment(HorizontalTextAlignment horizontalTextAlignment, VerticalTextAlignment verticalTextAlignment) {
        getObject().setHorizontalTextAlignment(horizontalTextAlignment);
        getObject().setVerticalTextAlignment(verticalTextAlignment);
        return (T) this;
    }

    /**
     * <p>setImageAlignment.</p>
     *
     * @param horizontalImageAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     * @param verticalImageAlignment   a {@link net.sf.dynamicreports.report.constant.VerticalImageAlignment} object.
     * @return a T object.
     */
    public T setImageAlignment(HorizontalImageAlignment horizontalImageAlignment, VerticalImageAlignment verticalImageAlignment) {
        getObject().setHorizontalImageAlignment(horizontalImageAlignment);
        getObject().setVerticalImageAlignment(verticalImageAlignment);
        return (T) this;
    }

    /**
     * <p>setVerticalAlignment.</p>
     *
     * @param verticalAlignment a {@link net.sf.dynamicreports.report.constant.VerticalAlignment} object.
     * @return a T object.
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

    /**
     * <p>setVerticalTextAlignment.</p>
     *
     * @param verticalTextAlignment a {@link net.sf.dynamicreports.report.constant.VerticalTextAlignment} object.
     * @return a T object.
     */
    public T setVerticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
        getObject().setVerticalTextAlignment(verticalTextAlignment);
        return (T) this;
    }

    /**
     * <p>setVerticalImageAlignment.</p>
     *
     * @param verticalImageAlignment a {@link net.sf.dynamicreports.report.constant.VerticalImageAlignment} object.
     * @return a T object.
     */
    public T setVerticalImageAlignment(VerticalImageAlignment verticalImageAlignment) {
        getObject().setVerticalImageAlignment(verticalImageAlignment);
        return (T) this;
    }

    /**
     * <p>setMarkup.</p>
     *
     * @param markup a {@link net.sf.dynamicreports.report.constant.Markup} object.
     * @return a T object.
     */
    public T setMarkup(Markup markup) {
        getObject().setMarkup(markup);
        return (T) this;
    }

    /**
     * <p>setLineSpacing.</p>
     *
     * @param lineSpacing a {@link net.sf.dynamicreports.report.constant.LineSpacing} object.
     * @return a T object.
     */
    public T setLineSpacing(LineSpacing lineSpacing) {
        getObject().getParagraph().setLineSpacing(lineSpacing);
        return (T) this;
    }

    /**
     * <p>setLineSpacingSize.</p>
     *
     * @param lineSpacingSize a {@link java.lang.Float} object.
     * @return a T object.
     */
    public T setLineSpacingSize(Float lineSpacingSize) {
        getObject().getParagraph().setLineSpacingSize(lineSpacingSize);
        return (T) this;
    }

    /**
     * <p>setFirstLineIndent.</p>
     *
     * @param firstLineIndent a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setFirstLineIndent(Integer firstLineIndent) {
        getObject().getParagraph().setFirstLineIndent(firstLineIndent);
        return (T) this;
    }

    /**
     * <p>setLeftIndent.</p>
     *
     * @param leftIndent a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setLeftIndent(Integer leftIndent) {
        getObject().getParagraph().setLeftIndent(leftIndent);
        return (T) this;
    }

    /**
     * <p>setRightIndent.</p>
     *
     * @param rightIndent a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setRightIndent(Integer rightIndent) {
        getObject().getParagraph().setRightIndent(rightIndent);
        return (T) this;
    }

    /**
     * <p>setSpacingBefore.</p>
     *
     * @param spacingBefore a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setSpacingBefore(Integer spacingBefore) {
        getObject().getParagraph().setSpacingBefore(spacingBefore);
        return (T) this;
    }

    /**
     * <p>setSpacingAfter.</p>
     *
     * @param spacingAfter a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setSpacingAfter(Integer spacingAfter) {
        getObject().getParagraph().setSpacingAfter(spacingAfter);
        return (T) this;
    }

    /**
     * <p>setTabStopWidth.</p>
     *
     * @param tabStopWidth a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setTabStopWidth(Integer tabStopWidth) {
        getObject().getParagraph().setTabStopWidth(tabStopWidth);
        return (T) this;
    }

    /**
     * <p>addTabStop.</p>
     *
     * @param position  a int.
     * @param alignment a {@link net.sf.dynamicreports.report.constant.TabStopAlignment} object.
     * @return a T object.
     */
    public T addTabStop(int position, TabStopAlignment alignment) {
        Validate.notNull(alignment, "alignment must not be null");
        DRTabStop tabStop = new DRTabStop();
        tabStop.setPosition(position);
        tabStop.setAlignment(alignment);
        getObject().getParagraph().getTabStops().add(tabStop);
        return (T) this;
    }

    /**
     * <p>setLinePen.</p>
     *
     * @param linePen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a T object.
     */
    public T setLinePen(PenBuilder linePen) {
        if (linePen != null) {
            getObject().setLinePen(linePen.build());
        } else {
            getObject().setLinePen(null);
        }
        return (T) this;
    }

    /**
     * <p>getStyle.</p>
     *
     * @return a U object.
     */
    public U getStyle() {
        return build();
    }
}
