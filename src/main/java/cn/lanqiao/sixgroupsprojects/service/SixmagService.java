package cn.lanqiao.sixgroupsprojects.service;

import cn.lanqiao.sixgroupsprojects.model.dto.SixmagLogin;
import cn.lanqiao.sixgroupsprojects.model.pojo.Manager;

public interface SixmagService {
    Manager login(SixmagLogin tUser);
}
