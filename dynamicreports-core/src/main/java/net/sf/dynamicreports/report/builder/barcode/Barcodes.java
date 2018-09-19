/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.builder.barcode;

import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating barcodes
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Barcodes {

    // codabar

    /**
     * <p>codabar.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.CodabarBarcodeBuilder} object.
     */
    public static CodabarBarcodeBuilder codabar(String code) {
        return new CodabarBarcodeBuilder(code);
    }

    /**
     * <p>codabar.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.CodabarBarcodeBuilder} object.
     */
    public static CodabarBarcodeBuilder codabar(DRIExpression<String> codeExpression) {
        return new CodabarBarcodeBuilder(codeExpression);
    }

    // code128

    /**
     * <p>code128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code128BarcodeBuilder} object.
     */
    public static Code128BarcodeBuilder code128(String code) {
        return new Code128BarcodeBuilder(code);
    }

    /**
     * <p>code128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code128BarcodeBuilder} object.
     */
    public static Code128BarcodeBuilder code128(DRIExpression<String> codeExpression) {
        return new Code128BarcodeBuilder(codeExpression);
    }

    // ean128

    /**
     * <p>ean128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean128BarcodeBuilder} object.
     */
    public static Ean128BarcodeBuilder ean128(String code) {
        return new Ean128BarcodeBuilder(code);
    }

    /**
     * <p>ean128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean128BarcodeBuilder} object.
     */
    public static Ean128BarcodeBuilder ean128(DRIExpression<String> codeExpression) {
        return new Ean128BarcodeBuilder(codeExpression);
    }

    // dataMatrix

    /**
     * <p>dataMatrix.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.DataMatrixBarcodeBuilder} object.
     */
    public static DataMatrixBarcodeBuilder dataMatrix(String code) {
        return new DataMatrixBarcodeBuilder(code);
    }

    /**
     * <p>dataMatrix.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.DataMatrixBarcodeBuilder} object.
     */
    public static DataMatrixBarcodeBuilder dataMatrix(DRIExpression<String> codeExpression) {
        return new DataMatrixBarcodeBuilder(codeExpression);
    }

    // code39

    /**
     * <p>code39.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public static Code39BarcodeBuilder code39(String code) {
        return new Code39BarcodeBuilder(code);
    }

    /**
     * <p>code39.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public static Code39BarcodeBuilder code39(DRIExpression<String> codeExpression) {
        return new Code39BarcodeBuilder(codeExpression);
    }

    // interleaved2Of5

    /**
     * <p>interleaved2Of5.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Interleaved2Of5BarcodeBuilder} object.
     */
    public static Interleaved2Of5BarcodeBuilder interleaved2Of5(String code) {
        return new Interleaved2Of5BarcodeBuilder(code);
    }

    /**
     * <p>interleaved2Of5.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Interleaved2Of5BarcodeBuilder} object.
     */
    public static Interleaved2Of5BarcodeBuilder interleaved2Of5(DRIExpression<String> codeExpression) {
        return new Interleaved2Of5BarcodeBuilder(codeExpression);
    }

    // upca

    /**
     * <p>upca.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpcaBarcodeBuilder} object.
     */
    public static UpcaBarcodeBuilder upca(String code) {
        return new UpcaBarcodeBuilder(code);
    }

    /**
     * <p>upca.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpcaBarcodeBuilder} object.
     */
    public static UpcaBarcodeBuilder upca(DRIExpression<String> codeExpression) {
        return new UpcaBarcodeBuilder(codeExpression);
    }

    // upce

    /**
     * <p>upce.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpceBarcodeBuilder} object.
     */
    public static UpceBarcodeBuilder upce(String code) {
        return new UpceBarcodeBuilder(code);
    }

    /**
     * <p>upce.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UpceBarcodeBuilder} object.
     */
    public static UpceBarcodeBuilder upce(DRIExpression<String> codeExpression) {
        return new UpceBarcodeBuilder(codeExpression);
    }

    // ean13

    /**
     * <p>ean13.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean13BarcodeBuilder} object.
     */
    public static Ean13BarcodeBuilder ean13(String code) {
        return new Ean13BarcodeBuilder(code);
    }

    /**
     * <p>ean13.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean13BarcodeBuilder} object.
     */
    public static Ean13BarcodeBuilder ean13(DRIExpression<String> codeExpression) {
        return new Ean13BarcodeBuilder(codeExpression);
    }

    // ean8

    /**
     * <p>ean8.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean8BarcodeBuilder} object.
     */
    public static Ean8BarcodeBuilder ean8(String code) {
        return new Ean8BarcodeBuilder(code);
    }

    /**
     * <p>ean8.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Ean8BarcodeBuilder} object.
     */
    public static Ean8BarcodeBuilder ean8(DRIExpression<String> codeExpression) {
        return new Ean8BarcodeBuilder(codeExpression);
    }

    // uspsIntelligentMail

    /**
     * <p>uspsIntelligentMail.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UspsIntelligentMailBarcodeBuilder} object.
     */
    public static UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(String code) {
        return new UspsIntelligentMailBarcodeBuilder(code);
    }

    /**
     * <p>uspsIntelligentMail.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.UspsIntelligentMailBarcodeBuilder} object.
     */
    public static UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(DRIExpression<String> codeExpression) {
        return new UspsIntelligentMailBarcodeBuilder(codeExpression);
    }

    // royalMailCustomer

    /**
     * <p>royalMailCustomer.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.RoyalMailCustomerBarcodeBuilder} object.
     */
    public static RoyalMailCustomerBarcodeBuilder royalMailCustomer(String code) {
        return new RoyalMailCustomerBarcodeBuilder(code);
    }

    /**
     * <p>royalMailCustomer.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.RoyalMailCustomerBarcodeBuilder} object.
     */
    public static RoyalMailCustomerBarcodeBuilder royalMailCustomer(DRIExpression<String> codeExpression) {
        return new RoyalMailCustomerBarcodeBuilder(codeExpression);
    }

    // postnet

    /**
     * <p>postnet.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.PostnetBarcodeBuilder} object.
     */
    public static PostnetBarcodeBuilder postnet(String code) {
        return new PostnetBarcodeBuilder(code);
    }

    /**
     * <p>postnet.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.PostnetBarcodeBuilder} object.
     */
    public static PostnetBarcodeBuilder postnet(DRIExpression<String> codeExpression) {
        return new PostnetBarcodeBuilder(codeExpression);
    }

    // pdf417

    /**
     * <p>pdf417.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Pdf417BarcodeBuilder} object.
     */
    public static Pdf417BarcodeBuilder pdf417(String code) {
        return new Pdf417BarcodeBuilder(code);
    }

    /**
     * <p>pdf417.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Pdf417BarcodeBuilder} object.
     */
    public static Pdf417BarcodeBuilder pdf417(DRIExpression<String> codeExpression) {
        return new Pdf417BarcodeBuilder(codeExpression);
    }

    // qrCode

    /**
     * <p>qrCode.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.QrCodeBuilder} object.
     */
    public static QrCodeBuilder qrCode(String code) {
        return new QrCodeBuilder(code);
    }

    /**
     * <p>qrCode.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.QrCodeBuilder} object.
     */
    public static QrCodeBuilder qrCode(DRIExpression<String> codeExpression) {
        return new QrCodeBuilder(codeExpression);
    }

    // barbecue 2of7

    /**
     * <p>barbecue_2of7.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_2of7(String code) {
        return new BarbecueBuilder(BarbecueType.BARCODE_2OF7, code);
    }

    /**
     * <p>barbecue_2of7.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_2of7(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.BARCODE_2OF7, codeExpression);
    }

    // barbecue 3of9

    /**
     * <p>barbecue_3of9.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_3of9(String code) {
        return new BarbecueBuilder(BarbecueType.BARCODE_3OF9, code);
    }

    /**
     * <p>barbecue_3of9.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_3of9(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.BARCODE_3OF9, codeExpression);
    }

    // barbecue bookland

    /**
     * <p>barbecue_bookland.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_bookland(String code) {
        return new BarbecueBuilder(BarbecueType.BOOKLAND, code);
    }

    /**
     * <p>barbecue_bookland.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_bookland(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.BOOKLAND, codeExpression);
    }

    // barbecue codabar

    /**
     * <p>barbecue_codabar.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_codabar(String code) {
        return new BarbecueBuilder(BarbecueType.CODABAR, code);
    }

    /**
     * <p>barbecue_codabar.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_codabar(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.CODABAR, codeExpression);
    }

    // barbecue code128

    /**
     * <p>barbecue_code128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128(String code) {
        return new BarbecueBuilder(BarbecueType.CODE128, code);
    }

    /**
     * <p>barbecue_code128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.CODE128, codeExpression);
    }

    // barbecue code128A

    /**
     * <p>barbecue_code128A.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128A(String code) {
        return new BarbecueBuilder(BarbecueType.CODE128A, code);
    }

    /**
     * <p>barbecue_code128A.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128A(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.CODE128A, codeExpression);
    }

    // barbecue code128B

    /**
     * <p>barbecue_code128B.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128B(String code) {
        return new BarbecueBuilder(BarbecueType.CODE128B, code);
    }

    /**
     * <p>barbecue_code128B.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128B(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.CODE128B, codeExpression);
    }

    // barbecue code128C

    /**
     * <p>barbecue_code128C.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128C(String code) {
        return new BarbecueBuilder(BarbecueType.CODE128C, code);
    }

    /**
     * <p>barbecue_code128C.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code128C(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.CODE128C, codeExpression);
    }

    // barbecue code39

    /**
     * <p>barbecue_code39.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code39(String code) {
        return new BarbecueBuilder(BarbecueType.CODE39, code);
    }

    /**
     * <p>barbecue_code39.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code39(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.CODE39, codeExpression);
    }

    // barbecue code39 extended

    /**
     * <p>barbecue_code39Extended.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code39Extended(String code) {
        return new BarbecueBuilder(BarbecueType.CODE39_EXTENDED, code);
    }

    /**
     * <p>barbecue_code39Extended.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_code39Extended(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.CODE39_EXTENDED, codeExpression);
    }

    // barbecue ean128

    /**
     * <p>barbecue_ean128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_ean128(String code) {
        return new BarbecueBuilder(BarbecueType.EAN128, code);
    }

    /**
     * <p>barbecue_ean128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_ean128(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.EAN128, codeExpression);
    }

    // barbecue ean13

    /**
     * <p>barbecue_ean13.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_ean13(String code) {
        return new BarbecueBuilder(BarbecueType.EAN13, code);
    }

    /**
     * <p>barbecue_ean13.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_ean13(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.EAN13, codeExpression);
    }

    // barbecue global trade item number

    /**
     * <p>barbecue_globalTradeItemNumber.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_globalTradeItemNumber(String code) {
        return new BarbecueBuilder(BarbecueType.GLOBAL_TRADE_ITEM_NUMBER, code);
    }

    /**
     * <p>barbecue_globalTradeItemNumber.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_globalTradeItemNumber(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.GLOBAL_TRADE_ITEM_NUMBER, codeExpression);
    }

    // barbecue int2of5

    /**
     * <p>barbecue_int2of5.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_int2of5(String code) {
        return new BarbecueBuilder(BarbecueType.INT_2OF5, code);
    }

    /**
     * <p>barbecue_int2of5.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_int2of5(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.INT_2OF5, codeExpression);
    }

    // barbecue monarch

    /**
     * <p>barbecue_monarch.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_monarch(String code) {
        return new BarbecueBuilder(BarbecueType.MONARCH, code);
    }

    /**
     * <p>barbecue_monarch.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_monarch(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.MONARCH, codeExpression);
    }

    // barbecue nw7

    /**
     * <p>barbecue_nw7.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_nw7(String code) {
        return new BarbecueBuilder(BarbecueType.NW7, code);
    }

    /**
     * <p>barbecue_nw7.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_nw7(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.NW7, codeExpression);
    }

    // barbecue pdf417

    /**
     * <p>barbecue_pdf417.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_pdf417(String code) {
        return new BarbecueBuilder(BarbecueType.PDF417, code);
    }

    /**
     * <p>barbecue_pdf417.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_pdf417(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.PDF417, codeExpression);
    }

    // barbecue postnet

    /**
     * <p>barbecue_postnet.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_postnet(String code) {
        return new BarbecueBuilder(BarbecueType.POSTNET, code);
    }

    /**
     * <p>barbecue_postnet.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_postnet(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.POSTNET, codeExpression);
    }

    // barbecue random weight upca

    /**
     * <p>barbecue_randomWeightUpca.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_randomWeightUpca(String code) {
        return new BarbecueBuilder(BarbecueType.RANDOM_WEIGHT_UPCA, code);
    }

    /**
     * <p>barbecue_randomWeightUpca.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_randomWeightUpca(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.RANDOM_WEIGHT_UPCA, codeExpression);
    }

    // barbecue scc14 shipping code

    /**
     * <p>barbecue_scc14ShippingCode.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_scc14ShippingCode(String code) {
        return new BarbecueBuilder(BarbecueType.SCC14_SHIPPING_CODE, code);
    }

    /**
     * <p>barbecue_scc14ShippingCode.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_scc14ShippingCode(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.SCC14_SHIPPING_CODE, codeExpression);
    }

    // barbecue shipment identification number

    /**
     * <p>barbecue_shipmentIdentificationNumber.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_shipmentIdentificationNumber(String code) {
        return new BarbecueBuilder(BarbecueType.SHIPMENT_IDENTIFICATION_NUMBER, code);
    }

    /**
     * <p>barbecue_shipmentIdentificationNumber.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_shipmentIdentificationNumber(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.SHIPMENT_IDENTIFICATION_NUMBER, codeExpression);
    }

    // barbecue sscc18

    /**
     * <p>barbecue_sscc18.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_sscc18(String code) {
        return new BarbecueBuilder(BarbecueType.SSCC18, code);
    }

    /**
     * <p>barbecue_sscc18.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_sscc18(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.SSCC18, codeExpression);
    }

    // barbecue std 2of5

    /**
     * <p>barbecue_std2of5.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_std2of5(String code) {
        return new BarbecueBuilder(BarbecueType.STD_2OF5, code);
    }

    /**
     * <p>barbecue_std2of5.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_std2of5(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.STD_2OF5, codeExpression);
    }

    // barbecue ucc128

    /**
     * <p>barbecue_ucc128.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_ucc128(String code) {
        return new BarbecueBuilder(BarbecueType.UCC128, code);
    }

    /**
     * <p>barbecue_ucc128.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_ucc128(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.UCC128, codeExpression);
    }

    // barbecue upca

    /**
     * <p>barbecue_upca.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_upca(String code) {
        return new BarbecueBuilder(BarbecueType.UPCA, code);
    }

    /**
     * <p>barbecue_upca.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_upca(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.UPCA, codeExpression);
    }

    // barbecue usd3

    /**
     * <p>barbecue_usd3.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_usd3(String code) {
        return new BarbecueBuilder(BarbecueType.USD3, code);
    }

    /**
     * <p>barbecue_usd3.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_usd3(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.USD3, codeExpression);
    }

    // barbecue usd4

    /**
     * <p>barbecue_usd4.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_usd4(String code) {
        return new BarbecueBuilder(BarbecueType.USD4, code);
    }

    /**
     * <p>barbecue_usd4.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_usd4(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.USD4, codeExpression);
    }

    // barbecue usps

    /**
     * <p>barbecue_usps.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_usps(String code) {
        return new BarbecueBuilder(BarbecueType.USPS, code);
    }

    /**
     * <p>barbecue_usps.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public static BarbecueBuilder barbecue_usps(DRIExpression<String> codeExpression) {
        return new BarbecueBuilder(BarbecueType.USPS, codeExpression);
    }
}
