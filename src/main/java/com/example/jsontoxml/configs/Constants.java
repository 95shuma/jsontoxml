package com.example.jsontoxml.configs;

public class Constants {

    public static final String exception_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<exception message>invalid request</message>";

    public static final String exception_xml_command = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<exception message>invalid command</message>";

    public static final String correcr_xml_check = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<response id=\"%d\" dts=\"%s\">\n" +
            "  <p_id>%d</p_id>\n" +
            "  <status>0</status>\n" +
            "  <message>ACCOUNT EXISTS</message>\n" +
            "</response>";

    public static final String correcr_xml_pay = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<response id=\"%d\" dts=\"%s\">\n" +
            "  <p_id>%d</p_id>\n" +
            "  <status>1</status>\n" +
            "  <message>PAYMENT CONFIRMED</message>\n" +
            "</response>";
}
