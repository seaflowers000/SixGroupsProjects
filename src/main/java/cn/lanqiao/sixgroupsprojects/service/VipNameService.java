package cn.lanqiao.sixgroupsprojects.service;

import cn.lanqiao.sixgroupsprojects.mapper.VipNameMapper;

import java.util.List;

public interface VipNameService {
    /**
     * 查询所有会员列表
     */
    List<VipNameMapper> selectAll();
}
