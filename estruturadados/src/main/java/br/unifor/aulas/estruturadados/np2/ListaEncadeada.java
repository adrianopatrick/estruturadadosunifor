package br.unifor.aulas.estruturadados.np2;

import br.unifor.aulas.estruturadados.np1.Lista;

public class ListaEncadeada<E> implements Lista<E> {

	private No<E> primeiro;
	private No<E> ultimo;
	private int tamanho;

	@Override
	public void add(E e) {
		No<E> novo = new No<E>(e);
		if (tamanho == 0) {
			primeiro = novo;
		} else {
			ultimo.pt = novo;
		}
		ultimo = novo;
		this.tamanho++;
	}

	@Override
	public void add(int i, E e) {
		validaIndex(i);
		No<E> novo = new No<E>(e);
		if (isInitial(i)) {
			if (isEmpty()) {
				ultimo = novo;
			}
			novo.pt = primeiro.pt;
			primeiro = novo;
		} else if (isEnd(i)) {
			add(e);
		} else {
			No<E> anterior = getNo(i - 1);
			novo.pt = anterior.pt;
			anterior.pt = novo;
		}
		this.tamanho++;
	}

	private boolean isEnd(int i) {
		return i == size() - 1;
	}

	private boolean isInitial(int i) {
		return i == 0;
	}

	@Override
	public int size() {
		return this.tamanho;
	}

	@Override
	public Object get(int i) {
		this.validaIndex(i);
		No<E> proximo = this.primeiro;
		for (int j = 0; j < i; j++) {
			proximo = proximo.pt;
		}
		return proximo.valor;
	}

	public No<E> getNo(int i) {
		this.validaIndex(i);
		No<E> proximo = this.primeiro;
		for (int j = 0; j < i; j++) {
			proximo = proximo.pt;
		}
		return proximo;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(E e) {
		No<E> proximo = primeiro;
		for (int i = 0; i < size(); i++) {
			if (proximo.valor == e) {
				return true;
			}
			proximo = proximo.pt;
		}
		return false;
	}

	@Override
	public Object remove(int i) {
		this.validaIndex(i);
		Object valorRemovido = null;
		if(isInitial(i)) {
			valorRemovido = primeiro.valor;
			primeiro = primeiro.pt;
			if(isLastElement()){
				ultimo = null;
			}
		} else if(isEnd(i)) {
			No<E> anterior = getNo(i - 1);
			valorRemovido = ultimo.valor;
			ultimo = anterior;
			anterior.pt = null;
		} else {
			No<E> anterior = getNo(i - 1);
			No<E> buscado = getNo(i);
			valorRemovido = buscado.valor;
			anterior.pt = buscado.pt;
		}
		this.tamanho--;
		
		return valorRemovido;
	}

	@Override
	public boolean remove(E e) {
		No<E> proximo = primeiro;
		No<E> anterior = null;
		for(int i = 0; i < size(); i++) {
			if(proximo.valor == e) {
				if(isInitial(i)){
					if(isLastElement()){
						ultimo = null;
					}
					primeiro = primeiro.pt;
				} else if(isEnd(i)) {
					ultimo = anterior;
					ultimo.pt = null;
				} else {
					anterior.pt = proximo.pt;
				}
				this.tamanho--;
			}
			anterior = proximo.pt;
			proximo = proximo.pt;
		}
		return false;
	}

	private boolean isLastElement() {
		return primeiro == ultimo;
	}

	private static class No<E> {

		private Object valor;
		private No<E> pt;

		public No(Object valor) {
			this.valor = valor;
		}
	}

}
