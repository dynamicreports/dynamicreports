/*
 * DynamicReports - parent - DynamicReports parent
 * Copyright © 2010 Ricardo Mariaca and the DynamicReports Contributors (${email})
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.dynamicreports.site;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Page {
	private String page;
	private String path;
	private String documentation;
	private String examples;
	private boolean sideBar;
	private String content;
	private boolean hasCode;
	private Set<String> codeClasses;
	private boolean hasImage;
	private boolean hasImageGroup;
	private String description;
	private String keywords;
	private String title;

	public Page(String page, String name, String pageContent) throws Exception {
		this.page = page;
		init();
		setPage(name, pageContent);
	}

	private void init() throws Exception {
		path = "";
		documentation = "documentation/";
		examples = "examples/";
		sideBar = true;
		hasCode = false;
		codeClasses = new LinkedHashSet<String>();
		hasImage = false;
		hasImageGroup = false;
		description = "";
		keywords = "";
		title = "";
	}

	private void setPage(String name, String pageContent) throws Exception {
		if (pageContent.indexOf("<@java_code>") != -1) {
			codeClasses.add("Java");
		}
		if (pageContent.indexOf("<@xml_code>") != -1) {
			codeClasses.add("Xml");
		}
		hasCode = !codeClasses.isEmpty();
		hasImage = pageContent.indexOf("<@example") != -1;
		hasImageGroup = pageContent.indexOf("<@image_group") != -1;
		content = "/" + name;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public String getExamples() {
		return examples;
	}

	public void setExamples(String examples) {
		this.examples = examples;
	}

	public boolean isSideBar() {
		return sideBar;
	}

	public void setSideBar(boolean sideBar) {
		this.sideBar = sideBar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isHasCode() {
		return hasCode;
	}

	public void setHasCode(boolean hasCode) {
		this.hasCode = hasCode;
	}

	public Set<String> getCodeClasses() {
		return codeClasses;
	}

	public void setCodeClasses(Set<String> codeClasses) {
		this.codeClasses = codeClasses;
	}

	public boolean isHasImage() {
		return hasImage;
	}

	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}

	public boolean isHasImageGroup() {
		return hasImageGroup;
	}

	public void setHasImageGroup(boolean hasImageGroup) {
		this.hasImageGroup = hasImageGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
