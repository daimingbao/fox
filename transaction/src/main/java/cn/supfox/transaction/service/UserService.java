package cn.supfox.transaction.service;


import cn.supfox.transaction.db.User;

/**
 * @author dmb
 * @since 2020/2/20
 */
public interface UserService {

    void register(User user);

    void delete(User user);

}
