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
package net.sf.dynamicreports.examples.complex.applicationform;

import java.util.Date;

/**
 * <p>ApplicationForm class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class ApplicationForm {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String address;
    private String city;
    private String postalCode;
    private String telephone;
    private String mobile;
    private String email;

    /**
     * <p>Getter for the field <code>firstName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <p>Setter for the field <code>firstName</code>.</p>
     *
     * @param firstName a {@link java.lang.String} object.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <p>Getter for the field <code>lastName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <p>Setter for the field <code>lastName</code>.</p>
     *
     * @param lastName a {@link java.lang.String} object.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <p>Getter for the field <code>dateOfBirth</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * <p>Setter for the field <code>dateOfBirth</code>.</p>
     *
     * @param dateOfBirth a {@link java.util.Date} object.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * <p>Getter for the field <code>gender</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.applicationform.Gender} object.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * <p>Setter for the field <code>gender</code>.</p>
     *
     * @param gender a {@link net.sf.dynamicreports.examples.complex.applicationform.Gender} object.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * <p>Getter for the field <code>maritalStatus</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.examples.complex.applicationform.MaritalStatus} object.
     */
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * <p>Setter for the field <code>maritalStatus</code>.</p>
     *
     * @param maritalStatus a {@link net.sf.dynamicreports.examples.complex.applicationform.MaritalStatus} object.
     */
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * <p>Getter for the field <code>address</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>Setter for the field <code>address</code>.</p>
     *
     * @param address a {@link java.lang.String} object.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <p>Getter for the field <code>city</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCity() {
        return city;
    }

    /**
     * <p>Setter for the field <code>city</code>.</p>
     *
     * @param city a {@link java.lang.String} object.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * <p>Getter for the field <code>postalCode</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * <p>Setter for the field <code>postalCode</code>.</p>
     *
     * @param postalCode a {@link java.lang.String} object.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * <p>Getter for the field <code>telephone</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * <p>Setter for the field <code>telephone</code>.</p>
     *
     * @param telephone a {@link java.lang.String} object.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * <p>Getter for the field <code>mobile</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * <p>Setter for the field <code>mobile</code>.</p>
     *
     * @param mobile a {@link java.lang.String} object.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * <p>Getter for the field <code>email</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>Setter for the field <code>email</code>.</p>
     *
     * @param email a {@link java.lang.String} object.
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
