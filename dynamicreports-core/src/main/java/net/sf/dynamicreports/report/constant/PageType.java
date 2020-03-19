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
package net.sf.dynamicreports.report.constant;

/**
 * <p>PageType class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public enum PageType {
    LETTER(612, 792), NOTE(540, 720), LEGAL(612, 1008), A0(2380, 3368), A1(1684, 2380), A2(1190, 1684), A3(842, 1190), A4(595, 842), A5(421, 595), A6(297, 421), A7(210, 297), A8(148, 210),
    A9(105, 148), A10(74, 105), B0(2836, 4008), B1(2004, 2836), B2(1418, 2004), B3(1002, 1418), B4(709, 1002), B5(501, 709), B6(353, 497), B7(252, 353), B8(173, 252), B9(122, 173), B10(86, 122),
    C0(2599, 3679), C1(1836, 2599), C2(1296, 1836), C3(922, 1296), C4(648, 922), C5(461, 648), C6(324, 461), C7(230, 324), C8(158, 230), C9(115, 158), C10(79, 115), ARCH_E(2592, 3456),
    ARCH_D(1728, 2592), ARCH_C(1296, 1728), ARCH_B(864, 1296), ARCH_A(648, 864), FLSA(612, 936), FLSE(612, 936), HALFLETTER(396, 612), _11X17(792, 1224), LEDGER(1224, 792);

    private int width;
    private int height;

    private PageType(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * <p>Getter for the field <code>width</code>.</p>
     *
     * @return a int.
     */
    public int getWidth() {
        return width;
    }

    /**
     * <p>Getter for the field <code>height</code>.</p>
     *
     * @return a int.
     */
    public int getHeight() {
        return height;
    }
}
