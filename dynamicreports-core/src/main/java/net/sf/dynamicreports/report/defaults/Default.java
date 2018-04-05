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

package net.sf.dynamicreports.report.defaults;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.sf.dynamicreports.report.base.DRMargin;
import net.sf.dynamicreports.report.base.datatype.DRDataType;
import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.base.style.DRPadding;
import net.sf.dynamicreports.report.base.style.DRSimpleStyle;
import net.sf.dynamicreports.report.base.style.DRStyle;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizer;
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;
import net.sf.dynamicreports.report.constant.CrosstabTotalPosition;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.Language;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.constant.TableOfContentsPosition;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.style.DRIStyle;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Default {
	private String reportName;
	private Locale locale;
	private boolean showColumnTitle;
	private boolean showColumnValues;
	private boolean ignorePagination;
	private WhenNoDataType whenNoDataType;
	private WhenResourceMissingType whenResourceMissingType;
	private boolean titleOnANewPage;
	private boolean summaryOnANewPage;
	private boolean summaryWithPageHeaderAndFooter;
	private boolean floatColumnFooter;
	private Orientation printOrder;
	private RunDirection columnDirection;
	private String language;
	private boolean useFieldNameAsDescription;
	// style
	private boolean highlightDetailOddRows;
	private DRSimpleStyle detailOddRowStyle;
	private boolean highlightDetailEvenRows;
	private DRSimpleStyle detailEvenRowStyle;
	private DRStyle textStyle;
	private DRStyle columnTitleStyle;
	private DRStyle columnStyle;
	private DRStyle groupTitleStyle;
	private DRStyle groupStyle;
	private DRStyle subtotalStyle;
	private DRStyle imageStyle;
	private DRStyle chartStyle;
	private DRStyle barcodeStyle;
	// page
	private int pageWidth;
	private int pageHeight;
	private PageOrientation pageOrientation;
	private DRMargin pageMargin;
	private DRMargin subreportPageMargin;
	private int pageColumnsPerPage;
	private int pageColumnSpace;
	private boolean ignorePageWidth;
	// column
	private boolean columnPrintRepeatedDetailValues;
	private int columnWidth;
	// component
	private boolean removeLineWhenBlank;
	private boolean printInFirstWholeBand;
	private boolean printWhenDetailOverflows;
	// group
	private GroupHeaderLayout groupHeaderLayout;
	private boolean groupHideColumn;
	private boolean groupShowColumnHeaderAndFooter;
	private int groupPadding;
	private boolean groupStartInNewPage;
	private boolean groupStartInNewColumn;
	private boolean groupReprintHeaderOnEachPage;
	private boolean groupResetPageNumber;
	private Integer groupMinHeightToStartNewPage;
	private GroupFooterPosition groupFooterPosition;
	private boolean groupKeepTogether;
	private boolean groupHeaderWithSubtotal;
	private boolean groupByDataType;
	// subtotal
	private Position subtotalLabelPosition;
	// table of contents
	private boolean tableOfContents;
	private DRITableOfContentsCustomizer tableOfContentsCustomizer;
	private boolean addGroupToTableOfContents;
	private TableOfContentsPosition tableOfContentsPosition;
	// text field
	private int textFieldWidth;
	private boolean textFieldPrintRepeatedValues;
	private boolean textFieldStretchWithOverflow;
	// image
	private int imageWidth;
	private int imageHeight;
	// filler
	private int fillerWidth;
	private int fillerHeight;
	// line
	private int lineWidth;
	private int lineHeight;
	// ellipse
	private int ellipseWidth;
	private int ellipseHeight;
	// rectangle
	private Integer rectangleRadius;
	private int rectangleWidth;
	private int rectangleHeight;
	// map
	private int mapWidth;
	private int mapHeight;
	// custom component
	private int customComponentWidth;
	private int customComponentHeight;
	// break
	private int breakWidth;
	private int breakHeight;
	// generic element
	private int genericElementWidth;
	private int genericElementHeight;
	// list
	private Integer listWidth;
	private Integer listHeight;
	private int listgap;
	private HorizontalCellComponentAlignment horizontalCellComponentAlignment;
	private VerticalCellComponentAlignment verticalCellComponentAlignment;
	// multi page list
	private int multiPageListWidth;
	private int multiPageListHeight;
	// chart
	private int chartWidth;
	private int chartHeight;
	private List<Color> chartSeriesColors;
	private String chartValuePattern;
	private String chartPercentValuePattern;
	private boolean chartCategoryDatasetUseSeriesAsCategory;
	private TimePeriod chartTimeSeriesDatasetTimePeriodType;
	private ValueLocation chartThermometerPlotValueLocation;
	private String chartTheme;
	// barcode
	private int barcodeWidth;
	private int barcodeHeight;
	// subreport
	private int subreportWidth;
	private int subreportHeight;
	// crosstab
	private int crosstabWidth;
	private int crosstabHeight;
	private CrosstabTotalPosition crosstabColumnGroupTotalPosition;
	private CrosstabTotalPosition crosstabRowGroupTotalPosition;
	private boolean crosstabColumnGroupShowTotal;
	private boolean crosstabRowGroupShowTotal;
	private int crosstabColumnGroupTotalHeaderMaxWidth;
	private int crosstabRowGroupHeaderMaxWidth;
	private int crosstabCellMaxWidth;
	private boolean crosstabHighlightOddRows;
	private DRSimpleStyle crosstabOddRowStyle;
	private boolean crosstabHighlightEvenRows;
	private DRSimpleStyle crosstabEvenRowStyle;
	private DRStyle crosstabGroupStyle;
	private DRStyle crosstabGroupTotalStyle;
	private DRStyle crosstabGrandTotalStyle;
	private DRStyle crosstabCellStyle;
	private DRStyle crosstabMeasureTitleStyle;
	private CrosstabPercentageType crosstabPercentageType;
	// boolean
	private BooleanComponentType booleanComponentType;
	private boolean booleanEmptyWhenNullValue;
	private int booleanImageWidth;
	private int booleanImageHeight;
	private DRStyle booleanColumnStyle;
	private HorizontalImageAlignment booleanHorizontalImageAlignment;
	// split
	private SplitType defaultSplitType;
	private SplitType titleSplitType;
	private SplitType pageHeaderSplitType;
	private SplitType pageFooterSplitType;
	private SplitType columnHeaderSplitType;
	private SplitType columnFooterSplitType;
	private SplitType groupHeaderSplitType;
	private SplitType groupFooterSplitType;
	private SplitType detailHeaderSplitType;
	private SplitType detailSplitType;
	private SplitType detailFooterSplitType;
	private SplitType lastPageFooterSplitType;
	private SplitType summarySplitType;
	private SplitType noDataSplitType;
	private SplitType backgroundSplitType;
	// band style
	private DRIStyle bandStyle;
	// band background component
	private DRIComponent bandBackgroundComponent;
	// font
	private DRFont font;
	// datatype
	private DRDataType<Number, BigDecimal> bigDecimalType;
	private DRDataType<Number, BigInteger> bigIntegerType;
	private DRDataType<Number, Byte> byteType;
	private DRDataType<Number, Double> doubleType;
	private DRDataType<Number, Float> floatType;
	private DRDataType<Number, Integer> integerType;
	private DRDataType<Number, Long> longType;
	private DRDataType<Number, Short> shortType;
	private DRDataType<Date, Date> dateType;
	private DRDataType<Date, Date> dateYearToMonthType;
	private DRDataType<Date, Date> dateYearToHourType;
	private DRDataType<Date, Date> dateYearToMinuteType;
	private DRDataType<Date, Date> dateYearToSecondType;
	private DRDataType<Date, Date> dateYearToFractionType;
	private DRDataType<Date, Date> dateYearType;
	private DRDataType<Date, Date> dateMonthType;
	private DRDataType<Date, Date> dateDayType;
	private DRDataType<Date, Date> timeHourToMinuteType;
	private DRDataType<Date, Date> timeHourToSecondType;
	private DRDataType<Date, Date> timeHourToFractionType;
	private DRDataType<Number, Double> percentageType;
	private DRDataType<Boolean, Boolean> booleanType;
	private DRDataType<Character, Character> characterType;
	private DRDataType<String, String> stringType;
	private HorizontalTextAlignment pageXofYHorizontalTextAlignment;
	// system fonts
	private boolean loadSystemFonts;

	public Default() {
		init();
	}

	private void init() {
		this.reportName = "Report";
		this.locale = Locale.getDefault();
		this.showColumnTitle = true;
		this.showColumnValues = true;
		this.ignorePagination = false;
		this.whenNoDataType = WhenNoDataType.NO_PAGES;
		this.whenResourceMissingType = WhenResourceMissingType.NULL;
		this.titleOnANewPage = false;
		this.summaryOnANewPage = false;
		this.summaryWithPageHeaderAndFooter = false;
		this.floatColumnFooter = false;
		this.printOrder = Orientation.VERTICAL;
		this.columnDirection = RunDirection.LEFT_TO_RIGHT;
		this.language = Language.JAVA;
		this.useFieldNameAsDescription = true;

		this.highlightDetailOddRows = false;
		this.detailOddRowStyle = new DRSimpleStyle();
		detailOddRowStyle.setBackgroundColor(new Color(200, 200, 200));
		this.highlightDetailEvenRows = false;
		this.detailEvenRowStyle = new DRSimpleStyle();
		detailEvenRowStyle.setBackgroundColor(new Color(240, 240, 240));

		this.textStyle = new DRStyle();
		textStyle.setForegroundColor(Color.BLACK);
		textStyle.setPadding(new DRPadding(2));

		this.columnTitleStyle = null;
		this.columnStyle = null;
		this.groupTitleStyle = null;
		this.groupStyle = null;
		this.subtotalStyle = null;
		this.imageStyle = new DRStyle();
		imageStyle.setImageScale(ImageScale.RETAIN_SHAPE);
		this.chartStyle = null;
		this.barcodeStyle = null;

		this.pageWidth = PageType.A4.getWidth();
		this.pageHeight = PageType.A4.getHeight();
		this.pageOrientation = PageOrientation.PORTRAIT;
		this.pageMargin = new DRMargin(10);
		this.subreportPageMargin = new DRMargin(0);
		this.pageColumnsPerPage = 1;
		this.pageColumnSpace = 0;
		this.ignorePageWidth = false;

		this.columnPrintRepeatedDetailValues = true;
		this.columnWidth = 100;

		this.removeLineWhenBlank = false;
		this.printInFirstWholeBand = false;
		this.printWhenDetailOverflows = false;

		this.groupHeaderLayout = GroupHeaderLayout.VALUE;
		this.groupHideColumn = true;
		this.groupShowColumnHeaderAndFooter = false;
		this.groupPadding = 10;
		this.groupStartInNewPage = false;
		this.groupStartInNewColumn = false;
		this.groupReprintHeaderOnEachPage = false;
		this.groupResetPageNumber = false;
		this.groupMinHeightToStartNewPage = null;
		this.groupFooterPosition = GroupFooterPosition.NORMAL;
		this.groupKeepTogether = false;
		this.groupHeaderWithSubtotal = false;
		this.groupByDataType = false;

		this.subtotalLabelPosition = Position.TOP;

		this.tableOfContents = false;
		this.tableOfContentsCustomizer = new TableOfContentsCustomizer();
		this.addGroupToTableOfContents = true;
		this.tableOfContentsPosition = TableOfContentsPosition.TOP;

		this.textFieldWidth = 100;
		this.textFieldPrintRepeatedValues = true;
		this.textFieldStretchWithOverflow = true;

		this.imageWidth = 100;
		this.imageHeight = 100;

		this.fillerWidth = 0;
		this.fillerHeight = 0;

		this.lineWidth = 1;
		this.lineHeight = 1;

		this.ellipseWidth = 100;
		this.ellipseHeight = 100;

		this.rectangleRadius = null;
		this.rectangleWidth = 100;
		this.rectangleHeight = 100;

		this.mapWidth = 200;
		this.mapHeight = 200;

		this.customComponentWidth = 200;
		this.customComponentHeight = 200;

		this.breakWidth = 1;
		this.breakHeight = 1;

		this.genericElementWidth = 100;
		this.genericElementHeight = 100;

		this.genericElementWidth = 100;
		this.genericElementHeight = 100;

		this.listWidth = null;
		this.listHeight = null;
		this.listgap = 0;
		this.horizontalCellComponentAlignment = HorizontalCellComponentAlignment.FLOAT;
		this.verticalCellComponentAlignment = VerticalCellComponentAlignment.EXPAND;

		this.multiPageListWidth = 200;
		this.multiPageListHeight = 0;

		this.chartWidth = 200;
		this.chartHeight = 200;
		this.chartSeriesColors = new ArrayList<Color>();
		this.chartValuePattern = "#,##0.##";
		this.chartPercentValuePattern = "#,##0.##";
		this.chartCategoryDatasetUseSeriesAsCategory = false;
		this.chartTimeSeriesDatasetTimePeriodType = TimePeriod.DAY;
		this.chartThermometerPlotValueLocation = ValueLocation.NONE;
		this.chartTheme = null;

		this.barcodeWidth = 100;
		this.barcodeHeight = 100;

		this.subreportWidth = 200;
		this.subreportHeight = 0;

		this.crosstabWidth = 200;
		this.crosstabHeight = 0;
		this.crosstabColumnGroupTotalPosition = CrosstabTotalPosition.END;
		this.crosstabRowGroupTotalPosition = CrosstabTotalPosition.END;
		this.crosstabColumnGroupShowTotal = true;
		this.crosstabRowGroupShowTotal = true;
		this.crosstabColumnGroupTotalHeaderMaxWidth = 150;
		this.crosstabRowGroupHeaderMaxWidth = 150;
		this.crosstabCellMaxWidth = 150;
		this.crosstabHighlightOddRows = false;
		this.crosstabOddRowStyle = new DRSimpleStyle();
		crosstabOddRowStyle.setBackgroundColor(new Color(200, 200, 200));
		this.crosstabHighlightEvenRows = false;
		this.crosstabEvenRowStyle = new DRSimpleStyle();
		crosstabEvenRowStyle.setBackgroundColor(new Color(240, 240, 240));
		this.crosstabGroupStyle = null;
		this.crosstabGroupTotalStyle = null;
		this.crosstabGrandTotalStyle = null;
		this.crosstabCellStyle = null;
		this.crosstabMeasureTitleStyle = null;
		this.crosstabPercentageType = CrosstabPercentageType.NONE;

		this.booleanComponentType = BooleanComponentType.TEXT_TRUE_FALSE;
		this.booleanEmptyWhenNullValue = false;
		this.booleanImageWidth = 14;
		this.booleanImageHeight = 14;
		this.booleanColumnStyle = null;
		this.booleanHorizontalImageAlignment = HorizontalImageAlignment.CENTER;

		this.pageXofYHorizontalTextAlignment = HorizontalTextAlignment.CENTER;

		this.defaultSplitType = null;
		this.titleSplitType = null;
		this.pageHeaderSplitType = null;
		this.pageFooterSplitType = null;
		this.columnHeaderSplitType = null;
		this.columnFooterSplitType = null;
		this.groupHeaderSplitType = null;
		this.groupFooterSplitType = null;
		this.detailHeaderSplitType = null;
		this.detailSplitType = null;
		this.detailFooterSplitType = null;
		this.lastPageFooterSplitType = null;
		this.summarySplitType = null;
		this.noDataSplitType = null;
		this.backgroundSplitType = null;

		this.bandStyle = null;

		this.bandBackgroundComponent = null;

		this.font = new DRFont("SansSerif", 10);

		this.bigDecimalType = new DRDataType<Number, BigDecimal>("#,##0.00#", HorizontalTextAlignment.RIGHT);
		this.bigIntegerType = new DRDataType<Number, BigInteger>("#,##0", HorizontalTextAlignment.RIGHT);
		this.byteType = new DRDataType<Number, Byte>("#,##0", HorizontalTextAlignment.RIGHT);
		this.doubleType = new DRDataType<Number, Double>("#,##0.#", HorizontalTextAlignment.RIGHT);
		this.floatType = new DRDataType<Number, Float>("#,##0.#", HorizontalTextAlignment.RIGHT);
		this.integerType = new DRDataType<Number, Integer>("#,##0", HorizontalTextAlignment.RIGHT);
		this.longType = new DRDataType<Number, Long>("#,##0", HorizontalTextAlignment.RIGHT);
		this.shortType = new DRDataType<Number, Short>("#,##0", HorizontalTextAlignment.RIGHT);
		this.dateType = new DRDataType<Date, Date>("MM/dd/yyyy", HorizontalTextAlignment.RIGHT);
		this.dateYearToMonthType = new DRDataType<Date, Date>("MM/yyyy", HorizontalTextAlignment.RIGHT);
		this.dateYearToHourType = new DRDataType<Date, Date>("MM/dd/yyyy h a", HorizontalTextAlignment.RIGHT);
		this.dateYearToMinuteType = new DRDataType<Date, Date>("MM/dd/yyyy h:mm a", HorizontalTextAlignment.RIGHT);
		this.dateYearToSecondType = new DRDataType<Date, Date>("MM/dd/yyyy h:mm:ss a", HorizontalTextAlignment.RIGHT);
		this.dateYearToFractionType = new DRDataType<Date, Date>("MM/dd/yyyy h:mm:ss,SSS a", HorizontalTextAlignment.RIGHT);
		this.dateYearType = new DRDataType<Date, Date>("yyyy", HorizontalTextAlignment.RIGHT);
		this.dateMonthType = new DRDataType<Date, Date>("MMMM", HorizontalTextAlignment.RIGHT);
		this.dateDayType = new DRDataType<Date, Date>("dd", HorizontalTextAlignment.RIGHT);
		this.timeHourToMinuteType = new DRDataType<Date, Date>("h:mm a", HorizontalTextAlignment.RIGHT);
		this.timeHourToSecondType = new DRDataType<Date, Date>("h:mm:ss a", HorizontalTextAlignment.RIGHT);
		this.timeHourToFractionType = new DRDataType<Date, Date>("h:mm:ss,SSS a", HorizontalTextAlignment.RIGHT);
		this.percentageType = new DRDataType<Number, Double>("#,##0.00%", HorizontalTextAlignment.RIGHT);
		this.booleanType = new DRDataType<Boolean, Boolean>(null, HorizontalTextAlignment.CENTER);
		this.characterType = new DRDataType<Character, Character>(null, HorizontalTextAlignment.LEFT);
		this.stringType = new DRDataType<String, String>(null, HorizontalTextAlignment.LEFT);

		this.loadSystemFonts = true;
	}

	public String getReportName() {
		return reportName;
	}

	public Locale getLocale() {
		return locale;
	}

	public boolean isShowColumnTitle() {
		return showColumnTitle;
	}

	public boolean isShowColumnValues() {
		return showColumnValues;
	}

	public boolean isIgnorePagination() {
		return ignorePagination;
	}

	public WhenNoDataType getWhenNoDataType() {
		return whenNoDataType;
	}

	public WhenResourceMissingType getWhenResourceMissingType() {
		return whenResourceMissingType;
	}

	public boolean isTitleOnANewPage() {
		return titleOnANewPage;
	}

	public boolean isSummaryOnANewPage() {
		return summaryOnANewPage;
	}

	public boolean isSummaryWithPageHeaderAndFooter() {
		return summaryWithPageHeaderAndFooter;
	}

	public boolean isFloatColumnFooter() {
		return floatColumnFooter;
	}

	public Orientation getPrintOrder() {
		return printOrder;
	}

	public RunDirection getColumnDirection() {
		return columnDirection;
	}

	public String getLanguage() {
		return language;
	}

	public boolean isUseFieldNameAsDescription() {
		return useFieldNameAsDescription;
	}

	public boolean isHighlightDetailOddRows() {
		return highlightDetailOddRows;
	}

	public DRSimpleStyle getDetailOddRowStyle() {
		return detailOddRowStyle;
	}

	public boolean isHighlightDetailEvenRows() {
		return highlightDetailEvenRows;
	}

	public DRSimpleStyle getDetailEvenRowStyle() {
		return detailEvenRowStyle;
	}

	public DRStyle getTextStyle() {
		return textStyle;
	}

	public DRStyle getColumnTitleStyle() {
		return columnTitleStyle;
	}

	public DRStyle getColumnStyle() {
		return columnStyle;
	}

	public DRStyle getGroupTitleStyle() {
		return groupTitleStyle;
	}

	public DRStyle getGroupStyle() {
		return groupStyle;
	}

	public DRStyle getSubtotalStyle() {
		return subtotalStyle;
	}

	public DRStyle getImageStyle() {
		return imageStyle;
	}

	public DRStyle getChartStyle() {
		return chartStyle;
	}

	public DRStyle getBarcodeStyle() {
		return barcodeStyle;
	}

	public int getPageWidth() {
		return pageWidth;
	}

	public int getPageHeight() {
		return pageHeight;
	}

	public PageOrientation getPageOrientation() {
		return pageOrientation;
	}

	public DRMargin getPageMargin() {
		return pageMargin;
	}

	public DRMargin getSubreportPageMargin() {
		return subreportPageMargin;
	}

	public int getPageColumnsPerPage() {
		return pageColumnsPerPage;
	}

	public int getPageColumnSpace() {
		return pageColumnSpace;
	}

	public boolean isIgnorePageWidth() {
		return ignorePageWidth;
	}

	public boolean isColumnPrintRepeatedDetailValues() {
		return columnPrintRepeatedDetailValues;
	}

	public int getColumnWidth() {
		return columnWidth;
	}

	public boolean isRemoveLineWhenBlank() {
		return removeLineWhenBlank;
	}

	public boolean isPrintInFirstWholeBand() {
		return printInFirstWholeBand;
	}

	public boolean isPrintWhenDetailOverflows() {
		return printWhenDetailOverflows;
	}

	public GroupHeaderLayout getGroupHeaderLayout() {
		return groupHeaderLayout;
	}

	public boolean isGroupHideColumn() {
		return groupHideColumn;
	}

	public boolean isGroupShowColumnHeaderAndFooter() {
		return groupShowColumnHeaderAndFooter;
	}

	public int getGroupPadding() {
		return groupPadding;
	}

	public boolean isGroupStartInNewPage() {
		return groupStartInNewPage;
	}

	public boolean isGroupStartInNewColumn() {
		return groupStartInNewColumn;
	}

	public boolean isGroupReprintHeaderOnEachPage() {
		return groupReprintHeaderOnEachPage;
	}

	public boolean isGroupResetPageNumber() {
		return groupResetPageNumber;
	}

	public Integer getGroupMinHeightToStartNewPage() {
		return groupMinHeightToStartNewPage;
	}

	public GroupFooterPosition getGroupFooterPosition() {
		return groupFooterPosition;
	}

	public boolean isGroupKeepTogether() {
		return groupKeepTogether;
	}

	public boolean isGroupHeaderWithSubtotal() {
		return groupHeaderWithSubtotal;
	}

	public boolean isGroupByDataType() {
		return groupByDataType;
	}

	public Position getSubtotalLabelPosition() {
		return subtotalLabelPosition;
	}

	public boolean isTableOfContents() {
		return tableOfContents;
	}

	public DRITableOfContentsCustomizer getTableOfContentsCustomizer() {
		return tableOfContentsCustomizer;
	}

	public boolean isAddGroupToTableOfContents() {
		return addGroupToTableOfContents;
	}

	public TableOfContentsPosition getTableOfContentsPosition() {
		return tableOfContentsPosition;
	}

	public int getTextFieldWidth() {
		return textFieldWidth;
	}

	public boolean isTextFieldPrintRepeatedValues() {
		return textFieldPrintRepeatedValues;
	}

	public boolean isTextFieldStretchWithOverflow() {
		return textFieldStretchWithOverflow;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public int getFillerWidth() {
		return fillerWidth;
	}

	public int getFillerHeight() {
		return fillerHeight;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public int getLineHeight() {
		return lineHeight;
	}

	public int getEllipseWidth() {
		return ellipseWidth;
	}

	public int getEllipseHeight() {
		return ellipseHeight;
	}

	public Integer getRectangleRadius() {
		return rectangleRadius;
	}

	public int getRectangleWidth() {
		return rectangleWidth;
	}

	public int getRectangleHeight() {
		return rectangleHeight;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public int getCustomComponentWidth() {
		return customComponentWidth;
	}

	public int getCustomComponentHeight() {
		return customComponentHeight;
	}

	public int getBreakWidth() {
		return breakWidth;
	}

	public int getBreakHeight() {
		return breakHeight;
	}

	public Integer getGenericElementWidth() {
		return genericElementWidth;
	}

	public Integer getGenericElementHeight() {
		return genericElementHeight;
	}

	public Integer getListWidth() {
		return listWidth;
	}

	public Integer getListHeight() {
		return listHeight;
	}

	public int getListgap() {
		return listgap;
	}

	public HorizontalCellComponentAlignment getHorizontalCellComponentAlignment() {
		return horizontalCellComponentAlignment;
	}

	public VerticalCellComponentAlignment getVerticalCellComponentAlignment() {
		return verticalCellComponentAlignment;
	}

	public int getMultiPageListWidth() {
		return multiPageListWidth;
	}

	public int getMultiPageListHeight() {
		return multiPageListHeight;
	}

	public int getChartWidth() {
		return chartWidth;
	}

	public int getChartHeight() {
		return chartHeight;
	}

	public List<Color> getChartSeriesColors() {
		return chartSeriesColors;
	}

	public String getChartValuePattern() {
		return chartValuePattern;
	}

	public String getChartPercentValuePattern() {
		return chartPercentValuePattern;
	}

	public boolean isChartCategoryDatasetUseSeriesAsCategory() {
		return chartCategoryDatasetUseSeriesAsCategory;
	}

	public TimePeriod getChartTimeSeriesDatasetTimePeriodType() {
		return chartTimeSeriesDatasetTimePeriodType;
	}

	public ValueLocation getChartThermometerPlotValueLocation() {
		return chartThermometerPlotValueLocation;
	}

	public String getChartTheme() {
		return chartTheme;
	}

	public int getBarcodeWidth() {
		return barcodeWidth;
	}

	public int getBarcodeHeight() {
		return barcodeHeight;
	}

	public int getSubreportWidth() {
		return subreportWidth;
	}

	public int getSubreportHeight() {
		return subreportHeight;
	}

	public int getCrosstabWidth() {
		return crosstabWidth;
	}

	public int getCrosstabHeight() {
		return crosstabHeight;
	}

	public CrosstabTotalPosition getCrosstabColumnGroupTotalPosition() {
		return crosstabColumnGroupTotalPosition;
	}

	public CrosstabTotalPosition getCrosstabRowGroupTotalPosition() {
		return crosstabRowGroupTotalPosition;
	}

	public boolean isCrosstabColumnGroupShowTotal() {
		return crosstabColumnGroupShowTotal;
	}

	public boolean isCrosstabRowGroupShowTotal() {
		return crosstabRowGroupShowTotal;
	}

	public int getCrosstabColumnGroupTotalHeaderMaxWidth() {
		return crosstabColumnGroupTotalHeaderMaxWidth;
	}

	public int getCrosstabRowGroupHeaderMaxWidth() {
		return crosstabRowGroupHeaderMaxWidth;
	}

	public int getCrosstabCellMaxWidth() {
		return crosstabCellMaxWidth;
	}

	public DRSimpleStyle getCrosstabOddRowStyle() {
		return crosstabOddRowStyle;
	}

	public DRSimpleStyle getCrosstabEvenRowStyle() {
		return crosstabEvenRowStyle;
	}

	public boolean isCrosstabHighlightOddRows() {
		return crosstabHighlightOddRows;
	}

	public boolean isCrosstabHighlightEvenRows() {
		return crosstabHighlightEvenRows;
	}

	public DRStyle getCrosstabGroupStyle() {
		return crosstabGroupStyle;
	}

	public DRStyle getCrosstabGroupTotalStyle() {
		return crosstabGroupTotalStyle;
	}

	public DRStyle getCrosstabGrandTotalStyle() {
		return crosstabGrandTotalStyle;
	}

	public DRStyle getCrosstabCellStyle() {
		return crosstabCellStyle;
	}

	public DRStyle getCrosstabMeasureTitleStyle() {
		return crosstabMeasureTitleStyle;
	}

	public CrosstabPercentageType getCrosstabPercentageType() {
		return crosstabPercentageType;
	}

	public BooleanComponentType getBooleanComponentType() {
		return booleanComponentType;
	}

	public boolean isBooleanEmptyWhenNullValue() {
		return booleanEmptyWhenNullValue;
	}

	public int getBooleanImageWidth() {
		return booleanImageWidth;
	}

	public int getBooleanImageHeight() {
		return booleanImageHeight;
	}

	public DRIStyle getBooleanColumnStyle() {
		return booleanColumnStyle;
	}

	public HorizontalImageAlignment getBooleanHorizontalImageAlignment() {
		return booleanHorizontalImageAlignment;
	}

	public SplitType getDefaultSplitType() {
		return defaultSplitType;
	}

	public SplitType getTitleSplitType() {
		return titleSplitType;
	}

	public SplitType getPageHeaderSplitType() {
		return pageHeaderSplitType;
	}

	public SplitType getPageFooterSplitType() {
		return pageFooterSplitType;
	}

	public SplitType getColumnHeaderSplitType() {
		return columnHeaderSplitType;
	}

	public SplitType getColumnFooterSplitType() {
		return columnFooterSplitType;
	}

	public SplitType getGroupHeaderSplitType() {
		return groupHeaderSplitType;
	}

	public SplitType getGroupFooterSplitType() {
		return groupFooterSplitType;
	}

	public SplitType getDetailHeaderSplitType() {
		return detailHeaderSplitType;
	}

	public SplitType getDetailSplitType() {
		return detailSplitType;
	}

	public SplitType getDetailFooterSplitType() {
		return detailFooterSplitType;
	}

	public SplitType getLastPageFooterSplitType() {
		return lastPageFooterSplitType;
	}

	public SplitType getSummarySplitType() {
		return summarySplitType;
	}

	public SplitType getNoDataSplitType() {
		return noDataSplitType;
	}

	public SplitType getBackgroundSplitType() {
		return backgroundSplitType;
	}

	public DRIStyle getBandStyle() {
		return bandStyle;
	}

	public DRIComponent getBandBackgroundComponent() {
		return bandBackgroundComponent;
	}

	public DRFont getFont() {
		return font;
	}

	public DRDataType<Number, BigDecimal> getBigDecimalType() {
		return bigDecimalType;
	}

	public DRDataType<Number, BigInteger> getBigIntegerType() {
		return bigIntegerType;
	}

	public DRDataType<Number, Byte> getByteType() {
		return byteType;
	}

	public DRDataType<Number, Double> getDoubleType() {
		return doubleType;
	}

	public DRDataType<Number, Float> getFloatType() {
		return floatType;
	}

	public DRDataType<Number, Integer> getIntegerType() {
		return integerType;
	}

	public DRDataType<Number, Long> getLongType() {
		return longType;
	}

	public DRDataType<Number, Short> getShortType() {
		return shortType;
	}

	public DRDataType<Date, Date> getDateType() {
		return dateType;
	}

	public DRDataType<Date, Date> getDateYearToMonthType() {
		return dateYearToMonthType;
	}

	public DRDataType<Date, Date> getDateYearToHourType() {
		return dateYearToHourType;
	}

	public DRDataType<Date, Date> getDateYearToMinuteType() {
		return dateYearToMinuteType;
	}

	public DRDataType<Date, Date> getDateYearToSecondType() {
		return dateYearToSecondType;
	}

	public DRDataType<Date, Date> getDateYearToFractionType() {
		return dateYearToFractionType;
	}

	public DRDataType<Date, Date> getDateYearType() {
		return dateYearType;
	}

	public DRDataType<Date, Date> getDateMonthType() {
		return dateMonthType;
	}

	public DRDataType<Date, Date> getDateDayType() {
		return dateDayType;
	}

	public DRDataType<Date, Date> getTimeHourToMinuteType() {
		return timeHourToMinuteType;
	}

	public DRDataType<Date, Date> getTimeHourToSecondType() {
		return timeHourToSecondType;
	}

	public DRDataType<Date, Date> getTimeHourToFractionType() {
		return timeHourToFractionType;
	}

	public DRDataType<Number, Double> getPercentageType() {
		return percentageType;
	}

	public DRDataType<Boolean, Boolean> getBooleanType() {
		return booleanType;
	}

	public DRDataType<Character, Character> getCharacterType() {
		return characterType;
	}

	public DRDataType<String, String> getStringType() {
		return stringType;
	}

	public HorizontalTextAlignment getPageXofYHorizontalTextAlignment() {
		return pageXofYHorizontalTextAlignment;
	}

	public boolean isLoadSystemFonts() {
		return loadSystemFonts;
	}

	protected void setLoadSystemFonts(boolean loadSystemFonts) {
		this.loadSystemFonts = loadSystemFonts;
	}

}
