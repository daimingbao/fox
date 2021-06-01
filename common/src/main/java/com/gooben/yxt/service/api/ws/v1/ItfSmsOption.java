
package com.gooben.yxt.service.api.ws.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;itfSmsOption complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="itfSmsOption"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="extCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="hasSms" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="isFlashMsg" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="isLongMsg" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="isReceipt" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="needMO" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
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
@XmlType(name = "itfSmsOption", propOrder = {
    "content",
    "extCode",
    "hasSms",
    "isFlashMsg",
    "isLongMsg",
    "isReceipt",
    "needMO",
    "routeName"
})
public class ItfSmsOption {

    protected String content;
    protected String extCode;
    protected boolean hasSms;
    protected boolean isFlashMsg;
    protected boolean isLongMsg;
    protected boolean isReceipt;
    protected boolean needMO;
    protected String routeName;

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
     * 获取extCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtCode() {
        return extCode;
    }

    /**
     * 设置extCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtCode(String value) {
        this.extCode = value;
    }

    /**
     * 获取hasSms属性的值。
     * 
     */
    public boolean isHasSms() {
        return hasSms;
    }

    /**
     * 设置hasSms属性的值。
     * 
     */
    public void setHasSms(boolean value) {
        this.hasSms = value;
    }

    /**
     * 获取isFlashMsg属性的值。
     * 
     */
    public boolean isIsFlashMsg() {
        return isFlashMsg;
    }

    /**
     * 设置isFlashMsg属性的值。
     * 
     */
    public void setIsFlashMsg(boolean value) {
        this.isFlashMsg = value;
    }

    /**
     * 获取isLongMsg属性的值。
     * 
     */
    public boolean isIsLongMsg() {
        return isLongMsg;
    }

    /**
     * 设置isLongMsg属性的值。
     * 
     */
    public void setIsLongMsg(boolean value) {
        this.isLongMsg = value;
    }

    /**
     * 获取isReceipt属性的值。
     * 
     */
    public boolean isIsReceipt() {
        return isReceipt;
    }

    /**
     * 设置isReceipt属性的值。
     * 
     */
    public void setIsReceipt(boolean value) {
        this.isReceipt = value;
    }

    /**
     * 获取needMO属性的值。
     * 
     */
    public boolean isNeedMO() {
        return needMO;
    }

    /**
     * 设置needMO属性的值。
     * 
     */
    public void setNeedMO(boolean value) {
        this.needMO = value;
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
