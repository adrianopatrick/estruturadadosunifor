package br.unifor.aulas.estruturadados.np1;

public interface Lista<E> {

	/**
	 * @param Element
	 * 
	 * insere o elemento no final da lista.
	 * */
	void add(E e);
	
	/**
	 * inserir um elemento nos limites entre a posição 0 e
	 * a quantidade de elementos na lista.
	 * 
	 * @param index, element
	 * */
	void add(int i, E e);
	
	/**
	 * Retorna a quantidade de elementos da lista.
	 * */
	int size();
	
	/**
	 * Retorna o elemento da posição i.
	 * */
	Object get(int i);
	
	/**
	 * Retorna {true} se a lista estiver vazia e false caso contrário.
	 * */
	boolean isEmpty();
	
	boolean contains(E e);
	
	Object remove(int i);
	
	boolean remove(E e);
	
	default void validaIndex(int index) {
		if (index < 0 || index >= this.size()) {
			throw new ArrayIndexOutOfBoundsException("Índice fora do intervalo permitido.");
		}
	}
}
