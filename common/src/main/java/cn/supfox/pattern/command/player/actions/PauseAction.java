package cn.supfox.pattern.command.player.actions;

import cn.supfox.pattern.command.player.GPlayer;
import cn.supfox.pattern.command.player.IAction;

/**
 * Created by Tom.
 */
public class PauseAction implements IAction {
    private GPlayer gplayer;

    public PauseAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    public void execute() {
        gplayer.pause();
    }
}
