package ks46team01.interceptor.config;

import ks46team01.interceptor.AdminInterceptor;
import ks46team01.interceptor.PreventLoggedInUserAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/**")
                .addPathPatterns("/user/listUser")
                .addPathPatterns("/companies/listCompany");

        // 회원 로그인상태에서 회원가입 하는거 방지
        registry.addInterceptor(new PreventLoggedInUserAccessInterceptor())
                .addPathPatterns("/user/addUser");
    }
}


