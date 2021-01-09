package cn.supfox.pattern.state.order;

/**
 * 订单状态
 */
public enum OrderStatus {
    //WAIT_PAYMENT 状态的时候接收的动作是 PAYED --> , WAIT_DELIVER 状态的时候接收的动作是 DELIVERY, WAIT_RECEIVE 状态接收的动作是RECEIVED;
    // 待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}