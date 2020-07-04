package cn.supfox.transaction.mapper;

import cn.supfox.transaction.db.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user (id, name) values (#{id}, #{name})")
    void insertSelective(User user);


}
