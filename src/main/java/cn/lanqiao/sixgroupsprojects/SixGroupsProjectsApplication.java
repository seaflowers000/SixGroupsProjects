package cn.lanqiao.sixgroupsprojects;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lanqiao.sixgroupsprojects.mapper")
public class SixGroupsProjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SixGroupsProjectsApplication.class, args);
    }

}
