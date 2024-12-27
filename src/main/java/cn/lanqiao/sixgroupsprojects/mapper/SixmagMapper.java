package cn.lanqiao.sixgroupsprojects.mapper;

import cn.lanqiao.sixgroupsprojects.model.dto.SixmagLogin;
import cn.lanqiao.sixgroupsprojects.model.pojo.Manager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SixmagMapper {
    @Select("select * from manager  where  account= #{account} and password=#{password} and delete_det=0")
    Manager login(SixmagLogin Manager);
    @Insert("insert into manager values (null,#{account},#{password},'游客',0)")
    int register(Manager tUser);
}
