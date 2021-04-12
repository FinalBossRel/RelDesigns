package es.rel.dad.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/home").permitAll();
		http.authorizeRequests().antMatchers("/contact").permitAll();
		http.authorizeRequests().antMatchers("/artGallery").permitAll();
		http.authorizeRequests().antMatchers("/singin.html").permitAll();
		http.authorizeRequests().antMatchers("/createaccount.html").permitAll();
		http.authorizeRequests().antMatchers("/authorItems").permitAll();
		http.authorizeRequests().antMatchers("/**/*.jpg", "/*.css").permitAll();
		
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		
		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/shoppingCart").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
		
		http.authorizeRequests().anyRequest().authenticated();
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		
		http.formLogin().defaultSuccessUrl("/");
		
		http.formLogin().failureUrl("/loginerror");
		
		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");
		
		// Disable CSRF at the moment
		http.csrf().disable();			
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Users
		auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}adminpass").roles("USER", "ADMIN");
	}
	
}
