package cn.supfox.transaction.service.impl;

import cn.supfox.transaction.service.BookUseDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.supfox.transaction.db.BookUseDetail;
import cn.supfox.transaction.service.BookUseService;
import cn.supfox.transaction.service.BookUseSummaryService;

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
