package br.unifor.aulas.estruturadados.np2;

import br.unifor.aulas.estruturadados.np1.Lista;

public class ListaDuplamenteEncadeada<E> implements Lista<E> {

	private No<E> primeiro;
	private No<E> ultimo;
	private int tamanho;

	private static class No<E> {
		private No<E> prox;
		private No<E> ant;
		private Object valor;

		private No(Object valor) {
			this.valor = valor;
		}
	}

	@Override
	public void add(E e) {
		No<E> novo = new No<>(e);
		if (isEmpty()) {
			primeiro = novo;
		} else {
			ultimo.prox = novo;
			novo.ant = ultimo;
		}
		ultimo = novo;
		this.tamanho++;
	}

	@Override
	public void add(int i, E e) {
		validaIndex(i);
		No<E> novo = new No<>(e);
		if (i == 0) {
			novo.prox = primeiro;
			if (isEmpty()) {
				ultimo = novo;
			} else {
				primeiro.ant = novo;
			}
			primeiro = novo;
		} else if (i == this.tamanho - 1) {
			this.add(e);
		} else {
			No<E> atual = getNo(i);
			novo.ant = atual.ant;
			novo.prox = atual;
			novo.ant.prox = novo;
			atual.ant = novo;
		}
		this.tamanho++;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object get(int i) {
		this.validaIndex(i);
		No<E> proximo = this.primeiro;
		for (int j = 0; j < i; j++) {
			proximo = proximo.prox;
		}
		return proximo.valor;
	}

	public No<E> getNo(int i) {
		this.validaIndex(i);
		No<E> proximo = this.primeiro;
		for (int j = 0; j < i; j++) {
			proximo = proximo.prox;
		}
		return proximo;
	}

	@Override
	public boolean isEmpty() {
		return this.tamanho == 0;
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
}
