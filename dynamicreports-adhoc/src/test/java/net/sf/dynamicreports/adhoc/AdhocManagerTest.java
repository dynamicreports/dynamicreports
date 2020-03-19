/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdhocManagerTest {

    private AdhocManager adhocManager;

    @Before
    public void setUp() throws Exception {

        adhocManager = AdhocManager.getInstance(new AdhocToXmlTransform(), new XmlToAdhocTransform());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createReport() throws Exception {

        //assertSame(new JasperReportBuilder(), adhocManager.createReport(new AdhocReport()));
    }

    @Test
    public void createReport1() {
    }

    @Test
    public void saveConfiguration() {
    }

    @Test
    public void loadConfiguration() {
    }
}