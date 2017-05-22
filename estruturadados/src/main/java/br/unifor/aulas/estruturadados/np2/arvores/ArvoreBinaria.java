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
			if(valorMaior(no, valor)) { 
				if(no.direito == null) {
					no.direito = new No<T>(valor);
				} else {
					inserir(no.direito, valor);
				}
			} else if(valorMenor(no, valor)) {
				if(no.esquerdo == null) {
					no.esquerdo = new No<T>(valor);
				} else {
					inserir(no.esquerdo, valor);
				}
			}
		}
	}
	
	public void remover(Object valor) throws Exception {
		if(isEmpty()) {
			throw new Exception("Estrutura vazia.");
		}
		remover(raiz, valor);
	}
	
	public void remover(No<T> no, Object valor) {
		if(valorMaior(no, valor)) {
			remover(no.direito, valor);
		} else if(valorMenor(no, valor)) {
			remover(no.esquerdo, valor);
		} else {
			if(no.direito != null) {
				no.valor = getMin(no.direito);
				remover(no.direito, no.valor);
			} else if(no.esquerdo != null) {
				no.valor = getMax(no.esquerdo);
				remover(no.esquerdo, no.valor);
			} else {
				no = null;
			}
		}
	}

	private Object getMax(No<T> esquerdo) {
		if(raiz.direito != null) {
			getMax(raiz.direito);
		}
		return raiz;
	}

	private Object getMin(No<T> raiz) {
		if(raiz.esquerdo != null) {
			getMin(raiz.esquerdo);
		} 
		return raiz;
	}

	private boolean valorMenor(No<T> no, Object valor) {
		return comparator.compare(valor, no.valor) < 0;
	}

	private boolean valorMaior(No<T> no, Object valor) {
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
