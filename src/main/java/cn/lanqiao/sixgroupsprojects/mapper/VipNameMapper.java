package cn.lanqiao.sixgroupsprojects.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VipNameMapper {
    /**
     * 1.查询所有会员
     */
    @Select("select * from vip_name where status = 0")
    List<VipNameMapper> selectAll();
}
