package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.report.AdhocReportCustomizer;
import net.sf.dynamicreports.adhoc.report.DefaultAdhocReportCustomizer;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.exception.DRException;

public class SimpleCustomReport implements CustomReport {

    private final AdhocReportCustomizer adhocReportCustomizer;

    public SimpleCustomReport(final AdhocReportCustomizer adhocReportCustomizer) {
        this.adhocReportCustomizer = adhocReportCustomizer;
    }

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
    public JasperReportBuilder createReport(AdhocReport adhocReport) throws DRException {
        return createReport(adhocReport, adhocReportCustomizer);
    }

    /**
     * <p>createReport.</p>
     * Creates a JasperReportBuilder which is subsequently set up with the {@code JRDataSource} and finaly used to create a report like shown here:
     * <pre>
     *     {@code
     *      AdhocConfiguration configuration = new AdhocConfiguration();
     *      AdhocReport report = new AdhocReport();
     *      configuration.setReport(report);
     *      // configure report...
     *      JasperReportBuilder reportBuilder = AdhocManager.createReport(configuration.getReport(), new ReportCustomizer());
     *      reportBuilder.setDataSource(createDataSource());
     *      reportBuilder.show();
     *     }
     * </pre>
     *
     * @param adhocReport           a {@link net.sf.dynamicreports.adhoc.configuration.AdhocReport} object.
     * @param adhocReportCustomizer a {@link net.sf.dynamicreports.adhoc.report.AdhocReportCustomizer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    private JasperReportBuilder createReport(AdhocReport adhocReport, AdhocReportCustomizer adhocReportCustomizer) throws DRException {
        JasperReportBuilder report = DynamicReports.report();
        adhocReportCustomizer.customize(report, adhocReport);
        return report;
    }
}
