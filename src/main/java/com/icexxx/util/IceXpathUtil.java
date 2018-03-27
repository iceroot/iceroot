package com.icexxx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;

/**
 * xpath工具类
 * 
 * @author IceWater
 * @version 2.1
 */
public class IceXpathUtil {
    /**
     * 根据xpath表达式获取属性
     * 
     * @param fileName xml文件位置
     * @param xpathExpression xpath表达式
     * @return 获取的属性值
     * @since 2.1
     */
    public static String string(String fileName, String xpathExpression) {
        TransformerFactory transFact = TransformerFactory.newInstance();
        try {
            Transformer transFormer = transFact.newTransformer();
            DOMResult dom = new DOMResult();
            transFormer.transform(new StreamSource(new FileInputStream(new File(fileName))), dom);
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expression = xpath.compile(xpathExpression);
            String value = (String) expression.evaluate(dom.getNode(), XPathConstants.STRING);
            return value;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据xpath表达式获取xml对象
     * 
     * @param fileName xml文件路径
     * @param xpathExpression xpath表达式
     * @return 获取的xml对象
     */
    public static Element node(String fileName, String xpathExpression) {
        TransformerFactory transFact = TransformerFactory.newInstance();
        try {
            Transformer transFormer = transFact.newTransformer();
            DOMResult dom = new DOMResult();
            transFormer.transform(new StreamSource(new FileInputStream(new File(fileName))), dom);
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expression = xpath.compile(xpathExpression);
            org.w3c.dom.Element value = (Element) expression.evaluate(dom.getNode(), XPathConstants.NODE);
            return value;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取tomcat server.xml文件中的tomcat端口
     * 
     * @param fileName server.xml文件位置
     * @return 获取的tomcat端口
     */
    public static Integer tomcatPort(String fileName) {
        String xpathExpression = "/Server/Service/Connector[@protocol='HTTP/1.1']/@port";
        String value = string(fileName, xpathExpression);
        try {
            int parseInt = Integer.parseInt(value);
            return parseInt;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
