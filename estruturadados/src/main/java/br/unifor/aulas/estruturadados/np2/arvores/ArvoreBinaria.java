package br.unifor.aulas.estruturadados.np2.arvores;

import java.util.Comparator;

public class ArvoreBinaria<T> {

	private No<T> raiz = null;
	private Comparator<Object> comparator;
	
	public ArvoreBinaria(Comparator<Object> comparator) {
		this.comparator = comparator;
	}
	
	public void inserir(Object valor){
		inserir(raiz, valor);
	}
	
	private void inserir(No<T> no, Object valor) {
		if(isEmpty()) {
			this.raiz = new No<>(valor);
		} else {
			if(insereADireita(no, valor)) { 
				if(no.direito == null) {
					no.direito = new No<T>(valor);
				} else {
					inserir(no.direito, valor);
				}
			} else if(insereAEsquerda(no, valor)) {
				if(no.esquerdo == null) {
					no.esquerdo = new No<T>(valor);
				} else {
					inserir(no.esquerdo, valor);
				}
			}
		}
	}

	private boolean insereAEsquerda(No<T> no, Object valor) {
		return comparator.compare(valor, no.valor) < 0;
	}

	private boolean insereADireita(No<T> no, Object valor) {
		return comparator.compare(valor, no.valor) > 0;
	}

	private boolean isEmpty() {
		return raiz == null;
	}
	
	private static class No<T> {
		private Object valor;
		private No<T> esquerdo;
		private No<T> direito;
		
		public No(Object valor) {
			this.valor = valor;
		}
	}
}
