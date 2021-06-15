package br.com.generation.los4hermanos.lotus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    // Define que todas as autenticações serão do tipo userDetailsService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.inMemoryAuthentication()
        .withUser("lotus")
        .password(senhaEncoder()
        .encode("lotus"))
        .authorities("ROLE_USER");
    }

    // Define a classe que fará o encode (Criptografia) da senha
	// As Classes de encode são definidas na dependência commons-codec
    @Bean
    public PasswordEncoder senhaEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Método responsável por configurar as requisições (Requests) da API 
    @Override
    protected void configure(HttpSecurity htpp) throws Exception {
        htpp.authorizeRequests()
        .antMatchers("/usuario/logar").permitAll()
        .antMatchers("/usuario/cadastrar").permitAll()
        .antMatchers("/usuario/atualizar").permitAll()
        .anyRequest().authenticated() // SOLICITANDO TOKEN PARA
                                                                                            // TUDO QUE NAO SEJA O
                                                                                            // ENDPOINTS ACIMA
        .and().httpBasic() // UTILIZANDO O PADRAO BASIC PARA GERAR A CHAVE TOKEN
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // INDICAR QUAL É O
                                                                                                  // TIPO DE SESSÃO QUE
                                                                                                  // VAMOS UTILIZAR
        .and().cors() // HABILITANDO O CORS
        .and().csrf().disable(); // DESABILITANDO O CSRF (ESTAMOS UTILIZANDO TODOS AS CONF PADRAO)
    }

    
}