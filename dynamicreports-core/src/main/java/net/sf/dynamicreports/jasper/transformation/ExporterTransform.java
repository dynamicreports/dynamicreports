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
package net.sf.dynamicreports.jasper.transformation;

import java.io.File;

import net.sf.dynamicreports.design.transformation.StyleResolver;
import net.sf.dynamicreports.jasper.definition.export.JasperICsvExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIDocxExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIExcelExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIHtmlExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIJsonExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIOdsExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIOdtExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIPdfExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIPptxExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIRtfExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperITextExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIXlsExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIXlsxExporter;
import net.sf.dynamicreports.jasper.definition.export.JasperIXmlExporter;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.defaults.Defaults;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.export.FileHtmlResourceHandler;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.HtmlResourceHandler;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.JsonMetadataExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.AbstractXlsExporterConfiguration;
import net.sf.jasperreports.export.AbstractXlsReportConfiguration;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleCsvReportConfiguration;
import net.sf.jasperreports.export.SimpleDocxExporterConfiguration;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterConfiguration;
import net.sf.jasperreports.export.SimpleHtmlExporterConfiguration;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;
import net.sf.jasperreports.export.SimpleJsonExporterConfiguration;
import net.sf.jasperreports.export.SimpleJsonExporterOutput;
import net.sf.jasperreports.export.SimpleJsonMetadataReportConfiguration;
import net.sf.jasperreports.export.SimpleOdsExporterConfiguration;
import net.sf.jasperreports.export.SimpleOdsReportConfiguration;
import net.sf.jasperreports.export.SimpleOdtExporterConfiguration;
import net.sf.jasperreports.export.SimpleOdtReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimplePptxExporterConfiguration;
import net.sf.jasperreports.export.SimplePptxReportConfiguration;
import net.sf.jasperreports.export.SimpleReportExportConfiguration;
import net.sf.jasperreports.export.SimpleRtfExporterConfiguration;
import net.sf.jasperreports.export.SimpleRtfReportConfiguration;
import net.sf.jasperreports.export.SimpleTextExporterConfiguration;
import net.sf.jasperreports.export.SimpleTextReportConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.export.SimpleXmlExporterOutput;
import net.sf.jasperreports.web.util.WebHtmlResourceHandler;

/**
 * <p>
 * ExporterTransform class.
 * </p>
 *
 * @author Ricardo Mariaca
 *
 */
public class ExporterTransform {
  private final JasperIExporter jasperExporter;

  /**
   * <p>
   * Constructor for ExporterTransform.
   * </p>
   *
   * @param jasperExporter a
   *                       {@link net.sf.dynamicreports.jasper.definition.export.JasperIExporter}
   *                       object.
   */
  public ExporterTransform(JasperIExporter jasperExporter) {
    this.jasperExporter = jasperExporter;
  }

  /**
   * <p>
   * transform.
   * </p>
   *
   * @return a {@link net.sf.jasperreports.export.Exporter} object.
   * @throws net.sf.dynamicreports.report.exception.DRException if any.
   */
  public Exporter<?, ?, ?, ?> transform() throws DRException {
    Exporter<?, ?, ?, ?> jrExporter;

    if (jasperExporter instanceof JasperICsvExporter) {
      jrExporter = csv((JasperICsvExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIDocxExporter) {
      jrExporter = docx((JasperIDocxExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIXlsExporter) {
      jrExporter = xls((JasperIXlsExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIXlsxExporter) {
      jrExporter = xlsx((JasperIXlsxExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIHtmlExporter) {
      jrExporter = html((JasperIHtmlExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIOdsExporter) {
      jrExporter = ods((JasperIOdsExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIOdtExporter) {
      jrExporter = odt((JasperIOdtExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIPdfExporter) {
      jrExporter = pdf((JasperIPdfExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIRtfExporter) {
      jrExporter = rtf((JasperIRtfExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperITextExporter) {
      jrExporter = text((JasperITextExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIXmlExporter) {
      jrExporter = xml((JasperIXmlExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIPptxExporter) {
      jrExporter = pptx((JasperIPptxExporter) jasperExporter);
    } else if (jasperExporter instanceof JasperIJsonExporter) {
      jrExporter = json((JasperIJsonExporter) jasperExporter);
    } else {
      throw new JasperDesignException("Exporter " + jasperExporter.getClass().getName() + " not supported");
    }
    return jrExporter;
  }

  private SimpleWriterExporterOutput simpleWriterExporterOutput(JasperIExporter jasperExporter) {
    if (jasperExporter.getOutputWriter() != null) {
      return new SimpleWriterExporterOutput(jasperExporter.getOutputWriter());
    }
    if (jasperExporter.getOutputStream() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleWriterExporterOutput(jasperExporter.getOutputStream(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleWriterExporterOutput(jasperExporter.getOutputStream());
      }
    }
    if (jasperExporter.getOutputFile() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleWriterExporterOutput(jasperExporter.getOutputFile(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleWriterExporterOutput(jasperExporter.getOutputFile());
      }
    }
    if (jasperExporter.getOutputFileName() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleWriterExporterOutput(jasperExporter.getOutputFileName(),
            jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleWriterExporterOutput(jasperExporter.getOutputFileName());
      }
    }
    return null;
  }

  private SimpleOutputStreamExporterOutput simpleOutputStreamExporterOutput(JasperIExporter jasperExporter) {
    if (jasperExporter.getOutputStream() != null) {
      return new SimpleOutputStreamExporterOutput(jasperExporter.getOutputStream());
    }
    if (jasperExporter.getOutputFile() != null) {
      return new SimpleOutputStreamExporterOutput(jasperExporter.getOutputFile());
    }
    if (jasperExporter.getOutputFileName() != null) {
      return new SimpleOutputStreamExporterOutput(jasperExporter.getOutputFileName());
    }
    return null;
  }

  private SimpleHtmlExporterOutput simpleHtmlExporterOutput(JasperIExporter jasperExporter) {
    if (jasperExporter.getOutputWriter() != null) {
      return new SimpleHtmlExporterOutput(jasperExporter.getOutputWriter());
    }
    if (jasperExporter.getOutputStream() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleHtmlExporterOutput(jasperExporter.getOutputStream(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleHtmlExporterOutput(jasperExporter.getOutputStream());
      }
    }
    if (jasperExporter.getOutputFile() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleHtmlExporterOutput(jasperExporter.getOutputFile(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleHtmlExporterOutput(jasperExporter.getOutputFile());
      }
    }
    if (jasperExporter.getOutputFileName() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleHtmlExporterOutput(jasperExporter.getOutputFileName(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleHtmlExporterOutput(jasperExporter.getOutputFileName());
      }
    }
    return null;
  }

  private SimpleXmlExporterOutput simpleXmlExporterOutput(JasperIXmlExporter jasperExporter) {
    if (jasperExporter.getOutputWriter() != null) {
      return new SimpleXmlExporterOutput(jasperExporter.getOutputWriter());
    }
    if (jasperExporter.getOutputStream() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleXmlExporterOutput(jasperExporter.getOutputStream(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleXmlExporterOutput(jasperExporter.getOutputStream());
      }
    }
    if (jasperExporter.getOutputFile() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleXmlExporterOutput(jasperExporter.getOutputFile(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleXmlExporterOutput(jasperExporter.getOutputFile());
      }
    }
    if (jasperExporter.getOutputFileName() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleXmlExporterOutput(jasperExporter.getOutputFileName(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleXmlExporterOutput(jasperExporter.getOutputFileName());
      }
    }
    return null;
  }

  private SimpleJsonExporterOutput simpleJsonExporterOutput(JasperIExporter jasperExporter) {
    if (jasperExporter.getOutputWriter() != null) {
      return new SimpleJsonExporterOutput(jasperExporter.getOutputWriter());
    }
    if (jasperExporter.getOutputStream() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleJsonExporterOutput(jasperExporter.getOutputStream(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleJsonExporterOutput(jasperExporter.getOutputStream());
      }
    }
    if (jasperExporter.getOutputFile() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleJsonExporterOutput(jasperExporter.getOutputFile(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleJsonExporterOutput(jasperExporter.getOutputFile());
      }
    }
    if (jasperExporter.getOutputFileName() != null) {
      if (jasperExporter.getCharacterEncoding() != null) {
        return new SimpleJsonExporterOutput(jasperExporter.getOutputFileName(), jasperExporter.getCharacterEncoding());
      } else {
        return new SimpleJsonExporterOutput(jasperExporter.getOutputFileName());
      }
    }
    return null;
  }

  private void reportExportConfiguration(SimpleReportExportConfiguration reportExportConfiguration,
      JasperIExporter jasperExporter) {
    if (jasperExporter.getPageIndex() != null) {
      reportExportConfiguration.setPageIndex(jasperExporter.getPageIndex());
    }
    if (jasperExporter.getStartPageIndex() != null) {
      reportExportConfiguration.setStartPageIndex(jasperExporter.getStartPageIndex());
    }
    if (jasperExporter.getEndPageIndex() != null) {
      reportExportConfiguration.setEndPageIndex(jasperExporter.getEndPageIndex());
    }
    if (jasperExporter.getOffsetX() != null) {
      reportExportConfiguration.setOffsetX(jasperExporter.getOffsetX());
    }
    if (jasperExporter.getOffsetY() != null) {
      reportExportConfiguration.setOffsetY(jasperExporter.getOffsetY());
    }
  }

  private JRXmlExporter xml(JasperIXmlExporter jasperExporter) {
    final SimpleXmlExporterOutput exporterOutput = simpleXmlExporterOutput(jasperExporter);
    if (jasperExporter.getEmbeddingImages() != null) {
      exporterOutput.setEmbeddingImages(jasperExporter.getEmbeddingImages());
    }
    final SimpleReportExportConfiguration reportExportConfiguration = new SimpleReportExportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    final SimpleExporterConfiguration exporterConfiguration = new SimpleExporterConfiguration();

    final JRXmlExporter jrExporter = new JRXmlExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JRPptxExporter pptx(JasperIPptxExporter jasperExporter) {
    final SimpleOutputStreamExporterOutput exporterOutput = simpleOutputStreamExporterOutput(jasperExporter);
    final SimplePptxReportConfiguration reportExportConfiguration = new SimplePptxReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getIgnoreHyperLink() != null) {
      reportExportConfiguration.setIgnoreHyperlink(jasperExporter.getIgnoreHyperLink());
    }
    final SimplePptxExporterConfiguration exporterConfiguration = new SimplePptxExporterConfiguration();

    final JRPptxExporter jrExporter = new JRPptxExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JRTextExporter text(JasperITextExporter jasperExporter) {
    final SimpleWriterExporterOutput exporterOutput = simpleWriterExporterOutput(jasperExporter);
    final SimpleTextReportConfiguration reportExportConfiguration = new SimpleTextReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getCharacterWidth() != null) {
      reportExportConfiguration.setCharWidth(jasperExporter.getCharacterWidth());
    } else {
      final DRFont font = Defaults.getDefaults().getFont();
      reportExportConfiguration.setCharWidth((float) StyleResolver.getFontWidth(font));
    }
    if (jasperExporter.getCharacterHeight() != null) {
      reportExportConfiguration.setCharHeight(jasperExporter.getCharacterHeight());
    } else {
      final DRFont font = Defaults.getDefaults().getFont();
      reportExportConfiguration.setCharHeight((float) StyleResolver.getFontHeight(font));
    }
    if (jasperExporter.getPageWidthInChars() != null) {
      reportExportConfiguration.setPageWidthInChars(jasperExporter.getPageWidthInChars());
    }
    if (jasperExporter.getPageHeightInChars() != null) {
      reportExportConfiguration.setPageHeightInChars(jasperExporter.getPageHeightInChars());
    }
    final SimpleTextExporterConfiguration exporterConfiguration = new SimpleTextExporterConfiguration();
    if (jasperExporter.getPageSeparator() != null) {
      exporterConfiguration.setPageSeparator(jasperExporter.getPageSeparator());
    }
    if (jasperExporter.getLineSeparator() != null) {
      exporterConfiguration.setLineSeparator(jasperExporter.getLineSeparator());
    }
    if (jasperExporter.getTrimLineRight() != null) {
      exporterConfiguration.setTrimLineRight(jasperExporter.getTrimLineRight());
    }

    final JRTextExporter jrExporter = new JRTextExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JRRtfExporter rtf(JasperIRtfExporter jasperExporter) {
    final SimpleWriterExporterOutput exporterOutput = simpleWriterExporterOutput(jasperExporter);
    final SimpleRtfReportConfiguration reportExportConfiguration = new SimpleRtfReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getIgnoreHyperLink() != null) {
      reportExportConfiguration.setIgnoreHyperlink(jasperExporter.getIgnoreHyperLink());
    }
    final SimpleRtfExporterConfiguration exporterConfiguration = new SimpleRtfExporterConfiguration();

    final JRRtfExporter jrExporter = new JRRtfExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JRPdfExporter pdf(JasperIPdfExporter jasperExporter) {
    final SimpleOutputStreamExporterOutput exporterOutput = simpleOutputStreamExporterOutput(jasperExporter);
    final SimplePdfReportConfiguration reportExportConfiguration = new SimplePdfReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getForceSvgShapes() != null) {
      reportExportConfiguration.setForceSvgShapes(jasperExporter.getForceSvgShapes());
    }
    if (jasperExporter.getCollapseMissingBookmarkLevels() != null) {
      reportExportConfiguration.setCollapseMissingBookmarkLevels(jasperExporter.getCollapseMissingBookmarkLevels());
    }
    if (jasperExporter.getSizePageToContent() != null) {
      reportExportConfiguration.setSizePageToContent(jasperExporter.getSizePageToContent());
    }
    if (jasperExporter.getIgnoreHyperLink() != null) {
      reportExportConfiguration.setIgnoreHyperlink(jasperExporter.getIgnoreHyperLink());
    }
    if (jasperExporter.getForceLineBreakPolicy() != null) {
      reportExportConfiguration.setForceLineBreakPolicy(jasperExporter.getForceLineBreakPolicy());
    }
    final SimplePdfExporterConfiguration exporterConfiguration = new SimplePdfExporterConfiguration();
    if (jasperExporter.getCreatingBatchModeBookmarks() != null) {
      exporterConfiguration.setCreatingBatchModeBookmarks(jasperExporter.getCreatingBatchModeBookmarks());
    }
    if (jasperExporter.getCompressed() != null) {
      exporterConfiguration.setCompressed(jasperExporter.getCompressed());
    }
    if (jasperExporter.getEncrypted() != null) {
      exporterConfiguration.setEncrypted(jasperExporter.getEncrypted());
    }
    if (jasperExporter.getBitKey128() != null) {
      exporterConfiguration.set128BitKey(jasperExporter.getBitKey128());
    }
    if (jasperExporter.getUserPassword() != null) {
      exporterConfiguration.setUserPassword(jasperExporter.getUserPassword());
    }
    if (jasperExporter.getOwnerPassword() != null) {
      exporterConfiguration.setOwnerPassword(jasperExporter.getOwnerPassword());
    }
    if (jasperExporter.getPermissions() != null && !jasperExporter.getPermissions().isEmpty()) {
      exporterConfiguration.setPermissions(ConstantTransform.pdfPermission(jasperExporter.getPermissions()));
    }
    if (jasperExporter.getPdfVersion() != null) {
      exporterConfiguration.setPdfVersion(ConstantTransform.pdfVersion(jasperExporter.getPdfVersion()));
    }
    if (jasperExporter.getMetadataTitle() != null) {
      exporterConfiguration.setMetadataTitle(jasperExporter.getMetadataTitle());
    }
    if (jasperExporter.getMetadataAuthor() != null) {
      exporterConfiguration.setMetadataAuthor(jasperExporter.getMetadataAuthor());
    }
    if (jasperExporter.getMetadataSubject() != null) {
      exporterConfiguration.setMetadataSubject(jasperExporter.getMetadataSubject());
    }
    if (jasperExporter.getMetadataKeyWords() != null) {
      exporterConfiguration.setMetadataKeywords(jasperExporter.getMetadataKeyWords());
    }
    if (jasperExporter.getMetadataCreator() != null) {
      exporterConfiguration.setMetadataCreator(jasperExporter.getMetadataCreator());
    }
    if (jasperExporter.getPdfJavaScript() != null) {
      exporterConfiguration.setPdfJavaScript(jasperExporter.getPdfJavaScript());
    }
    if (jasperExporter.getTagged() != null) {
      exporterConfiguration.setTagged(jasperExporter.getTagged());
    }
    if (jasperExporter.getTagLanguage() != null) {
      exporterConfiguration.setTagLanguage(jasperExporter.getTagLanguage());
    }
    if (jasperExporter.getPrintScaling() != null) {
      exporterConfiguration.setPrintScaling(ConstantTransform.pdfPrintScaling(jasperExporter.getPrintScaling()));
    }
    if (jasperExporter.getPdfaConformance() != null) {
      exporterConfiguration.setPdfaConformance(ConstantTransform.pdfaConformance(jasperExporter.getPdfaConformance()));
    }
    if (jasperExporter.getIccProfilePath() != null) {
      exporterConfiguration.setIccProfilePath(jasperExporter.getIccProfilePath());
    }
    if (jasperExporter.getAllowedPermissionsHint() != null) {
      exporterConfiguration.setAllowedPermissionsHint(jasperExporter.getAllowedPermissionsHint());
    }
    if (jasperExporter.getDeniedPermissionsHint() != null) {
      exporterConfiguration.setDeniedPermissionsHint(jasperExporter.getDeniedPermissionsHint());
    }
    if (jasperExporter.getDisplayMetadataTitle() != null) {
      exporterConfiguration.setDisplayMetadataTitle(jasperExporter.getDisplayMetadataTitle());
    }

    final JRPdfExporter jrExporter = new JRPdfExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JROdtExporter odt(JasperIOdtExporter jasperExporter) {
    final SimpleOutputStreamExporterOutput exporterOutput = simpleOutputStreamExporterOutput(jasperExporter);
    final SimpleOdtReportConfiguration reportExportConfiguration = new SimpleOdtReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getFlexibleRowHeight() != null) {
      reportExportConfiguration.setFlexibleRowHeight(jasperExporter.getFlexibleRowHeight());
    }
    if (jasperExporter.getIgnoreHyperLink() != null) {
      reportExportConfiguration.setIgnoreHyperlink(jasperExporter.getIgnoreHyperLink());
    }
    final SimpleOdtExporterConfiguration exporterConfiguration = new SimpleOdtExporterConfiguration();

    final JROdtExporter jrExporter = new JROdtExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JROdsExporter ods(JasperIOdsExporter jasperExporter) {
    final SimpleOutputStreamExporterOutput exporterOutput = simpleOutputStreamExporterOutput(jasperExporter);
    final SimpleOdsReportConfiguration reportExportConfiguration = new SimpleOdsReportConfiguration();
    reportExcelExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getFlexibleRowHeight() != null) {
      reportExportConfiguration.setFlexibleRowHeight(jasperExporter.getFlexibleRowHeight());
    }
    final SimpleOdsExporterConfiguration exporterConfiguration = new SimpleOdsExporterConfiguration();
    reportExcelExporterConfiguration(exporterConfiguration, jasperExporter);

    final JROdsExporter jrExporter = new JROdsExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private HtmlExporter html(JasperIHtmlExporter jasperExporter) {
    final SimpleHtmlExporterOutput exporterOutput = simpleHtmlExporterOutput(jasperExporter);
    final Boolean outputImagesToDir = jasperExporter.getOutputImagesToDir();
    final String imagesUri = jasperExporter.getImagesURI();
    HtmlResourceHandler imageHandler = null;
    if (outputImagesToDir == null || outputImagesToDir) {
      File imagesDir = null;
      final String imagesDirName = jasperExporter.getImagesDirName();
      if (imagesDirName != null) {
        imagesDir = new File(imagesDirName);
      }
      if (imagesDir != null) {
        imageHandler = new FileHtmlResourceHandler(imagesDir,
            imagesUri == null ? imagesDir.getName() + "/{0}" : imagesUri + "{0}");
      }
    }
    if (imageHandler == null && imagesUri != null) {
      imageHandler = new WebHtmlResourceHandler(imagesUri + "{0}");
    }
    if (imageHandler != null) {
      exporterOutput.setImageHandler(imageHandler);
    }
    final SimpleHtmlReportConfiguration reportExportConfiguration = new SimpleHtmlReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getRemoveEmptySpaceBetweenRows() != null) {
      reportExportConfiguration.setRemoveEmptySpaceBetweenRows(jasperExporter.getRemoveEmptySpaceBetweenRows());
    }
    if (jasperExporter.getWhitePageBackground() != null) {
      reportExportConfiguration.setWhitePageBackground(jasperExporter.getWhitePageBackground());
    }
    if (jasperExporter.getWrapBreakWord() != null) {
      reportExportConfiguration.setWrapBreakWord(jasperExporter.getWrapBreakWord());
    }
    if (jasperExporter.getSizeUnit() != null) {
      reportExportConfiguration.setSizeUnit(ConstantTransform.sizeUnit(jasperExporter.getSizeUnit()));
    }
    if (jasperExporter.getIgnorePageMargins() != null) {
      reportExportConfiguration.setIgnorePageMargins(jasperExporter.getIgnorePageMargins());
    }
    if (jasperExporter.getBorderCollapse() != null) {
      reportExportConfiguration.setBorderCollapse(ConstantTransform.borderCollapse(jasperExporter.getBorderCollapse()));
    }
    if (jasperExporter.getAccessibleHtml() != null) {
      reportExportConfiguration.setAccessibleHtml(jasperExporter.getAccessibleHtml());
    }
    if (jasperExporter.getZoomRatio() != null) {
      reportExportConfiguration.setZoomRatio(jasperExporter.getZoomRatio());
    }
    if (jasperExporter.getIgnoreHyperLink() != null) {
      reportExportConfiguration.setIgnoreHyperlink(jasperExporter.getIgnoreHyperLink());
    }
    final SimpleHtmlExporterConfiguration exporterConfiguration = new SimpleHtmlExporterConfiguration();
    if (jasperExporter.getHtmlHeader() != null) {
      exporterConfiguration.setHtmlHeader(jasperExporter.getHtmlHeader());
    }
    if (jasperExporter.getBetweenPagesHtml() != null) {
      exporterConfiguration.setBetweenPagesHtml(jasperExporter.getBetweenPagesHtml());
    }
    if (jasperExporter.getHtmlFooter() != null) {
      exporterConfiguration.setHtmlFooter(jasperExporter.getHtmlFooter());
    }
    if (jasperExporter.getFlushOutput() != null) {
      exporterConfiguration.setFlushOutput(jasperExporter.getFlushOutput());
    }

    final HtmlExporter jrExporter = new HtmlExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JsonMetadataExporter json(JasperIJsonExporter jasperExporter) {
    final SimpleJsonExporterOutput exporterOutput = simpleJsonExporterOutput(jasperExporter);
    final SimpleJsonMetadataReportConfiguration reportExportConfiguration = new SimpleJsonMetadataReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    reportExportConfiguration.setIgnoreHyperlink(reportExportConfiguration.isIgnoreHyperlink());

    final SimpleJsonExporterConfiguration exporterConfiguration = new SimpleJsonExporterConfiguration();
    if (jasperExporter.isFlushOutput() != null) {
      exporterConfiguration.setFlushOutput(exporterConfiguration.isFlushOutput());
    }
    if (jasperExporter.isReportComponentsExportOnly() != null) {
      exporterConfiguration.setReportComponentsExportOnly(jasperExporter.isReportComponentsExportOnly());
    }

    final JsonMetadataExporter jrExporter = new JsonMetadataExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private void reportExcelExportConfiguration(AbstractXlsReportConfiguration reportExportConfiguration,
      JasperIExcelExporter jasperExporter) {
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getOnePagePerSheet() != null) {
      reportExportConfiguration.setOnePagePerSheet(jasperExporter.getOnePagePerSheet());
    }
    if (jasperExporter.getRemoveEmptySpaceBetweenRows() != null) {
      reportExportConfiguration.setRemoveEmptySpaceBetweenRows(jasperExporter.getRemoveEmptySpaceBetweenRows());
    }
    if (jasperExporter.getRemoveEmptySpaceBetweenColumns() != null) {
      reportExportConfiguration.setRemoveEmptySpaceBetweenColumns(jasperExporter.getRemoveEmptySpaceBetweenColumns());
    }
    if (jasperExporter.getWhitePageBackground() != null) {
      reportExportConfiguration.setWhitePageBackground(jasperExporter.getWhitePageBackground());
    }
    if (jasperExporter.getDetectCellType() != null) {
      reportExportConfiguration.setDetectCellType(jasperExporter.getDetectCellType());
    }
    if (jasperExporter.getSheetNames() != null && !jasperExporter.getSheetNames().isEmpty()) {
      final String[] sheetNames = jasperExporter.getSheetNames()
        .toArray(new String[jasperExporter.getSheetNames().size()]);
      reportExportConfiguration.setSheetNames(sheetNames);
    }
    if (jasperExporter.getFontSizeFixEnabled() != null) {
      reportExportConfiguration.setFontSizeFixEnabled(jasperExporter.getFontSizeFixEnabled());
    }
    if (jasperExporter.getImageBorderFixEnabled() != null) {
      reportExportConfiguration.setImageBorderFixEnabled(jasperExporter.getImageBorderFixEnabled());
    }
    if (jasperExporter.getMaxRowsPerSheet() != null) {
      reportExportConfiguration.setMaxRowsPerSheet(jasperExporter.getMaxRowsPerSheet());
    }
    if (jasperExporter.getIgnoreGraphics() != null) {
      reportExportConfiguration.setIgnoreGraphics(jasperExporter.getIgnoreGraphics());
    }
    if (jasperExporter.getCollapseRowSpan() != null) {
      reportExportConfiguration.setCollapseRowSpan(jasperExporter.getCollapseRowSpan());
    }
    if (jasperExporter.getIgnoreCellBorder() != null) {
      reportExportConfiguration.setIgnoreCellBorder(jasperExporter.getIgnoreCellBorder());
    }
    if (jasperExporter.getIgnoreCellBackground() != null) {
      reportExportConfiguration.setIgnoreCellBackground(jasperExporter.getIgnoreCellBackground());
    }
    if (jasperExporter.getPassword() != null) {
      reportExportConfiguration.setPassword(jasperExporter.getPassword());
    }
    if (jasperExporter.getIgnorePageMargins() != null) {
      reportExportConfiguration.setIgnorePageMargins(jasperExporter.getIgnorePageMargins());
    }
    if (jasperExporter.getWrapText() != null) {
      reportExportConfiguration.setWrapText(jasperExporter.getWrapText());
    }
    if (jasperExporter.getCellLocked() != null) {
      reportExportConfiguration.setCellLocked(jasperExporter.getCellLocked());
    }
    if (jasperExporter.getCellHidden() != null) {
      reportExportConfiguration.setCellHidden(jasperExporter.getCellHidden());
    }
    if (jasperExporter.getSheetHeaderLeft() != null) {
      reportExportConfiguration.setSheetHeaderLeft(jasperExporter.getSheetHeaderLeft());
    }
    if (jasperExporter.getSheetHeaderCenter() != null) {
      reportExportConfiguration.setSheetHeaderCenter(jasperExporter.getSheetHeaderCenter());
    }
    if (jasperExporter.getSheetHeaderRight() != null) {
      reportExportConfiguration.setSheetHeaderRight(jasperExporter.getSheetHeaderRight());
    }
    if (jasperExporter.getSheetFooterLeft() != null) {
      reportExportConfiguration.setSheetFooterLeft(jasperExporter.getSheetFooterLeft());
    }
    if (jasperExporter.getSheetFooterCenter() != null) {
      reportExportConfiguration.setSheetFooterCenter(jasperExporter.getSheetFooterCenter());
    }
    if (jasperExporter.getSheetFooterRight() != null) {
      reportExportConfiguration.setSheetFooterRight(jasperExporter.getSheetFooterRight());
    }
    if (jasperExporter.getFormatPatternsMap() != null) {
      reportExportConfiguration.setFormatPatternsMap(jasperExporter.getFormatPatternsMap());
    }
    if (jasperExporter.getIgnoreHyperLink() != null) {
      reportExportConfiguration.setIgnoreHyperlink(jasperExporter.getIgnoreHyperLink());
    }
    if (jasperExporter.getIgnoreAnchors() != null) {
      reportExportConfiguration.setIgnoreAnchors(jasperExporter.getIgnoreAnchors());
    }
    if (jasperExporter.getFitWidth() != null) {
      reportExportConfiguration.setFitWidth(jasperExporter.getFitWidth());
    }
    if (jasperExporter.getFitHeight() != null) {
      reportExportConfiguration.setFitHeight(jasperExporter.getFitHeight());
    }
    if (jasperExporter.getPageScale() != null) {
      reportExportConfiguration.setPageScale(jasperExporter.getPageScale());
    }
    if (jasperExporter.getSheetDirection() != null) {
      reportExportConfiguration.setSheetDirection(ConstantTransform.runDirection(jasperExporter.getSheetDirection()));
    }
    if (jasperExporter.getColumnWidthRatio() != null) {
      reportExportConfiguration.setColumnWidthRatio(jasperExporter.getColumnWidthRatio());
    }
    if (jasperExporter.getUseTimeZone() != null) {
      reportExportConfiguration.setUseTimeZone(jasperExporter.getUseTimeZone());
    }
    if (jasperExporter.getFirstPageNumber() != null) {
      reportExportConfiguration.setFirstPageNumber(jasperExporter.getFirstPageNumber());
    }
    if (jasperExporter.getShowGridLines() != null) {
      reportExportConfiguration.setShowGridLines(jasperExporter.getShowGridLines());
    }
    if (jasperExporter.getImageAnchorType() != null) {
      reportExportConfiguration
        .setImageAnchorType(ConstantTransform.imageAnchorType(jasperExporter.getImageAnchorType()));
    }
  }

  private void reportExcelExporterConfiguration(AbstractXlsExporterConfiguration exporterConfiguration,
      JasperIExcelExporter jasperExporter) {
    if (jasperExporter.getCreateCustomPalette() != null) {
      exporterConfiguration.setCreateCustomPalette(jasperExporter.getCreateCustomPalette());
    }
    if (jasperExporter.getWorkbookTemplate() != null) {
      exporterConfiguration.setWorkbookTemplate(jasperExporter.getWorkbookTemplate());
    }
    if (jasperExporter.getKeepWorkbookTemplateSheets() != null) {
      exporterConfiguration.setKeepWorkbookTemplateSheets(jasperExporter.getKeepWorkbookTemplateSheets());
    }
  }

  private JRXlsxExporter xlsx(JasperIXlsxExporter jasperExporter) {
    final SimpleOutputStreamExporterOutput exporterOutput = simpleOutputStreamExporterOutput(jasperExporter);
    final SimpleXlsxReportConfiguration reportExportConfiguration = new SimpleXlsxReportConfiguration();
    reportExcelExportConfiguration(reportExportConfiguration, jasperExporter);
    final SimpleXlsxExporterConfiguration exporterConfiguration = new SimpleXlsxExporterConfiguration();
    reportExcelExporterConfiguration(exporterConfiguration, jasperExporter);
    if (jasperExporter.getMacroTemplate() != null) {
      exporterConfiguration.setMacroTemplate(jasperExporter.getMacroTemplate());
    }

    final JRXlsxExporter jrExporter = new JRXlsxExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JRXlsExporter xls(JasperIXlsExporter jasperExporter) {
    final SimpleOutputStreamExporterOutput exporterOutput = simpleOutputStreamExporterOutput(jasperExporter);
    final SimpleXlsReportConfiguration reportExportConfiguration = new SimpleXlsReportConfiguration();
    reportExcelExportConfiguration(reportExportConfiguration, jasperExporter);
    final SimpleXlsExporterConfiguration exporterConfiguration = new SimpleXlsExporterConfiguration();
    reportExcelExporterConfiguration(exporterConfiguration, jasperExporter);

    final JRXlsExporter jrExporter = new JRXlsExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JRDocxExporter docx(JasperIDocxExporter jasperExporter) {
    final SimpleOutputStreamExporterOutput exporterOutput = simpleOutputStreamExporterOutput(jasperExporter);
    final SimpleDocxReportConfiguration reportExportConfiguration = new SimpleDocxReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    if (jasperExporter.getFramesAsNestedTables() != null) {
      reportExportConfiguration.setFramesAsNestedTables(jasperExporter.getFramesAsNestedTables());
    }
    if (jasperExporter.getFlexibleRowHeight() != null) {
      reportExportConfiguration.setFlexibleRowHeight(jasperExporter.getFlexibleRowHeight());
    }
    if (jasperExporter.getIgnoreHyperLink() != null) {
      reportExportConfiguration.setIgnoreHyperlink(jasperExporter.getIgnoreHyperLink());
    }
    final SimpleDocxExporterConfiguration exporterConfiguration = new SimpleDocxExporterConfiguration();

    final JRDocxExporter jrExporter = new JRDocxExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }

  private JRCsvExporter csv(JasperICsvExporter jasperExporter) {
    final SimpleWriterExporterOutput exporterOutput = simpleWriterExporterOutput(jasperExporter);
    final SimpleCsvReportConfiguration reportExportConfiguration = new SimpleCsvReportConfiguration();
    reportExportConfiguration(reportExportConfiguration, jasperExporter);
    final SimpleCsvExporterConfiguration exporterConfiguration = new SimpleCsvExporterConfiguration();
    if (jasperExporter.getFieldDelimiter() != null) {
      exporterConfiguration.setFieldDelimiter(jasperExporter.getFieldDelimiter());
    }
    if (jasperExporter.getRecordDelimiter() != null) {
      exporterConfiguration.setRecordDelimiter(jasperExporter.getRecordDelimiter());
    }

    final JRCsvExporter jrExporter = new JRCsvExporter();
    jrExporter.setExporterOutput(exporterOutput);
    jrExporter.setConfiguration(reportExportConfiguration);
    jrExporter.setConfiguration(exporterConfiguration);
    return jrExporter;
  }
}
