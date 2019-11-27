package com.zq.springcloud.service.impl;

import com.zq.springcloud.dao.DeptDao;
import com.zq.springcloud.entities.Dept;
import com.zq.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameDeptServiceImpl
 * @Description
 * @Author
 * @Date2019/11/15 10:24
 * @Version V1.0
 **/
@Service
public class DeptServiceImpl implements DeptService
{
    @Resource
    private DeptDao dao ;

    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }

}

