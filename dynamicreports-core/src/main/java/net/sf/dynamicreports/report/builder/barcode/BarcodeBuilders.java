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

import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating barcodes
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BarcodeBuilders {

	// codabar
	public CodabarBarcodeBuilder codabar(String code) {
		return Barcodes.codabar(code);
	}

	public CodabarBarcodeBuilder codabar(DRIExpression<String> codeExpression) {
		return Barcodes.codabar(codeExpression);
	}

	// code128
	public Code128BarcodeBuilder code128(String code) {
		return Barcodes.code128(code);
	}

	public Code128BarcodeBuilder code128(DRIExpression<String> codeExpression) {
		return Barcodes.code128(codeExpression);
	}

	// ean128
	public Ean128BarcodeBuilder ean128(String code) {
		return Barcodes.ean128(code);
	}

	public Ean128BarcodeBuilder ean128(DRIExpression<String> codeExpression) {
		return Barcodes.ean128(codeExpression);
	}

	// dataMatrix
	public DataMatrixBarcodeBuilder dataMatrix(String code) {
		return Barcodes.dataMatrix(code);
	}

	public DataMatrixBarcodeBuilder dataMatrix(DRIExpression<String> codeExpression) {
		return Barcodes.dataMatrix(codeExpression);
	}

	// code39
	public Code39BarcodeBuilder code39(String code) {
		return Barcodes.code39(code);
	}

	public Code39BarcodeBuilder code39(DRIExpression<String> codeExpression) {
		return Barcodes.code39(codeExpression);
	}

	// interleaved2Of5
	public Interleaved2Of5BarcodeBuilder interleaved2Of5(String code) {
		return Barcodes.interleaved2Of5(code);
	}

	public Interleaved2Of5BarcodeBuilder interleaved2Of5(DRIExpression<String> codeExpression) {
		return Barcodes.interleaved2Of5(codeExpression);
	}

	// upca
	public UpcaBarcodeBuilder upca(String code) {
		return Barcodes.upca(code);
	}

	public UpcaBarcodeBuilder upca(DRIExpression<String> codeExpression) {
		return Barcodes.upca(codeExpression);
	}

	// upce
	public UpceBarcodeBuilder upce(String code) {
		return Barcodes.upce(code);
	}

	public UpceBarcodeBuilder upce(DRIExpression<String> codeExpression) {
		return Barcodes.upce(codeExpression);
	}

	// ean13
	public Ean13BarcodeBuilder ean13(String code) {
		return Barcodes.ean13(code);
	}

	public Ean13BarcodeBuilder ean13(DRIExpression<String> codeExpression) {
		return Barcodes.ean13(codeExpression);
	}

	// ean8
	public Ean8BarcodeBuilder ean8(String code) {
		return Barcodes.ean8(code);
	}

	public Ean8BarcodeBuilder ean8(DRIExpression<String> codeExpression) {
		return Barcodes.ean8(codeExpression);
	}

	// uspsIntelligentMail
	public UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(String code) {
		return Barcodes.uspsIntelligentMail(code);
	}

	public UspsIntelligentMailBarcodeBuilder uspsIntelligentMail(DRIExpression<String> codeExpression) {
		return Barcodes.uspsIntelligentMail(codeExpression);
	}

	// royalMailCustomer
	public RoyalMailCustomerBarcodeBuilder royalMailCustomer(String code) {
		return Barcodes.royalMailCustomer(code);
	}

	public RoyalMailCustomerBarcodeBuilder royalMailCustomer(DRIExpression<String> codeExpression) {
		return Barcodes.royalMailCustomer(codeExpression);
	}

	// postnet
	public PostnetBarcodeBuilder postnet(String code) {
		return Barcodes.postnet(code);
	}

	public PostnetBarcodeBuilder postnet(DRIExpression<String> codeExpression) {
		return Barcodes.postnet(codeExpression);
	}

	// pdf417
	public Pdf417BarcodeBuilder pdf417(String code) {
		return Barcodes.pdf417(code);
	}

	public Pdf417BarcodeBuilder pdf417(DRIExpression<String> codeExpression) {
		return Barcodes.pdf417(codeExpression);
	}

	// qrCode
	public QrCodeBuilder qrCode(String code) {
		return Barcodes.qrCode(code);
	}

	public QrCodeBuilder qrCode(DRIExpression<String> codeExpression) {
		return Barcodes.qrCode(codeExpression);
	}

	// barbecue 2of7
	public BarbecueBuilder barbecue_2of7(String code) {
		return Barcodes.barbecue_2of7(code);
	}

	public BarbecueBuilder barbecue_2of7(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_2of7(codeExpression);
	}

	// barbecue 3of9
	public BarbecueBuilder barbecue_3of9(String code) {
		return Barcodes.barbecue_3of9(code);
	}

	public BarbecueBuilder barbecue_3of9(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_3of9(codeExpression);
	}

	// barbecue bookland
	public BarbecueBuilder barbecue_bookland(String code) {
		return Barcodes.barbecue_bookland(code);
	}

	public BarbecueBuilder barbecue_bookland(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_bookland(codeExpression);
	}

	// barbecue codabar
	public BarbecueBuilder barbecue_codabar(String code) {
		return Barcodes.barbecue_codabar(code);
	}

	public BarbecueBuilder barbecue_codabar(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_codabar(codeExpression);
	}

	// barbecue code128
	public BarbecueBuilder barbecue_code128(String code) {
		return Barcodes.barbecue_code128(code);
	}

	public BarbecueBuilder barbecue_code128(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_code128(codeExpression);
	}

	// barbecue code128A
	public BarbecueBuilder barbecue_code128A(String code) {
		return Barcodes.barbecue_code128A(code);
	}

	public BarbecueBuilder barbecue_code128A(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_code128A(codeExpression);
	}

	// barbecue code128B
	public BarbecueBuilder barbecue_code128B(String code) {
		return Barcodes.barbecue_code128B(code);
	}

	public BarbecueBuilder barbecue_code128B(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_code128B(codeExpression);
	}

	// barbecue code128C
	public BarbecueBuilder barbecue_code128C(String code) {
		return Barcodes.barbecue_code128C(code);
	}

	public BarbecueBuilder barbecue_code128C(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_code128C(codeExpression);
	}

	// barbecue code39
	public BarbecueBuilder barbecue_code39(String code) {
		return Barcodes.barbecue_code39(code);
	}

	public BarbecueBuilder barbecue_code39(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_code39(codeExpression);
	}

	// barbecue code39 extended
	public BarbecueBuilder barbecue_code39Extended(String code) {
		return Barcodes.barbecue_code39Extended(code);
	}

	public BarbecueBuilder barbecue_code39Extended(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_code39Extended(codeExpression);
	}

	// barbecue ean128
	public BarbecueBuilder barbecue_ean128(String code) {
		return Barcodes.barbecue_ean128(code);
	}

	public BarbecueBuilder barbecue_ean128(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_ean128(codeExpression);
	}

	// barbecue ean13
	public BarbecueBuilder barbecue_ean13(String code) {
		return Barcodes.barbecue_ean13(code);
	}

	public BarbecueBuilder barbecue_ean13(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_ean13(codeExpression);
	}

	// barbecue global trade item number
	public BarbecueBuilder barbecue_globalTradeItemNumber(String code) {
		return Barcodes.barbecue_globalTradeItemNumber(code);
	}

	public BarbecueBuilder barbecue_globalTradeItemNumber(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_globalTradeItemNumber(codeExpression);
	}

	// barbecue int2of5
	public BarbecueBuilder barbecue_int2of5(String code) {
		return Barcodes.barbecue_int2of5(code);
	}

	public BarbecueBuilder barbecue_int2of5(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_int2of5(codeExpression);
	}

	// barbecue monarch
	public BarbecueBuilder barbecue_monarch(String code) {
		return Barcodes.barbecue_monarch(code);
	}

	public BarbecueBuilder barbecue_monarch(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_monarch(codeExpression);
	}

	// barbecue nw7
	public BarbecueBuilder barbecue_nw7(String code) {
		return Barcodes.barbecue_nw7(code);
	}

	public BarbecueBuilder barbecue_nw7(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_nw7(codeExpression);
	}

	// barbecue pdf417
	public BarbecueBuilder barbecue_pdf417(String code) {
		return Barcodes.barbecue_pdf417(code);
	}

	public BarbecueBuilder barbecue_pdf417(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_pdf417(codeExpression);
	}

	// barbecue postnet
	public BarbecueBuilder barbecue_postnet(String code) {
		return Barcodes.barbecue_postnet(code);
	}

	public BarbecueBuilder barbecue_postnet(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_postnet(codeExpression);
	}

	// barbecue random weight upca
	public BarbecueBuilder barbecue_randomWeightUpca(String code) {
		return Barcodes.barbecue_randomWeightUpca(code);
	}

	public BarbecueBuilder barbecue_randomWeightUpca(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_randomWeightUpca(codeExpression);
	}

	// barbecue scc14 shipping code
	public BarbecueBuilder barbecue_scc14ShippingCode(String code) {
		return Barcodes.barbecue_scc14ShippingCode(code);
	}

	public BarbecueBuilder barbecue_scc14ShippingCode(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_scc14ShippingCode(codeExpression);
	}

	// barbecue shipment identification number
	public BarbecueBuilder barbecue_shipmentIdentificationNumber(String code) {
		return Barcodes.barbecue_shipmentIdentificationNumber(code);
	}

	public BarbecueBuilder barbecue_shipmentIdentificationNumber(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_shipmentIdentificationNumber(codeExpression);
	}

	// barbecue sscc18
	public BarbecueBuilder barbecue_sscc18(String code) {
		return Barcodes.barbecue_sscc18(code);
	}

	public BarbecueBuilder barbecue_sscc18(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_sscc18(codeExpression);
	}

	// barbecue std 2of5
	public BarbecueBuilder barbecue_std2of5(String code) {
		return Barcodes.barbecue_std2of5(code);
	}

	public BarbecueBuilder barbecue_std2of5(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_std2of5(codeExpression);
	}

	// barbecue ucc128
	public BarbecueBuilder barbecue_ucc128(String code) {
		return Barcodes.barbecue_ucc128(code);
	}

	public BarbecueBuilder barbecue_ucc128(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_ucc128(codeExpression);
	}

	// barbecue upca
	public BarbecueBuilder barbecue_upca(String code) {
		return Barcodes.barbecue_upca(code);
	}

	public BarbecueBuilder barbecue_upca(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_upca(codeExpression);
	}

	// barbecue usd3
	public BarbecueBuilder barbecue_usd3(String code) {
		return Barcodes.barbecue_usd3(code);
	}

	public BarbecueBuilder barbecue_usd3(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_usd3(codeExpression);
	}

	// barbecue usd4
	public BarbecueBuilder barbecue_usd4(String code) {
		return Barcodes.barbecue_usd4(code);
	}

	public BarbecueBuilder barbecue_usd4(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_usd4(codeExpression);
	}

	// barbecue usps
	public BarbecueBuilder barbecue_usps(String code) {
		return Barcodes.barbecue_usps(code);
	}

	public BarbecueBuilder barbecue_usps(DRIExpression<String> codeExpression) {
		return Barcodes.barbecue_usps(codeExpression);
	}
}
