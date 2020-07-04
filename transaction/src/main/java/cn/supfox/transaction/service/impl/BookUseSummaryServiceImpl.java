package cn.supfox.transaction.service.impl;


import cn.supfox.transaction.db.BookUseSummary;
import cn.supfox.transaction.mapper.BookUseSummaryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.supfox.transaction.service.BookUseSummaryService;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class BookUseSummaryServiceImpl  implements BookUseSummaryService {

    @Resource
    private BookUseSummaryMapper bookUseSummaryMapper;

    @Override
    @Transactional
    public void increment(String bookName) {
        BookUseSummary bookUseSummary = bookUseSummaryMapper.get(bookName);
        if (Objects.isNull(bookUseSummary)) {
            bookUseSummary = new BookUseSummary();
            bookUseSummary.setBookName(bookName);
            bookUseSummary.setCount(1L);
            bookUseSummaryMapper.add(bookUseSummary);
        } else {
            Long originCount = bookUseSummary.getCount();
            bookUseSummary.setCount(originCount + 1);
            bookUseSummaryMapper.increment(bookUseSummary, originCount);
        }
    }
}
