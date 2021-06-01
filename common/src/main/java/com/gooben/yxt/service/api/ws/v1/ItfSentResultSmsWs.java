
package com.gooben.yxt.service.api.ws.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;ItfSentResultSmsWs complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ItfSentResultSmsWs"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="receiptResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiptResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiptResultName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiveNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="resultDetails" type="{http://v1.ws.api.service.yxt.gooben.com/}ArrayOfItfTaskSmsListResult" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="sendNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="sentResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="sentResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="sentResultName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItfSentResultSmsWs", propOrder = {
    "receiptResult",
    "receiptResultCode",
    "receiptResultName",
    "receiveNumber",
    "resultDetails",
    "sendNumber",
    "sentResult",
    "sentResultCode",
    "sentResultName",
    "transactionId"
})
public class ItfSentResultSmsWs {

    protected Integer receiptResult;
    protected String receiptResultCode;
    protected String receiptResultName;
    protected String receiveNumber;
    protected ArrayOfItfTaskSmsListResult resultDetails;
    protected String sendNumber;
    protected Integer sentResult;
    protected String sentResultCode;
    protected String sentResultName;
    protected String transactionId;

    /**
     * 获取receiptResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReceiptResult() {
        return receiptResult;
    }

    /**
     * 设置receiptResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReceiptResult(Integer value) {
        this.receiptResult = value;
    }

    /**
     * 获取receiptResultCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptResultCode() {
        return receiptResultCode;
    }

    /**
     * 设置receiptResultCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptResultCode(String value) {
        this.receiptResultCode = value;
    }

    /**
     * 获取receiptResultName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptResultName() {
        return receiptResultName;
    }

    /**
     * 设置receiptResultName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptResultName(String value) {
        this.receiptResultName = value;
    }

    /**
     * 获取receiveNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiveNumber() {
        return receiveNumber;
    }

    /**
     * 设置receiveNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiveNumber(String value) {
        this.receiveNumber = value;
    }

    /**
     * 获取resultDetails属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItfTaskSmsListResult }
     *     
     */
    public ArrayOfItfTaskSmsListResult getResultDetails() {
        return resultDetails;
    }

    /**
     * 设置resultDetails属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItfTaskSmsListResult }
     *     
     */
    public void setResultDetails(ArrayOfItfTaskSmsListResult value) {
        this.resultDetails = value;
    }

    /**
     * 获取sendNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendNumber() {
        return sendNumber;
    }

    /**
     * 设置sendNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendNumber(String value) {
        this.sendNumber = value;
    }

    /**
     * 获取sentResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSentResult() {
        return sentResult;
    }

    /**
     * 设置sentResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSentResult(Integer value) {
        this.sentResult = value;
    }

    /**
     * 获取sentResultCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentResultCode() {
        return sentResultCode;
    }

    /**
     * 设置sentResultCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentResultCode(String value) {
        this.sentResultCode = value;
    }

    /**
     * 获取sentResultName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentResultName() {
        return sentResultName;
    }

    /**
     * 设置sentResultName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentResultName(String value) {
        this.sentResultName = value;
    }

    /**
     * 获取transactionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置transactionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

}
