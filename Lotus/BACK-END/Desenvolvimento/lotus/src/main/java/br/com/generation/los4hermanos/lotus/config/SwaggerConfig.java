package br.com.generation.los4hermanos.lotus.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    //Define a package onde estão as classes do tipo @RestController, para que o Swagger mapeie todas
    //as classes e seus respectivos endpoints para montar a documentação do projeto
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors
        .basePackage("br.com.generation.los4hermanos.lotus.controller")) //inserindo o pacote de controlador
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metadata())//chamando metodo 
        .useDefaultResponseMessages(false)
        .globalResponses(HttpMethod.GET, responseMessageForGet());

    }


    //configurando os dados da api 
    public static ApiInfo metadata() {

        return new ApiInfoBuilder()
        .title("API - LOTUS") //Define o titulo da sua aplicação que será exibida na documentação.
        .description("LOTUS trata-se de uma rede social voltada para avaliação das mulheres no ambiente de trabalho.") //Cria uma descrição para a sua aplicação
        .version("1.0.0") //Define a versão da sua aplicação.
        .license("Apache License Version 2.0") //Define o tipo de licença da sua aplicação.
        .licenseUrl("https://github.com/Isaquesc/Lotus")
        .contact(contact())
        .build();
    }

    private static Contact contact() {
        return new Contact ("Los 4 Hermanos ", "https://github.com/Isaquesc/Lotus", "llos4hermanos@gmail.com");
    }

    // Define as mensagens personalizadas para os códigos de Resposta do protocolo http (http
    // Response). Cada linha é referente a um Status Code.

    private static List<Response> responseMessageForGet() {
        return new ArrayList<Response>() {

            private static final long serialVersionUID = 1L;

            {
                add(new ResponseBuilder().code("200").description("Sucesso!").build()); // Salve todos arquivos e inicie a sua aplicação.
                add(new ResponseBuilder().code("201").description("Objeto Criado!").build());
                add(new ResponseBuilder().code("401").description("Não Autorizado!").build());
                add(new ResponseBuilder().code("403").description("Proibido!").build());
                add(new ResponseBuilder().code("404").description("Não Encontrado!").build());
                add(new ResponseBuilder().code("500").description("Erro!").build());
                }
        };
        
    }
    
}
