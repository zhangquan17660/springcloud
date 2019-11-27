package com.zq.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zq.springcloud.entities.Dept;
import com.zq.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassNameDeptController
 * @Description
 * @Author
 * @Date2019/11/15 10:26
 * @Version V1.0
 **/
@RestController
public class DeptController
{
    @Autowired
    private DeptService service = null;

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept =  this.service.get(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("\"该ID：\"+id+\"没有没有对应的信息,null--@HystrixCommand\"");
        dept.setDb_source("no this database in MySQL");
        return dept;
    }




}

