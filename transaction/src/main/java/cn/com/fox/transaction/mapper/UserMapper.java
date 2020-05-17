package cn.com.fox.transaction.mapper;

import cn.com.fox.transaction.service.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user (id, name) values (#{id}, #{name})")
    void insertSelective(User user);


}
