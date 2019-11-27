package com.zq.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassNameMySelfRule
 * @Description
 * @Author
 * @Date2019/11/20 20:19
 * @Version V1.0
 **/
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        //return new RandomRule();//Ribbon默认是轮询，我自定义为随机

        return new RandomRule_ZY();//我自定义为每个机器被访问5次
    }
}
