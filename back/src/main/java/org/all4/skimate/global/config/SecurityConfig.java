package org.all4.skimate.global.config;



import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.all4.skimate.jwt.filter.JwtAuthenticationProcessingFilter;
import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.login.filter.CustomJsonUsernamePasswordAuthenticationFilter;
import org.all4.skimate.login.handler.LoginFailureHandler;
import org.all4.skimate.login.service.LoginService;
import org.all4.skimate.login.handler.LoginSuccessHandler;
import org.all4.skimate.member.repository.MemberRepository;
import org.all4.skimate.oauth2.service.CustomOAuth2UserService;
import org.all4.skimate.oauth2.handler.OAuth2LoginFailureHandler;
import org.all4.skimate.oauth2.handler.OAuth2LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private final LoginService loginService;
    private final JwtService jwtService;
    private final MemberRepository memberRepository;
    private final ObjectMapper objectMapper;
    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
    private final OAuth2LoginFailureHandler oAuth2LoginFailureHandler;
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                // [PART 1]
                .formLogin().disable() // FormLogin ?????? X
                .httpBasic().disable()// httpBasic ?????? X
                .cors().configurationSource(corsConfigurationSource())
                .and().csrf().disable() // csrf ?????? ?????? X
//                .headers().frameOptions().disable()



                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()


                .authorizeRequests()


                .antMatchers("/","/css/**","/images/**","/js/**","/favicon.ico","/h2-console/**").permitAll()
                .antMatchers("/sign-up").permitAll()
                .antMatchers("/api/skiRounge").permitAll()
                .antMatchers("/api/lesson/list").permitAll()
                .antMatchers("/skiPost/**").permitAll()
                .anyRequest().authenticated() // ?????? ?????? ???????????? ?????? ????????? ???????????? ?????? ??????
                .and()

                .addFilterAfter(customJsonUsernamePasswordAuthenticationFilter(), LogoutFilter.class)
                .addFilterBefore(jwtAuthenticationProcessingFilter(), CustomJsonUsernamePasswordAuthenticationFilter.class)

                .oauth2Login()
                .successHandler(oAuth2LoginSuccessHandler) // ???????????? ??????????????? ????????? ??? Handler ??????
                .failureHandler(oAuth2LoginFailureHandler) // ?????? ????????? ?????? ??? ????????? ??????
                .userInfoEndpoint().userService(customOAuth2UserService); // customUserService ??????


        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(loginService);
        return new ProviderManager(provider);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler(jwtService, memberRepository);
    }

    /**
     * ????????? ?????? ??? ???????????? LoginFailureHandler ??? ??????
     */
    @Bean
    public LoginFailureHandler loginFailureHandler() {
        return new LoginFailureHandler();
    }




    @Bean
    public CustomJsonUsernamePasswordAuthenticationFilter customJsonUsernamePasswordAuthenticationFilter() {
        CustomJsonUsernamePasswordAuthenticationFilter passwordAuthenticationFilter
                = new CustomJsonUsernamePasswordAuthenticationFilter(objectMapper);
        passwordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        passwordAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
        passwordAuthenticationFilter.setAuthenticationFailureHandler(loginFailureHandler());
        return passwordAuthenticationFilter;
    }

    //[PART 5]
    @Bean
    public JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter() {
        JwtAuthenticationProcessingFilter jwtAuthenticationFilter = new JwtAuthenticationProcessingFilter(jwtService, memberRepository);
        return jwtAuthenticationFilter;
    }
}
