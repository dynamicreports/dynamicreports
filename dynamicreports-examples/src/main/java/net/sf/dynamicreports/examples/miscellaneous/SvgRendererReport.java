/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.examples.miscellaneous;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.renderers.Renderable;
import net.sf.jasperreports.renderers.SimpleDataRenderer;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

/**
 * <p>SvgRendererReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class SvgRendererReport {

    /**
     * <p>Constructor for SvgRendererReport.</p>
     */
    public SvgRendererReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new SvgRendererReport();
    }

    private void build() {
        try {
            Renderable image = new SimpleDataRenderer(JRLoader.loadBytes(Templates.class.getResource("images/map.svg")), null);

            report().setTemplate(Templates.reportTemplate)
                    .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .title(Templates.createTitleComponent("SvgRenderer"), cmp.image(image).setHeight(500))
                    .show();
        } catch (DRException | JRException e) {
            e.printStackTrace();
        }
    }
}
