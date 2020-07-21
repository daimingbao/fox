package cn.supfox.core.service;


import cn.supfox.core.db.User;

/**
 * @author dmb
 * @since 2020/2/20
 */
public interface UserService {

    void register(User user);

    void delete(User user);

}
