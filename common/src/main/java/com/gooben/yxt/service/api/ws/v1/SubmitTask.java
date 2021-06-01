
package com.gooben.yxt.service.api.ws.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;submitTask complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="submitTask"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="details" type="{http://v1.ws.api.service.yxt.gooben.com/}itfSendDetail" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="atTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="itfOptions" type="{http://v1.ws.api.service.yxt.gooben.com/}itfOptions" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submitTask", propOrder = {
    "details",
    "atTime",
    "itfOptions"
})
public class SubmitTask {

    protected List<ItfSendDetail> details;
    protected String atTime;
    protected ItfOptions itfOptions;

    /**
     * Gets the value of the details property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the details property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDetails().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ItfSendDetail }
     * 
     * 
     */
    public List<ItfSendDetail> getDetails() {
        if (details == null) {
            details = new ArrayList<ItfSendDetail>();
        }
        return this.details;
    }

    public void setDetails(List<ItfSendDetail> details) {
        this.details = details;
    }

    /**
     * 获取atTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtTime() {
        return atTime;
    }

    /**
     * 设置atTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtTime(String value) {
        this.atTime = value;
    }

    /**
     * 获取itfOptions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ItfOptions }
     *     
     */
    public ItfOptions getItfOptions() {
        return itfOptions;
    }

    /**
     * 设置itfOptions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ItfOptions }
     *     
     */
    public void setItfOptions(ItfOptions value) {
        this.itfOptions = value;
    }

}
