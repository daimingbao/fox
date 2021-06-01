
package com.gooben.yxt.service.api.ws.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;itfCallOption complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="itfCallOption"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="callContentType" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="hasCall" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="ivrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="retryInterval" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="retryNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itfCallOption", propOrder = {
    "callContentType",
    "content",
    "hasCall",
    "ivrCode",
    "retryInterval",
    "retryNumber",
    "routeName"
})
public class ItfCallOption {

    protected int callContentType;
    protected String content;
    protected boolean hasCall;
    protected String ivrCode;
    protected int retryInterval;
    protected int retryNumber;
    protected String routeName;

    /**
     * 获取callContentType属性的值。
     * 
     */
    public int getCallContentType() {
        return callContentType;
    }

    /**
     * 设置callContentType属性的值。
     * 
     */
    public void setCallContentType(int value) {
        this.callContentType = value;
    }

    /**
     * 获取content属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置content属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * 获取hasCall属性的值。
     * 
     */
    public boolean isHasCall() {
        return hasCall;
    }

    /**
     * 设置hasCall属性的值。
     * 
     */
    public void setHasCall(boolean value) {
        this.hasCall = value;
    }

    /**
     * 获取ivrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvrCode() {
        return ivrCode;
    }

    /**
     * 设置ivrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvrCode(String value) {
        this.ivrCode = value;
    }

    /**
     * 获取retryInterval属性的值。
     * 
     */
    public int getRetryInterval() {
        return retryInterval;
    }

    /**
     * 设置retryInterval属性的值。
     * 
     */
    public void setRetryInterval(int value) {
        this.retryInterval = value;
    }

    /**
     * 获取retryNumber属性的值。
     * 
     */
    public int getRetryNumber() {
        return retryNumber;
    }

    /**
     * 设置retryNumber属性的值。
     * 
     */
    public void setRetryNumber(int value) {
        this.retryNumber = value;
    }

    /**
     * 获取routeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * 设置routeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteName(String value) {
        this.routeName = value;
    }

}
