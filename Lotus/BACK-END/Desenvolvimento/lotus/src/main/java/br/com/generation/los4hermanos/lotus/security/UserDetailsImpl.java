package br.com.generation.los4hermanos.lotus.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import br.com.generation.los4hermanos.lotus.model.Usuario;

public class UserDetailsImpl implements UserDetails{

    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    public UserDetailsImpl(Usuario usuario) {
        this.userName = usuario.getUsuario();
        this.password = usuario.getSenha();
    }

    public UserDetailsImpl() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    // Recupera a senha do Token
    @Override
    public String getPassword() {
        return password;
    }
    
    //Recupera o usuário do Token
    @Override
    public String getUsername() {
        return userName;
    }

    //Informa se a conta do usuário expirou
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    // Informa se a conta do usuário está bloqueada
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Informa se a senha do usuário expirou
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Informa se a conta do usuário está ativa
    @Override
    public boolean isEnabled() {
        return true;
    }

    
}