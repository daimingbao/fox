package cn.supfox.transaction.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import cn.supfox.transaction.db.BookUseDetail;

@Mapper
public interface BookUseDetailMapper {
    @Insert(value = "insert into book_use_detail(user_tag, book_name, create_time) values (#{userTag}, #{bookName}, now())")
    void add(BookUseDetail bookUseDetail);
}
