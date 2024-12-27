package cn.lanqiao.sixgroupsprojects.mapper;

import cn.lanqiao.sixgroupsprojects.model.dto.SixmagLogin;
import cn.lanqiao.sixgroupsprojects.model.pojo.Manager;

public interface SixmagMapper {
    Manager login(SixmagLogin manager);
    int register(Manager manager);
}