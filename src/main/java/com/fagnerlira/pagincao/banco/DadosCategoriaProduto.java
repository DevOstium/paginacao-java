package com.fagnerlira.pagincao.banco;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fagnerlira.pagincao.domain.Categoria;
import com.fagnerlira.pagincao.domain.Produto;
import com.fagnerlira.pagincao.repositories.CategoriaRepository;

@Configuration
public class DadosCategoriaProduto {

	@Autowired
	private CategoriaRepository cat;
	
	@Bean
	public void loadDados() {
		
		 List<Categoria> categorias = 
			 Arrays.asList(
					 new Categoria("Hortfruiti", Arrays.asList( 
															new Produto("Banana",  LocalDate.now(), 2.50, 20, false),
															new Produto("Laranja", LocalDate.now(), 4.50, 60, false),
															new Produto("Maça",    LocalDate.now(), 8.50, 80, false),
															new Produto("Mamão",   LocalDate.now(), 1.50, 70, false),
															new Produto("Limão",   LocalDate.now(), 1.50, 70,  true),
															new Produto("Tomate",  LocalDate.now(), 1.50, 70,  true)
												  	      )
						                  ),
					 
					new Categoria("Bebidas", Arrays.asList( 
															new Produto("Coca-Cola 2L",           LocalDate.now(), 7.50,  120, false),
															new Produto("Cerveja Heineken 350ml", LocalDate.now(), 4.50,   70, false),
															new Produto("Leite Ninho 1L",         LocalDate.now(), 4.50,   55, false),
															new Produto("Vinho do Porto",         LocalDate.now(), 15.50,  32, false),
															new Produto("Cerveja Bhrama",         LocalDate.now(), 15.50,  32, false),
															new Produto("Suco de Uva",            LocalDate.now(), 15.50,  32,  true),
															new Produto("Suco de Melancia",       LocalDate.now(), 15.50,  32,  true)
														  )
								),
				
					new Categoria("Esportes", Arrays.asList( 
															new Produto("Chuteira",             LocalDate.now(), 150.50,  70, false),
															new Produto("Camisa do Flamengo",   LocalDate.now(), 452.50,  40, false),
															new Produto("Bola de couro",        LocalDate.now(), 260.50,  25, false),
															new Produto("Tênis de corrida",     LocalDate.now(), 550.50,  15, false),
															new Produto("Taco de Baseball",     LocalDate.now(), 854.50,  75, false),
															new Produto("Bone da Nike",         LocalDate.now(), 487.50,  2 ,  true),
															new Produto("Luva de Boxe",         LocalDate.now(), 342.50,  69,  true)
									                       )
                                  )	
					);
				  
		cat.saveAll( categorias);
	}
	
}














