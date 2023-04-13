package ks46team01.common.security.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable().cors().disable()
                    .authorizeHttpRequests(request -> request
                            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                            .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
                    )
                    .formLogin(login -> login	// form 방식 로그인 사용
                            .defaultSuccessUrl("/", true)	// 성공 시 main으로
                            .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
                    )
//                    .formLogin(login -> login
//                            .loginPage("/auth/login")	// [A] 커스텀 로그인 페이지 지정
//                            .loginProcessingUrl("/login-process")	// [B] submit 받을 url
//                            .usernameParameter("123")	// [C] submit할 아이디
//                            .passwordParameter("123")	// [D] submit할 비밀번호
//                            .defaultSuccessUrl("/", true)
//                            .permitAll()
//                    )
                    .logout(withDefaults());	// 로그아웃은 기본설정으로 (/logout으로 인증해제)

            return http.build();
        }
    }
