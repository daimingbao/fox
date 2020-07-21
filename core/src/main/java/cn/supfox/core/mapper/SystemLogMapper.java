package cn.supfox.core.mapper;

import cn.supfox.core.db.SystemLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemLogMapper {

    @Insert("insert into system_log (id, log_date) values (#{logId}, #{logDate})")
    void add(SystemLog log);
}
