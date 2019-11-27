package com.zq.springcloud.controller;

import com.zq.springcloud.entities.Dept;
import com.zq.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameDeptController
 * @Description
 * @Author
 * @Date2019/11/15 10:26
 * @Version V1.0
 **/
@RestController
@RequestMapping("/dept")
public class DeptController
{
    @Autowired
    private DeptService service;
    @Resource
    private DiscoveryClient client;
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }



}

