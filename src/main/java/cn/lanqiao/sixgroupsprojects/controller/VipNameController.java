package cn.lanqiao.sixgroupsprojects.controller;


import cn.lanqiao.sixgroupsprojects.mapper.VipNameMapper;
import cn.lanqiao.sixgroupsprojects.service.VipNameService;

import cn.lanqiao.sixgroupsprojects.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vipName")
public class VipNameController {
    // 注入依赖
    private VipNameService vipNameService;
    /**
     * 1.查询所有会员列表
     */
    @RequestMapping("/select")
    public ResponseUtils select(){
        //
        final List<VipNameMapper> vipNameMappers = vipNameService.selectAll();
        if(vipNameService == null){
            //查询为空(失败)
            return new ResponseUtils(500,"查询失败");
        }else{
            // 查询成功
            return new ResponseUtils(200,"查询成功",vipNameService);
        }


    }

}
