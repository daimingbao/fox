package cn.supfox.proxy.service.impl;

import cn.supfox.proxy.service.TicketService;

public class TicketServiceImpl implements TicketService {

    @Override
    public void sendTicket(String userId, String ticketId) {
        System.out.println("给用户"+userId+"发券"+ticketId+"成功");
    }
}
