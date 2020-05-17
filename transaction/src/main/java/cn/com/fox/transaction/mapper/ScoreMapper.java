package cn.com.fox.transaction.mapper;

import cn.com.fox.transaction.service.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreMapper {

    @Insert("insert into score (id, total) values (#{id}, #{total})")
    void add(Score score);
}
