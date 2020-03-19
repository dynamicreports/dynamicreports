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
package net.sf.dynamicreports.jasper.transformation;

import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignBarbecue;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignBarcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignBarcode4j;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignCodabarBarcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignCode128Barcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignCode39Barcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignDataMatrixBarcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignEan128Barcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignEan13Barcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignEan8Barcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignInterleaved2Of5Barcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignPdf417Barcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignPostnetBarcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignQrCode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignRoyalMailCustomerBarcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignUpcaBarcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignUpceBarcode;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignUspsIntelligentMailBarcode;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.jasperreports.components.ComponentsExtensionsRegistryFactory;
import net.sf.jasperreports.components.barbecue.BarbecueComponent;
import net.sf.jasperreports.components.barbecue.StandardBarbecueComponent;
import net.sf.jasperreports.components.barcode4j.Barcode4jComponent;
import net.sf.jasperreports.components.barcode4j.BarcodeComponent;
import net.sf.jasperreports.components.barcode4j.CodabarComponent;
import net.sf.jasperreports.components.barcode4j.Code128Component;
import net.sf.jasperreports.components.barcode4j.Code39Component;
import net.sf.jasperreports.components.barcode4j.DataMatrixComponent;
import net.sf.jasperreports.components.barcode4j.EAN128Component;
import net.sf.jasperreports.components.barcode4j.EAN13Component;
import net.sf.jasperreports.components.barcode4j.EAN8Component;
import net.sf.jasperreports.components.barcode4j.Interleaved2Of5Component;
import net.sf.jasperreports.components.barcode4j.PDF417Component;
import net.sf.jasperreports.components.barcode4j.POSTNETComponent;
import net.sf.jasperreports.components.barcode4j.QRCodeComponent;
import net.sf.jasperreports.components.barcode4j.RoyalMailCustomerComponent;
import net.sf.jasperreports.components.barcode4j.UPCAComponent;
import net.sf.jasperreports.components.barcode4j.UPCEComponent;
import net.sf.jasperreports.components.barcode4j.USPSIntelligentMailComponent;
import net.sf.jasperreports.engine.component.ComponentKey;
import net.sf.jasperreports.engine.design.JRDesignComponentElement;
import net.sf.jasperreports.engine.design.JRDesignElement;

/**
 * <p>BarcodeTransform class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class BarcodeTransform {
    private JasperTransformAccessor accessor;

    /**
     * <p>Constructor for BarcodeTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor} object.
     */
    public BarcodeTransform(JasperTransformAccessor accessor) {
        this.accessor = accessor;
    }

    /**
     * <p>transform.</p>
     *
     * @param barcode a {@link net.sf.dynamicreports.design.definition.barcode.DRIDesignBarcode} object.
     * @return a {@link net.sf.jasperreports.engine.design.JRDesignElement} object.
     */
    protected JRDesignElement transform(DRIDesignBarcode barcode) {
        JRDesignComponentElement jrComponent = new JRDesignComponentElement();
        jrComponent.setComponent(barcodeComponent(barcode));
        jrComponent.setComponentKey(new ComponentKey(ComponentsExtensionsRegistryFactory.NAMESPACE, "jr", barcode.getName()));
        return jrComponent;
    }

    /**
     * <p>transform.</p>
     *
     * @param barbecue a {@link net.sf.dynamicreports.design.definition.barcode.DRIDesignBarbecue} object.
     * @return a {@link net.sf.jasperreports.engine.design.JRDesignElement} object.
     */
    protected JRDesignElement transform(DRIDesignBarbecue barbecue) {
        JRDesignComponentElement jrComponent = new JRDesignComponentElement();
        jrComponent.setComponent(barbecueComponent(barbecue));
        jrComponent.setComponentKey(new ComponentKey(ComponentsExtensionsRegistryFactory.NAMESPACE, "jr", barbecue.getName()));
        return jrComponent;
    }

    private BarcodeComponent barcodeComponent(DRIDesignBarcode barcode) {
        if (barcode instanceof DRIDesignCodabarBarcode) {
            return codabar((DRIDesignCodabarBarcode) barcode);
        } else if (barcode instanceof DRIDesignCode128Barcode) {
            return code128((DRIDesignCode128Barcode) barcode);
        } else if (barcode instanceof DRIDesignEan128Barcode) {
            return ean128((DRIDesignEan128Barcode) barcode);
        } else if (barcode instanceof DRIDesignDataMatrixBarcode) {
            return dataMatrix((DRIDesignDataMatrixBarcode) barcode);
        } else if (barcode instanceof DRIDesignCode39Barcode) {
            return code39((DRIDesignCode39Barcode) barcode);
        } else if (barcode instanceof DRIDesignInterleaved2Of5Barcode) {
            return interleaved2Of5((DRIDesignInterleaved2Of5Barcode) barcode);
        } else if (barcode instanceof DRIDesignUpcaBarcode) {
            return upca((DRIDesignUpcaBarcode) barcode);
        } else if (barcode instanceof DRIDesignUpceBarcode) {
            return upce((DRIDesignUpceBarcode) barcode);
        } else if (barcode instanceof DRIDesignEan13Barcode) {
            return ean13((DRIDesignEan13Barcode) barcode);
        } else if (barcode instanceof DRIDesignEan8Barcode) {
            return ean8((DRIDesignEan8Barcode) barcode);
        } else if (barcode instanceof DRIDesignUspsIntelligentMailBarcode) {
            return uspsIntelligentMail((DRIDesignUspsIntelligentMailBarcode) barcode);
        } else if (barcode instanceof DRIDesignRoyalMailCustomerBarcode) {
            return royalMailCustomer((DRIDesignRoyalMailCustomerBarcode) barcode);
        } else if (barcode instanceof DRIDesignPostnetBarcode) {
            return postnet((DRIDesignPostnetBarcode) barcode);
        } else if (barcode instanceof DRIDesignPdf417Barcode) {
            return pdf417((DRIDesignPdf417Barcode) barcode);
        } else if (barcode instanceof DRIDesignQrCode) {
            return qrCode((DRIDesignQrCode) barcode);
        } else {
            throw new JasperDesignException("Barcode " + barcode.getClass().getName() + " not supported");
        }
    }

    private BarbecueComponent barbecueComponent(DRIDesignBarbecue barbecue) {
        StandardBarbecueComponent jrBarbecue = new StandardBarbecueComponent();
        EvaluationTime evaluationTime = barbecue.getEvaluationTime();
        jrBarbecue.setEvaluationTimeValue(ConstantTransform.evaluationTime(evaluationTime));
        if (evaluationTime != null && evaluationTime.equals(EvaluationTime.GROUP) && barbecue.getEvaluationGroup() != null) {
            jrBarbecue.setEvaluationGroup(accessor.getGroupTransform().getGroup(barbecue.getEvaluationGroup()).getName());
        }
        jrBarbecue.setType(ConstantTransform.barbecueType(barbecue.getType()));
        jrBarbecue.setCodeExpression(accessor.getExpressionTransform().getExpression(barbecue.getCodeExpression()));
        jrBarbecue.setApplicationIdentifierExpression(accessor.getExpressionTransform().getExpression(barbecue.getApplicationIdentifierExpression()));
        if (barbecue.getDrawText() != null) {
            jrBarbecue.setDrawText(barbecue.getDrawText());
        }
        if (barbecue.getChecksumRequired() != null) {
            jrBarbecue.setChecksumRequired(barbecue.getChecksumRequired());
        }
        jrBarbecue.setBarWidth(barbecue.getBarWidth());
        jrBarbecue.setBarHeight(barbecue.getBarHeight());
        if (barbecue.getOrientation() != null) {
            jrBarbecue.setRotation(ConstantTransform.barbecueRotation(barbecue.getOrientation()));
        }
        return jrBarbecue;
    }

    private void barcode(BarcodeComponent jrBarcode, DRIDesignBarcode barcode) {
        EvaluationTime evaluationTime = barcode.getEvaluationTime();
        jrBarcode.setEvaluationTimeValue(ConstantTransform.evaluationTime(evaluationTime));
        if (evaluationTime != null && evaluationTime.equals(EvaluationTime.GROUP) && barcode.getEvaluationGroup() != null) {
            jrBarcode.setEvaluationGroup(accessor.getGroupTransform().getGroup(barcode.getEvaluationGroup()).getName());
        }
        jrBarcode.setCodeExpression(accessor.getExpressionTransform().getExpression(barcode.getCodeExpression()));
    }

    private void barcode4j(Barcode4jComponent jrBarcode4j, DRIDesignBarcode4j barcode4j) {
        barcode(jrBarcode4j, barcode4j);
        jrBarcode4j.setPatternExpression(accessor.getExpressionTransform().getExpression(barcode4j.getPatternExpression()));
        jrBarcode4j.setModuleWidth(barcode4j.getModuleWidth());
        if (barcode4j.getOrientation() != null) {
            jrBarcode4j.setOrientation(ConstantTransform.barcodeOrientation(barcode4j.getOrientation()));
        }
        jrBarcode4j.setTextPosition(ConstantTransform.barcodeTextPosition(barcode4j.getTextPosition()));
        jrBarcode4j.setQuietZone(barcode4j.getQuietZone());
        jrBarcode4j.setVerticalQuietZone(barcode4j.getVerticalQuietZone());
    }

    private Barcode4jComponent codabar(DRIDesignCodabarBarcode barcode) {
        CodabarComponent jrBarcode = new CodabarComponent();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setWideFactor(barcode.getWideFactor());
        return jrBarcode;
    }

    private Barcode4jComponent code128(DRIDesignCode128Barcode barcode) {
        Code128Component jrBarcode = new Code128Component();
        barcode4j(jrBarcode, barcode);
        return jrBarcode;
    }

    private Barcode4jComponent ean128(DRIDesignEan128Barcode barcode) {
        EAN128Component jrBarcode = new EAN128Component();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        return jrBarcode;
    }

    private Barcode4jComponent dataMatrix(DRIDesignDataMatrixBarcode barcode) {
        DataMatrixComponent jrBarcode = new DataMatrixComponent();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setShape(ConstantTransform.barcodeShape(barcode.getShape()));
        return jrBarcode;
    }

    private Barcode4jComponent code39(DRIDesignCode39Barcode barcode) {
        Code39Component jrBarcode = new Code39Component();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        jrBarcode.setDisplayChecksum(barcode.getDisplayChecksum());
        jrBarcode.setDisplayStartStop(barcode.getDisplayStartStop());
        jrBarcode.setExtendedCharSetEnabled(barcode.getExtendedCharSetEnabled());
        jrBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
        jrBarcode.setWideFactor(barcode.getWideFactor());
        return jrBarcode;
    }

    private Barcode4jComponent interleaved2Of5(DRIDesignInterleaved2Of5Barcode barcode) {
        Interleaved2Of5Component jrBarcode = new Interleaved2Of5Component();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        jrBarcode.setDisplayChecksum(barcode.getDisplayChecksum());
        jrBarcode.setWideFactor(barcode.getWideFactor());
        return jrBarcode;
    }

    private Barcode4jComponent upca(DRIDesignUpcaBarcode barcode) {
        UPCAComponent jrBarcode = new UPCAComponent();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        return jrBarcode;
    }

    private Barcode4jComponent upce(DRIDesignUpceBarcode barcode) {
        UPCEComponent jrBarcode = new UPCEComponent();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        return jrBarcode;
    }

    private Barcode4jComponent ean13(DRIDesignEan13Barcode barcode) {
        EAN13Component jrBarcode = new EAN13Component();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        return jrBarcode;
    }

    private Barcode4jComponent ean8(DRIDesignEan8Barcode barcode) {
        EAN8Component jrBarcode = new EAN8Component();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        return jrBarcode;
    }

    private Barcode4jComponent uspsIntelligentMail(DRIDesignUspsIntelligentMailBarcode barcode) {
        USPSIntelligentMailComponent jrBarcode = new USPSIntelligentMailComponent();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        jrBarcode.setAscenderHeight(barcode.getAscenderHeight());
        jrBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
        jrBarcode.setTrackHeight(barcode.getTrackHeight());
        return jrBarcode;
    }

    private Barcode4jComponent royalMailCustomer(DRIDesignRoyalMailCustomerBarcode barcode) {
        RoyalMailCustomerComponent jrBarcode = new RoyalMailCustomerComponent();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()));
        jrBarcode.setAscenderHeight(barcode.getAscenderHeight());
        jrBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
        jrBarcode.setTrackHeight(barcode.getTrackHeight());
        return jrBarcode;
    }

    private Barcode4jComponent postnet(DRIDesignPostnetBarcode barcode) {
        POSTNETComponent jrBarcode = new POSTNETComponent();
        barcode4j(jrBarcode, barcode);
        if (barcode.getChecksumMode() != null) {
            jrBarcode.setChecksumMode(ConstantTransform.barcodeChecksumMode(barcode.getChecksumMode()).getName());
        }
        jrBarcode.setDisplayChecksum(barcode.getDisplayChecksum());
        jrBarcode.setShortBarHeight(barcode.getShortBarHeight());
        if (barcode.getBaselinePosition() != null) {
            jrBarcode.setBaselinePosition(ConstantTransform.barcodeBaselinePosition(barcode.getBaselinePosition()).getName());
        }
        jrBarcode.setIntercharGapWidth(barcode.getIntercharGapWidth());
        return jrBarcode;
    }

    private Barcode4jComponent pdf417(DRIDesignPdf417Barcode barcode) {
        PDF417Component jrBarcode = new PDF417Component();
        barcode4j(jrBarcode, barcode);
        jrBarcode.setMinColumns(barcode.getMinColumns());
        jrBarcode.setMaxColumns(barcode.getMaxColumns());
        jrBarcode.setMinRows(barcode.getMinRows());
        jrBarcode.setMaxRows(barcode.getMaxRows());
        jrBarcode.setWidthToHeightRatio(barcode.getWidthToHeightRatio());
        jrBarcode.setErrorCorrectionLevel(barcode.getErrorCorrectionLevel());
        return jrBarcode;
    }

    private QRCodeComponent qrCode(DRIDesignQrCode qrCode) {
        QRCodeComponent jrQrCode = new QRCodeComponent();
        barcode(jrQrCode, qrCode);
        jrQrCode.setMargin(qrCode.getMargin());
        jrQrCode.setErrorCorrectionLevel(ConstantTransform.qrCodeErrorCorrectionLevel(qrCode.getErrorCorrectionLevel()));
        return jrQrCode;
    }

}
