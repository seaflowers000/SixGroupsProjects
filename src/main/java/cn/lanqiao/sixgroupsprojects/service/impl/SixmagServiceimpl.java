package cn.lanqiao.sixgroupsprojects.service.impl;

import cn.lanqiao.sixgroupsprojects.mapper.SixmagMapper;
import cn.lanqiao.sixgroupsprojects.model.dto.SixmagLogin;
import cn.lanqiao.sixgroupsprojects.model.pojo.Manager;
import cn.lanqiao.sixgroupsprojects.service.SixmagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class SixmagServiceimpl implements SixmagService {
    @Autowired
    private SixmagMapper sixmagMapper;
    @Override
    public Manager login(SixmagLogin Manager){
        Manager result = sixmagMapper.login(Manager);
        if (result!=null){
            return result;
        }else   {
            return null;
        }
    }
}
