package cn.supfox.transaction.mapper;

import cn.supfox.transaction.db.BookUseSummary;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookUseSummaryMapper {

    @Insert(value = "insert into book_use_summary(book_name, count, create_time) values (#{bookName}, #{count}, now())")
    void add(BookUseSummary bookUseSummary);

    @Select(value = "select * from book_use_summary where book_name = #{bookName}")
    BookUseSummary get(String bookName);

    @Update(value = "update book_use_summary set count = #{bookUseSummary.count} where book_name = #{bookUseSummary.bookName} and count = #{originCount}")
    void increment(@Param("bookUseSummary") BookUseSummary bookUseSummary, @Param("originCount") Long originCount);
}
