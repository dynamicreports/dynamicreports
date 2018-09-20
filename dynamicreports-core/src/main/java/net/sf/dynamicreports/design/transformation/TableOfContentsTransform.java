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
package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.DRDesignTableOfContentsHeading;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.transformation.expressions.TocPrintWhenExpression;
import net.sf.dynamicreports.design.transformation.expressions.TocReferenceExpression;
import net.sf.dynamicreports.design.transformation.expressions.TocReferenceLinkExpression;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.DRITableOfContentsHeading;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.component.DRIHyperLinkComponent;
import net.sf.dynamicreports.report.definition.component.DRITextField;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>TableOfContentsTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class TableOfContentsTransform {
    private DesignTransformAccessor accessor;
    private Map<DRITableOfContentsHeading, Integer> levels;

    /**
     * <p>Constructor for TableOfContentsTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public TableOfContentsTransform(DesignTransformAccessor accessor) {
        this.accessor = accessor;
        this.levels = new HashMap<DRITableOfContentsHeading, Integer>();
    }

    /**
     * <p>componentHeading.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignTableOfContentsHeading} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRDesignTableOfContentsHeading componentHeading(DRIComponent component) throws DRException {
        DRITableOfContentsHeading tocHeading = component.getTableOfContentsHeading();
        boolean tableOfContents = accessor.isTableOfContents();
        if (tableOfContents && tocHeading != null) {
            DRTextField<String> referenceField = new DRTextField<String>();
            int level = getLevel(tocHeading);
            DRIExpression<?> labelExpression = tocHeading.getLabelExpression();
            if (labelExpression == null && component instanceof DRITextField) {
                labelExpression = ((DRITextField<?>) component).getValueExpression();
            }
            if (labelExpression == null) {
                labelExpression = Expressions.text("");
            }
            String expressionName = labelExpression.getName();
            DRIExpression<String> anchorNameExpression = null;
            if (component instanceof DRIHyperLinkComponent) {
                anchorNameExpression = ((DRIHyperLinkComponent) component).getAnchorNameExpression();
            }
            DRIExpression<?> customValueExpression = tocHeading.getCustomValueExpression();
            referenceField.setValueExpression(new TocReferenceExpression(level, expressionName, labelExpression, anchorNameExpression, customValueExpression));
            referenceField.setAnchorNameExpression(new TocReferenceLinkExpression(expressionName, anchorNameExpression));
            referenceField.setPrintWhenExpression(component.getPrintWhenExpression());
            DRDesignTextField designReferenceField = accessor.getComponentTransform()
                                                             .textField(referenceField, DefaultStyleType.TEXT);
            designReferenceField.setWidth(1);
            designReferenceField.setHeight(1);
            designReferenceField.setUniqueName(expressionName + ".tocReference");

            DRDesignTableOfContentsHeading designTocHeading = new DRDesignTableOfContentsHeading();
            designTocHeading.setReferenceField(designReferenceField);
            return designTocHeading;
        }

        return null;
    }

    private int getLevel(DRITableOfContentsHeading tocHeading) {
        if (levels.containsKey(tocHeading)) {
            return levels.get(tocHeading);
        }
        int level = 0;
        if (tocHeading.getParentHeading() != null) {
            level = getLevel(tocHeading.getParentHeading()) + 1;
        }
        levels.put(tocHeading, level);
        return level;
    }

    /**
     * <p>groupHeading.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @param level a int.
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignTableOfContentsHeading} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRDesignTableOfContentsHeading groupHeading(DRIGroup group, int level) throws DRException {
        boolean tableOfContents = accessor.isTableOfContents();
        boolean isAddGroupToTableOfContents = accessor.getTemplateTransform()
                                                      .isAddGroupToTableOfContents(group);
        if (tableOfContents && isAddGroupToTableOfContents) {
            DRTextField<String> referenceField = new DRTextField<String>();
            DRITextField<?> valueField = group.getValueField();
            referenceField.setValueExpression(new TocReferenceExpression(level, group.getName(), valueField.getValueExpression(), valueField.getAnchorNameExpression(), null));
            referenceField.setAnchorNameExpression(new TocReferenceLinkExpression(group.getName(), valueField.getAnchorNameExpression()));
            referenceField.setPrintWhenExpression(new TocPrintWhenExpression(valueField.getValueExpression()));
            DRDesignTextField designReferenceField = accessor.getComponentTransform()
                                                             .textField(referenceField, DefaultStyleType.TEXT);
            designReferenceField.setWidth(0);
            designReferenceField.setHeight(0);
            designReferenceField.setUniqueName("group_" + group.getName() + ".tocReference");

            DRDesignTableOfContentsHeading designTocHeading = new DRDesignTableOfContentsHeading();
            designTocHeading.setReferenceField(designReferenceField);
            return designTocHeading;
        }

        return null;
    }

}
