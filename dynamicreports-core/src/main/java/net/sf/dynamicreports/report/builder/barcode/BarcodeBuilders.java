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
package net.sf.dynamicreports.report.builder.barcode;

import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating barcodes
 *
 * @author Ricardo Mariaca
 * 
 */
public class BarcodeBuilders {

    // codabar

    /**
     * <p>codabar.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.CodabarBarcodeBuilder} object.
     */
    public CodabarBarcodeBuilder codabar(String code) {
        return Barcodes.codabar(code);
    }

    /**
     * <p>codabar.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.CodabarBarcodeBuilder} object.
     */
    public CodabarBarcodeBuilder codabar(DRIExpression<String> codeExpression) {
        return Barcodes.codabar(codeExpression);
    }

    // code128

    /**
     * <p>code128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code128BarcodeBuilder} object.
     */
    public Code128BarcodeBuilder code128(String code) {
        return Barcodes.code128(code);
    }

    /**
     * <p>code128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code128BarcodeBuilder} object.
     */
    public Code128BarcodeBuilder code128(DRIExpression<String> codeExpression) {
        return Barcodes.code128(codeExpression);
    }

    // ean128

    /**
     * <p>ean128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean128BarcodeBuilder} object.
     */
    public Ean128BarcodeBuilder ean128(String code) {
        return Barcodes.ean128(code);
    }

    /**
     * <p>ean128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean128BarcodeBuilder} object.
     */
    public Ean128BarcodeBuilder ean128(DRIExpression<String> codeExpression) {
        return Barcodes.ean128(codeExpression);
    }

    // dataMatrix

    /**
     * <p>dataMatrix.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.DataMatrixBarcodeBuilder} object.
     */
    public DataMatrixBarcodeBuilder dataMatrix(String code) {
        return Barcodes.dataMatrix(code);
    }

    /**
     * <p>dataMatrix.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.DataMatrixBarcodeBuilder} object.
     */
    public DataMatrixBarcodeBuilder dataMatrix(DRIExpression<String> codeExpression) {
        return Barcodes.dataMatrix(codeExpression);
    }

    // code39

    /**
     * <p>code39.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public Code39BarcodeBuilder code39(String code) {
        return Barcodes.code39(code);
    }

    /**
     * <p>code39.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public Code39BarcodeBuilder code39(DRIExpression<String> codeExpression) {
        return Barcodes.code39(codeExpression);
    }

    // interleaved2Of5

    /**
     * <p>interleaved2Of5.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Interleaved2Of5BarcodeBuilder} object.
     */
    public Interleaved2Of5BarcodeBuilder interleaved2Of5(String code) {
        return Barcodes.interleaved2Of5(code);
    }

    /**
     * <p>interleaved2Of5.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Interleaved2Of5BarcodeBuilder} object.
     */
    public Interleaved2Of5BarcodeBuilder interleaved2Of5(DRIExpression<String> codeExpression) {
        return Barcodes.interleaved2Of5(codeExpression);
    }

    // upca

    /**
     * <p>upca.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpcaBarcodeBuilder} object.
     */
    public UpcaBarcodeBuilder upca(String code) {
        return Barcodes.upca(code);
    }

    /**
     * <p>upca.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpcaBarcodeBuilder} object.
     */
    public UpcaBarcodeBuilder upca(DRIExpression<String> codeExpression) {
        return Barcodes.upca(codeExpression);
    }

    // upce

    /**
     * <p>upce.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpceBarcodeBuilder} object.
     */
    public UpceBarcodeBuilder upce(String code) {
        return Barcodes.upce(code);
    }

    /**
     * <p>upce.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpceBarcodeBuilder} object.
     */
    public UpceBarcodeBuilder upce(DRIExpression<String> codeExpression) {
        return Barcodes.upce(codeExpression);
    }

    // ean13

    /**
     * <p>ean13.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean13BarcodeBuilder} object.
     */
    public Ean13BarcodeBuilder ean13(String code) {
        return Barcodes.ean13(code);
    }

    /**
     * <p>ean13.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean13BarcodeBuilder} object.
     */
    public Ean13BarcodeBuilder ean13(DRIExpression<String> codeExpression) {
        return Barcodes.ean13(codeExpression);
    }

    // ean8

    /**
     * <p>ean8.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean8BarcodeBuilder} object.
     */
    public Ean8BarcodeBuilder ean8(String code) {
        return Barcodes.ean8(code);
    }

    /**
     * <p>ean8.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean8BarcodeBuilder} object.
     */
    public Ean8BarcodeBuilder ean8(DRIExpression<String> codeExpression) {
        return Barcodes.ean8(codeExpression);
    }

    // uspsIntelligentMail

    /**
     * <p>uspsIntelligentMail.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UspsIntelligentMailBarcodeBuilder} object.
     */
    public UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(String code) {
        return Barcodes.uspsIntelligentMail(code);
    }

    /**
     * <p>uspsIntelligentMail.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UspsIntelligentMailBarcodeBuilder} object.
     */
    public UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(DRIExpression<String> codeExpression) {
        return Barcodes.uspsIntelligentMail(codeExpression);
    }

    // royalMailCustomer

    /**
     * <p>royalMailCustomer.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.RoyalMailCustomerBarcodeBuilder} object.
     */
    public RoyalMailCustomerBarcodeBuilder royalMailCustomer(String code) {
        return Barcodes.royalMailCustomer(code);
    }

    /**
     * <p>royalMailCustomer.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.RoyalMailCustomerBarcodeBuilder} object.
     */
    public RoyalMailCustomerBarcodeBuilder royalMailCustomer(DRIExpression<String> codeExpression) {
        return Barcodes.royalMailCustomer(codeExpression);
    }

    // postnet

    /**
     * <p>postnet.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.PostnetBarcodeBuilder} object.
     */
    public PostnetBarcodeBuilder postnet(String code) {
        return Barcodes.postnet(code);
    }

    /**
     * <p>postnet.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.PostnetBarcodeBuilder} object.
     */
    public PostnetBarcodeBuilder postnet(DRIExpression<String> codeExpression) {
        return Barcodes.postnet(codeExpression);
    }

    // pdf417

    /**
     * <p>pdf417.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Pdf417BarcodeBuilder} object.
     */
    public Pdf417BarcodeBuilder pdf417(String code) {
        return Barcodes.pdf417(code);
    }

    /**
     * <p>pdf417.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Pdf417BarcodeBuilder} object.
     */
    public Pdf417BarcodeBuilder pdf417(DRIExpression<String> codeExpression) {
        return Barcodes.pdf417(codeExpression);
    }

    // qrCode

    /**
     * <p>qrCode.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.QrCodeBuilder} object.
     */
    public QrCodeBuilder qrCode(String code) {
        return Barcodes.qrCode(code);
    }

    /**
     * <p>qrCode.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.QrCodeBuilder} object.
     */
    public QrCodeBuilder qrCode(DRIExpression<String> codeExpression) {
        return Barcodes.qrCode(codeExpression);
    }

    // barbecue 2of7

    /**
     * <p>barbecue_2of7.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_2of7(String code) {
        return Barcodes.barbecue_2of7(code);
    }

    /**
     * <p>barbecue_2of7.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_2of7(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_2of7(codeExpression);
    }

    // barbecue 3of9

    /**
     * <p>barbecue_3of9.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_3of9(String code) {
        return Barcodes.barbecue_3of9(code);
    }

    /**
     * <p>barbecue_3of9.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_3of9(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_3of9(codeExpression);
    }

    // barbecue bookland

    /**
     * <p>barbecue_bookland.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_bookland(String code) {
        return Barcodes.barbecue_bookland(code);
    }

    /**
     * <p>barbecue_bookland.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_bookland(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_bookland(codeExpression);
    }

    // barbecue codabar

    /**
     * <p>barbecue_codabar.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_codabar(String code) {
        return Barcodes.barbecue_codabar(code);
    }

    /**
     * <p>barbecue_codabar.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_codabar(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_codabar(codeExpression);
    }

    // barbecue code128

    /**
     * <p>barbecue_code128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128(String code) {
        return Barcodes.barbecue_code128(code);
    }

    /**
     * <p>barbecue_code128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_code128(codeExpression);
    }

    // barbecue code128A

    /**
     * <p>barbecue_code128A.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128A(String code) {
        return Barcodes.barbecue_code128A(code);
    }

    /**
     * <p>barbecue_code128A.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128A(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_code128A(codeExpression);
    }

    // barbecue code128B

    /**
     * <p>barbecue_code128B.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128B(String code) {
        return Barcodes.barbecue_code128B(code);
    }

    /**
     * <p>barbecue_code128B.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128B(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_code128B(codeExpression);
    }

    // barbecue code128C

    /**
     * <p>barbecue_code128C.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128C(String code) {
        return Barcodes.barbecue_code128C(code);
    }

    /**
     * <p>barbecue_code128C.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code128C(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_code128C(codeExpression);
    }

    // barbecue code39

    /**
     * <p>barbecue_code39.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code39(String code) {
        return Barcodes.barbecue_code39(code);
    }

    /**
     * <p>barbecue_code39.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code39(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_code39(codeExpression);
    }

    // barbecue code39 extended

    /**
     * <p>barbecue_code39Extended.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code39Extended(String code) {
        return Barcodes.barbecue_code39Extended(code);
    }

    /**
     * <p>barbecue_code39Extended.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_code39Extended(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_code39Extended(codeExpression);
    }

    // barbecue ean128

    /**
     * <p>barbecue_ean128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_ean128(String code) {
        return Barcodes.barbecue_ean128(code);
    }

    /**
     * <p>barbecue_ean128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_ean128(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_ean128(codeExpression);
    }

    // barbecue ean13

    /**
     * <p>barbecue_ean13.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_ean13(String code) {
        return Barcodes.barbecue_ean13(code);
    }

    /**
     * <p>barbecue_ean13.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_ean13(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_ean13(codeExpression);
    }

    // barbecue global trade item number

    /**
     * <p>barbecue_globalTradeItemNumber.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_globalTradeItemNumber(String code) {
        return Barcodes.barbecue_globalTradeItemNumber(code);
    }

    /**
     * <p>barbecue_globalTradeItemNumber.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_globalTradeItemNumber(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_globalTradeItemNumber(codeExpression);
    }

    // barbecue int2of5

    /**
     * <p>barbecue_int2of5.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_int2of5(String code) {
        return Barcodes.barbecue_int2of5(code);
    }

    /**
     * <p>barbecue_int2of5.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_int2of5(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_int2of5(codeExpression);
    }

    // barbecue monarch

    /**
     * <p>barbecue_monarch.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_monarch(String code) {
        return Barcodes.barbecue_monarch(code);
    }

    /**
     * <p>barbecue_monarch.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_monarch(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_monarch(codeExpression);
    }

    // barbecue nw7

    /**
     * <p>barbecue_nw7.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_nw7(String code) {
        return Barcodes.barbecue_nw7(code);
    }

    /**
     * <p>barbecue_nw7.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_nw7(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_nw7(codeExpression);
    }

    // barbecue pdf417

    /**
     * <p>barbecue_pdf417.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_pdf417(String code) {
        return Barcodes.barbecue_pdf417(code);
    }

    /**
     * <p>barbecue_pdf417.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_pdf417(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_pdf417(codeExpression);
    }

    // barbecue postnet

    /**
     * <p>barbecue_postnet.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_postnet(String code) {
        return Barcodes.barbecue_postnet(code);
    }

    /**
     * <p>barbecue_postnet.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_postnet(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_postnet(codeExpression);
    }

    // barbecue random weight upca

    /**
     * <p>barbecue_randomWeightUpca.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_randomWeightUpca(String code) {
        return Barcodes.barbecue_randomWeightUpca(code);
    }

    /**
     * <p>barbecue_randomWeightUpca.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_randomWeightUpca(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_randomWeightUpca(codeExpression);
    }

    // barbecue scc14 shipping code

    /**
     * <p>barbecue_scc14ShippingCode.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_scc14ShippingCode(String code) {
        return Barcodes.barbecue_scc14ShippingCode(code);
    }

    /**
     * <p>barbecue_scc14ShippingCode.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_scc14ShippingCode(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_scc14ShippingCode(codeExpression);
    }

    // barbecue shipment identification number

    /**
     * <p>barbecue_shipmentIdentificationNumber.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_shipmentIdentificationNumber(String code) {
        return Barcodes.barbecue_shipmentIdentificationNumber(code);
    }

    /**
     * <p>barbecue_shipmentIdentificationNumber.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_shipmentIdentificationNumber(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_shipmentIdentificationNumber(codeExpression);
    }

    // barbecue sscc18

    /**
     * <p>barbecue_sscc18.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_sscc18(String code) {
        return Barcodes.barbecue_sscc18(code);
    }

    /**
     * <p>barbecue_sscc18.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_sscc18(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_sscc18(codeExpression);
    }

    // barbecue std 2of5

    /**
     * <p>barbecue_std2of5.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_std2of5(String code) {
        return Barcodes.barbecue_std2of5(code);
    }

    /**
     * <p>barbecue_std2of5.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_std2of5(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_std2of5(codeExpression);
    }

    // barbecue ucc128

    /**
     * <p>barbecue_ucc128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_ucc128(String code) {
        return Barcodes.barbecue_ucc128(code);
    }

    /**
     * <p>barbecue_ucc128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_ucc128(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_ucc128(codeExpression);
    }

    // barbecue upca

    /**
     * <p>barbecue_upca.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_upca(String code) {
        return Barcodes.barbecue_upca(code);
    }

    /**
     * <p>barbecue_upca.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_upca(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_upca(codeExpression);
    }

    // barbecue usd3

    /**
     * <p>barbecue_usd3.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_usd3(String code) {
        return Barcodes.barbecue_usd3(code);
    }

    /**
     * <p>barbecue_usd3.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_usd3(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_usd3(codeExpression);
    }

    // barbecue usd4

    /**
     * <p>barbecue_usd4.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_usd4(String code) {
        return Barcodes.barbecue_usd4(code);
    }

    /**
     * <p>barbecue_usd4.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_usd4(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_usd4(codeExpression);
    }

    // barbecue usps

    /**
     * <p>barbecue_usps.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_usps(String code) {
        return Barcodes.barbecue_usps(code);
    }

    /**
     * <p>barbecue_usps.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder barbecue_usps(DRIExpression<String> codeExpression) {
        return Barcodes.barbecue_usps(codeExpression);
    }
}
