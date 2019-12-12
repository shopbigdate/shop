package com.qrsx.springboot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 
 * @ClassName: CorsConfig
 * @Description:对跨域的配置
 * @author: 姜振楠
 * @date: 2019年12月11日 下午4:47:55
 * 
 */
@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
		registry.addMapping("/**")
				// 允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容
				.allowedOrigins("*")
				// 是否允许用户发送、处理
				.allowCredentials(true)
				// 允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				// 预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
				.maxAge(3600);
	}
}
