package com.crg.firstdemocrg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstDemoCrgApplicationTests {

	@Autowired
	private StringRedisTemplate strRedis;
	@Test
	public void contextLoads() {

		//操作String类型的数据
		ValueOperations<String, String> valueStr = strRedis.opsForValue();
		//存储一条数据
		valueStr.set("goodsProdu","长安");
        String goodsName = valueStr.get("goodsProdu");
        System.out.println(goodsName);


	}

}
