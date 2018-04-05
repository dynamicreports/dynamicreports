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

package net.sf.dynamicreports.jasper.base.templatedesign;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.jasper.transformation.ConstantTransform;
import net.sf.dynamicreports.report.base.DRField;
import net.sf.dynamicreports.report.base.DRMargin;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.DRIMargin;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRBand;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.xml.JRXmlWriter;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperTemplateDesign implements DRITemplateDesign<JasperDesign> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private JasperDesign jasperDesign;
	private List<DRIField<?>> fields;
	private DRMargin margin;
	private transient ByteArrayOutputStream templateDesign;

	public JasperTemplateDesign(JasperDesign jasperDesign) throws DRException {
		init(jasperDesign);
	}

	public JasperTemplateDesign(File file) throws DRException {
		Validate.notNull(file, "file must not be null");
		try {
			init(JRXmlLoader.load(file));
		} catch (JRException e) {
			throw new DRException(e);
		}
	}

	public JasperTemplateDesign(String fileName) throws DRException {
		Validate.notNull(fileName, "fileName must not be null");
		try {
			init(JRXmlLoader.load(fileName));
		} catch (JRException e) {
			throw new DRException(e);
		}
	}

	public JasperTemplateDesign(InputStream inputStream) throws DRException {
		Validate.notNull(inputStream, "inputStream must not be null");
		try {
			init(JRXmlLoader.load(inputStream));
		} catch (JRException e) {
			throw new DRException(e);
		}
	}

	public JasperTemplateDesign(URL url) throws DRException {
		Validate.notNull(url, "url must not be null");
		try {
			init(JRXmlLoader.load(url.openStream()));
		} catch (JRException e) {
			throw new DRException(e);
		} catch (IOException e) {
			throw new DRException(e);
		}
	}

	private void init(JasperDesign jasperDesign) throws DRException {
		Validate.notNull(jasperDesign, "jasperDesign must not be null");
		this.jasperDesign = jasperDesign;

		this.fields = new ArrayList<DRIField<?>>();
		for (JRField jrField : jasperDesign.getFields()) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			DRField<?> field = new DRField(jrField.getName(), jrField.getValueClass());
			fields.add(field);
		}

		this.margin = new DRMargin();
		margin.setTop(jasperDesign.getTopMargin());
		margin.setLeft(jasperDesign.getLeftMargin());
		margin.setBottom(jasperDesign.getBottomMargin());
		margin.setRight(jasperDesign.getRightMargin());
	}

	@Override
	public String getReportName() {
		return jasperDesign.getName();
	}

	@Override
	public List<DRIField<?>> getFields() {
		return fields;
	}

	@Override
	public boolean isDefinedParameter(String name) {
		JRParameter parameter = jasperDesign.getParametersMap().get(name);
		return parameter != null;
	}

	@Override
	public String getResourceBundleName() {
		return jasperDesign.getResourceBundle();
	}

	@Override
	public Boolean getIgnorePagination() {
		return jasperDesign.isIgnorePagination();
	}

	@Override
	public WhenNoDataType getWhenNoDataType() {
		return ConstantTransform.whenNoDataType(jasperDesign.getWhenNoDataTypeValue());
	}

	@Override
	public WhenResourceMissingType getWhenResourceMissingType() {
		return ConstantTransform.whenResourceMissingType(jasperDesign.getWhenResourceMissingTypeValue());
	}

	@Override
	public Boolean getTitleOnANewPage() {
		return jasperDesign.isTitleNewPage();
	}

	@Override
	public Boolean getSummaryOnANewPage() {
		return jasperDesign.isSummaryNewPage();
	}

	@Override
	public Boolean getSummaryWithPageHeaderAndFooter() {
		return jasperDesign.isSummaryWithPageHeaderAndFooter();
	}

	@Override
	public Boolean getFloatColumnFooter() {
		return jasperDesign.isFloatColumnFooter();
	}

	@Override
	public Integer getPageWidth() {
		return jasperDesign.getPageWidth();
	}

	@Override
	public Integer getPageHeight() {
		return jasperDesign.getPageHeight();
	}

	@Override
	public PageOrientation getPageOrientation() {
		return ConstantTransform.pageOrientation(jasperDesign.getOrientationValue());
	}

	@Override
	public DRIMargin getPageMargin() {
		return margin;
	}

	@Override
	public Integer getPageColumnsPerPage() {
		return jasperDesign.getColumnCount();
	}

	@Override
	public Integer getPageColumnSpace() {
		return jasperDesign.getColumnSpacing();
	}

	@Override
	public Integer getPageColumnWidth() {
		return jasperDesign.getColumnWidth();
	}

	@Override
	public int getTitleComponentsCount() {
		return getBandComponentsCount(jasperDesign.getTitle());
	}

	@Override
	public int getPageHeaderComponentsCount() {
		return getBandComponentsCount(jasperDesign.getPageHeader());
	}

	@Override
	public int getPageFooterComponentsCount() {
		return getBandComponentsCount(jasperDesign.getPageFooter());
	}

	@Override
	public int getColumnHeaderComponentsCount() {
		return getBandComponentsCount(jasperDesign.getColumnHeader());
	}

	@Override
	public int getColumnFooterComponentsCount() {
		return getBandComponentsCount(jasperDesign.getColumnFooter());
	}

	@Override
	public int getLastPageFooterComponentsCount() {
		return getBandComponentsCount(jasperDesign.getLastPageFooter());
	}

	@Override
	public int getSummaryComponentsCount() {
		return getBandComponentsCount(jasperDesign.getSummary());
	}

	@Override
	public int getNoDataComponentsCount() {
		return getBandComponentsCount(jasperDesign.getNoData());
	}

	@Override
	public int getBackgroundComponentsCount() {
		return getBandComponentsCount(jasperDesign.getBackground());
	}

	private int getBandComponentsCount(JRBand band) {
		if (band != null && band.getElements() != null) {
			return band.getElements().length;
		}
		return 0;
	}

	@Override
	public JasperDesign getDesign() throws DRException {
		try {
			if (templateDesign == null) {
				templateDesign = new ByteArrayOutputStream();
				JRXmlWriter.writeReport(jasperDesign, templateDesign, "UTF-8");
			}

			return JRXmlLoader.load(new ByteArrayInputStream(templateDesign.toByteArray()));
		} catch (JRException e) {
			throw new DRException(e);
		}
	}
}
