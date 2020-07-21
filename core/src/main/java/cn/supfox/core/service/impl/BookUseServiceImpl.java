package cn.supfox.core.service.impl;

import cn.supfox.core.db.BookUseDetail;
import cn.supfox.core.service.BookUseDetailService;
import cn.supfox.core.service.BookUseService;
import cn.supfox.core.service.BookUseSummaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BookUseServiceImpl implements BookUseService {

    @Resource
    private BookUseSummaryService bookUseSummaryService;

    @Resource
    private BookUseDetailService bookUseDetailService;


    @Override
    @Transactional
    public void useBook(String bookName, String userTag) {
        BookUseDetail bookUseDetail = new BookUseDetail();
        bookUseDetail.setBookName(bookName);
        bookUseDetail.setUserTag(userTag);
        bookUseDetailService.add(bookUseDetail);

        bookUseSummaryService.increment(bookName);
    }
}
