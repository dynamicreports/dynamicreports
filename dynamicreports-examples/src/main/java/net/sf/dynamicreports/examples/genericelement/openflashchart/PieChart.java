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

package net.sf.dynamicreports.examples.genericelement.openflashchart;

import net.sf.jasperreports.engine.JRRuntimeException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class PieChart implements ChartGenerator {
	private String title;
	private String backgroundColor = "ffffff";
	private String[] valueColors = { "fadf12", "ed262a", "006f3c", "fa6112", "409dcf", "e5018c", "eaab35" };
	private JSONArray values = new JSONArray();

	@Override
	public String generateChart() {
		try {
			JSONObject chart = new JSONObject();
			if (backgroundColor != null) {
				chart.put("bg_colour", backgroundColor);
			}
			if (title != null) {
				chart.put("title", new JSONObject().put("text", title));
			}

			JSONObject pie = new JSONObject();
			pie.put("type", "pie");
			pie.put("animate", true);
			pie.put("tip", "#val# of #total#<br>#percent#");
			pie.put("start-angle", 35);
			pie.put("border", 2);
			pie.put("alpha", .6);

			if (valueColors != null) {
				JSONArray colors = new JSONArray();
				for (int i = 0; i < valueColors.length; i++) {
					colors.put(valueColors[i]);
				}
				pie.put("colours", colors);
			}
			pie.put("values", values);

			JSONArray elements = new JSONArray();
			elements.put(pie);
			chart.put("elements", elements);

			return chart.toString();
		} catch (JSONException e) {
			throw new JRRuntimeException(e);
		}
	}

	public void addValue(String label, Number value) {
		JSONObject pieValue = new JSONObject();
		try {
			pieValue.put("value", value);
			pieValue.put("label", label);
		} catch (JSONException e) {
			throw new JRRuntimeException(e);
		}
		values.put(pieValue);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setValueColors(String[] valueColors) {
		this.valueColors = valueColors;
	}
}
