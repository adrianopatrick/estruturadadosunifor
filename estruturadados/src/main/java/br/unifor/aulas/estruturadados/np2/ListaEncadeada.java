package br.unifor.aulas.estruturadados.np2;

import br.unifor.aulas.estruturadados.np1.Lista;

public class ListaEncadeada<E> implements Lista<E> {
	
	private No<E> primeiro;
	private No<E> ultimo;
	private int tamanho;

	@Override
	public void add(E e) {
		No<E> novo = new No<E>(e);
		if(tamanho == 0) {
			primeiro = novo;
		} else {
			ultimo.pt = novo;
		}
		ultimo = novo;
		this.tamanho++;
	}

	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return this.tamanho;
	}

	@Override
	public Object get(int i) {
		this.validaIndex(i);
		No<E> proximo = this.primeiro;
		for(int j = 0; j < i; j++) {
			proximo = proximo.pt;
		}
		return proximo.valor;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static class No<E> {
		
		private Object valor;
		private No<E> pt;
		
		public No(Object valor) {
			this.valor = valor;
		}
	}

}
