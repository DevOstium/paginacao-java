package com.fagnerlira.pagincao.banco;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fagnerlira.pagincao.domain.Modulo;
import com.fagnerlira.pagincao.domain.Usuario;
import com.fagnerlira.pagincao.repositories.ModuloRepository;
import com.fagnerlira.pagincao.repositories.UsuarioRepository;

@Configuration
public class PopulaBanco {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private ModuloRepository modulo;

	@Bean
	public void usuaioDB() {
		
		
		modulo.saveAll( Arrays.asList(
										new Modulo("Prefeitura"),
										new Modulo("Marketing"),
										new Modulo("Laboratorio"),
										new Modulo("Comercial")
								     )
			         );	
		
		repo.saveAll(Arrays.asList(       
										new Usuario("Fagner Lira"),
										new Usuario("Maria Silva"),
										new Usuario("Geraldo Pereira"),
										new Usuario("Freira Lima"),
										new Usuario("Padre Souza"),
										new Usuario("Pedro de Deus"),
										new Usuario("Cristina do Brasil"),
										new Usuario("Samara Limpo"),
										new Usuario("Vanessa do Bairro"),
										new Usuario("Vera Part"),
										new Usuario("Keila Weat"),
										new Usuario("Hilda Poah"),
										new Usuario("Amalia Loois"),
										new Usuario("Renata Nass"),
										new Usuario("Helena Morais"),
										new Usuario("Leca Fei"),
										new Usuario("Monaca Fritas"),
										new Usuario("Roberta Mais"),
										new Usuario("Roberta Maia"),
										new Usuario("Alexssada Godin"),
										new Usuario("Amanda Liso"),
										new Usuario("Claudia Leite"),
										new Usuario("Vanessa Camargo"),
										new Usuario("Adriana Heito"),
										new Usuario("Priscila Boico"),
										new Usuario("Lucia Koite")
				));
	}
	
}
