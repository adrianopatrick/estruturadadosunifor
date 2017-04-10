package br.unifor.aulas.estruturadados.np1;

public class ListaSimples<E> implements Lista<E> {

	private Object[] elementos = new Object[100];
	private int index = 0;

	@Override
	public void add(E e) {
		verificaEspaco();
		elementos[this.index++] = e;
	}

	@Override
	public void add(int i, E e) {
		verificaEspaco();
		validaIndex(i);
		if (elementos[i] != null) {
			for (int j = this.index; j > i; j--) {
				elementos[j] = elementos[j - 1];
			}
		}
		elementos[i] = e;
		this.index++;

	}

	@Override
	public int size() {
		return this.index;
	}

	@Override
	public Object get(int i) {
		validaIndex(i);
		return elementos[i];
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(E e) {
		Integer indice = BuscaSerial.buscar(elementos, e);
		return indice != null ? true : false;
	}

	@Override
	public Object remove(int i) {
		validaIndex(i);
		Object aRemover = this.get(i);
		this.remove(aRemover);
		return aRemover;
	}

	@Override
	public boolean remove(Object obj) {
		Integer indice = BuscaSerial.buscar(elementos, obj);

		if (indice != null) {
			if (indice < size() - 1) {
				for (int i = indice; i < size() - 1; i++) {
					elementos[i] = elementos[i + 1];
				}
			}
			elementos[--index] = null;
			return true;
		}

		return false;
	}

	private void verificaEspaco() {
		if (this.index == elementos.length) {
			throw new StackOverflowError("Não há mais espaço na lista");
		}
	}

	public static void main(String[] args) {
		Lista<Integer> lista = new ListaSimples<>();
		lista.add(10);
		lista.add(0, 30);

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i) + " ");
		}
	}

}
