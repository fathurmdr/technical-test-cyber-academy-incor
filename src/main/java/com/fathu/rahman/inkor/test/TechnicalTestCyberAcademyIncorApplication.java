package com.fathu.rahman.inkor.test;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@SpringBootApplication
@ServletComponentScan
public class TechnicalTestCyberAcademyIncorApplication implements WebMvcConfigurer {

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

		String dbUrl = dotenv.get("DB_URL");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");

        System.setProperty("spring.datasource.url", dbUrl);
        System.setProperty("spring.datasource.username", dbUsername);
        System.setProperty("spring.datasource.password", dbPassword);
	
		SpringApplication.run(TechnicalTestCyberAcademyIncorApplication.class, args);
	}

}
