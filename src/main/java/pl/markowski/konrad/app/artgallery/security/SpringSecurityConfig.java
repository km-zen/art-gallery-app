package pl.markowski.konrad.app.artgallery.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    // TODO: 28.09.2022 do formularza tworzącego autora dodać pola login / hasło  
    // z wyłączoną autentykacją rozwiązać problem braku wyświetlania h2 console
    // z wyłączoną autentykacją dodać nowego autora
    // z włączoną autentykacją zalogować się na utworzonego użytkownika 
    // TODO: 28.09.2022 dodać password encoder 

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
//                        .antMatchers("/", "/home").permitAll()
                                .antMatchers("/authors").hasRole("USER")
                                .antMatchers("/authors/create").hasRole("ADMIN")
//                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form.permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
        return new GalleryUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }
}
