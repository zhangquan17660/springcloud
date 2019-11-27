package com.zq.springcloud.controller;

import java.util.List;

import com.zq.springcloud.entities.Dept;
import com.zq.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassNameDeptController_Feign
 * @Description
 * @Author
 * @Date2019/11/22 9:42
 * @Version V1.0
 **/
@RestController
public class DeptController_Feign {
    @Resource
    private DeptClientService service ;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept) {
        return this.service.add(dept);
    }
}
