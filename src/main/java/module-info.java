module Farmazomat
{
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires lombok;
    requires com.google.common;

    opens pl.farmazomat;
    opens pl.farmazomat.view;
}