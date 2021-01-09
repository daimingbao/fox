package cn.supfox.pattern.command.player;

import cn.supfox.pattern.command.player.actions.PauseAction;
import cn.supfox.pattern.command.player.actions.PlayAction;
import cn.supfox.pattern.command.player.actions.SpeedAction;
import cn.supfox.pattern.command.player.actions.StopAction;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //命令执行方
        GPlayer player = new GPlayer();

        //命令发送方，以后执行命令不用找gplayer直接找controller<br>
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));

        controller.addAction(new PauseAction(player));
        controller.addAction(new PlayAction(player));
        controller.addAction(new StopAction(player));
        controller.addAction(new SpeedAction(player));
        controller.executes();
    }
}