package request;

import java.io.Serializable;

public class WechatEnpointRequest implements Serializable {

    private String signature;

    private Long timestamp;

    private Integer nonce;

    private String echostr;

    public String getSignature() {
        return signature;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getNonce() {
        return nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    @Override
    public String toString() {
        return "WechatEnpointRequest{" +
                "signature='" + signature + '\'' +
                ", timestamp=" + timestamp +
                ", nonce=" + nonce +
                ", echostr='" + echostr + '\'' +
                '}';
    }
}
