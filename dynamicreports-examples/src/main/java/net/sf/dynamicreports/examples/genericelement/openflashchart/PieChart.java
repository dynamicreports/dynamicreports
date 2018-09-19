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

package net.sf.dynamicreports.examples.genericelement.openflashchart;

import net.sf.jasperreports.engine.JRRuntimeException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * <p>PieChart class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class PieChart implements ChartGenerator {
    private String title;
    private String backgroundColor = "ffffff";
    private String[] valueColors = {"fadf12", "ed262a", "006f3c", "fa6112", "409dcf", "e5018c", "eaab35"};
    private JSONArray values = new JSONArray();

    /** {@inheritDoc} */
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

    /**
     * <p>addValue.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @param value a {@link java.lang.Number} object.
     */
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

    /**
     * <p>Setter for the field <code>title</code>.</p>
     *
     * @param title a {@link java.lang.String} object.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <p>Setter for the field <code>backgroundColor</code>.</p>
     *
     * @param backgroundColor a {@link java.lang.String} object.
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * <p>Setter for the field <code>valueColors</code>.</p>
     *
     * @param valueColors an array of {@link java.lang.String} objects.
     */
    public void setValueColors(String[] valueColors) {
        this.valueColors = valueColors;
    }
}
