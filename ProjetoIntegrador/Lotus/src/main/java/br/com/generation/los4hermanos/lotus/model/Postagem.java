package br.com.generation.los4hermanos.lotus.model;

//import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_postagem")
public class Postagem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    
    @NotNull
    private String mensagem;
    
    /*@Temporal(TemporalType.TIMESTAMP)
    private Date data_postagem = new java.sql.Date(System.currentTimeMillis());          !!!! COMENTEI PORQUE NAO ESTAVA INSERINDO COM A DATA CORRETA */

    @NotNull
    @Size(min = 3, max = 50)
    private String titulo;

    private String midia; // Usuária irá inserir links

    @NotNull
    private String empresa;                                          /* ADICIONEI UM NOVO CAMPO PARA COLOCAR A EMPRESA QUE ESTA RECEBENDO A RECLAMAÇÃO */ 
    
    // RELACIONAMENTO
    @ManyToOne
    @JsonIgnoreProperties("postagem")    
    private Usuario usuario;

    // RELACIONAMENTO
    @ManyToOne
    @JsonIgnoreProperties("postagem")    
    private Tema tema;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /*public Date getData_postagem() {
        return this.data_postagem;
    }

    public void setData_postagem(Date data_postagem) {
        this.data_postagem = data_postagem;
    }*/

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMidia() {
        return this.midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tema getTema() {
        return this.tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }


    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }


}
