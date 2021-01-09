package cn.supfox.pattern.bridge.message;

/**
 * Created by Tom.
 */
//继承的话：EmailMessage extends UrgencyMessage  implements IMessage
public class EmailMessage implements IMessage {
    public void send(String message, String toUser) {
        System.out.println("使用邮件消息发送" + message + "给" + toUser);
    }
}
