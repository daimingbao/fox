package cn.supfox.transaction.mapper;

import cn.supfox.transaction.db.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreMapper {

    @Insert("insert into score (id, total) values (#{id}, #{total})")
    void add(Score score);
}
