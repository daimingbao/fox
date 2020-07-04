package cn.supfox.transaction.service.impl;


import cn.supfox.transaction.mapper.BookUseDetailMapper;
import cn.supfox.transaction.service.BookUseDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.supfox.transaction.db.BookUseDetail;

import javax.annotation.Resource;


@Service
public class BookUseDetailServiceImpl implements BookUseDetailService {

    @Resource
    private BookUseDetailMapper bookUseDetailMapper;

    @Override
    @Transactional
    public void add(BookUseDetail bookUseDetail) {
        bookUseDetailMapper.add(bookUseDetail);
    }
}
