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
package net.sf.dynamicreports.assembly;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import net.sf.dynamicreports.Project;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Template;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GenerateClasspath {

	public static void main(String[] args) throws Exception {
		Project project = new Project();
		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		cfg.setObjectWrapper(new DefaultObjectWrapperBuilder(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS).build());
		Template temp = cfg.getTemplate("src/assemblies/eclipse_classpath.ftl");
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("project", project);
		Writer out = new FileWriter(project.getOutputDirectory() + "/eclipse_classpath");
		temp.process(root, out);
		out.flush();

		project = new Project();
		cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		cfg.setObjectWrapper(new DefaultObjectWrapperBuilder(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS).build());
		temp = cfg.getTemplate("src/assemblies/netbeans_classpath.ftl");
		root = new HashMap<String, Object>();
		root.put("project", project);
		out = new FileWriter(project.getOutputDirectory() + "/netbeans_classpath");
		temp.process(root, out);
		out.flush();
	}
}
