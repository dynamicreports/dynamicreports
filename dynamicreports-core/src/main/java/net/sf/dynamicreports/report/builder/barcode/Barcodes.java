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

package net.sf.dynamicreports.report.builder.barcode;

import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating barcodes
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Barcodes {

	// codabar
	public static CodabarBarcodeBuilder codabar(String code) {
		return new CodabarBarcodeBuilder(code);
	}

	public static CodabarBarcodeBuilder codabar(DRIExpression<String> codeExpression) {
		return new CodabarBarcodeBuilder(codeExpression);
	}

	// code128
	public static Code128BarcodeBuilder code128(String code) {
		return new Code128BarcodeBuilder(code);
	}

	public static Code128BarcodeBuilder code128(DRIExpression<String> codeExpression) {
		return new Code128BarcodeBuilder(codeExpression);
	}

	// ean128
	public static Ean128BarcodeBuilder ean128(String code) {
		return new Ean128BarcodeBuilder(code);
	}

	public static Ean128BarcodeBuilder ean128(DRIExpression<String> codeExpression) {
		return new Ean128BarcodeBuilder(codeExpression);
	}

	// dataMatrix
	public static DataMatrixBarcodeBuilder dataMatrix(String code) {
		return new DataMatrixBarcodeBuilder(code);
	}

	public static DataMatrixBarcodeBuilder dataMatrix(DRIExpression<String> codeExpression) {
		return new DataMatrixBarcodeBuilder(codeExpression);
	}

	// code39
	public static Code39BarcodeBuilder code39(String code) {
		return new Code39BarcodeBuilder(code);
	}

	public static Code39BarcodeBuilder code39(DRIExpression<String> codeExpression) {
		return new Code39BarcodeBuilder(codeExpression);
	}

	// interleaved2Of5
	public static Interleaved2Of5BarcodeBuilder interleaved2Of5(String code) {
		return new Interleaved2Of5BarcodeBuilder(code);
	}

	public static Interleaved2Of5BarcodeBuilder interleaved2Of5(DRIExpression<String> codeExpression) {
		return new Interleaved2Of5BarcodeBuilder(codeExpression);
	}

	// upca
	public static UpcaBarcodeBuilder upca(String code) {
		return new UpcaBarcodeBuilder(code);
	}

	public static UpcaBarcodeBuilder upca(DRIExpression<String> codeExpression) {
		return new UpcaBarcodeBuilder(codeExpression);
	}

	// upce
	public static UpceBarcodeBuilder upce(String code) {
		return new UpceBarcodeBuilder(code);
	}

	public static UpceBarcodeBuilder upce(DRIExpression<String> codeExpression) {
		return new UpceBarcodeBuilder(codeExpression);
	}

	// ean13
	public static Ean13BarcodeBuilder ean13(String code) {
		return new Ean13BarcodeBuilder(code);
	}

	public static Ean13BarcodeBuilder ean13(DRIExpression<String> codeExpression) {
		return new Ean13BarcodeBuilder(codeExpression);
	}

	// ean8
	public static Ean8BarcodeBuilder ean8(String code) {
		return new Ean8BarcodeBuilder(code);
	}

	public static Ean8BarcodeBuilder ean8(DRIExpression<String> codeExpression) {
		return new Ean8BarcodeBuilder(codeExpression);
	}

	// uspsIntelligentMail
	public static UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(String code) {
		return new UspsIntelligentMailBarcodeBuilder(code);
	}

	public static UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(DRIExpression<String> codeExpression) {
		return new UspsIntelligentMailBarcodeBuilder(codeExpression);
	}

	// royalMailCustomer
	public static RoyalMailCustomerBarcodeBuilder royalMailCustomer(String code) {
		return new RoyalMailCustomerBarcodeBuilder(code);
	}

	public static RoyalMailCustomerBarcodeBuilder royalMailCustomer(DRIExpression<String> codeExpression) {
		return new RoyalMailCustomerBarcodeBuilder(codeExpression);
	}

	// postnet
	public static PostnetBarcodeBuilder postnet(String code) {
		return new PostnetBarcodeBuilder(code);
	}

	public static PostnetBarcodeBuilder postnet(DRIExpression<String> codeExpression) {
		return new PostnetBarcodeBuilder(codeExpression);
	}

	// pdf417
	public static Pdf417BarcodeBuilder pdf417(String code) {
		return new Pdf417BarcodeBuilder(code);
	}

	public static Pdf417BarcodeBuilder pdf417(DRIExpression<String> codeExpression) {
		return new Pdf417BarcodeBuilder(codeExpression);
	}

	// qrCode
	public static QrCodeBuilder qrCode(String code) {
		return new QrCodeBuilder(code);
	}

	public static QrCodeBuilder qrCode(DRIExpression<String> codeExpression) {
		return new QrCodeBuilder(codeExpression);
	}

	// barbecue 2of7
	public static BarbecueBuilder barbecue_2of7(String code) {
		return new BarbecueBuilder(BarbecueType.BARCODE_2OF7, code);
	}

	public static BarbecueBuilder barbecue_2of7(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.BARCODE_2OF7, codeExpression);
	}

	// barbecue 3of9
	public static BarbecueBuilder barbecue_3of9(String code) {
		return new BarbecueBuilder(BarbecueType.BARCODE_3OF9, code);
	}

	public static BarbecueBuilder barbecue_3of9(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.BARCODE_3OF9, codeExpression);
	}

	// barbecue bookland
	public static BarbecueBuilder barbecue_bookland(String code) {
		return new BarbecueBuilder(BarbecueType.BOOKLAND, code);
	}

	public static BarbecueBuilder barbecue_bookland(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.BOOKLAND, codeExpression);
	}

	// barbecue codabar
	public static BarbecueBuilder barbecue_codabar(String code) {
		return new BarbecueBuilder(BarbecueType.CODABAR, code);
	}

	public static BarbecueBuilder barbecue_codabar(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.CODABAR, codeExpression);
	}

	// barbecue code128
	public static BarbecueBuilder barbecue_code128(String code) {
		return new BarbecueBuilder(BarbecueType.CODE128, code);
	}

	public static BarbecueBuilder barbecue_code128(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.CODE128, codeExpression);
	}

	// barbecue code128A
	public static BarbecueBuilder barbecue_code128A(String code) {
		return new BarbecueBuilder(BarbecueType.CODE128A, code);
	}

	public static BarbecueBuilder barbecue_code128A(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.CODE128A, codeExpression);
	}

	// barbecue code128B
	public static BarbecueBuilder barbecue_code128B(String code) {
		return new BarbecueBuilder(BarbecueType.CODE128B, code);
	}

	public static BarbecueBuilder barbecue_code128B(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.CODE128B, codeExpression);
	}

	// barbecue code128C
	public static BarbecueBuilder barbecue_code128C(String code) {
		return new BarbecueBuilder(BarbecueType.CODE128C, code);
	}

	public static BarbecueBuilder barbecue_code128C(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.CODE128C, codeExpression);
	}

	// barbecue code39
	public static BarbecueBuilder barbecue_code39(String code) {
		return new BarbecueBuilder(BarbecueType.CODE39, code);
	}

	public static BarbecueBuilder barbecue_code39(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.CODE39, codeExpression);
	}

	// barbecue code39 extended
	public static BarbecueBuilder barbecue_code39Extended(String code) {
		return new BarbecueBuilder(BarbecueType.CODE39_EXTENDED, code);
	}

	public static BarbecueBuilder barbecue_code39Extended(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.CODE39_EXTENDED, codeExpression);
	}

	// barbecue ean128
	public static BarbecueBuilder barbecue_ean128(String code) {
		return new BarbecueBuilder(BarbecueType.EAN128, code);
	}

	public static BarbecueBuilder barbecue_ean128(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.EAN128, codeExpression);
	}

	// barbecue ean13
	public static BarbecueBuilder barbecue_ean13(String code) {
		return new BarbecueBuilder(BarbecueType.EAN13, code);
	}

	public static BarbecueBuilder barbecue_ean13(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.EAN13, codeExpression);
	}

	// barbecue global trade item number
	public static BarbecueBuilder barbecue_globalTradeItemNumber(String code) {
		return new BarbecueBuilder(BarbecueType.GLOBAL_TRADE_ITEM_NUMBER, code);
	}

	public static BarbecueBuilder barbecue_globalTradeItemNumber(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.GLOBAL_TRADE_ITEM_NUMBER, codeExpression);
	}

	// barbecue int2of5
	public static BarbecueBuilder barbecue_int2of5(String code) {
		return new BarbecueBuilder(BarbecueType.INT_2OF5, code);
	}

	public static BarbecueBuilder barbecue_int2of5(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.INT_2OF5, codeExpression);
	}

	// barbecue monarch
	public static BarbecueBuilder barbecue_monarch(String code) {
		return new BarbecueBuilder(BarbecueType.MONARCH, code);
	}

	public static BarbecueBuilder barbecue_monarch(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.MONARCH, codeExpression);
	}

	// barbecue nw7
	public static BarbecueBuilder barbecue_nw7(String code) {
		return new BarbecueBuilder(BarbecueType.NW7, code);
	}

	public static BarbecueBuilder barbecue_nw7(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.NW7, codeExpression);
	}

	// barbecue pdf417
	public static BarbecueBuilder barbecue_pdf417(String code) {
		return new BarbecueBuilder(BarbecueType.PDF417, code);
	}

	public static BarbecueBuilder barbecue_pdf417(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.PDF417, codeExpression);
	}

	// barbecue postnet
	public static BarbecueBuilder barbecue_postnet(String code) {
		return new BarbecueBuilder(BarbecueType.POSTNET, code);
	}

	public static BarbecueBuilder barbecue_postnet(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.POSTNET, codeExpression);
	}

	// barbecue random weight upca
	public static BarbecueBuilder barbecue_randomWeightUpca(String code) {
		return new BarbecueBuilder(BarbecueType.RANDOM_WEIGHT_UPCA, code);
	}

	public static BarbecueBuilder barbecue_randomWeightUpca(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.RANDOM_WEIGHT_UPCA, codeExpression);
	}

	// barbecue scc14 shipping code
	public static BarbecueBuilder barbecue_scc14ShippingCode(String code) {
		return new BarbecueBuilder(BarbecueType.SCC14_SHIPPING_CODE, code);
	}

	public static BarbecueBuilder barbecue_scc14ShippingCode(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.SCC14_SHIPPING_CODE, codeExpression);
	}

	// barbecue shipment identification number
	public static BarbecueBuilder barbecue_shipmentIdentificationNumber(String code) {
		return new BarbecueBuilder(BarbecueType.SHIPMENT_IDENTIFICATION_NUMBER, code);
	}

	public static BarbecueBuilder barbecue_shipmentIdentificationNumber(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.SHIPMENT_IDENTIFICATION_NUMBER, codeExpression);
	}

	// barbecue sscc18
	public static BarbecueBuilder barbecue_sscc18(String code) {
		return new BarbecueBuilder(BarbecueType.SSCC18, code);
	}

	public static BarbecueBuilder barbecue_sscc18(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.SSCC18, codeExpression);
	}

	// barbecue std 2of5
	public static BarbecueBuilder barbecue_std2of5(String code) {
		return new BarbecueBuilder(BarbecueType.STD_2OF5, code);
	}

	public static BarbecueBuilder barbecue_std2of5(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.STD_2OF5, codeExpression);
	}

	// barbecue ucc128
	public static BarbecueBuilder barbecue_ucc128(String code) {
		return new BarbecueBuilder(BarbecueType.UCC128, code);
	}

	public static BarbecueBuilder barbecue_ucc128(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.UCC128, codeExpression);
	}

	// barbecue upca
	public static BarbecueBuilder barbecue_upca(String code) {
		return new BarbecueBuilder(BarbecueType.UPCA, code);
	}

	public static BarbecueBuilder barbecue_upca(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.UPCA, codeExpression);
	}

	// barbecue usd3
	public static BarbecueBuilder barbecue_usd3(String code) {
		return new BarbecueBuilder(BarbecueType.USD3, code);
	}

	public static BarbecueBuilder barbecue_usd3(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.USD3, codeExpression);
	}

	// barbecue usd4
	public static BarbecueBuilder barbecue_usd4(String code) {
		return new BarbecueBuilder(BarbecueType.USD4, code);
	}

	public static BarbecueBuilder barbecue_usd4(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.USD4, codeExpression);
	}

	// barbecue usps
	public static BarbecueBuilder barbecue_usps(String code) {
		return new BarbecueBuilder(BarbecueType.USPS, code);
	}

	public static BarbecueBuilder barbecue_usps(DRIExpression<String> codeExpression) {
		return new BarbecueBuilder(BarbecueType.USPS, codeExpression);
	}
}
