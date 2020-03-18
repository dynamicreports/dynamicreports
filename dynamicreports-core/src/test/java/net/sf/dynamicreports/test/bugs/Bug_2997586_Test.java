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
package net.sf.dynamicreports.test.bugs;

import org.junit.Assert;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import org.junit.Test;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * <p>
 * The height in setDimension(Integer width, Integer height) of the DimensionComponentBuilder class is set with the width.
 */
public class Bug_2997586_Test {

    @Test
    public void test() {
        Integer width = 150;
        Integer height = 200;

        TextFieldBuilder<String> textField = cmp.text("").setDimension(width, height);
        Assert.assertEquals("Component width", width, textField.getComponent().getWidth());
        Assert.assertEquals("Component height", height, textField.getComponent().getHeight());

        textField = cmp.text("").setFixedDimension(width, height);
        Assert.assertEquals("Component fixed width", width, textField.getComponent().getWidth());
        Assert.assertEquals("Component fixed height", height, textField.getComponent().getHeight());

        textField = cmp.text("").setMinDimension(width, height);
        Assert.assertEquals("Component min width", width, textField.getComponent().getWidth());
        Assert.assertEquals("Component min height", height, textField.getComponent().getHeight());
    }
}
