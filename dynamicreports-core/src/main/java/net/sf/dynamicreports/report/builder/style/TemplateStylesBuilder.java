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

import net.sf.dynamicreports.jasper.base.JasperTemplateStyleLoader;
import net.sf.dynamicreports.report.base.style.DRStyle;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.commons.lang3.Validate;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>TemplateStylesBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class TemplateStylesBuilder extends AbstractBuilder<TemplateStylesBuilder, List<StyleBuilder>> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for TemplateStylesBuilder.</p>
     */
    protected TemplateStylesBuilder() {
        super(new ArrayList<StyleBuilder>());
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param inputStream a {@link java.io.InputStream} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public TemplateStylesBuilder loadStyles(InputStream inputStream) {
        return addStyles(JasperTemplateStyleLoader.loadStyles(inputStream));
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param file a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public TemplateStylesBuilder loadStyles(File file) {
        return addStyles(JasperTemplateStyleLoader.loadStyles(file));
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param fileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public TemplateStylesBuilder loadStyles(String fileName) throws DRException {
        return addStyles(JasperTemplateStyleLoader.loadStyles(fileName));
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param url a {@link java.net.URL} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public TemplateStylesBuilder loadStyles(URL url) {
        return addStyles(JasperTemplateStyleLoader.loadStyles(url));
    }

    private TemplateStylesBuilder addStyles(DRStyle[] styles) {
        for (DRStyle style : styles) {
            this.getObject().add(new StyleBuilder(style));
        }
        return this;
    }

    /**
     * <p>styles.</p>
     *
     * @param styles a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public TemplateStylesBuilder styles(StyleBuilder... styles) {
        return addStyle(styles);
    }

    /**
     * <p>addStyle.</p>
     *
     * @param styles a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public TemplateStylesBuilder addStyle(StyleBuilder... styles) {
        Validate.notNull(styles, "styles must not be null");
        Validate.noNullElements(styles, "styles must not contains null style");
        for (StyleBuilder templateStyle : styles) {
            getObject().add(templateStyle);
        }
        return this;
    }

    /**
     * <p>getStyle.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     */
    public StyleBuilder getStyle(String name) {
        Validate.notNull(name, "name must not be null");
        for (StyleBuilder style : getStyles()) {
            if (name.equals(style.getStyle().getName())) {
                return style;
            }
        }
        return null;
    }

    /**
     * <p>getStyles.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<StyleBuilder> getStyles() {
        return build();
    }
}
