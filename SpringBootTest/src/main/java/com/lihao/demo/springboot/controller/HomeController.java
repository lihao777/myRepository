package com.lihao.demo.springboot.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lihao.demo.springboot.po.User;
import com.lihao.demo.springboot.service.UserService;



@Controller
// 将对应key值的对象设置到httpsession中
@SessionAttributes("user")
public class HomeController {

	@RequestMapping("/")
	public String main(Map<String, Object>map) {
		// 从session中，获取user对应的值，在servlet中，采用：request.getSession().getAttribute("user");
		if (map.get("user") == null) {
			return "redirect:/login";
		}
		// <!-- jsp所在的位置-->
		// <property name="prefix" value="/WEB-INF/jsp/" />
		// <!-- jsp文件的后缀名-->
		// <property name="suffix" value=".jsp" />
		// /WEB-INF/jsp/main.jsp
		return "main";
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		// 视图名称：login
		// 在springMVC-servlet.xml中配置了视图解析器，给视图名称加上前缀和后缀，从而拼接为一个完成的jsp路径
		return "login";
	}

	@Resource // 注入，@Autowired
	private UserService userService;
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String password, Map<String, Object> map) {
		User u = userService.authenticate (userName, password);
		// 认证成功
		if (u != null) {
			// 在servlet开发中，设置session：request.getSession().setAttribute ("user", userName);
			// 在springmvc中，设置session需要在类上面加上@SessionAtrributes
			map.put("user", userName);
			return "redirect:/";
		}
		// 认证失败
		// 在servlet开发中：request.setAttribute ("msg", "认证失败！");
		// 在sringmvc开发中：
		map.put("msg", "认证失败！");
		return "login";
	}
	
	/**
	 * 响应退出按钮点击时请求的URL
	 * @param map
	 * @param status
	 * @return
	 */
	@RequestMapping ("/logout")
	public String logout (Map<String, Object>map, SessionStatus status) {
		// 从session中删除用户信息
		map.remove("user");
		// 表示更新session
		status.setComplete();
		// 重定向到登录页面
		return "redirect:/login";
	}
	
}
