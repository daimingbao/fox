package cn.supfox.core.mapper;

import cn.supfox.core.db.BookUseDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookUseDetailMapper {
    @Insert(value = "insert into book_use_detail(user_tag, book_name, create_time) values (#{userTag}, #{bookName}, now())")
    void add(BookUseDetail bookUseDetail);
}
