/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.googlecharts.jasper;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRComponentElement;
import net.sf.jasperreports.engine.component.Component;
import net.sf.jasperreports.engine.component.ComponentXmlWriter;
import net.sf.jasperreports.engine.component.ComponentsEnvironment;
import net.sf.jasperreports.engine.component.XmlDigesterConfigurer;
import net.sf.jasperreports.engine.export.GenericElementHandler;
import net.sf.jasperreports.engine.export.GenericElementHandlerBundle;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.util.JRXmlWriteHelper;
import net.sf.jasperreports.engine.util.XmlNamespace;
import net.sf.jasperreports.engine.xml.JRXmlWriter;
import org.apache.commons.digester.Digester;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>GoogleChartsHandler class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GoogleChartsHandler implements XmlDigesterConfigurer, ComponentXmlWriter, GenericElementHandlerBundle {
    private Map<String, Class<? extends Component>> components;
    private Map<String, GenericElementHandler> handlers;

    /**
     * <p>Constructor for GoogleChartsHandler.</p>
     */
    public GoogleChartsHandler() {
        components = new HashMap<String, Class<? extends Component>>();
        handlers = new HashMap<String, GenericElementHandler>();
    }

    /**
     * <p>add.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param componentClass a {@link java.lang.Class} object.
     * @param handler a {@link net.sf.jasperreports.engine.export.GenericElementHandler} object.
     */
    public void add(String name, Class<? extends Component> componentClass, GenericElementHandler handler) {
        components.put(name, componentClass);
        handlers.put(name, handler);
    }

    /** {@inheritDoc} */
    @Override
    public void configureDigester(Digester digester) {
        for (String name : components.keySet()) {
            String mapPattern = "*/componentElement/googleCharts/" + name;
            digester.addObjectCreate(mapPattern, components.get(name));
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean isToWrite(JRComponentElement componentElement, JRXmlWriter reportWriter) {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public void writeToXml(JRComponentElement componentElement, JRXmlWriter reportWriter) throws IOException {
        if (components.containsKey(componentElement.getComponentKey()
                                                   .getName())) {
            JRXmlWriteHelper writer = reportWriter.getXmlWriteHelper();

            String namespaceURI = componentElement.getComponentKey()
                                                  .getNamespace();
            String schemaLocation = ComponentsEnvironment.getInstance(DefaultJasperReportsContext.getInstance())
                                                         .getBundle(namespaceURI)
                                                         .getXmlParser()
                                                         .getPublicSchemaLocation();
            XmlNamespace namespace = new XmlNamespace(namespaceURI, componentElement.getComponentKey()
                                                                                    .getNamespacePrefix(), schemaLocation);

            writer.startElement(componentElement.getComponentKey()
                                                .getName(), namespace);

            writer.closeElement();
        }
    }

    /** {@inheritDoc} */
    @Override
    public String getNamespace() {
        return GoogleChartsExtensionsRegistryFactory.NAMESPACE;
    }

    /** {@inheritDoc} */
    @Override
    public GenericElementHandler getHandler(String elementName, String exporterKey) {
        if (handlers.containsKey(elementName)) {
            if (HtmlExporter.HTML_EXPORTER_KEY.equals(exporterKey)) {
                return handlers.get(elementName);
            }
        }
        return null;
    }
}
