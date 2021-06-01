
package com.gooben.yxt.service.api.ws.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;itfOptions complex type的 Java 类。
 * 
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="itfOptions"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="itfCallOption" type="{http://v1.ws.api.service.yxt.gooben.com/}itfCallOption" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="itfExtentOptions"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="entry" maxOccurs="unbounded" minOccurs="0"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;sequence&amp;gt;
 *                             &amp;lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *                             &amp;lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *                           &amp;lt;/sequence&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/complexContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="itfSmsOption" type="{http://v1.ws.api.service.yxt.gooben.com/}itfSmsOption" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itfOptions", propOrder = {
    "itfCallOption",
    "itfExtentOptions",
    "itfSmsOption"
})
public class ItfOptions {

    protected ItfCallOption itfCallOption;
    @XmlElement(required = true)
    protected ItfOptions.ItfExtentOptions itfExtentOptions;
    protected ItfSmsOption itfSmsOption;

    /**
     * 获取itfCallOption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ItfCallOption }
     *     
     */
    public ItfCallOption getItfCallOption() {
        return itfCallOption;
    }

    /**
     * 设置itfCallOption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ItfCallOption }
     *     
     */
    public void setItfCallOption(ItfCallOption value) {
        this.itfCallOption = value;
    }

    /**
     * 获取itfExtentOptions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ItfOptions.ItfExtentOptions }
     *     
     */
    public ItfOptions.ItfExtentOptions getItfExtentOptions() {
        return itfExtentOptions;
    }

    /**
     * 设置itfExtentOptions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ItfOptions.ItfExtentOptions }
     *     
     */
    public void setItfExtentOptions(ItfOptions.ItfExtentOptions value) {
        this.itfExtentOptions = value;
    }

    /**
     * 获取itfSmsOption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ItfSmsOption }
     *     
     */
    public ItfSmsOption getItfSmsOption() {
        return itfSmsOption;
    }

    /**
     * 设置itfSmsOption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ItfSmsOption }
     *     
     */
    public void setItfSmsOption(ItfSmsOption value) {
        this.itfSmsOption = value;
    }


    /**
     * &lt;p&gt;anonymous complex type的 Java 类。
     * 
     * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="entry" maxOccurs="unbounded" minOccurs="0"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;sequence&amp;gt;
     *                   &amp;lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
     *                   &amp;lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
     *                 &amp;lt;/sequence&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/complexContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class ItfExtentOptions {

        protected List<ItfOptions.ItfExtentOptions.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * &lt;p&gt;
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the entry property.
         * 
         * &lt;p&gt;
         * For example, to add a new item, do as follows:
         * &lt;pre&gt;
         *    getEntry().add(newItem);
         * &lt;/pre&gt;
         * 
         * 
         * &lt;p&gt;
         * Objects of the following type(s) are allowed in the list
         * {@link ItfOptions.ItfExtentOptions.Entry }
         * 
         * 
         */
        public List<ItfOptions.ItfExtentOptions.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<ItfOptions.ItfExtentOptions.Entry>();
            }
            return this.entry;
        }


        /**
         * &lt;p&gt;anonymous complex type的 Java 类。
         * 
         * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;complexContent&amp;gt;
         *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *       &amp;lt;sequence&amp;gt;
         *         &amp;lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
         *         &amp;lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
         *       &amp;lt;/sequence&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected String key;
            protected String value;

            /**
             * 获取key属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * 设置key属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * 获取value属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * 设置value属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
