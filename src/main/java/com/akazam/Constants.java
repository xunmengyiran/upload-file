package com.akazam;

import java.text.SimpleDateFormat;

public interface Constants {

    interface DataFormat{
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    }

}
