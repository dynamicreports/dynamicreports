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
package net.sf.dynamicreports.examples.complex.applicationform;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.FillerBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * <p>ApplicationFormDesign class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ApplicationFormDesign {
    private static final int cellWidth = 18;
    private static final int cellHeight = 18;

    private ApplicationFormData data = new ApplicationFormData();

    private StyleBuilder textStyle;
    private StyleBuilder centeredStyle;
    private StyleBuilder labelStyle;
    private StyleBuilder cellStyle;

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        ApplicationFormDesign design = new ApplicationFormDesign();
        try {
            JasperReportBuilder report = design.build();
            report.show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>build.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperReportBuilder build() throws DRException {
        JasperReportBuilder report = report();

        ApplicationForm applicationForm = data.getApplicationForm();

        textStyle = stl.style().setFontSize(12).setPadding(2);
        centeredStyle = stl.style(textStyle).setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.MIDDLE);
        labelStyle = stl.style(textStyle).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT).bold();
        cellStyle = stl.style(textStyle).setBorder(stl.pen1Point()).setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.MIDDLE);

        HorizontalListBuilder applicant = cmp.horizontalList()
                                             .add(label("First name", 14), emptyCell(1), label("Last name", 16))
                                             .newRow()
                                             .add(textCell(applicationForm.getFirstName(), 14), emptyCell(1), textCell(applicationForm.getLastName(), 16))
                                             .newRow(5)
                                             .add(emptyCell(1), dateOfBirth(applicationForm.getDateOfBirth()), emptyCell(4), gender(applicationForm.getGender()))
                                             .newRow(5)
                                             .add(emptyCell(1), maritalStatus(applicationForm.getMaritalStatus()));

        HorizontalListBuilder address = cmp.horizontalList()
                                           .add(label("Address", 31))
                                           .newRow()
                                           .add(textCell(applicationForm.getAddress(), 31))
                                           .newRow()
                                           .add(textCell("", 31))
                                           .newRow()
                                           .add(label("City", 21), emptyCell(5), label("Postal code", 5))
                                           .newRow()
                                           .add(textCell(applicationForm.getCity(), 21), emptyCell(5), textCell(applicationForm.getPostalCode(), 5));

        HorizontalListBuilder contact = cmp.horizontalList()
                                           .add(label("Telephone", 12), emptyCell(7), label("Mobile", 12))
                                           .newRow()
                                           .add(textCell(applicationForm.getTelephone(), 12), emptyCell(7), textCell(applicationForm.getMobile(), 12))
                                           .newRow()
                                           .add(label("Email", 31))
                                           .newRow()
                                           .add(textCell(applicationForm.getEmail(), 31));

        report.setTemplate(Templates.reportTemplate)
              .setPageFormat(PageType.A5, PageOrientation.LANDSCAPE)
              .setTextStyle(textStyle)
              .title(Templates.createTitleComponent("ApplicationForm"), cmp.text("APPLICATION FORM").setStyle(Templates.bold18CenteredStyle), applicant, cmp.verticalGap(10), address,
                     cmp.verticalGap(10), contact);

        return report;
    }

    private HorizontalListBuilder dateOfBirth(Date dateOfBirth) {
        String date = new SimpleDateFormat("MM/dd/yyyy").format(dateOfBirth);
        HorizontalListBuilder list = cmp.horizontalList()
                                        .add(label("Date Of Birth", 5))
                                        .add(textCell(StringUtils.substringBefore(date, "/"), 2), label("/", 1, centeredStyle))
                                        .add(textCell(StringUtils.substringBetween(date, "/"), 2), label("/", 1, centeredStyle))
                                        .add(textCell(StringUtils.substringAfterLast(date, "/"), 4));
        return list;
    }

    private HorizontalListBuilder gender(Gender gender) {
        HorizontalListBuilder list = cmp.horizontalList()
                                        .add(label("Gender", 3))
                                        .add(textCell(gender.equals(Gender.MALE) ? "X" : "", 1), label("Male", 2, textStyle))
                                        .add(textCell(gender.equals(Gender.FEMALE) ? "X" : "", 1), label("Female", 3, textStyle));
        return list;
    }

    private HorizontalListBuilder maritalStatus(MaritalStatus maritalStatus) {
        HorizontalListBuilder list = cmp.horizontalList()
                                        .add(label("Marital status", 5))
                                        .add(textCell(maritalStatus.equals(MaritalStatus.SINGLE) ? "X" : "", 1), label("Single", 3, textStyle))
                                        .add(textCell(maritalStatus.equals(MaritalStatus.MARRIED) ? "X" : "", 1), label("Married", 3, textStyle))
                                        .add(textCell(maritalStatus.equals(MaritalStatus.DIVORCED) ? "X" : "", 1), label("Divorced", 3, textStyle));
        return list;
    }

    private FillerBuilder emptyCell(int size) {
        return cmp.gap(cellWidth * size, cellHeight);
    }

    private HorizontalListBuilder textCell(String text, int size) {
        HorizontalListBuilder list = cmp.horizontalList();
        String cellText = StringUtils.rightPad(text, size);
        cellText = StringUtils.left(cellText, size);
        for (char character : cellText.toCharArray()) {
            TextFieldBuilder<String> cell = cmp.text(String.valueOf(character)).setStyle(cellStyle).setFixedDimension(cellWidth, cellHeight);
            list.add(cell);
        }
        return list;
    }

    private TextFieldBuilder<String> label(String text, int size) {
        return label(text, size, labelStyle);
    }

    private TextFieldBuilder<String> label(String text, int size, StyleBuilder style) {
        TextFieldBuilder<String> label = cmp.text(text).setFixedWidth(cellWidth * size);
        if (style != null) {
            label.setStyle(style);
        }
        return label;
    }
}
