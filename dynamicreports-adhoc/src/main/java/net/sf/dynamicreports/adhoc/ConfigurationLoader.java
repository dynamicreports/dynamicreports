package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.report.exception.DRException;

import java.io.InputStream;
import java.io.OutputStream;

public interface ConfigurationLoader {
    /**
     * <p>saveConfiguration.</p>
     * This method enables a client to save configuration to an XML file. Consider the folowing example
     * <pre>
     *     AdhocReport report = new AdhocReport();
     *     AdhocColumn column = new AdhocColumn();
     *     column.setName("item");
     *      report.addColumn(column);
     *
     *      column = new AdhocColumn();
     *      column.setName("quantity");
     *      report.addColumn(column);
     *  AdhocConfiguration configuration = new AdhocConfiguration();
     *  configuration.setReport(report);
     *
     *  // Now saving to an XML file in the system
     *  AdhocManager.saveConfiguration(configuration, new FileOutputStream("c:/temp/configuration.xml"));
     * </pre>
     *
     * @param adhocConfiguration a {@link net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration} object.
     * @param os                 a {@link java.io.OutputStream} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    void saveConfiguration(AdhocConfiguration adhocConfiguration, OutputStream os) throws DRException;

    /**
     * <p>loadConfiguration.</p>
     * This method enables a client to read {@link AdhocConfiguration} from an {@link InputStream} The method may be applied as shown:
     * <pre>
     *     {@code
     *        AdhocConfiguration loadedConfiguration = AdhocManager.loadConfiguration(new FileInputStream("c:/temp/configuration.xml"));
     *     }
     * </pre>
     *
     * @param is a {@link InputStream} object.
     * @return a {@link AdhocConfiguration} object.
     * @throws DRException if any.
     */
    AdhocConfiguration loadConfiguration(InputStream is) throws DRException;
}
