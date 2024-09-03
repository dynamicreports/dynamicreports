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
package net.sf.dynamicreports.test.bugs;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;

/**
 * @author Ricardo Mariaca
 *         <p>
 *         The height in setDimension(Integer width, Integer height) of the
 *         DimensionComponentBuilder class is set with the width.
 */
public class Bug_2997586_Test {

  @Test
  public void test() {
    final Integer width = 150;
    final Integer height = 200;

    TextFieldBuilder<String> textField = cmp.text("").setDimension(width, height);
    assertEquals(width, textField.getComponent().getWidth(), "Component width");
    assertEquals(height, textField.getComponent().getHeight(), "Component height");

    textField = cmp.text("").setFixedDimension(width, height);
    assertEquals(width, textField.getComponent().getWidth(), "Component fixed width");
    assertEquals(height, textField.getComponent().getHeight(), "Component fixed height");

    textField = cmp.text("").setMinDimension(width, height);
    assertEquals(width, textField.getComponent().getWidth(), "Component min width");
    assertEquals(height, textField.getComponent().getHeight(), "Component min height");
  }
}
