package com.ccb.ProdPms.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//登录配置

//自定义拦截器：继承WebMvcConfigurerAdapter和HandlerInterceptorAdapter来实现拦截器对登录请求进行拦截和session的判断

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

	// final关键字修饰的变量，只能进行一次赋值操作，并且在生存期内不可以改变它的值。
	public final static String SESSION_KEY = "username";

	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	// 添加注册拦截器来组成一个拦截链，以及用于添加拦截规则和排除不用的拦截
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

		addInterceptor.excludePathPatterns("/error");
		addInterceptor.excludePathPatterns("/login**");

		addInterceptor.addPathPatterns("/**");
	}

	private class SecurityInterceptor extends HandlerInterceptorAdapter {
		@SuppressWarnings("unused")
		public String preHandle(HttpServletRequest request, Object handler) throws IOException {
			HttpSession session = request.getSession();

			// 判断是否已有该用户登录的session
			if (session.getAttribute(SESSION_KEY) != null) {
				return "success";
			}
			return "redirect:/login";
			// 这里的response全局生效，导致其他所有请求的response都返回同样的登录页面，所以先把它注释掉，后续再改;上面的preHandle本来返回类型为boolean，先改成string做跳转
			/*
			 * // 跳转到登录页 String url = "/login"; response.sendRedirect(url);
			 */

		}
	}
}
