package cn.supfox.pattern.command.player.actions;



import cn.supfox.pattern.command.player.GPlayer;
import cn.supfox.pattern.command.player.IAction;

/**
 * Created by Tom.
 */
public class PlayAction implements IAction {
    private GPlayer gplayer;

    public PlayAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    //真正播放是gplayer里干活<br>
    public void execute() {
        gplayer.play();
    }
}
