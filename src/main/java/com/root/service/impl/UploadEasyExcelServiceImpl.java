package com.root.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.root.dao.EasyExcelDao;
import com.root.entity.UploadEasyExcelData;
import com.root.service.UploadEasyExcelService;

import java.util.List;

/**
 * @author riemann
 * @date 2019/12/19 23:40
 */
//@Service
public class UploadEasyExcelServiceImpl implements UploadEasyExcelService {

    @Autowired
    private EasyExcelDao easyExcelDao;

    @Override
    public List<UploadEasyExcelData> selectAll() {
        return easyExcelDao.selectAll();
    }
}

