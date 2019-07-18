package com.akazam.service;

import org.springframework.web.multipart.MultipartFile;

public interface DataProcessService {
    String uploadExcelFile(MultipartFile excelFile) throws Exception;
}
