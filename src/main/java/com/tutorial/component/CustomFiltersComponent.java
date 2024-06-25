package com.tutorial.component;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.tutorial.filter.ReqRespFilter;

@Component
public class CustomFiltersComponent {

	/**
	 * 自定義 filter
	 */
	@Bean
	public FilterRegistrationBean<ReqRespFilter> loggingFilter() {
		FilterRegistrationBean<ReqRespFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new ReqRespFilter());
		registrationBean.addUrlPatterns("/account");
		registrationBean.setOrder(2);

		return registrationBean;
	}

}
