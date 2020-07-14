package com.atguigu.gmall.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TestJwt {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("memberId","1");
        map.put("nickname","akai");
        String ip="127.0.0.1";
        String time = new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
        String encode = JwtUtil.encode("2019gmall0105", map, ip + time);

        System.out.println(encode);
    }
}
