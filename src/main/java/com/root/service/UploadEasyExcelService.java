package com.root.service;

import java.util.List;

import com.root.entity.UploadEasyExcelData;

/**
 * @author riemann
 * @date 2019/12/19 23:31
 */

public interface UploadEasyExcelService {

    /**
     *查询所有
     * @return
     */
    List<UploadEasyExcelData> selectAll();

}

