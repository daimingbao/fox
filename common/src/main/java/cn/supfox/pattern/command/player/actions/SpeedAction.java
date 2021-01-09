package cn.supfox.pattern.command.player.actions;

import cn.supfox.pattern.command.player.GPlayer;
import cn.supfox.pattern.command.player.IAction;

/**
 * Created by Tom.
 */
public class SpeedAction implements IAction {
    private GPlayer gplayer;

    public SpeedAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    public void execute() {
        gplayer.speed();
    }
}
