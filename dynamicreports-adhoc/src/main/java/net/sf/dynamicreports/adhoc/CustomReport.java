package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.report.DefaultAdhocReportCustomizer;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * This object creates a report builder from which one could export to any type:
 * pdf, xml, xlsx and ptx
 */
public interface CustomReport {

    /**
     * <p>createReport.</p>
     * Creates a JasperReportBuilder which is subsequently set up with the {@code JRDataSource} and finaly used to create a report like shown here:
     * <pre>
     *     {@code
     *     AdhocConfiguration configuration = new AdhocConfiguration();
     *      AdhocReport report = new AdhocReport();
     *      configuration.setReport(report);
     *      // configure report...
     *     JasperReportBuilder reportBuilder = AdhocManager.createReport(configuration.getReport());
     *     reportBuilder.setDataSource(createDataSource());
     *     reportBuilder.show();
     *     }
     * </pre>
     * The {@code AdhocReportCustomizer} is internally provided by invocation of the {@link DefaultAdhocReportCustomizer}
     *
     * @param adhocReport a {@link net.sf.dynamicreports.adhoc.configuration.AdhocReport} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    JasperReportBuilder createReport(AdhocReport adhocReport) throws DRException;

}
