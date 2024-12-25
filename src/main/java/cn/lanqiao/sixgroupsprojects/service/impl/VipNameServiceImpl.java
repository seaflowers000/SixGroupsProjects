package cn.lanqiao.sixgroupsprojects.service.impl;
import cn.lanqiao.sixgroupsprojects.mapper.VipNameMapper;
import cn.lanqiao.sixgroupsprojects.service.VipNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VipNameServiceImpl implements VipNameService {
    // 依赖注入
    @Autowired
    private VipNameMapper vipNameMapper;
    @Override
    public List<VipNameMapper> selectAll() {
        final List<VipNameMapper> vipNameMappers = vipNameMapper.selectAll();
        if(vipNameMappers != null){
            // 有参数返回值
            return vipNameMappers;
        }else{
            return null;
        }
    }
}
