package br.com.generation.los4hermanos.lotus.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.generation.los4hermanos.lotus.model.UsuarioLogin;
import br.com.generation.los4hermanos.lotus.model.Usuario;
import br.com.generation.los4hermanos.lotus.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;


@Service //IMPLEMENTA AS REGRAS DE NEGOCIO DA API
public class UsuarioService {

    @Autowired
    private UsuarioRepository bancoRepository;


    //Regra de negocio
    //Método para efetuar cadastrar usuario no sistema e Criptografar a senha do mesmo
    public Usuario CadastrarUsuario(Usuario usuario) {

        // Verificando se o usuario ja existe
        if (bancoRepository.findAllByUsuarioContainingIgnoreCase(usuario.getUsuario()).isPresent())
            return null;

        // Verificando se o email ja existe
        if (bancoRepository.findAllByEmailContainingIgnoreCase(usuario.getEmail()).isPresent())
        return null;

        // Verificando se o cpf é valido
        if (bancoRepository.findAllByCpf(usuario.getCpf()).isPresent())
        return null;

        // Criptografia da senha
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(usuario.getSenha());

        //Atualiza a senha no objeto usuario, substituindo a senha digitada pela criptografada
        usuario.setSenha(senhaEncoder);

        return bancoRepository.save(usuario);
    }

    //Método para efetuar atualizar usuario no sistema
    public Optional<Usuario> atualizarUsuario(Usuario usuario){
		
		// Criptografia da senha
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
	
		/* Atualiza a senha no objeto usuario, ou seja,
		substitui a senha digitada pela senha criptografada */
		usuario.setSenha(senhaEncoder);
		
		return Optional.of(bancoRepository.save(usuario));

	}

    // Método para efetuar login no sistema
    public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = bancoRepository.findAllByEmailContainingIgnoreCase(user.get().getEmail());

        if (usuario.isPresent()) {
            if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

                String auth = user.get().getEmail() + ":" + user.get().getSenha();
                byte[]encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setNome(usuario.get().getNome());
                user.get().setCpf(usuario.get().getCpf());
                user.get().setUsuario(usuario.get().getUsuario());
                user.get().setSenha(usuario.get().getSenha());

                return user;
            }
        }

        return null;

    }
    
}
