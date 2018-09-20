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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Example {
	private String name;
	private String path;
	private Class<? extends Object> design;

	public Example(String name, String path, Class<? extends Object> design) {
		this.name = name;
		this.path = path;
		this.design = design;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public Class<? extends Object> getDesign() {
		return design;
	}
}
