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
package net.sf.dynamicreports.adhoc.exception;

import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>AdhocException class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocException extends RuntimeException {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    ;

    /**
     * <p>Constructor for AdhocException.</p>
     *
     * @param message a {@link java.lang.String} object.
     */
    public AdhocException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for AdhocException.</p>
     *
     * @param cause a {@link java.lang.Throwable} object.
     */
    public AdhocException(Throwable cause) {
        super(cause);
    }

    /**
     * <p>Constructor for AdhocException.</p>
     *
     * @param message a {@link java.lang.String} object.
     * @param cause a {@link java.lang.Throwable} object.
     */
    public AdhocException(String message, Throwable cause) {
        super(message, cause);
    }

}
