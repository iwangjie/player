package com.onblur7;

import com.onblur7.util.MD5Tools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerApplicationTests {

	@Test
	public void contextLoads() {
		String token1 = MD5Tools.md5EncodePassword("wooawooa","ronger");

		String token2 = MD5Tools.md5EncodePassword("wooawooa","kim");

		System.out.print("token1:"+token1+" token2:"+token2);
	}

}
