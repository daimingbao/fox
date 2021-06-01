
package com.gooben.yxt.service.api.ws.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;itfSubmitResultWs complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="itfSubmitResultWs"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="taskSmsId" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="taskCallId" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="beFilteredNumbers" type="{http://v1.ws.api.service.yxt.gooben.com/}ArrayOfItfBeFilteredNumber" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="itfAcceptedDetailSmses" type="{http://v1.ws.api.service.yxt.gooben.com/}ArrayOfItfAcceptedDetail" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="itfAcceptedDetailCalls" type="{http://v1.ws.api.service.yxt.gooben.com/}ArrayOfItfAcceptedDetail" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itfSubmitResultWs", propOrder = {
    "taskSmsId",
    "taskCallId",
    "status",
    "beFilteredNumbers",
    "itfAcceptedDetailSmses",
    "itfAcceptedDetailCalls"
})
public class ItfSubmitResultWs {

    protected long taskSmsId;
    protected long taskCallId;
    protected int status;
    protected ArrayOfItfBeFilteredNumber beFilteredNumbers;
    protected ArrayOfItfAcceptedDetail itfAcceptedDetailSmses;
    protected ArrayOfItfAcceptedDetail itfAcceptedDetailCalls;

    /**
     * 获取taskSmsId属性的值。
     * 
     */
    public long getTaskSmsId() {
        return taskSmsId;
    }

    /**
     * 设置taskSmsId属性的值。
     * 
     */
    public void setTaskSmsId(long value) {
        this.taskSmsId = value;
    }

    /**
     * 获取taskCallId属性的值。
     * 
     */
    public long getTaskCallId() {
        return taskCallId;
    }

    /**
     * 设置taskCallId属性的值。
     * 
     */
    public void setTaskCallId(long value) {
        this.taskCallId = value;
    }

    /**
     * 获取status属性的值。
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * 获取beFilteredNumbers属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItfBeFilteredNumber }
     *     
     */
    public ArrayOfItfBeFilteredNumber getBeFilteredNumbers() {
        return beFilteredNumbers;
    }

    /**
     * 设置beFilteredNumbers属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItfBeFilteredNumber }
     *     
     */
    public void setBeFilteredNumbers(ArrayOfItfBeFilteredNumber value) {
        this.beFilteredNumbers = value;
    }

    /**
     * 获取itfAcceptedDetailSmses属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItfAcceptedDetail }
     *     
     */
    public ArrayOfItfAcceptedDetail getItfAcceptedDetailSmses() {
        return itfAcceptedDetailSmses;
    }

    /**
     * 设置itfAcceptedDetailSmses属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItfAcceptedDetail }
     *     
     */
    public void setItfAcceptedDetailSmses(ArrayOfItfAcceptedDetail value) {
        this.itfAcceptedDetailSmses = value;
    }

    /**
     * 获取itfAcceptedDetailCalls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItfAcceptedDetail }
     *     
     */
    public ArrayOfItfAcceptedDetail getItfAcceptedDetailCalls() {
        return itfAcceptedDetailCalls;
    }

    /**
     * 设置itfAcceptedDetailCalls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItfAcceptedDetail }
     *     
     */
    public void setItfAcceptedDetailCalls(ArrayOfItfAcceptedDetail value) {
        this.itfAcceptedDetailCalls = value;
    }

}
