package br.com.generation.los4hermanos.lotus.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id // Identificador do Usuario
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Atributo Obrigatório")
    private String nome;

    @NotNull(message = "Atributo Obrigatório")
    private String email;

    @NotNull(message = "Atributo Obrigatório")
    private String senha;

    @NotNull(message = "Atributo Obrigatório")
    private String telefone;

    @NotNull(message = "Atributo Obrigatório")
    private String usuario;

    private String foto; // LINK FOTO DE PERFIL

    @NotNull(message = "Atributo Obrigatório")
    private String genero;

    @NotNull(message = "Atributo Obrigatório")
    private boolean pessoa_fisica;

    @CPF
    private String cpf;

    private String cnpj;

    private int score;  // atributo que determina nota de avaliação de uma empresa

    // RELACIONAMENTO
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isPessoa_fisica() {
        return this.pessoa_fisica;
    }

    public boolean getPessoa_fisica() {
        return this.pessoa_fisica;
    }

    public void setPessoa_fisica(boolean pessoa_fisica) {
        this.pessoa_fisica = pessoa_fisica;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Postagem> getPostagem() {
        return this.postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
}