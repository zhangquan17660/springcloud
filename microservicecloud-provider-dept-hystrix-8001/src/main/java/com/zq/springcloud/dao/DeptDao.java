package com.zq.springcloud.dao;

import com.zq.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassNameDeptDao
 * @Description
 * @Author
 * @Date2019/11/15 10:22
 * @Version V1.0
 **/
@Mapper
public interface DeptDao
{
     boolean addDept(Dept dept);

     Dept findById(Long id);

     List<Dept> findAll();
}

