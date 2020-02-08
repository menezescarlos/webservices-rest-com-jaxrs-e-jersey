package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.HttpServer;

public class ClienteTest {
	
    private HttpServer server;

    @Before
    public void before() {
       // ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
       //URI uri = URI.create("http://localhost:8080/");
       this.server = Servidor.inicializaServidor();
    }

    @After
    public void mataServidor() {
        server.stop();
    }

	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/carrinhos").request().get(String.class);
		//System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("Rua Vergueiro 3185"));
		
		
	
	
	}
}