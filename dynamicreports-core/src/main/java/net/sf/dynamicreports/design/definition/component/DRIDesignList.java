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
package net.sf.dynamicreports.design.definition.component;

import net.sf.dynamicreports.design.constant.ComponentGroupType;
import net.sf.dynamicreports.report.constant.ListType;

import java.util.List;

/**
 * <p>DRIDesignList interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface DRIDesignList extends DRIDesignComponent {

    /**
     * <p>getComponents.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<? extends DRIDesignComponent> getComponents();

    /**
     * <p>getType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ListType} object.
     */
    public ListType getType();

    /**
     * <p>getComponentGroupType.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.constant.ComponentGroupType} object.
     */
    public ComponentGroupType getComponentGroupType();

    /**
     * <p>getBackgroundComponent.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.component.DRIDesignComponent} object.
     */
    public DRIDesignComponent getBackgroundComponent();
}
