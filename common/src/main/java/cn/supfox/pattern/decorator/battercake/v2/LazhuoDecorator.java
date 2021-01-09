package cn.supfox.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public class LazhuoDecorator extends BattercakeDecorator{

    public LazhuoDecorator(Battercake battercake) {
        super(battercake);
    }

    protected String getMsg(){ return super.getMsg() + "点蜡烛";}

    public int getPrice(){ return super.getPrice() + 2;}

}
