package cn.lanqiao.sixgroupsprojects.controller;

import cn.lanqiao.sixgroupsprojects.service.SixmagService;
import cn.lanqiao.sixgroupsprojects.service.impl.SixmagServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mag")
public class SixmagController {
    @Autowired
    private SixmagService sixmagService;
}
