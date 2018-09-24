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

import net.sf.dynamicreports.jasper.constant.SizeUnit;
import net.sf.dynamicreports.jasper.definition.export.JasperIHtmlExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>JasperHtmlExporter class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperHtmlExporter extends AbstractJasperExporter implements JasperIHtmlExporter {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Boolean outputImagesToDir;
    private String imagesDirName;
    private String imagesURI;
    private String htmlHeader;
    private String betweenPagesHtml;
    private String htmlFooter;
    private Boolean removeEmptySpaceBetweenRows;
    private Boolean whitePageBackground;
    private Boolean usingImagesToAlign;
    private Boolean wrapBreakWord;
    private SizeUnit sizeUnit;
    private Boolean framesAsNestedTables;
    private Boolean ignorePageMargins;
    private String borderCollapse;
    private Boolean accessibleHtml;
    private Float zoomRatio;
    private Boolean ignoreHyperLink;
    private Boolean flushOutput;

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getOutputImagesToDir() {
        return outputImagesToDir;
    }

    /**
     * <p>Setter for the field <code>outputImagesToDir</code>.</p>
     *
     * @param outputImagesToDir a {@link java.lang.Boolean} object.
     */
    public void setOutputImagesToDir(Boolean outputImagesToDir) {
        this.outputImagesToDir = outputImagesToDir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getImagesDirName() {
        return imagesDirName;
    }

    /**
     * <p>Setter for the field <code>imagesDirName</code>.</p>
     *
     * @param imagesDirName a {@link java.lang.String} object.
     */
    public void setImagesDirName(String imagesDirName) {
        this.imagesDirName = imagesDirName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getImagesURI() {
        return imagesURI;
    }

    /**
     * <p>Setter for the field <code>imagesURI</code>.</p>
     *
     * @param imagesURI a {@link java.lang.String} object.
     */
    public void setImagesURI(String imagesURI) {
        this.imagesURI = imagesURI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHtmlHeader() {
        return htmlHeader;
    }

    /**
     * <p>Setter for the field <code>htmlHeader</code>.</p>
     *
     * @param htmlHeader a {@link java.lang.String} object.
     */
    public void setHtmlHeader(String htmlHeader) {
        this.htmlHeader = htmlHeader;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBetweenPagesHtml() {
        return betweenPagesHtml;
    }

    /**
     * <p>Setter for the field <code>betweenPagesHtml</code>.</p>
     *
     * @param betweenPagesHtml a {@link java.lang.String} object.
     */
    public void setBetweenPagesHtml(String betweenPagesHtml) {
        this.betweenPagesHtml = betweenPagesHtml;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHtmlFooter() {
        return htmlFooter;
    }

    /**
     * <p>Setter for the field <code>htmlFooter</code>.</p>
     *
     * @param htmlFooter a {@link java.lang.String} object.
     */
    public void setHtmlFooter(String htmlFooter) {
        this.htmlFooter = htmlFooter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getRemoveEmptySpaceBetweenRows() {
        return removeEmptySpaceBetweenRows;
    }

    /**
     * <p>Setter for the field <code>removeEmptySpaceBetweenRows</code>.</p>
     *
     * @param removeEmptySpaceBetweenRows a {@link java.lang.Boolean} object.
     */
    public void setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
        this.removeEmptySpaceBetweenRows = removeEmptySpaceBetweenRows;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getWhitePageBackground() {
        return whitePageBackground;
    }

    /**
     * <p>Setter for the field <code>whitePageBackground</code>.</p>
     *
     * @param whitePageBackground a {@link java.lang.Boolean} object.
     */
    public void setWhitePageBackground(Boolean whitePageBackground) {
        this.whitePageBackground = whitePageBackground;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getUsingImagesToAlign() {
        return usingImagesToAlign;
    }

    /**
     * <p>Setter for the field <code>usingImagesToAlign</code>.</p>
     *
     * @param usingImagesToAlign a {@link java.lang.Boolean} object.
     */
    public void setUsingImagesToAlign(Boolean usingImagesToAlign) {
        this.usingImagesToAlign = usingImagesToAlign;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getWrapBreakWord() {
        return wrapBreakWord;
    }

    /**
     * <p>Setter for the field <code>wrapBreakWord</code>.</p>
     *
     * @param wrapBreakWord a {@link java.lang.Boolean} object.
     */
    public void setWrapBreakWord(Boolean wrapBreakWord) {
        this.wrapBreakWord = wrapBreakWord;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SizeUnit getSizeUnit() {
        return sizeUnit;
    }

    /**
     * <p>Setter for the field <code>sizeUnit</code>.</p>
     *
     * @param sizeUnit a {@link net.sf.dynamicreports.jasper.constant.SizeUnit} object.
     */
    public void setSizeUnit(SizeUnit sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getFramesAsNestedTables() {
        return framesAsNestedTables;
    }

    /**
     * <p>Setter for the field <code>framesAsNestedTables</code>.</p>
     *
     * @param framesAsNestedTables a {@link java.lang.Boolean} object.
     */
    public void setFramesAsNestedTables(Boolean framesAsNestedTables) {
        this.framesAsNestedTables = framesAsNestedTables;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getIgnorePageMargins() {
        return ignorePageMargins;
    }

    /**
     * <p>Setter for the field <code>ignorePageMargins</code>.</p>
     *
     * @param ignorePageMargins a {@link java.lang.Boolean} object.
     */
    public void setIgnorePageMargins(Boolean ignorePageMargins) {
        this.ignorePageMargins = ignorePageMargins;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBorderCollapse() {
        return borderCollapse;
    }

    /**
     * <p>Setter for the field <code>borderCollapse</code>.</p>
     *
     * @param borderCollapse a {@link java.lang.String} object.
     */
    public void setBorderCollapse(String borderCollapse) {
        this.borderCollapse = borderCollapse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getAccessibleHtml() {
        return accessibleHtml;
    }

    /**
     * <p>Setter for the field <code>accessibleHtml</code>.</p>
     *
     * @param accessibleHtml a {@link java.lang.Boolean} object.
     */
    public void setAccessibleHtml(Boolean accessibleHtml) {
        this.accessibleHtml = accessibleHtml;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getIgnoreHyperLink() {
        return ignoreHyperLink;
    }

    /**
     * <p>Setter for the field <code>ignoreHyperLink</code>.</p>
     *
     * @param ignoreHyperLink a {@link java.lang.Boolean} object.
     */
    public void setIgnoreHyperLink(Boolean ignoreHyperLink) {
        this.ignoreHyperLink = ignoreHyperLink;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getFlushOutput() {
        return flushOutput;
    }

    /**
     * <p>Setter for the field <code>flushOutput</code>.</p>
     *
     * @param flushOutput a {@link java.lang.Boolean} object.
     */
    public void setFlushOutput(Boolean flushOutput) {
        this.flushOutput = flushOutput;
    }

}
