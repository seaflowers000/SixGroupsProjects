package cn.lanqiao.sixgroupsprojects.mapper;

import cn.lanqiao.sixgroupsprojects.model.dto.SixmagLogin;
import cn.lanqiao.sixgroupsprojects.model.pojo.Manager;
import org.apache.ibatis.annotations.Select;

public interface SixmagMapper {
    @Select("select * from t_user  where  account= #{account} and password=#{password} and delete_det=0")
    Manager login(SixmagLogin Manager);
}
