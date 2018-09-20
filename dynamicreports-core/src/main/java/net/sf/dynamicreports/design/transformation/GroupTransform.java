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

import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.DRDesignTableOfContentsHeading;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignFiller;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.design.transformation.expressions.GroupByDataTypeExpression;
import net.sf.dynamicreports.report.base.DRVariable;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.definition.DRIBand;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.DRIReport;
import net.sf.dynamicreports.report.definition.column.DRIValueColumn;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>GroupTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GroupTransform {
    private DesignTransformAccessor accessor;
    private List<? extends DRIGroup> groups;
    private Map<DRIGroup, DRDesignGroup> designGroups;
    private List<DRIValueColumn<?>> hideGroupColumns;
    private DRIGroup firstResetPageNumberGroup;
    private int groupPadding;

    /**
     * <p>Constructor for GroupTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public GroupTransform(DesignTransformAccessor accessor) {
        this.accessor = accessor;
        init();
    }

    private void init() {
        DRIReport report = accessor.getReport();
        groups = report.getGroups();
        designGroups = new LinkedHashMap<DRIGroup, DRDesignGroup>();
        hideGroupColumns = new ArrayList<DRIValueColumn<?>>();
        groupPadding = 0;
    }

    /**
     * <p>transform.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void transform() throws DRException {
        for (DRIGroup group : groups) {
            DRDesignGroup designGroup = group(group);
            addGroup(group, designGroup);
        }
    }

    private void addGroup(DRIGroup group, DRDesignGroup designGroup) {
        if (accessor.getTemplateTransform()
                    .isGroupHideColumn(group) && group.getValueField()
                                                      .getValueExpression() instanceof DRIValueColumn<?>) {
            hideGroupColumns.add((DRIValueColumn<?>) group.getValueField()
                                                          .getValueExpression());
        }
        designGroups.put(group, designGroup);
        if (firstResetPageNumberGroup == null && designGroup.isResetPageNumber()) {
            firstResetPageNumberGroup = group;
        }
        groupPadding += accessor.getTemplateTransform()
                                .getGroupPadding(group);
    }

    /**
     * <p>transformHeaderAndFooter.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void transformHeaderAndFooter() throws DRException {
        int groupPadding = 0;
        int level = 0;
        for (DRIGroup group : groups) {
            headerAndFooter(group, designGroups.get(group), groupPadding, level++);
            groupPadding += accessor.getTemplateTransform()
                                    .getGroupPadding(group);
        }
    }

    private void headerAndFooter(DRIGroup group, DRDesignGroup designGroup, int groupPadding, int level) throws DRException {
        DRDesignList header = new DRDesignList();
        TemplateTransform templateTransform = accessor.getTemplateTransform();

        DRDesignTableOfContentsHeading designTocHeading = accessor.getTableOfContentsTransform()
                                                                  .groupHeading(group, level);
        if (designTocHeading != null) {
            header.addComponent(designTocHeading.getReferenceField());
        }

        switch (templateTransform.getGroupHeaderLayout(group)) {
            case EMPTY:
                break;
            case TITLE_AND_VALUE:
                if (groupPadding > 0) {
                    DRDesignFiller filler = new DRDesignFiller();
                    filler.setWidth(groupPadding);
                    filler.setHeight(0);
                    header.addComponent(HorizontalCellComponentAlignment.CENTER, null, filler);
                }
                header.addComponent(HorizontalCellComponentAlignment.LEFT, null, titleComponent(group));
                DRDesignTextField valueComponent = valueComponent(group);
                header.addComponent(valueComponent);
                if (designTocHeading != null) {
                    valueComponent.setAnchorNameExpression(designTocHeading.getReferenceField()
                                                                           .getAnchorNameExpression());
                    valueComponent.setBookmarkLevel(designTocHeading.getReferenceField()
                                                                    .getBookmarkLevel());
                    valueComponent.setHyperLink(designTocHeading.getReferenceField()
                                                                .getHyperLink());
                }
                break;
            case VALUE:
                if (groupPadding > 0) {
                    DRDesignFiller filler = new DRDesignFiller();
                    filler.setWidth(groupPadding);
                    filler.setHeight(0);
                    header.addComponent(HorizontalCellComponentAlignment.CENTER, null, filler);
                }
                valueComponent = valueComponent(group);
                header.addComponent(valueComponent);
                if (designTocHeading != null) {
                    valueComponent.setAnchorNameExpression(designTocHeading.getReferenceField()
                                                                           .getAnchorNameExpression());
                    valueComponent.setBookmarkLevel(designTocHeading.getReferenceField()
                                                                    .getBookmarkLevel());
                    valueComponent.setHyperLink(designTocHeading.getReferenceField()
                                                                .getHyperLink());
                }
                break;
            default:
                throw new DRDesignReportException("Group header layout " + templateTransform.getGroupHeaderLayout(group)
                                                                                            .name() + " not supported");
        }
        if (!header.isEmpty()) {
            DRIBand bnd = group.getHeaderBand();
            DRDesignBand band = accessor.getBandTransform()
                                        .band("groupHeaderTitleAndValue", bnd, templateTransform.getGroupHeaderSplitType(bnd), templateTransform.getGroupHeaderStyle(bnd),
                                              templateTransform.getGroupHeaderBackgroundComponent(bnd));
            band.addComponent(header);
            designGroup.addHeaderBand(band);
        }

        DRIBand band = group.getHeaderBand();
        designGroup.addHeaderBand(
            groupBand("groupHeader", band, templateTransform.getGroupHeaderSplitType(band), templateTransform.getGroupHeaderStyle(band), templateTransform.getGroupHeaderBackgroundComponent(band),
                      groupPadding, designGroup));
        band = group.getFooterBand();
        designGroup.addFooterBand(
            groupBand("groupFooter", band, templateTransform.getGroupFooterSplitType(band), templateTransform.getGroupFooterStyle(band), templateTransform.getGroupFooterBackgroundComponent(band),
                      groupPadding, designGroup));
        if (templateTransform.isGroupShowColumnHeaderAndFooter(group)) {
            designGroup.addHeaderBand(accessor.getBandTransform()
                                              .getColumnHeaderForGroupBand());
            designGroup.addFooterBand(accessor.getBandTransform()
                                              .getColumnFooterBand());
        }
    }

    private DRDesignBand groupBand(String name, DRIBand band, SplitType splitType, DRIReportStyle defaultStyle, DRIComponent defaultBackgroundComponent, int groupPadding, DRDesignGroup resetGroup)
        throws DRException {
        DRDesignBand designBand = accessor.getBandTransform()
                                          .band(name, band, splitType, defaultStyle, defaultBackgroundComponent, ResetType.GROUP, resetGroup);
        if (groupPadding > 0) {
            DRDesignFiller filler = new DRDesignFiller();
            filler.setWidth(groupPadding);
            filler.setHeight(0);
            DRDesignList list = new DRDesignList();
            list.addComponent(HorizontalCellComponentAlignment.CENTER, null, filler);
            list.addComponent(designBand.getList());
            designBand.setList(list);
        }
        return designBand;
    }

    // title
    @SuppressWarnings("unchecked")
    private DRDesignComponent titleComponent(DRIGroup group) throws DRException {
        @SuppressWarnings("rawtypes") DRTextField titleField = new DRTextField();
        titleField.setValueExpression(group.getTitleExpression());
        titleField.setStyle(group.getTitleStyle());
        titleField.setWidth(group.getTitleWidth());
        DRDesignTextField designTitleField = accessor.getComponentTransform()
                                                     .textField(titleField, DefaultStyleType.GROUP_TITLE);
        designTitleField.setUniqueName("group_" + group.getName() + ".title");
        return designTitleField;
    }

    // value
    private DRDesignTextField valueComponent(DRIGroup group) throws DRException {
        DRDesignTextField designValueField = accessor.getComponentTransform()
                                                     .textField(group.getValueField(), DefaultStyleType.GROUP);
        designValueField.setUniqueName("group_" + group.getName());
        return designValueField;
    }

    // group
    @SuppressWarnings( {"unchecked", "rawtypes"})
    private DRDesignGroup group(DRIGroup group) throws DRException {
        TemplateTransform templateTransform = accessor.getTemplateTransform();
        DRDesignGroup designGroup = new DRDesignGroup(group.getName());
        designGroup.setStartInNewPage(templateTransform.isGroupStartInNewPage(group));
        designGroup.setStartInNewColumn(templateTransform.isGroupStartInNewColumn(group));
        designGroup.setReprintHeaderOnEachPage(templateTransform.isGroupReprintHeaderOnEachPage(group));
        designGroup.setResetPageNumber(templateTransform.isGroupResetPageNumber(group));
        designGroup.setMinHeightToStartNewPage(templateTransform.getGroupMinHeightToStartNewPage(group));
        designGroup.setFooterPosition(templateTransform.getGroupFooterPosition(group));
        designGroup.setKeepTogether(templateTransform.isGroupKeepTogether(group));
        designGroup.setHeaderWithSubtotal(templateTransform.isGroupHeaderWithSubtotal(group));
        DRIExpression<?> groupExpression = group.getValueField()
                                                .getValueExpression();
        if (templateTransform.isGroupByDataType(group) && group.getValueField()
                                                               .getDataType() != null) {
            accessor.getExpressionTransform()
                    .transformExpression(groupExpression);
            DRIDataType<?, ?> dataType = group.getValueField()
                                              .getDataType();
            groupExpression = new GroupByDataTypeExpression(groupExpression, dataType);
        }
        groupExpression = new DRVariable(groupExpression, Calculation.NOTHING);
        designGroup.setGroupExpression(accessor.getExpressionTransform()
                                               .transformExpression(groupExpression));
        return designGroup;
    }

    /**
     * <p>getGroup.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     */
    protected DRDesignGroup getGroup(DRIGroup group) {
        return designGroups.get(group);
    }

    /**
     * <p>getFirstGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     */
    protected DRIGroup getFirstGroup() {
        if (!groups.isEmpty()) {
            return groups.get(0);
        }
        return null;
    }

    /**
     * <p>getBeforeGroup.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     */
    protected DRIGroup getBeforeGroup(DRIGroup group) {
        if (groups.size() > 1 && groups.indexOf(group) > 0) {
            return groups.get(groups.indexOf(group) - 1);
        }
        return null;
    }

    /**
     * <p>getLastGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     */
    protected DRIGroup getLastGroup() {
        if (!groups.isEmpty()) {
            return groups.get(groups.size() - 1);
        }
        return null;
    }

    /**
     * <p>Getter for the field <code>firstResetPageNumberGroup</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     */
    protected DRIGroup getFirstResetPageNumberGroup() {
        return firstResetPageNumberGroup;
    }

    /**
     * <p>Getter for the field <code>groupPadding</code>.</p>
     *
     * @return a int.
     */
    protected int getGroupPadding() {
        return groupPadding;
    }

    /**
     * <p>Getter for the field <code>hideGroupColumns</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    protected List<DRIValueColumn<?>> getHideGroupColumns() {
        return hideGroupColumns;
    }

    /**
     * <p>Getter for the field <code>groups</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRDesignGroup> getGroups() {
        return designGroups.values();
    }

}
