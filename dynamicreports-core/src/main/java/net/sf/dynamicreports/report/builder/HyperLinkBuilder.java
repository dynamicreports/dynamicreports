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

package net.sf.dynamicreports.report.builder;

import net.sf.dynamicreports.report.base.DRHyperLink;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HyperLinkTarget;
import net.sf.dynamicreports.report.constant.HyperLinkType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * <p>HyperLinkBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class HyperLinkBuilder extends AbstractBuilder<HyperLinkBuilder, DRHyperLink> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for HyperLinkBuilder.</p>
	 */
	protected HyperLinkBuilder() {
		super(new DRHyperLink());
	}

	/**
	 * <p>Constructor for HyperLinkBuilder.</p>
	 *
	 * @param link a {@link java.lang.String} object.
	 */
	protected HyperLinkBuilder(String link) {
		super(new DRHyperLink());
		setLink(link);
	}

	/**
	 * <p>Constructor for HyperLinkBuilder.</p>
	 *
	 * @param linkExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	protected HyperLinkBuilder(DRIExpression<String> linkExpression) {
		super(new DRHyperLink());
		setLink(linkExpression);
	}

	/**
	 * <p>setLink.</p>
	 *
	 * @param link a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setLink(String link) {
		Validate.notNull(link, "link must not be null");
		return setLink(Expressions.text(link));
	}

	/**
	 * <p>setLink.</p>
	 *
	 * @param linkExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setLink(DRIExpression<String> linkExpression) {
		Validate.notNull(linkExpression, "linkExpression must not be null");
		getObject().setReferenceExpression(linkExpression);
		getObject().setType(HyperLinkType.REFERENCE.name());
		return this;
	}

	/**
	 * <p>setAnchor.</p>
	 *
	 * @param anchor a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setAnchor(String anchor) {
		getObject().setAnchorExpression(Expressions.text(anchor));
		return this;
	}

	/**
	 * <p>setAnchor.</p>
	 *
	 * @param anchorExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setAnchor(DRIExpression<String> anchorExpression) {
		getObject().setAnchorExpression(anchorExpression);
		return this;
	}

	/**
	 * <p>setPage.</p>
	 *
	 * @param page a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setPage(Integer page) {
		getObject().setPageExpression(Expressions.value(page));
		return this;
	}

	/**
	 * <p>setPage.</p>
	 *
	 * @param pageExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setPage(DRIExpression<Integer> pageExpression) {
		getObject().setPageExpression(pageExpression);
		return this;
	}

	/**
	 * <p>setReference.</p>
	 *
	 * @param reference a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setReference(String reference) {
		getObject().setReferenceExpression(Expressions.text(reference));
		return this;
	}

	/**
	 * <p>setReference.</p>
	 *
	 * @param referenceExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setReference(DRIExpression<String> referenceExpression) {
		getObject().setReferenceExpression(referenceExpression);
		return this;
	}

	/**
	 * <p>setTooltip.</p>
	 *
	 * @param tooltip a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setTooltip(String tooltip) {
		getObject().setTooltipExpression(Expressions.text(tooltip));
		return this;
	}

	/**
	 * <p>setTooltip.</p>
	 *
	 * @param tooltipExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setTooltip(DRIExpression<String> tooltipExpression) {
		getObject().setTooltipExpression(tooltipExpression);
		return this;
	}

	/**
	 * <p>setType.</p>
	 *
	 * @param hyperLinkType a {@link net.sf.dynamicreports.report.constant.HyperLinkType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setType(HyperLinkType hyperLinkType) {
		getObject().setType(hyperLinkType.name());
		return this;
	}

	/**
	 * <p>setType.</p>
	 *
	 * @param hyperLinkType a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setType(String hyperLinkType) {
		getObject().setType(hyperLinkType);
		return this;
	}

	/**
	 * <p>setTarget.</p>
	 *
	 * @param hyperLinkTarget a {@link net.sf.dynamicreports.report.constant.HyperLinkTarget} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setTarget(HyperLinkTarget hyperLinkTarget) {
		getObject().setTarget(hyperLinkTarget.name());
		return this;
	}

	/**
	 * <p>setTarget.</p>
	 *
	 * @param hyperLinkTarget a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public HyperLinkBuilder setTarget(String hyperLinkTarget) {
		getObject().setTarget(hyperLinkTarget);
		return this;
	}

	/**
	 * <p>getHyperLink.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.base.DRHyperLink} object.
	 */
	public DRHyperLink getHyperLink() {
		return build();
	}
}
