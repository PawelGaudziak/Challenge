package pl.pwn.reaktor.challenge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        auth.jdbcAuthentication()

                // sprawdzenie i pobranie loginu i hasła oraz czy jest aktywny po adresie email który jest loginem
                .usersByUsernameQuery("SELECT email, haslo, 1 FROM firmy WHERE email=?") // taka kolejność parametrów, jeśli w bazie nie mamy "active", to na sztywno trzeba by wpisać "1"
                .authoritiesByUsernameQuery("SELECT f.email, f.role FROM firmy f  WHERE f.email=?")

                //ustawienie klasy odpowiedzialnej za nawiązanie połączenia z bazą dancyh
                .dataSource(dataSource)

                //ustawienie sposobu szyfrowania hasła w bazie danych
                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // dostęp do adresów ... będzie miał tylko użytkownik o roli "user"
                .antMatchers("/KPO").hasAuthority("user")
                // poniższe linki (adresy url) są dostępne dla wszystkich zalogowanych bez względu na rolę
                //.antMatchers("/article/*", "/article").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")// adres strony z naszym formularzem logowania
                .defaultSuccessUrl("/") // domyślne przekierowanie po poprawnym zalogowaniu
                .failureUrl("/login?error=true") // adres agy jest błąd logowania
                .usernameParameter("email")
                .passwordParameter("haslo")
                .and() // w tym zapisie między kolejnymi "and" kolejność dowolna oprócz formLogin, które musi być najpierw
                .logout().logoutUrl("/logout").logoutSuccessUrl("/");


    }
}

