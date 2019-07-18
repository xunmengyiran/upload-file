package com.akazam.service.impl;

import com.akazam.Constants;
import com.akazam.service.DataProcessService;
import com.akazam.utils.ExcelUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataProcessServiceImpl implements DataProcessService {

    private Logger log = LoggerFactory.getLogger(DataProcessServiceImpl.class);

    @Override
    public String uploadExcelFile(MultipartFile excelFile) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        if (excelFile.isEmpty()) {
            resultMap.put("status", 0);
            resultMap.put("msg", "请选择文件");
        } else {
            long excelFileSize = excelFile.getSize();
            log.info("上传文件的大小为:" + excelFileSize);
            String excelFileName = excelFile.getOriginalFilename();
            log.info("上传文件的名称为:" + excelFileName);
            String subffix = excelFileName.substring(excelFileName.lastIndexOf(".") + 1, excelFileName.length());
            log.info("上传文件的格式为:" + subffix);
            String filePath = "C:\\Users\\DELL\\Desktop\\tmp\\"+Constants.DataFormat.sdf3.format(new Date())+excelFileName;
            File file = new File(filePath);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            excelFile.transferTo(file);
            List<String> sqlList = ExcelUtils.readExcelContent2DB(filePath);
            for (String s:sqlList){
                System.out.println("sql:"+s);
            }
            resultMap.put("status", 1);
            resultMap.put("msg", "上传成功");
        }
        JSONObject json = JSONObject.fromObject(resultMap);
        return json.toString();
    }
}
