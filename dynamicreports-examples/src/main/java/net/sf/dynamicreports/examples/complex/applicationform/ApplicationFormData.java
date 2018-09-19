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

package net.sf.dynamicreports.examples.complex.applicationform;

import net.sf.jasperreports.engine.JRDataSource;

import java.util.Calendar;

/**
 * <p>ApplicationFormData class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ApplicationFormData {
    private ApplicationForm applicationForm;

    /**
     * <p>Constructor for ApplicationFormData.</p>
     */
    public ApplicationFormData() {
        applicationForm = createApplicationForm();
    }

    private ApplicationForm createApplicationForm() {
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setFirstName("Mary");
        applicationForm.setLastName("Patterson");
        Calendar c = Calendar.getInstance();
        c.set(1990, 3, 11);
        applicationForm.setDateOfBirth(c.getTime());
        applicationForm.setGender(Gender.FEMALE);
        applicationForm.setMaritalStatus(MaritalStatus.MARRIED);
        applicationForm.setAddress("151 Pompton St.");
        applicationForm.setCity("Washington");
        applicationForm.setPostalCode("09820");
        applicationForm.setTelephone("12-744-14682");
        applicationForm.setMobile("259-182572");
        applicationForm.setEmail("mpatterson@noemail.com");

        return applicationForm;
    }

    /**
     * <p>Getter for the field <code>applicationForm</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.applicationform.ApplicationForm} object.
     */
    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    /**
     * <p>createDataSource.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRDataSource} object.
     */
    public JRDataSource createDataSource() {
        return null;
    }
}
