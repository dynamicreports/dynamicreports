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

package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.barcode.DRDesignBarbecue;
import net.sf.dynamicreports.design.base.barcode.DRDesignBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignBarcode4j;
import net.sf.dynamicreports.design.base.barcode.DRDesignChecksumBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignCodabarBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignCode128Barcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignCode39Barcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignDataMatrixBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignEan128Barcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignEan13Barcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignEan8Barcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignInterleaved2Of5Barcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignPdf417Barcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignPostnetBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignQrCode;
import net.sf.dynamicreports.design.base.barcode.DRDesignRoyalMailCustomerBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignUpcaBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignUpceBarcode;
import net.sf.dynamicreports.design.base.barcode.DRDesignUspsIntelligentMailBarcode;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.report.definition.barcode.DRIBarbecue;
import net.sf.dynamicreports.report.definition.barcode.DRIBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRIBarcode4j;
import net.sf.dynamicreports.report.definition.barcode.DRIChecksumBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRICodabarBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRICode128Barcode;
import net.sf.dynamicreports.report.definition.barcode.DRICode39Barcode;
import net.sf.dynamicreports.report.definition.barcode.DRIDataMatrixBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRIEan128Barcode;
import net.sf.dynamicreports.report.definition.barcode.DRIEan13Barcode;
import net.sf.dynamicreports.report.definition.barcode.DRIEan8Barcode;
import net.sf.dynamicreports.report.definition.barcode.DRIInterleaved2Of5Barcode;
import net.sf.dynamicreports.report.definition.barcode.DRIPdf417Barcode;
import net.sf.dynamicreports.report.definition.barcode.DRIPostnetBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRIQrCode;
import net.sf.dynamicreports.report.definition.barcode.DRIRoyalMailCustomerBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRIUpcaBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRIUpceBarcode;
import net.sf.dynamicreports.report.definition.barcode.DRIUspsIntelligentMailBarcode;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BarcodeTransform {
	private DesignTransformAccessor accessor;

	public BarcodeTransform(DesignTransformAccessor accessor) {
		this.accessor = accessor;
	}

	protected DRDesignBarcode transform(DRIBarcode barcode) throws DRException {
		if (barcode instanceof DRICodabarBarcode) {
			return codabar((DRICodabarBarcode) barcode);
		} else if (barcode instanceof DRICode128Barcode) {
			return code128((DRICode128Barcode) barcode);
		} else if (barcode instanceof DRIEan128Barcode) {
			return ean128((DRIEan128Barcode) barcode);
		} else if (barcode instanceof DRIDataMatrixBarcode) {
			return dataMatrix((DRIDataMatrixBarcode) barcode);
		} else if (barcode instanceof DRICode39Barcode) {
			return code39((DRICode39Barcode) barcode);
		} else if (barcode instanceof DRIInterleaved2Of5Barcode) {
			return interleaved2Of5((DRIInterleaved2Of5Barcode) barcode);
		} else if (barcode instanceof DRIUpcaBarcode) {
			return upca((DRIUpcaBarcode) barcode);
		} else if (barcode instanceof DRIUpceBarcode) {
			return upce((DRIUpceBarcode) barcode);
		} else if (barcode instanceof DRIEan13Barcode) {
			return ean13((DRIEan13Barcode) barcode);
		} else if (barcode instanceof DRIEan8Barcode) {
			return ean8((DRIEan8Barcode) barcode);
		} else if (barcode instanceof DRIUspsIntelligentMailBarcode) {
			return uspsIntelligentMail((DRIUspsIntelligentMailBarcode) barcode);
		} else if (barcode instanceof DRIRoyalMailCustomerBarcode) {
			return royalMailCustomer((DRIRoyalMailCustomerBarcode) barcode);
		} else if (barcode instanceof DRIPostnetBarcode) {
			return postnet((DRIPostnetBarcode) barcode);
		} else if (barcode instanceof DRIPdf417Barcode) {
			return pdf417((DRIPdf417Barcode) barcode);
		} else if (barcode instanceof DRIQrCode) {
			return qrCode((DRIQrCode) barcode);
		} else {
			throw new DRDesignReportException("Barcode " + barcode.getClass().getName() + " not supported");
		}
	}

	protected DRDesignBarbecue transform(DRIBarbecue barbecue) throws DRException {
		DRDesignBarbecue designBarbecue = new DRDesignBarbecue();
		designBarbecue.setWidth(accessor.getTemplateTransform().getBarbecueWidth(barbecue));
		designBarbecue.setHeight(accessor.getTemplateTransform().getBarbecueHeight(barbecue));
		designBarbecue.setType(barbecue.getType());
		designBarbecue.setCodeExpression(accessor.getExpressionTransform().transformExpression(barbecue.getCodeExpression()));
		designBarbecue.setApplicationIdentifierExpression(accessor.getExpressionTransform().transformExpression(barbecue.getApplicationIdentifierExpression()));
		designBarbecue.setDrawText(barbecue.getDrawText());
		designBarbecue.setChecksumRequired(barbecue.getChecksumRequired());
		designBarbecue.setBarWidth(barbecue.getBarWidth());
		designBarbecue.setBarHeight(barbecue.getBarHeight());
		designBarbecue.setOrientation(barbecue.getOrientation());
		return designBarbecue;
	}

	private void barcode(DRDesignBarcode designBarcode, DRIBarcode barcode) throws DRException {
		designBarcode.setWidth(accessor.getTemplateTransform().getBarcodeWidth(barcode));
		designBarcode.setHeight(accessor.getTemplateTransform().getBarcodeHeight(barcode));
		designBarcode.setCodeExpression(accessor.getExpressionTransform().transformExpression(barcode.getCodeExpression()));
	}

	private void barcode4j(DRDesignBarcode4j designBarcode4j, DRIBarcode4j barcode4j) throws DRException {
		barcode(designBarcode4j, barcode4j);
		designBarcode4j.setPatternExpression(accessor.getExpressionTransform().transformExpression(barcode4j.getPatternExpression()));
		designBarcode4j.setModuleWidth(barcode4j.getModuleWidth());
		designBarcode4j.setOrientation(barcode4j.getOrientation());
		designBarcode4j.setTextPosition(barcode4j.getTextPosition());
		designBarcode4j.setQuietZone(barcode4j.getQuietZone());
		designBarcode4j.setVerticalQuietZone(barcode4j.getVerticalQuietZone());
	}

	private void checksumBarcode(DRDesignChecksumBarcode designBarcode, DRIChecksumBarcode barcode) throws DRException {
		barcode4j(designBarcode, barcode);
		designBarcode.setChecksumMode(barcode.getChecksumMode());
	}

	private DRDesignCodabarBarcode codabar(DRICodabarBarcode barcode) throws DRException {
		DRDesignCodabarBarcode designBarcode = new DRDesignCodabarBarcode();
		barcode4j(designBarcode, barcode);
		designBarcode.setWideFactor(barcode.getWideFactor());
		return designBarcode;
	}

	private DRDesignCode128Barcode code128(DRICode128Barcode barcode) throws DRException {
		DRDesignCode128Barcode designBarcode = new DRDesignCode128Barcode();
		barcode4j(designBarcode, barcode);
		return designBarcode;
	}

	private DRDesignEan128Barcode ean128(DRIEan128Barcode barcode) throws DRException {
		DRDesignEan128Barcode designBarcode = new DRDesignEan128Barcode();
		checksumBarcode(designBarcode, barcode);
		return designBarcode;
	}

	private DRDesignDataMatrixBarcode dataMatrix(DRIDataMatrixBarcode barcode) throws DRException {
		DRDesignDataMatrixBarcode designBarcode = new DRDesignDataMatrixBarcode();
		barcode4j(designBarcode, barcode);
		designBarcode.setShape(barcode.getShape());
		return designBarcode;
	}

	private DRDesignCode39Barcode code39(DRICode39Barcode barcode) throws DRException {
		DRDesignCode39Barcode designBarcode = new DRDesignCode39Barcode();
		checksumBarcode(designBarcode, barcode);
		designBarcode.setDisplayChecksum(barcode.getDisplayChecksum());
		designBarcode.setDisplayStartStop(barcode.getDisplayStartStop());
		designBarcode.setExtendedCharSetEnabled(barcode.getExtendedCharSetEnabled());
		designBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
		designBarcode.setWideFactor(barcode.getWideFactor());
		return designBarcode;
	}

	private DRDesignInterleaved2Of5Barcode interleaved2Of5(DRIInterleaved2Of5Barcode barcode) throws DRException {
		DRDesignInterleaved2Of5Barcode designBarcode = new DRDesignInterleaved2Of5Barcode();
		checksumBarcode(designBarcode, barcode);
		designBarcode.setDisplayChecksum(barcode.getDisplayChecksum());
		designBarcode.setWideFactor(barcode.getWideFactor());
		return designBarcode;
	}

	private DRDesignUpcaBarcode upca(DRIUpcaBarcode barcode) throws DRException {
		DRDesignUpcaBarcode designBarcode = new DRDesignUpcaBarcode();
		checksumBarcode(designBarcode, barcode);
		return designBarcode;
	}

	private DRDesignUpceBarcode upce(DRIUpceBarcode barcode) throws DRException {
		DRDesignUpceBarcode designBarcode = new DRDesignUpceBarcode();
		checksumBarcode(designBarcode, barcode);
		return designBarcode;
	}

	private DRDesignEan13Barcode ean13(DRIEan13Barcode barcode) throws DRException {
		DRDesignEan13Barcode designBarcode = new DRDesignEan13Barcode();
		checksumBarcode(designBarcode, barcode);
		return designBarcode;
	}

	private DRDesignEan8Barcode ean8(DRIEan8Barcode barcode) throws DRException {
		DRDesignEan8Barcode designBarcode = new DRDesignEan8Barcode();
		checksumBarcode(designBarcode, barcode);
		return designBarcode;
	}

	private DRDesignUspsIntelligentMailBarcode uspsIntelligentMail(DRIUspsIntelligentMailBarcode barcode) throws DRException {
		DRDesignUspsIntelligentMailBarcode designBarcode = new DRDesignUspsIntelligentMailBarcode();
		checksumBarcode(designBarcode, barcode);
		designBarcode.setAscenderHeight(barcode.getAscenderHeight());
		designBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
		designBarcode.setTrackHeight(barcode.getTrackHeight());
		return designBarcode;
	}

	private DRDesignRoyalMailCustomerBarcode royalMailCustomer(DRIRoyalMailCustomerBarcode barcode) throws DRException {
		DRDesignRoyalMailCustomerBarcode designBarcode = new DRDesignRoyalMailCustomerBarcode();
		checksumBarcode(designBarcode, barcode);
		designBarcode.setAscenderHeight(barcode.getAscenderHeight());
		designBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
		designBarcode.setTrackHeight(barcode.getTrackHeight());
		return designBarcode;
	}

	private DRDesignPostnetBarcode postnet(DRIPostnetBarcode barcode) throws DRException {
		DRDesignPostnetBarcode designBarcode = new DRDesignPostnetBarcode();
		checksumBarcode(designBarcode, barcode);
		designBarcode.setDisplayChecksum(barcode.getDisplayChecksum());
		designBarcode.setShortBarHeight(barcode.getShortBarHeight());
		designBarcode.setBaselinePosition(barcode.getBaselinePosition());
		designBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
		return designBarcode;
	}

	private DRDesignPdf417Barcode pdf417(DRIPdf417Barcode barcode) throws DRException {
		DRDesignPdf417Barcode designBarcode = new DRDesignPdf417Barcode();
		barcode4j(designBarcode, barcode);
		designBarcode.setMinColumns(barcode.getMinColumns());
		designBarcode.setMaxColumns(barcode.getMaxColumns());
		designBarcode.setMinRows(barcode.getMinRows());
		designBarcode.setMaxRows(barcode.getMaxRows());
		designBarcode.setWidthToHeightRatio(barcode.getWidthToHeightRatio());
		designBarcode.setErrorCorrectionLevel(barcode.getErrorCorrectionLevel());
		return designBarcode;
	}

	private DRDesignQrCode qrCode(DRIQrCode qrCode) throws DRException {
		DRDesignQrCode designQrCode = new DRDesignQrCode();
		barcode(designQrCode, qrCode);
		designQrCode.setMargin(qrCode.getMargin());
		designQrCode.setErrorCorrectionLevel(qrCode.getErrorCorrectionLevel());
		return designQrCode;
	}
}
