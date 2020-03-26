/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report;

import net.sf.dynamicreports.report.constant.Calculation;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * ReportUtils class.
 * </p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class ReportUtils {
    private static final Lock LOCK = new ReentrantLock();
    private static int counter;

    /**
     * <p>
     * generateUniqueName.
     * </p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String generateUniqueName(String name) {
        try {
            LOCK.lock();
            return generateName(name);
        } finally {
            LOCK.unlock();
        }
    }

    /**
     * <p>
     * getVariableValueClass.
     * </p>
     *
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param valueClass  a {@link java.lang.Class} object.
     * @return a {@link java.lang.Class} object.
     */
    public static Class<?> getVariableValueClass(Calculation calculation, Class<?> valueClass) {
        if (calculation.equals(Calculation.COUNT) || calculation.equals(Calculation.DISTINCT_COUNT)) {
            return Long.class;
        }
        if (calculation.equals(Calculation.AVERAGE) || calculation.equals(Calculation.STANDARD_DEVIATION) || calculation.equals(Calculation.VARIANCE)) {
            return Number.class;
        }
        return valueClass;
    }

    /**
     * <p>
     * getGenericClass.
     * </p>
     *
     * @param object a {@link java.lang.Object} object.
     * @param index  a int.
     * @return a {@link java.lang.Class} object.
     */
    public static Class<?> getGenericClass(Object object, int index) {
        ParameterizedType genericSuperclass = getParameterizedType(object.getClass());
        if (genericSuperclass == null) {
            return String.class;
        }
        Class<?> rawType = getRawType(genericSuperclass.getActualTypeArguments()[index]);
        if (rawType == null) {
            return String.class;
        }
        return rawType;
    }

    /**
     * Setter for testing purposes only.
     *
     * @param counter the counter value
     */
    static void setCounter(int counter) {
        ReportUtils.counter = counter;
    }

    private static ParameterizedType getParameterizedType(Class<?> classs) {
        if (classs == null) {
            return null;
        }
        if (classs.getGenericSuperclass() instanceof ParameterizedType) {
            return (ParameterizedType) classs.getGenericSuperclass();
        }
        return getParameterizedType((Class<?>) classs.getGenericSuperclass());
    }

    private static Class<?> getRawType(Object typeArgument) {
        if (typeArgument instanceof ParameterizedType) {
            return getRawType(((ParameterizedType) typeArgument).getRawType());
        } else {
            if (typeArgument instanceof Class<?>) {
                return (Class<?>) typeArgument;
            } else {
                return null;
            }
        }
    }

    private static String generateName(String name) {
        if (counter == Integer.MAX_VALUE) {
            counter = 0;
        }
        return name + "_" + counter++ + "_";
    }
}
