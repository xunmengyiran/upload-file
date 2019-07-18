package com.akazam.controller;

import com.akazam.bean.User;
import com.akazam.service.DataProcessService;
import com.akazam.service.UserService;
import com.akazam.utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dataprocessing")
public class DataProcessController {

    Logger log = LoggerFactory.getLogger(DataProcessController.class);

    @Autowired
    private DataProcessService dataProcessService;

    @Autowired
    private UserService userService;

    @RequestMapping("/goindex")
    public String goIndex() {
        return "index";
    }

    @RequestMapping("/godataimport")
    public String goDataImport() {
        return "data_import";
    }

    @RequestMapping("/importdata")
    public String importData() {
        return "";
    }

    @RequestMapping("/godataexport")
    public String goDataExport() {
        return "data_export";
    }

    @RequestMapping("/exportdata")
    public String exportData(HttpServletResponse response) {
        String[] headers = {"id", "userName", "password"};
        List<User> list = new ArrayList<User>();
        try {
            list = userService.getUserList();
            log.info("开始导出数据，数据总数" + list.size());
//            ExcelUtils.exportDBData2Excel(headers,list,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("/uploadexcel")
    public void uploadExcel(HttpServletResponse response, @RequestParam("excelFile") MultipartFile excelFile) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            String result= dataProcessService.uploadExcelFile(excelFile);
            log.info("==上传excel结果=="+result);
            pw.write(result);
            pw.flush();
        } catch (Exception e) {
            log.error("上传excel文件出错！");
            e.printStackTrace();
        }finally {
            if(pw != null){
                pw.close();
            }
        }
    }
}
