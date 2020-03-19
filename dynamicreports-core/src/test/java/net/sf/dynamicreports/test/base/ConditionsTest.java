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
package net.sf.dynamicreports.test.base;

import org.junit.Assert;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;
import org.junit.Test;

import java.sql.Connection;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cnd;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;

/**
 * @author Ricardo Mariaca
 */
public class ConditionsTest {

    @Test
    public void test() {
        // equal
        FieldBuilder<Integer> value = field("name", Integer.class);
        //conditionTrue("equal", cnd.equal(value, 5, 10, 20));
        //conditionFalse("equal", cnd.equal(value, 5, 20));

        // unequal
        //conditionFalse("unequal", cnd.unEqual(value, 5, 10, 20));
        //conditionTrue("unequal", cnd.unEqual(value, 5, 20));

        // smaller
        conditionFalse("smaller", cnd.smaller(value, 5));
        conditionFalse("smaller", cnd.smaller(value, 10));
        conditionTrue("smaller", cnd.smaller(value, 15));

        // smallerOrEquals
        conditionFalse("smallerOrEquals", cnd.smallerOrEquals(value, 5));
        conditionTrue("smallerOrEquals", cnd.smallerOrEquals(value, 10));
        conditionTrue("smallerOrEquals", cnd.smallerOrEquals(value, 15));

        // greater
        conditionTrue("greater", cnd.greater(value, 5));
        conditionFalse("greater", cnd.greater(value, 10));
        conditionFalse("greater", cnd.greater(value, 15));

        // greaterOrEquals
        conditionTrue("greaterOrEquals", cnd.greaterOrEquals(value, 5));
        conditionTrue("greaterOrEquals", cnd.greaterOrEquals(value, 10));
        conditionFalse("greaterOrEquals", cnd.greaterOrEquals(value, 15));

        // between
        conditionTrue("between", cnd.between(value, 5, 15));
        conditionTrue("between", cnd.between(value, 5, 10));
        conditionTrue("between", cnd.between(value, 10, 20));
        conditionFalse("between", cnd.between(value, 5, 9));
        conditionFalse("between", cnd.between(value, 11, 20));

        // notBetween
        conditionFalse("notBetween", cnd.notBetween(value, 5, 15));
        conditionFalse("notBetween", cnd.notBetween(value, 5, 10));
        conditionFalse("notBetween", cnd.notBetween(value, 10, 20));
        conditionTrue("notBetween", cnd.notBetween(value, 5, 9));
        conditionTrue("notBetween", cnd.notBetween(value, 11, 20));

        // equal object
        FieldBuilder<Object> value2 = field("name", Object.class);
        conditionTrue("equal", cnd.equal(value2, Type.A, Type.C, Type.F), Type.C);
        conditionFalse("equal", cnd.equal(value2, Type.B, Type.C), Type.E);

        // unequal object
        conditionFalse("unequal", cnd.unEqual(value2, Type.A, Type.C, Type.F), Type.C);
        conditionTrue("unequal", cnd.unEqual(value2, Type.B, Type.C), Type.E);
    }

    private void conditionTrue(String name, DRISimpleExpression<Boolean> condition) {
        Assert.assertTrue(name + " condition", condition.evaluate(new TestReportParameters(10)));
    }

    private void conditionFalse(String name, DRISimpleExpression<Boolean> condition) {
        Assert.assertFalse(name + " condition", condition.evaluate(new TestReportParameters(10)));
    }

    private void conditionTrue(String name, DRISimpleExpression<Boolean> condition, Object actualValue) {
        Assert.assertTrue(name + " condition", condition.evaluate(new TestReportParameters(actualValue)));
    }

    private void conditionFalse(String name, DRISimpleExpression<Boolean> condition, Object actualValue) {
        Assert.assertFalse(name + " condition", condition.evaluate(new TestReportParameters(actualValue)));
    }

    private enum Type {
        A, B, C, D, E, F
    }

    private class TestReportParameters implements ReportParameters {
        private Object value;

        public TestReportParameters(Object value) {
            this.value = value;
        }

        @Override
        public Integer getColumnNumber() {
            return null;
        }

        @Override
        public Integer getColumnRowNumber() {
            return null;
        }

        @Override
        public Connection getConnection() {
            return null;
        }

        @Override
        public Integer getGroupCount(String groupName) {
            return null;
        }

        @Override
        public Locale getLocale() {
            return null;
        }

        @Override
        public String getMessage(String key) {
            return null;
        }

        @Override
        public String getMessage(String key, Object[] arguments) {
            return null;
        }

        @Override
        public Integer getPageNumber() {
            return null;
        }

        @Override
        public Integer getPageRowNumber() {
            return null;
        }

        @Override
        public Integer getReportRowNumber() {
            return null;
        }

        @Override
        public Integer getCrosstabRowNumber() {
            return null;
        }

        @Override
        public DRIScriptlet getScriptlet(String name) {
            return null;
        }

        @Override
        public <T> T getValue(String name) {
            return null;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T getValue(DRIValue<T> value) {
            return (T) this.value;
        }

        @Override
        public ReportParameters getMasterParameters() {
            return null;
        }

        @Override
        public Integer getSubreportWidth() {
            return null;
        }

        @Override
        public <T> T getFieldValue(String name) {
            return null;
        }

        @Override
        public <T> T getVariableValue(String name) {
            return null;
        }

        @Override
        public <T> T getParameterValue(String name) {
            return null;
        }
    }
}
