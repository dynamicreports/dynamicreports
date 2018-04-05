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

package net.sf.dynamicreports.jasper.transformation;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.Second;
import org.jfree.data.time.Week;
import org.jfree.data.time.Year;
import org.krysalis.barcode4j.BaselineAlignment;
import org.krysalis.barcode4j.ChecksumMode;
import org.krysalis.barcode4j.impl.datamatrix.SymbolShapeHint;

import com.lowagie.text.pdf.PdfWriter;

import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.jasper.constant.PdfPermission;
import net.sf.dynamicreports.jasper.constant.PdfVersion;
import net.sf.dynamicreports.jasper.constant.SizeUnit;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.report.constant.AxisPosition;
import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.constant.BarcodeBaselinePosition;
import net.sf.dynamicreports.report.constant.BarcodeChecksumMode;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeShape;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.constant.BreakType;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;
import net.sf.dynamicreports.report.constant.CrosstabTotalPosition;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.HyperLinkTarget;
import net.sf.dynamicreports.report.constant.HyperLinkType;
import net.sf.dynamicreports.report.constant.ImageAnchorType;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.LineDirection;
import net.sf.dynamicreports.report.constant.LineSpacing;
import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PdfPrintScaling;
import net.sf.dynamicreports.report.constant.PdfaConformance;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.QrCodeErrorCorrectionLevel;
import net.sf.dynamicreports.report.constant.RectangleAnchor;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.ScaleType;
import net.sf.dynamicreports.report.constant.SpiderRotation;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.report.constant.TabStopAlignment;
import net.sf.dynamicreports.report.constant.TableOrder;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.constant.VerticalImageAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.jasperreports.charts.type.AxisPositionEnum;
import net.sf.jasperreports.charts.type.EdgeEnum;
import net.sf.jasperreports.charts.type.MeterShapeEnum;
import net.sf.jasperreports.charts.type.PlotOrientationEnum;
import net.sf.jasperreports.charts.type.ScaleTypeEnum;
import net.sf.jasperreports.charts.type.ValueLocationEnum;
import net.sf.jasperreports.components.barcode4j.ErrorCorrectionLevelEnum;
import net.sf.jasperreports.components.barcode4j.TextPositionEnum;
import net.sf.jasperreports.components.spiderchart.type.SpiderRotationEnum;
import net.sf.jasperreports.components.spiderchart.type.TableOrderEnum;
import net.sf.jasperreports.crosstabs.type.CrosstabPercentageEnum;
import net.sf.jasperreports.crosstabs.type.CrosstabTotalPositionEnum;
import net.sf.jasperreports.engine.analytics.dataset.BucketOrder;
import net.sf.jasperreports.engine.design.JRDesignChart;
import net.sf.jasperreports.engine.export.type.ImageAnchorTypeEnum;
import net.sf.jasperreports.engine.type.BreakTypeEnum;
import net.sf.jasperreports.engine.type.CalculationEnum;
import net.sf.jasperreports.engine.type.EvaluationTimeEnum;
import net.sf.jasperreports.engine.type.FooterPositionEnum;
import net.sf.jasperreports.engine.type.HorizontalImageAlignEnum;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.HyperlinkTargetEnum;
import net.sf.jasperreports.engine.type.HyperlinkTypeEnum;
import net.sf.jasperreports.engine.type.LineDirectionEnum;
import net.sf.jasperreports.engine.type.LineSpacingEnum;
import net.sf.jasperreports.engine.type.LineStyleEnum;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.type.PositionTypeEnum;
import net.sf.jasperreports.engine.type.PrintOrderEnum;
import net.sf.jasperreports.engine.type.ResetTypeEnum;
import net.sf.jasperreports.engine.type.RotationEnum;
import net.sf.jasperreports.engine.type.RunDirectionEnum;
import net.sf.jasperreports.engine.type.ScaleImageEnum;
import net.sf.jasperreports.engine.type.SortOrderEnum;
import net.sf.jasperreports.engine.type.SplitTypeEnum;
import net.sf.jasperreports.engine.type.StretchTypeEnum;
import net.sf.jasperreports.engine.type.TabStopAlignEnum;
import net.sf.jasperreports.engine.type.VerticalImageAlignEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.type.WhenResourceMissingTypeEnum;
import net.sf.jasperreports.export.type.HtmlSizeUnitEnum;
import net.sf.jasperreports.export.type.PdfPrintScalingEnum;
import net.sf.jasperreports.export.type.PdfVersionEnum;
import net.sf.jasperreports.export.type.PdfaConformanceEnum;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ConstantTransform {

	protected static LineStyleEnum lineStyle(LineStyle lineStyle) {
		if (lineStyle == null) {
			return null;
		}

		switch (lineStyle) {
			case SOLID:
				return LineStyleEnum.SOLID;
			case DASHED:
				return LineStyleEnum.DASHED;
			case DOTTED:
				return LineStyleEnum.DOTTED;
			case DOUBLE:
				return LineStyleEnum.DOUBLE;
			default:
				throw new JasperDesignException("Line style " + lineStyle.name() + " not supported");
		}
	}

	@SuppressWarnings("deprecation")
	protected static ScaleImageEnum imageScale(ImageScale imageScale) {
		if (imageScale == null) {
			return null;
		}

		switch (imageScale) {
			case CLIP:
			case NO_RESIZE:
				return ScaleImageEnum.CLIP;
			case FILL_FRAME:
			case FILL:
				return ScaleImageEnum.FILL_FRAME;
			case RETAIN_SHAPE:
			case FILL_PROPORTIONALLY:
				return ScaleImageEnum.RETAIN_SHAPE;
			case REAL_HEIGHT:
				return ScaleImageEnum.REAL_HEIGHT;
			case REAL_SIZE:
				return ScaleImageEnum.REAL_SIZE;
			default:
				throw new JasperDesignException("Image scale " + imageScale.name() + " not supported");
		}
	}

	protected static ImageAnchorTypeEnum imageAnchorType(ImageAnchorType imageAnchorType) {
		if (imageAnchorType == null) {
			return null;
		}

		switch (imageAnchorType) {
			case MOVE_SIZE:
				return ImageAnchorTypeEnum.MOVE_SIZE;
			case MOVE_NO_SIZE:
				return ImageAnchorTypeEnum.MOVE_NO_SIZE;
			case NO_MOVE_NO_SIZE:
				return ImageAnchorTypeEnum.NO_MOVE_NO_SIZE;
			default:
				throw new JasperDesignException("Image anchor type " + imageAnchorType.name() + " not supported");
		}
	}

	protected static HorizontalTextAlignEnum horizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		if (horizontalTextAlignment == null) {
			return null;
		}

		switch (horizontalTextAlignment) {
			case LEFT:
				return HorizontalTextAlignEnum.LEFT;
			case CENTER:
				return HorizontalTextAlignEnum.CENTER;
			case RIGHT:
				return HorizontalTextAlignEnum.RIGHT;
			case JUSTIFIED:
				return HorizontalTextAlignEnum.JUSTIFIED;
			default:
				throw new JasperDesignException("Horizontal text alignment " + horizontalTextAlignment.name() + " not supported");
		}
	}

	protected static VerticalTextAlignEnum verticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
		if (verticalTextAlignment == null) {
			return null;
		}

		switch (verticalTextAlignment) {
			case TOP:
				return VerticalTextAlignEnum.TOP;
			case MIDDLE:
				return VerticalTextAlignEnum.MIDDLE;
			case BOTTOM:
				return VerticalTextAlignEnum.BOTTOM;
			case JUSTIFIED:
				return VerticalTextAlignEnum.JUSTIFIED;
			default:
				throw new JasperDesignException("Vertical text alignment " + verticalTextAlignment.name() + " not supported");
		}
	}

	protected static HorizontalImageAlignEnum horizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
		if (horizontalImageAlignment == null) {
			return null;
		}

		switch (horizontalImageAlignment) {
			case LEFT:
				return HorizontalImageAlignEnum.LEFT;
			case CENTER:
				return HorizontalImageAlignEnum.CENTER;
			case RIGHT:
				return HorizontalImageAlignEnum.RIGHT;
			default:
				throw new JasperDesignException("Horizontal image alignment " + horizontalImageAlignment.name() + " not supported");
		}
	}

	protected static VerticalImageAlignEnum verticalImageAlignment(VerticalImageAlignment verticalImageAlignment) {
		if (verticalImageAlignment == null) {
			return null;
		}

		switch (verticalImageAlignment) {
			case TOP:
				return VerticalImageAlignEnum.TOP;
			case MIDDLE:
				return VerticalImageAlignEnum.MIDDLE;
			case BOTTOM:
				return VerticalImageAlignEnum.BOTTOM;
			default:
				throw new JasperDesignException("Vertical image alignment " + verticalImageAlignment.name() + " not supported");
		}
	}

	protected static RotationEnum rotation(Rotation rotation) {
		if (rotation == null) {
			return null;
		}

		switch (rotation) {
			case NONE:
				return RotationEnum.NONE;
			case LEFT:
				return RotationEnum.LEFT;
			case RIGHT:
				return RotationEnum.RIGHT;
			case UPSIDE_DOWN:
				return RotationEnum.UPSIDE_DOWN;
			default:
				throw new JasperDesignException("Rotation " + rotation.name() + " not supported");
		}
	}

	protected static Byte chartType(ChartType chartType) {
		switch (chartType) {
			case AREA:
				return JRDesignChart.CHART_TYPE_AREA;
			case STACKEDAREA:
				return JRDesignChart.CHART_TYPE_STACKEDAREA;
			case BAR:
			case LAYEREDBAR:
			case WATERFALLBAR:
				return JRDesignChart.CHART_TYPE_BAR;
			case BAR3D:
				return JRDesignChart.CHART_TYPE_BAR3D;
			case STACKEDBAR:
			case GROUPEDSTACKEDBAR:
				return JRDesignChart.CHART_TYPE_STACKEDBAR;
			case STACKEDBAR3D:
				return JRDesignChart.CHART_TYPE_STACKEDBAR3D;
			case LINE:
				return JRDesignChart.CHART_TYPE_LINE;
			case PIE:
				return JRDesignChart.CHART_TYPE_PIE;
			case PIE3D:
				return JRDesignChart.CHART_TYPE_PIE3D;
			case TIMESERIES:
			case DIFFERENCE:
				return JRDesignChart.CHART_TYPE_TIMESERIES;
			case XYAREA:
				return JRDesignChart.CHART_TYPE_XYAREA;
			case XYBAR:
				return JRDesignChart.CHART_TYPE_XYBAR;
			case XYLINE:
			case XYSTEP:
				return JRDesignChart.CHART_TYPE_XYLINE;
			case SCATTER:
				return JRDesignChart.CHART_TYPE_SCATTER;
			case MULTI_AXIS:
				return JRDesignChart.CHART_TYPE_MULTI_AXIS;
			case XYBLOCK:
			case BUBBLE:
				return JRDesignChart.CHART_TYPE_BUBBLE;
			case CANDLESTICK:
				return JRDesignChart.CHART_TYPE_CANDLESTICK;
			case HIGHLOW:
				return JRDesignChart.CHART_TYPE_HIGHLOW;
			case METER:
				return JRDesignChart.CHART_TYPE_METER;
			case THERMOMETER:
				return JRDesignChart.CHART_TYPE_THERMOMETER;
			case GANTT:
				return JRDesignChart.CHART_TYPE_GANTT;
			default:
				throw new JasperDesignException("Chart " + chartType.name() + " not supported");
		}
	}

	protected static WhenNoDataTypeEnum whenNoDataType(WhenNoDataType whenNoDataType) {
		switch (whenNoDataType) {
			case NO_PAGES:
				return WhenNoDataTypeEnum.NO_PAGES;
			case BLANK_PAGE:
				return WhenNoDataTypeEnum.BLANK_PAGE;
			case ALL_SECTIONS_NO_DETAIL:
				return WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL;
			case NO_DATA_SECTION:
				return WhenNoDataTypeEnum.NO_DATA_SECTION;
			default:
				throw new JasperDesignException("When no data type " + whenNoDataType.name() + " not supported");
		}
	}

	public static WhenNoDataType whenNoDataType(WhenNoDataTypeEnum whenNoDataType) {
		if (whenNoDataType == null) {
			return null;
		}
		switch (whenNoDataType) {
			case NO_PAGES:
				return WhenNoDataType.NO_PAGES;
			case BLANK_PAGE:
				return WhenNoDataType.BLANK_PAGE;
			case ALL_SECTIONS_NO_DETAIL:
				return WhenNoDataType.ALL_SECTIONS_NO_DETAIL;
			case NO_DATA_SECTION:
				return WhenNoDataType.NO_DATA_SECTION;
			default:
				throw new JasperDesignException("When no data type " + whenNoDataType.name() + " not supported");
		}
	}

	protected static WhenResourceMissingTypeEnum whenResourceMissingType(WhenResourceMissingType whenResourceMissingType) {
		switch (whenResourceMissingType) {
			case NULL:
				return WhenResourceMissingTypeEnum.NULL;
			case EMPTY:
				return WhenResourceMissingTypeEnum.EMPTY;
			case KEY:
				return WhenResourceMissingTypeEnum.KEY;
			case ERROR:
				return WhenResourceMissingTypeEnum.ERROR;
			default:
				throw new JasperDesignException("When resource missing type " + whenResourceMissingType.name() + " not supported");
		}
	}

	public static WhenResourceMissingType whenResourceMissingType(WhenResourceMissingTypeEnum whenResourceMissingType) {
		switch (whenResourceMissingType) {
			case NULL:
				return WhenResourceMissingType.NULL;
			case EMPTY:
				return WhenResourceMissingType.EMPTY;
			case KEY:
				return WhenResourceMissingType.KEY;
			case ERROR:
				return WhenResourceMissingType.ERROR;
			default:
				throw new JasperDesignException("When resource missing type " + whenResourceMissingType.name() + " not supported");
		}
	}

	protected static OrientationEnum pageOrientation(PageOrientation orientation) {
		switch (orientation) {
			case PORTRAIT:
				return OrientationEnum.PORTRAIT;
			case LANDSCAPE:
				return OrientationEnum.LANDSCAPE;
			default:
				throw new JasperDesignException("Page orientation " + orientation.name() + " not supported");
		}
	}

	public static PageOrientation pageOrientation(OrientationEnum orientation) {
		switch (orientation) {
			case PORTRAIT:
				return PageOrientation.PORTRAIT;
			case LANDSCAPE:
				return PageOrientation.LANDSCAPE;
			default:
				throw new JasperDesignException("Page orientation " + orientation.name() + " not supported");
		}
	}

	public static ResetTypeEnum variableResetType(ResetType resetType) {
		if (resetType == null) {
			return ResetTypeEnum.NONE;
		}

		switch (resetType) {
			case NONE:
				return ResetTypeEnum.NONE;
			case REPORT:
				return ResetTypeEnum.REPORT;
			case PAGE:
				return ResetTypeEnum.PAGE;
			case COLUMN:
				return ResetTypeEnum.COLUMN;
			case GROUP:
				return ResetTypeEnum.GROUP;
			default:
				throw new JasperDesignException("Variable reset type " + resetType.name() + " not supported");
		}
	}

	public static EvaluationTimeEnum evaluationTime(EvaluationTime evaluationTime) {
		if (evaluationTime == null) {
			return EvaluationTimeEnum.NOW;
		}

		switch (evaluationTime) {
			case NOW:
				return EvaluationTimeEnum.NOW;
			case REPORT:
				return EvaluationTimeEnum.REPORT;
			case PAGE:
				return EvaluationTimeEnum.PAGE;
			case COLUMN:
				return EvaluationTimeEnum.COLUMN;
			case GROUP:
				return EvaluationTimeEnum.GROUP;
			case BAND:
				return EvaluationTimeEnum.BAND;
			case AUTO:
				return EvaluationTimeEnum.AUTO;
			default:
				throw new JasperDesignException("Evaluation time " + evaluationTime.name() + " not supported");
		}
	}

	protected static SplitTypeEnum splitType(SplitType splitType) {
		if (splitType == null) {
			return null;
		}
		switch (splitType) {
			case IMMEDIATE:
				return SplitTypeEnum.IMMEDIATE;
			case PREVENT:
				return SplitTypeEnum.PREVENT;
			case STRETCH:
				return SplitTypeEnum.STRETCH;
			default:
				throw new JasperDesignException("Split type " + splitType.name() + " not supported");
		}
	}

	protected static Class<?> timePeriodType(TimePeriod timePeriodType) {
		switch (timePeriodType) {
			case YEAR:
				return Year.class;
			case QUARTER:
				return Quarter.class;
			case MONTH:
				return Month.class;
			case WEEK:
				return Week.class;
			case DAY:
				return Day.class;
			case HOUR:
				return Hour.class;
			case MINUTE:
				return Minute.class;
			case SECOND:
				return Second.class;
			case MILLISECOND:
				return Millisecond.class;
			default:
				throw new JasperDesignException("Time period type " + timePeriodType.name() + " not supported");
		}
	}

	protected static PlotOrientationEnum chartPlotOrientation(Orientation orientation) {
		switch (orientation) {
			case HORIZONTAL:
				return PlotOrientationEnum.HORIZONTAL;
			case VERTICAL:
				return PlotOrientationEnum.VERTICAL;
			default:
				throw new JasperDesignException("Chart plot orientation " + orientation.name() + " not supported");
		}
	}

	protected static EdgeEnum chartPosition(Position position) {
		if (position == null) {
			return null;
		}

		switch (position) {
			case TOP:
				return EdgeEnum.TOP;
			case BOTTOM:
				return EdgeEnum.BOTTOM;
			case LEFT:
				return EdgeEnum.LEFT;
			case RIGHT:
				return EdgeEnum.RIGHT;
			default:
				throw new JasperDesignException("Position " + position.name() + " not supported");
		}
	}

	protected static AxisPositionEnum chartAxisPosition(AxisPosition axisPosition) {
		if (axisPosition == null) {
			return null;
		}

		switch (axisPosition) {
			case LEFT_OR_TOP:
				return AxisPositionEnum.LEFT_OR_TOP;
			case RIGHT_OR_BOTTOM:
				return AxisPositionEnum.RIGHT_OR_BOTTOM;
			default:
				throw new JasperDesignException("AxisPosition " + axisPosition.name() + " not supported");
		}
	}

	protected static MeterShapeEnum meterShape(MeterShape meterShape) {
		if (meterShape == null) {
			return null;
		}

		switch (meterShape) {
			case CHORD:
				return MeterShapeEnum.CHORD;
			case CIRCLE:
				return MeterShapeEnum.CIRCLE;
			case PIE:
				return MeterShapeEnum.PIE;
			case DIAL:
				return MeterShapeEnum.DIAL;
			default:
				throw new JasperDesignException("MeterShape " + meterShape.name() + " not supported");
		}
	}

	protected static ValueLocationEnum valueLocation(ValueLocation valueLocation) {
		if (valueLocation == null) {
			return null;
		}

		switch (valueLocation) {
			case NONE:
				return ValueLocationEnum.NONE;
			case LEFT:
				return ValueLocationEnum.LEFT;
			case RIGHT:
				return ValueLocationEnum.RIGHT;
			case BULB:
				return ValueLocationEnum.BULB;
			default:
				throw new JasperDesignException("ValueLocation " + valueLocation.name() + " not supported");
		}
	}

	protected static CalculationEnum calculation(Calculation calculation) {
		switch (calculation) {
			case NOTHING:
				return CalculationEnum.NOTHING;
			case COUNT:
				return CalculationEnum.COUNT;
			case SUM:
				return CalculationEnum.SUM;
			case AVERAGE:
				return CalculationEnum.AVERAGE;
			case LOWEST:
				return CalculationEnum.LOWEST;
			case HIGHEST:
				return CalculationEnum.HIGHEST;
			case STANDARD_DEVIATION:
				return CalculationEnum.STANDARD_DEVIATION;
			case VARIANCE:
				return CalculationEnum.VARIANCE;
			case FIRST:
				return CalculationEnum.FIRST;
			case DISTINCT_COUNT:
				return CalculationEnum.DISTINCT_COUNT;
			default:
				throw new JasperDesignException("Calculation " + calculation.name() + " not supported");
		}
	}

	protected static HtmlSizeUnitEnum sizeUnit(SizeUnit sizeUnit) {
		switch (sizeUnit) {
			case PIXEL:
				return HtmlSizeUnitEnum.PIXEL;
			case POINT:
				return HtmlSizeUnitEnum.POINT;
			default:
				throw new JasperDesignException("SizeUnit " + sizeUnit.name() + " not supported");
		}
	}

	protected static PdfVersionEnum pdfVersion(PdfVersion pdfVersion) {
		switch (pdfVersion) {
			case VERION_1_2:
				return PdfVersionEnum.VERSION_1_2;
			case VERION_1_3:
				return PdfVersionEnum.VERSION_1_3;
			case VERION_1_4:
				return PdfVersionEnum.VERSION_1_4;
			case VERION_1_5:
				return PdfVersionEnum.VERSION_1_5;
			case VERION_1_6:
				return PdfVersionEnum.VERSION_1_6;
			case VERION_1_7:
				return PdfVersionEnum.VERSION_1_7;
			default:
				throw new JasperDesignException("PdfVersion " + pdfVersion.name() + " not supported");
		}
	}

	protected static Integer pdfPermission(List<PdfPermission> permissions) {
		int permission = 0;
		for (PdfPermission pdfPermission : permissions) {
			switch (pdfPermission) {
				case PRINTING:
					return permission | PdfWriter.ALLOW_PRINTING;
				case MODIFY_CONTENTS:
					return permission | PdfWriter.ALLOW_MODIFY_CONTENTS;
				case COPY:
					return permission | PdfWriter.ALLOW_COPY;
				case MODIFY_ANNOTATIONS:
					return permission | PdfWriter.ALLOW_MODIFY_ANNOTATIONS;
				case FILL_IN:
					return permission | PdfWriter.ALLOW_FILL_IN;
				case SCREEN_READERS:
					return permission | PdfWriter.ALLOW_SCREENREADERS;
				case ASSEMBLY:
					return permission | PdfWriter.ALLOW_ASSEMBLY;
				case DEGRADED_PRINTING:
					return permission | PdfWriter.ALLOW_DEGRADED_PRINTING;
				default:
					throw new JasperDesignException("PdfPermission " + pdfPermission.name() + " not supported");
			}
		}
		return permission;
	}

	protected static PdfPrintScalingEnum pdfPrintScaling(PdfPrintScaling pdfPrintScaling) {
		switch (pdfPrintScaling) {
			case NONE:
				return PdfPrintScalingEnum.NONE;
			case DEFAULT:
				return PdfPrintScalingEnum.DEFAULT;
			default:
				throw new JasperDesignException("Pdf print scaling " + pdfPrintScaling.name() + " not supported");
		}
	}

	protected static PdfaConformanceEnum pdfaConformance(PdfaConformance pdfaConformance) {
		switch (pdfaConformance) {
			case NONE:
				return PdfaConformanceEnum.NONE;
			case PDFA_1A:
				return PdfaConformanceEnum.PDFA_1A;
			case PDFA_1B:
				return PdfaConformanceEnum.PDFA_1B;
			default:
				throw new JasperDesignException("Pdfa conformance " + pdfaConformance.name() + " not supported");
		}
	}

	public static net.sf.jasperreports.components.barcode4j.OrientationEnum barcodeOrientation(BarcodeOrientation orientation) {
		switch (orientation) {
			case NONE:
				return net.sf.jasperreports.components.barcode4j.OrientationEnum.UP;
			case LEFT:
				return net.sf.jasperreports.components.barcode4j.OrientationEnum.LEFT;
			case RIGHT:
				return net.sf.jasperreports.components.barcode4j.OrientationEnum.RIGHT;
			case UPSIDE_DOWN:
				return net.sf.jasperreports.components.barcode4j.OrientationEnum.DOWN;
			default:
				throw new JasperDesignException("BarcodeOrientation " + orientation.name() + " not supported");
		}
	}

	public static RotationEnum barbecueRotation(BarcodeOrientation orientation) {
		switch (orientation) {
			case NONE:
				return RotationEnum.NONE;
			case LEFT:
				return RotationEnum.LEFT;
			case RIGHT:
				return RotationEnum.RIGHT;
			case UPSIDE_DOWN:
				return RotationEnum.UPSIDE_DOWN;
			default:
				throw new JasperDesignException("BarcodeOrientation " + orientation.name() + " not supported");
		}
	}

	public static TextPositionEnum barcodeTextPosition(BarcodeTextPosition textPosition) {
		if (textPosition == null) {
			return null;
		}

		switch (textPosition) {
			case NONE:
				return TextPositionEnum.NONE;
			case BOTTOM:
				return TextPositionEnum.BOTTOM;
			case TOP:
				return TextPositionEnum.TOP;
			default:
				throw new JasperDesignException("BarcodeTextPosition " + textPosition.name() + " not supported");
		}
	}

	public static ChecksumMode barcodeChecksumMode(BarcodeChecksumMode checksumMode) {
		if (checksumMode == null) {
			return null;
		}

		switch (checksumMode) {
			case AUTO:
				return ChecksumMode.CP_AUTO;
			case IGNORE:
				return ChecksumMode.CP_IGNORE;
			case ADD:
				return ChecksumMode.CP_ADD;
			case CHECK:
				return ChecksumMode.CP_CHECK;
			default:
				throw new JasperDesignException("BarcodeChecksumMode " + checksumMode.name() + " not supported");
		}
	}

	public static SymbolShapeHint barcodeShape(BarcodeShape shape) {
		if (shape == null) {
			return null;
		}

		switch (shape) {
			case NONE:
				return SymbolShapeHint.FORCE_NONE;
			case SQUARE:
				return SymbolShapeHint.FORCE_SQUARE;
			case RECTANGLE:
				return SymbolShapeHint.FORCE_RECTANGLE;
			default:
				throw new JasperDesignException("BarcodeShape " + shape.name() + " not supported");
		}
	}

	public static BaselineAlignment barcodeBaselinePosition(BarcodeBaselinePosition baselinePosition) {
		if (baselinePosition == null) {
			return null;
		}

		switch (baselinePosition) {
			case TOP:
				return BaselineAlignment.ALIGN_TOP;
			case BOTTOM:
				return BaselineAlignment.ALIGN_BOTTOM;
			default:
				throw new JasperDesignException("BarcodeBaselinePosition " + baselinePosition.name() + " not supported");
		}
	}

	public static ErrorCorrectionLevelEnum qrCodeErrorCorrectionLevel(QrCodeErrorCorrectionLevel errorCorrectionLevel) {
		if (errorCorrectionLevel == null) {
			return null;
		}

		switch (errorCorrectionLevel) {
			case L:
				return ErrorCorrectionLevelEnum.L;
			case M:
				return ErrorCorrectionLevelEnum.M;
			case Q:
				return ErrorCorrectionLevelEnum.Q;
			case H:
				return ErrorCorrectionLevelEnum.H;
			default:
				throw new JasperDesignException("QrCodeErrorCorrectionLevel " + errorCorrectionLevel.name() + " not supported");
		}
	}

	public static String barbecueType(BarbecueType barbecueType) {
		if (barbecueType == null) {
			return null;
		}

		switch (barbecueType) {
			case BARCODE_2OF7:
				return "2of7";
			case BARCODE_3OF9:
				return "3of9";
			case BOOKLAND:
				return "Bookland";
			case CODABAR:
				return "Codabar";
			case CODE128:
				return "Code128";
			case CODE128A:
				return "Code128A";
			case CODE128B:
				return "Code128B";
			case CODE128C:
				return "Code128C";
			case CODE39:
				return "Code39";
			case CODE39_EXTENDED:
				return "Code39 (Extended)";
			case EAN128:
				return "EAN128";
			case EAN13:
				return "EAN13";
			case GLOBAL_TRADE_ITEM_NUMBER:
				return "GlobalTradeItemNumber";
			case INT_2OF5:
				return "Int2of5";
			case MONARCH:
				return "Monarch";
			case NW7:
				return "NW7";
			case PDF417:
				return "PDF417";
			case POSTNET:
				return "PostNet";
			case RANDOM_WEIGHT_UPCA:
				return "RandomWeightUPCA";
			case SCC14_SHIPPING_CODE:
				return "SCC14ShippingCode";
			case SHIPMENT_IDENTIFICATION_NUMBER:
				return "ShipmentIdentificationNumber";
			case SSCC18:
				return "SSCC18";
			case STD_2OF5:
				return "Std2of5";
			case UCC128:
				return "UCC128";
			case UPCA:
				return "UPCA";
			case USD3:
				return "USD3";
			case USD4:
				return "USD4";
			case USPS:
				return "USPS";
			default:
				throw new JasperDesignException("BarbecueType " + barbecueType.name() + " not supported");
		}
	}

	public static LineDirectionEnum lineDirection(LineDirection lineDirection) {
		if (lineDirection == null) {
			return null;
		}

		switch (lineDirection) {
			case TOP_DOWN:
				return LineDirectionEnum.TOP_DOWN;
			case BOTTOM_UP:
				return LineDirectionEnum.BOTTOM_UP;
			default:
				throw new JasperDesignException("LineDirection " + lineDirection.name() + " not supported");
		}
	}

	public static String markup(Markup markup) {
		if (markup == null) {
			return null;
		}

		switch (markup) {
			case NONE:
				return "none";
			case STYLED:
				return "styled";
			case RTF:
				return "rtf";
			case HTML:
				return "html";
			default:
				throw new JasperDesignException("Markup " + markup.name() + " not supported");
		}
	}

	public static LineSpacingEnum lineSpacing(LineSpacing lineSpacing) {
		if (lineSpacing == null) {
			return null;
		}

		switch (lineSpacing) {
			case SINGLE:
				return LineSpacingEnum.SINGLE;
			case ONE_AND_HALF:
				return LineSpacingEnum.ONE_AND_HALF;
			case DOUBLE:
				return LineSpacingEnum.DOUBLE;
			case AT_LEAST:
				return LineSpacingEnum.AT_LEAST;
			case FIXED:
				return LineSpacingEnum.FIXED;
			case PROPORTIONAL:
				return LineSpacingEnum.PROPORTIONAL;
			default:
				throw new JasperDesignException("LineSpacing " + lineSpacing.name() + " not supported");
		}
	}

	public static BreakTypeEnum breakType(BreakType breakType) {
		if (breakType == null) {
			return null;
		}

		switch (breakType) {
			case PAGE:
				return BreakTypeEnum.PAGE;
			case COLUMN:
				return BreakTypeEnum.COLUMN;
			default:
				throw new JasperDesignException("BreakType " + breakType.name() + " not supported");
		}
	}

	public static RunDirectionEnum runDirection(RunDirection runDirection) {
		if (runDirection == null) {
			return null;
		}

		switch (runDirection) {
			case LEFT_TO_RIGHT:
				return RunDirectionEnum.LTR;
			case RIGHT_TO_LEFT:
				return RunDirectionEnum.RTL;
			default:
				throw new JasperDesignException("RunDirection " + runDirection.name() + " not supported");
		}
	}

	public static CrosstabTotalPositionEnum crosstabTotalPosition(CrosstabTotalPosition totalPosition) {
		if (totalPosition == null) {
			return CrosstabTotalPositionEnum.NONE;
		}

		switch (totalPosition) {
			case START:
				return CrosstabTotalPositionEnum.START;
			case END:
				return CrosstabTotalPositionEnum.END;
			default:
				throw new JasperDesignException("CrosstabTotalPosition " + totalPosition.name() + " not supported");
		}
	}

	public static CrosstabPercentageEnum crosstabPercentageType(CrosstabPercentageType percentageType) {
		if (percentageType == null) {
			return null;
		}

		switch (percentageType) {
			case NONE:
				return CrosstabPercentageEnum.NONE;
			case GRAND_TOTAL:
				return CrosstabPercentageEnum.GRAND_TOTAL;
			default:
				throw new JasperDesignException("CrosstabPercentageType " + percentageType.name() + " not supported");
		}
	}

	public static SortOrderEnum orderType(OrderType orderType) {
		if (orderType == null) {
			return null;
		}

		switch (orderType) {
			case ASCENDING:
				return SortOrderEnum.ASCENDING;
			case DESCENDING:
				return SortOrderEnum.DESCENDING;
			default:
				throw new JasperDesignException("OrderType " + orderType.name() + " not supported");
		}
	}

	public static BucketOrder bucketOrderType(OrderType orderType) {
		if (orderType == null) {
			return null;
		}

		switch (orderType) {
			case ASCENDING:
				return BucketOrder.ASCENDING;
			case DESCENDING:
				return BucketOrder.DESCENDING;
			default:
				throw new JasperDesignException("OrderType " + orderType.name() + " not supported");
		}
	}

	public static PositionTypeEnum componentPositionType(ComponentPositionType componentPositionType) {
		switch (componentPositionType) {
			case FLOAT:
				return PositionTypeEnum.FLOAT;
			case FIX_RELATIVE_TO_TOP:
				return PositionTypeEnum.FIX_RELATIVE_TO_TOP;
			case FIX_RELATIVE_TO_BOTTOM:
				return PositionTypeEnum.FIX_RELATIVE_TO_BOTTOM;
			default:
				throw new JasperDesignException("ComponentPositionType " + componentPositionType.name() + " not supported");
		}
	}

	@SuppressWarnings("deprecation")
	public static StretchTypeEnum stretchType(StretchType stretchType) {
		if (stretchType == null) {
			return StretchTypeEnum.NO_STRETCH;
		}

		switch (stretchType) {
			case NO_STRETCH:
				return StretchTypeEnum.NO_STRETCH;
			case RELATIVE_TO_BAND_HEIGHT:
				return StretchTypeEnum.CONTAINER_HEIGHT;
			case RELATIVE_TO_TALLEST_OBJECT:
				return StretchTypeEnum.ELEMENT_GROUP_HEIGHT;
			case ELEMENT_GROUP_HEIGHT:
				return StretchTypeEnum.ELEMENT_GROUP_HEIGHT;
			case ELEMENT_GROUP_BOTTOM:
				return StretchTypeEnum.ELEMENT_GROUP_BOTTOM;
			case CONTAINER_HEIGHT:
				return StretchTypeEnum.CONTAINER_HEIGHT;
			case CONTAINER_BOTTOM:
				return StretchTypeEnum.CONTAINER_BOTTOM;
			default:
				throw new JasperDesignException("StretchType " + stretchType.name() + " not supported");
		}
	}

	public static HyperlinkTypeEnum hyperLinkType(String hyperLinkType) {
		if (hyperLinkType == null || !EnumUtils.isValidEnum(HyperLinkType.class, hyperLinkType)) {
			return null;
		}

		HyperLinkType type = HyperLinkType.valueOf(hyperLinkType);
		switch (type) {
			case NONE:
				return HyperlinkTypeEnum.NONE;
			case REFERENCE:
				return HyperlinkTypeEnum.REFERENCE;
			case LOCAL_ANCHOR:
				return HyperlinkTypeEnum.LOCAL_ANCHOR;
			case LOCAL_PAGE:
				return HyperlinkTypeEnum.LOCAL_PAGE;
			case REMOTE_ANCHOR:
				return HyperlinkTypeEnum.REMOTE_ANCHOR;
			case REMOTE_PAGE:
				return HyperlinkTypeEnum.REMOTE_PAGE;
			default:
				throw new JasperDesignException("HyperLinkType " + type.name() + " not supported");
		}
	}

	public static HyperlinkTargetEnum hyperLinkTarget(String hyperLinkTarget) {
		if (hyperLinkTarget == null || !EnumUtils.isValidEnum(HyperLinkTarget.class, hyperLinkTarget)) {
			return null;
		}

		HyperLinkTarget target = HyperLinkTarget.valueOf(hyperLinkTarget);
		switch (target) {
			case NONE:
				return HyperlinkTargetEnum.NONE;
			case SELF:
				return HyperlinkTargetEnum.SELF;
			case BLANK:
				return HyperlinkTargetEnum.BLANK;
			case PARENT:
				return HyperlinkTargetEnum.PARENT;
			case TOP:
				return HyperlinkTargetEnum.TOP;
			default:
				throw new JasperDesignException("HyperLinkTarget " + target.name() + " not supported");
		}
	}

	public static FooterPositionEnum groupFooterPosition(GroupFooterPosition footerPosition) {
		switch (footerPosition) {
			case NORMAL:
				return FooterPositionEnum.NORMAL;
			case COLLATE_AT_BOTTOM:
				return FooterPositionEnum.COLLATE_AT_BOTTOM;
			case FORCE_AT_BOTTOM:
				return FooterPositionEnum.FORCE_AT_BOTTOM;
			case STACK_AT_BOTTOM:
				return FooterPositionEnum.STACK_AT_BOTTOM;
			default:
				throw new JasperDesignException("GroupFooterPosition " + footerPosition.name() + " not supported");
		}
	}

	public static SpiderRotationEnum spiderRotation(SpiderRotation rotation) {
		if (rotation == null) {
			return null;
		}

		switch (rotation) {
			case CLOCKWISE:
				return SpiderRotationEnum.CLOCKWISE;
			case ANTICLOCKWISE:
				return SpiderRotationEnum.ANTICLOCKWISE;
			default:
				throw new JasperDesignException("SpiderRotation " + rotation.name() + " not supported");
		}
	}

	public static TableOrderEnum tableOrder(TableOrder tableOrder) {
		if (tableOrder == null) {
			return null;
		}

		switch (tableOrder) {
			case BY_ROW:
				return TableOrderEnum.BY_ROW;
			case BY_COLUMN:
				return TableOrderEnum.BY_COLUMN;
			default:
				throw new JasperDesignException("TableOrder " + tableOrder.name() + " not supported");
		}
	}

	public static TabStopAlignEnum tabStopAlignment(TabStopAlignment alignment) {
		switch (alignment) {
			case LEFT:
				return TabStopAlignEnum.LEFT;
			case CENTER:
				return TabStopAlignEnum.CENTER;
			case RIGHT:
				return TabStopAlignEnum.RIGHT;
			default:
				throw new JasperDesignException("TabStopAlignment " + alignment.name() + " not supported");
		}
	}

	protected static PrintOrderEnum printOrder(Orientation printOrder) {
		switch (printOrder) {
			case HORIZONTAL:
				return PrintOrderEnum.HORIZONTAL;
			case VERTICAL:
				return PrintOrderEnum.VERTICAL;
			default:
				throw new JasperDesignException("PrintOrder " + printOrder.name() + " not supported");
		}
	}

	public static ScaleTypeEnum scaleType(ScaleType scaleType) {
		switch (scaleType) {
			case ON_BOTH_AXES:
				return ScaleTypeEnum.ON_BOTH_AXES;
			case ON_DOMAIN_AXIS:
				return ScaleTypeEnum.ON_DOMAIN_AXIS;
			case ON_RANGE_AXIS:
				return ScaleTypeEnum.ON_RANGE_AXIS;
			default:
				throw new JasperDesignException("ScaleType " + scaleType.name() + " not supported");
		}
	}

	public static org.jfree.ui.RectangleAnchor rectangleAnchor(RectangleAnchor rectangleAnchor) {
		switch (rectangleAnchor) {
			case CENTER:
				return org.jfree.ui.RectangleAnchor.CENTER;
			case TOP:
				return org.jfree.ui.RectangleAnchor.TOP;
			case TOP_LEFT:
				return org.jfree.ui.RectangleAnchor.TOP_LEFT;
			case TOP_RIGHT:
				return org.jfree.ui.RectangleAnchor.TOP_RIGHT;
			case BOTTOM:
				return org.jfree.ui.RectangleAnchor.BOTTOM;
			case BOTTOM_LEFT:
				return org.jfree.ui.RectangleAnchor.BOTTOM_LEFT;
			case BOTTOM_RIGHT:
				return org.jfree.ui.RectangleAnchor.BOTTOM_RIGHT;
			case LEFT:
				return org.jfree.ui.RectangleAnchor.LEFT;
			case RIGHT:
				return org.jfree.ui.RectangleAnchor.RIGHT;
			default:
				throw new JasperDesignException("RectangleAnchor " + rectangleAnchor.name() + " not supported");
		}
	}
}
