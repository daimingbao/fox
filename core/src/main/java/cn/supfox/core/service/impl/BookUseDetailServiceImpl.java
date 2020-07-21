package cn.supfox.core.service.impl;


import cn.supfox.core.db.BookUseDetail;
import cn.supfox.core.mapper.BookUseDetailMapper;
import cn.supfox.core.service.BookUseDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
