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
package net.sf.dynamicreports;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Project {
	private String version;
	private String developmentVersion;
	private Date date;
	private String outputDirectory;
	private String avalonframeworkimplVersion;
	private String barcode4jVersion;
	private String barbecueVersion;
	private String zxingVersion;
	private String batikbridgeVersion;
	private String xmlgraphicscommonsVersion;
	private String bcprovjdkVersion;
	private String commonsbeanutilsVersion;
	private String commonscollectionsVersion;
	private String commonscollections4Version;
	private String commonsdigesterVersion;
	private String commonslangVersion;
	private String commonslang3Version;
	private String commonsloggingVersion;
	private String commonscodecVersion;
	private String itextVersion;
	private String jasperreportsVersion;
	private String jcommonVersion;
	private String ecjVersion;
	private String jfreechartVersion;
	private String jacksonVersion;
	private String log4jVersion;
	private String poiVersion;
	private String xmlapisVersion;
	private String springframeworkVersion;
	private String hsqldbVersion;
	private String xalanVersion;
	private String velocityVersion;
	private String jsonVersion;

	public Project() throws IOException {
		version = System.getenv("version");
		developmentVersion = System.getenv("developmentVersion");
		date = new Date();
		outputDirectory = System.getenv("outputDirectory");

		Properties properties = new Properties();
		String prop = System.getenv("properties");
		prop = prop.substring(1, prop.length() - 1);
		prop = prop.replaceAll(", ", "\n");
		properties.load(new ByteArrayInputStream(prop.getBytes()));

		avalonframeworkimplVersion = properties.getProperty("avalonframeworkimplVersion");
		barcode4jVersion = properties.getProperty("barcode4jVersion");
		barbecueVersion = properties.getProperty("barbecueVersion");
		zxingVersion = properties.getProperty("zxingVersion");
		batikbridgeVersion = properties.getProperty("batikbridgeVersion");
		xmlgraphicscommonsVersion = properties.getProperty("xmlgraphicscommonsVersion");
		bcprovjdkVersion = properties.getProperty("bcprovjdkVersion");
		commonsbeanutilsVersion = properties.getProperty("commonsbeanutilsVersion");
		commonscollectionsVersion = properties.getProperty("commonscollectionsVersion");
		commonscollections4Version = properties.getProperty("commonscollections4Version");
		commonsdigesterVersion = properties.getProperty("commonsdigesterVersion");
		commonslangVersion = properties.getProperty("commonslangVersion");
		commonslang3Version = properties.getProperty("commonslang3Version");
		commonsloggingVersion = properties.getProperty("commonsloggingVersion");
		commonscodecVersion = properties.getProperty("commonscodecVersion");
		itextVersion = properties.getProperty("itextVersion");
		jasperreportsVersion = properties.getProperty("jasperreportsVersion");
		jcommonVersion = properties.getProperty("jcommonVersion");
		ecjVersion = properties.getProperty("ecjVersion");
		jfreechartVersion = properties.getProperty("jfreechartVersion");
		jacksonVersion = properties.getProperty("jacksonVersion");
		log4jVersion = properties.getProperty("log4jVersion");
		poiVersion = properties.getProperty("poiVersion");
		xmlapisVersion = properties.getProperty("xmlapisVersion");
		springframeworkVersion = properties.getProperty("springframeworkVersion");
		hsqldbVersion = properties.getProperty("hsqldbVersion");
		xalanVersion = properties.getProperty("xalanVersion");
		velocityVersion = properties.getProperty("velocityVersion");
		jsonVersion = properties.getProperty("jsonVersion");
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDevelopmentVersion() {
		return developmentVersion;
	}

	public void setDevelopmentVersion(String developmentVersion) {
		this.developmentVersion = developmentVersion;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public String getAvalonframeworkimplVersion() {
		return avalonframeworkimplVersion;
	}

	public void setAvalonframeworkimplVersion(String avalonframeworkimplVersion) {
		this.avalonframeworkimplVersion = avalonframeworkimplVersion;
	}

	public String getBarcode4jVersion() {
		return barcode4jVersion;
	}

	public void setBarcode4jVersion(String barcode4jVersion) {
		this.barcode4jVersion = barcode4jVersion;
	}

	public String getBarbecueVersion() {
		return barbecueVersion;
	}

	public void setBarbecueVersion(String barbecueVersion) {
		this.barbecueVersion = barbecueVersion;
	}

	public String getZxingVersion() {
		return zxingVersion;
	}

	public void setZxingVersion(String zxingVersion) {
		this.zxingVersion = zxingVersion;
	}

	public String getBatikbridgeVersion() {
		return batikbridgeVersion;
	}

	public void setBatikbridgeVersion(String batikbridgeVersion) {
		this.batikbridgeVersion = batikbridgeVersion;
	}

	public String getXmlgraphicscommonsVersion() {
		return xmlgraphicscommonsVersion;
	}

	public void setXmlgraphicscommonsVersion(String xmlgraphicscommonsVersion) {
		this.xmlgraphicscommonsVersion = xmlgraphicscommonsVersion;
	}

	public String getBcprovjdkVersion() {
		return bcprovjdkVersion;
	}

	public void setBcprovjdkVersion(String bcprovjdkVersion) {
		this.bcprovjdkVersion = bcprovjdkVersion;
	}

	public String getCommonsbeanutilsVersion() {
		return commonsbeanutilsVersion;
	}

	public void setCommonsbeanutilsVersion(String commonsbeanutilsVersion) {
		this.commonsbeanutilsVersion = commonsbeanutilsVersion;
	}

	public String getCommonscollectionsVersion() {
		return commonscollectionsVersion;
	}

	public void setCommonscollectionsVersion(String commonscollectionsVersion) {
		this.commonscollectionsVersion = commonscollectionsVersion;
	}

	public String getCommonscollections4Version() {
		return commonscollections4Version;
	}

	public void setCommonscollections4Version(String commonscollections4Version) {
		this.commonscollections4Version = commonscollections4Version;
	}

	public String getCommonsdigesterVersion() {
		return commonsdigesterVersion;
	}

	public void setCommonsdigesterVersion(String commonsdigesterVersion) {
		this.commonsdigesterVersion = commonsdigesterVersion;
	}

	public String getCommonslangVersion() {
		return commonslangVersion;
	}

	public void setCommonslangVersion(String commonslangVersion) {
		this.commonslangVersion = commonslangVersion;
	}

	public String getCommonslang3Version() {
		return commonslang3Version;
	}

	public void setCommonslang3Version(String commonslang3Version) {
		this.commonslang3Version = commonslang3Version;
	}

	public String getCommonsloggingVersion() {
		return commonsloggingVersion;
	}

	public void setCommonsloggingVersion(String commonsloggingVersion) {
		this.commonsloggingVersion = commonsloggingVersion;
	}

	public String getCommonscodecVersion() {
		return commonscodecVersion;
	}

	public void setCommonscodecVersion(String commonscodecVersion) {
		this.commonscodecVersion = commonscodecVersion;
	}

	public String getItextVersion() {
		return itextVersion;
	}

	public void setItextVersion(String itextVersion) {
		this.itextVersion = itextVersion;
	}

	public String getJasperreportsVersion() {
		return jasperreportsVersion;
	}

	public void setJasperreportsVersion(String jasperreportsVersion) {
		this.jasperreportsVersion = jasperreportsVersion;
	}

	public String getJcommonVersion() {
		return jcommonVersion;
	}

	public void setJcommonVersion(String jcommonVersion) {
		this.jcommonVersion = jcommonVersion;
	}

	public String getEcjVersion() {
		return ecjVersion;
	}

	public void setEcjVersion(String ecjVersion) {
		this.ecjVersion = ecjVersion;
	}

	public String getJfreechartVersion() {
		return jfreechartVersion;
	}

	public void setJfreechartVersion(String jfreechartVersion) {
		this.jfreechartVersion = jfreechartVersion;
	}

	public String getJacksonVersion() {
		return jacksonVersion;
	}

	public void setJacksonVersion(String jacksonVersion) {
		this.jacksonVersion = jacksonVersion;
	}

	public String getLog4jVersion() {
		return log4jVersion;
	}

	public void setLog4jVersion(String log4jVersion) {
		this.log4jVersion = log4jVersion;
	}

	public String getPoiVersion() {
		return poiVersion;
	}

	public void setPoiVersion(String poiVersion) {
		this.poiVersion = poiVersion;
	}

	public String getXmlapisVersion() {
		return xmlapisVersion;
	}

	public void setXmlapisVersion(String xmlapisVersion) {
		this.xmlapisVersion = xmlapisVersion;
	}

	public String getSpringframeworkVersion() {
		return springframeworkVersion;
	}

	public void setSpringframeworkVersion(String springframeworkVersion) {
		this.springframeworkVersion = springframeworkVersion;
	}

	public String getHsqldbVersion() {
		return hsqldbVersion;
	}

	public void setHsqldbVersion(String hsqldbVersion) {
		this.hsqldbVersion = hsqldbVersion;
	}

	public String getXalanVersion() {
		return xalanVersion;
	}

	public void setXalanVersion(String xalanVersion) {
		this.xalanVersion = xalanVersion;
	}

	public String getVelocityVersion() {
		return velocityVersion;
	}

	public void setVelocityVersion(String velocityVersion) {
		this.velocityVersion = velocityVersion;
	}

	public String getJsonVersion() {
		return jsonVersion;
	}

	public void setJsonVersion(String jsonVersion) {
		this.jsonVersion = jsonVersion;
	}

}
