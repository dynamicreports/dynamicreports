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
package net.sf.dynamicreports.site;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.AbstractJasperExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@Aspect
public class ExamplesAspect {
	private static String name = "";

	@Around("show()")
	public JasperReportBuilder show(ProceedingJoinPoint pjp) throws Throwable {
		JasperReportBuilder reportBuilder = (JasperReportBuilder) pjp.getTarget();
		GenerateSite.generateExampleImage(name, reportBuilder);
		return reportBuilder;
	}

	@Pointcut("execution(public net.sf.dynamicreports.jasper.builder.JasperReportBuilder net.sf.dynamicreports.jasper.builder.JasperReportBuilder.show())")
	public void show() {
	}

	@Around("build()")
	public void build(ProceedingJoinPoint pjp) throws Throwable {
		Class<?> design = pjp.getSignature().getDeclaringType();
		name = design.getSimpleName();
		if (StringUtils.endsWith(name, "Design")) {
			name = StringUtils.substringBeforeLast(name, "Design");
		}
		String path = design.getName().substring(Templates.class.getPackage().getName().length() + 1).split("\\.")[0];
		GenerateSite.addExample(name, path, design);
		pjp.proceed();
	}

	@Pointcut("execution(void net.sf.dynamicreports.examples..main(*))")
	public void build() {
	}

	@Around("export()")
	public JasperReportBuilder to(ProceedingJoinPoint pjp) throws Throwable {
		JasperReportBuilder reportBuilder = (JasperReportBuilder) pjp.getTarget();
		GenerateSite.generateExampleImage(name, reportBuilder, (AbstractJasperExporterBuilder<?, ?>) pjp.getArgs()[0]);
		return reportBuilder;
	}

	@Pointcut("execution(public net.sf.dynamicreports.jasper.builder.JasperReportBuilder net.sf.dynamicreports.jasper.builder.JasperReportBuilder.toPdf(*)) || " +
			"execution(public net.sf.dynamicreports.jasper.builder.JasperReportBuilder net.sf.dynamicreports.jasper.builder.JasperReportBuilder.toHtml(*)) || " +
			"execution(public net.sf.dynamicreports.jasper.builder.JasperReportBuilder net.sf.dynamicreports.jasper.builder.JasperReportBuilder.toXls(*))")
	public void export() {
	}

	@Around("toConcatenatedPdf()")
	public JasperConcatenatedReportBuilder toConcatenatedPdf(ProceedingJoinPoint pjp) throws Throwable {
		JasperConcatenatedReportBuilder reportBuilder = (JasperConcatenatedReportBuilder) pjp.getTarget();
		GenerateSite.generateExampleImage(name, reportBuilder, (JasperPdfExporterBuilder) pjp.getArgs()[0]);
		return reportBuilder;
	}

	@Pointcut("execution(public net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder.toPdf(*))")
	public void toConcatenatedPdf() {
	}

	@Around("getOpenFlashChartLocation()")
	public String getOpenFlashChartLocation(ProceedingJoinPoint pjp) throws Throwable {
		return "openflashchart/" + pjp.proceed();
	}

	@Pointcut("execution(public String net.sf.dynamicreports.examples.genericelement.openflashchart.OpenFlashChartHtmlHandler.getSwfLocation())")
	public void getOpenFlashChartLocation() {
	}
}
