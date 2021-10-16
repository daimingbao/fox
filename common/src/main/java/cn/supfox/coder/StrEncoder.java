package cn.supfox.coder;

import org.apache.cxf.wsdl.http.UrlEncoded;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StrEncoder {


    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(URLDecoder.decode("%E7%BC%96%E7%A0%81%E5%9D%91%E7%88%B9.pdf", "utf-8"));
    }
}
