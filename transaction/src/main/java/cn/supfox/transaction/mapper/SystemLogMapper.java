package cn.supfox.transaction.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import cn.supfox.transaction.db.SystemLog;

@Mapper
public interface SystemLogMapper {

    @Insert("insert into system_log (id, log_date) values (#{logId}, #{logDate})")
    void add(SystemLog log);
}
