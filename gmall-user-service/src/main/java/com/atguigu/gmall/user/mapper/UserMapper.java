package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.bean.UmsMember;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<UmsMember> {
}
