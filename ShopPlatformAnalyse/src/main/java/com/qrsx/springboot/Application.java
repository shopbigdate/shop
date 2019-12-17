package com.qrsx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @ClassName: Application
 * @Description: TODO(启动类)
 * @author zsd
 * @date 2019年12月13日
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//清除spring boot的图标
		/*SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);*/
	}
}