package br.unifor.aulas.estruturadados;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.aulas.estruturadados.np2.arvores.ArvoreBinaria;

public class ArvoreBinariaTest {
	
	private ArvoreBinaria<Integer> arvore;
	
	@BeforeClass
	public void init(){
		arvore = new ArvoreBinaria<>((o1, o2) -> ((Integer)o1).compareTo((Integer)o2));
	}
	

	@Test
	public void testAdd() {
		arvore.inserir(15);
		arvore.inserir(8);
		arvore.inserir(6);
		arvore.inserir(2);
		arvore.inserir(23);
		arvore.inserir(31);
	}

}
