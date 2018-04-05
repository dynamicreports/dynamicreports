/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

package net.sf.dynamicreports.examples.gettingstarted;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ContainerReport {
	private StyleBuilder boldCenteredStyle;
	private StyleBuilder borderedStyle;

	public ContainerReport() {
		build();
	}

	private void build() {
		boldCenteredStyle = stl.style()
				.bold()
				.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		borderedStyle = stl.style(stl.pen1Point());

		try {
			report()// create new report design
					.title(
							createTextField("Horizontal list (contains 10 textfields)"),
							createHorizontalList(),
							cmp.verticalGap(20),
							createTextField("Multi row horizontal list (contains 10 textfields)"),
							createMultiRowHorizontalList(),
							cmp.verticalGap(20),
							createTextField("Horizontal flow list (contains 9 textfields)"),
							createHorizontalFlowList(),
							cmp.verticalGap(20),
							createTextField("Vertical list (contains 4 textfields)"),
							createVerticalList(),
							cmp.verticalGap(20),
							createTextField("Nested list (contains 1 horizontal and 3 vertical lists)"),
							createNestedList())
					.show();// create and show report
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private TextFieldBuilder<String> createTextField(String label) {
		return cmp.text(label).setStyle(boldCenteredStyle);
	}

	private ComponentBuilder<?, ?> createHorizontalList() {
		HorizontalListBuilder horizontalList = cmp.horizontalList();
		for (int i = 0; i < 10; i++) {
			horizontalList.add(cmp.text("").setStyle(borderedStyle));
		}
		return horizontalList;
	}

	private ComponentBuilder<?, ?> createMultiRowHorizontalList() {
		HorizontalListBuilder horizontalList = cmp.horizontalList();
		for (int i = 0; i < 3; i++) {
			horizontalList.add(cmp.text("").setStyle(borderedStyle));
		}
		horizontalList.newRow();
		for (int i = 0; i < 7; i++) {
			horizontalList.add(cmp.text("").setStyle(borderedStyle));
		}
		return horizontalList;
	}

	private ComponentBuilder<?, ?> createHorizontalFlowList() {
		HorizontalListBuilder horizontalList = cmp.horizontalFlowList();
		for (int i = 0; i < 9; i++) {
			horizontalList.add(cmp.text("").setStyle(borderedStyle));
		}
		return horizontalList;
	}

	private ComponentBuilder<?, ?> createVerticalList() {
		VerticalListBuilder verticalList = cmp.verticalList();
		for (int i = 0; i < 4; i++) {
			verticalList.add(cmp.text("").setStyle(borderedStyle));
		}
		return verticalList;
	}

	private ComponentBuilder<?, ?> createNestedList() {
		HorizontalListBuilder horizontalList = cmp.horizontalList();
		for (int i = 0; i < 3; i++) {
			horizontalList.add(createVerticalList());
		}
		return horizontalList;
	}

	public static void main(String[] args) {
		new ContainerReport();
	}
}
