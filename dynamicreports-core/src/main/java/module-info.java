module dynamicreports.core {

    exports net.sf.dynamicreports.design.base;
    exports net.sf.dynamicreports.design.constant;
    exports net.sf.dynamicreports.design.definition;
    exports net.sf.dynamicreports.design.exception;
    exports net.sf.dynamicreports.design.transformation;
    exports net.sf.dynamicreports.jasper.base;
    exports net.sf.dynamicreports.jasper.builder;
    exports net.sf.dynamicreports.jasper.constant;
    exports net.sf.dynamicreports.jasper.definition;
    exports net.sf.dynamicreports.jasper.exception;
    exports net.sf.dynamicreports.jasper.transformation;
    exports net.sf.dynamicreports.report;

    requires java.desktop;
    requires java.sql;
    requires java.xml;
    requires commons.lang3;
    requires jfreechart;
    requires jasperreports;
    requires slf4j.api;
}