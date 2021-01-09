package cn.supfox.pattern.mediator.chatroom;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //各个用户在一个聊天室发消息
        ChatRoom chatRoom = new ChatRoom();

        User tom = new User("Tom",chatRoom);
        User jerry = new User("Jerry",chatRoom);

        tom.sendMessage("Hi! I am Tom.");
        jerry.sendMessage("Hello! My name is Jerry.");
    }
}
