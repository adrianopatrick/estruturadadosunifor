package br.unifor.aulas.estruturadados.np1;

import java.util.Comparator;

public class BuscaBinaria {

	/**
	 * Complexidade: O(lg n)
	 * */
	public static Integer busca(Integer[] numbers, Integer valor) {
		if(valor != null) {
			Integer inicio = 0;
			Integer fim = numbers.length - 1;

			Integer media = (inicio + fim) / 2;
			while (inicio <= fim) {
				if (numbers[media] == valor) {
					return media;
				} else if (numbers[media] > valor) {
					fim = media - 1;
				} else if (numbers[media] < valor) {
					inicio = media + 1;
				}
				media = (inicio + fim) / 2;
			}
		}
		return null;
	}

	/**
	 * O(n ^ 2)
	 */
	public static Integer buscar(Integer[] numbers, Integer valor, boolean isOrdered) {

		// O(n^2)
		if (!isOrdered) {
			InsertionSort.sort(numbers);
		}

		return buscar(numbers, valor, 0, numbers.length - 1);
	}

	public static Integer buscar(Object[] objs, Object valor, boolean isOrdered, Comparator<Object> comparator) {
		if (!isOrdered) {
			InsertionSort.sorting(objs, comparator);
		}

		return buscar(objs, valor, 0, objs.length - 1, comparator);
	}

	public static Integer buscar(Object[] objs, Object valor, Integer inicio, Integer fim, Comparator<Object> comparator) {
		if (inicio > fim) {
			return null;
		} else {
			Integer media = (inicio + fim) / 2;
			if (objs[media].equals(valor)) {
				return media;
			} else if (comparator.compare(objs[media], valor) < 0) {
				return buscar(objs, valor, media + 1, fim, comparator);
			} else if (comparator.compare(objs[media], valor) > 0) {
				return buscar(objs, valor, inicio, media - 1, comparator);
			}
		}

		return null;
	}

	/**
	 * O(ln n)
	 */
	public static Integer buscar(Integer[] numbers, Integer valor, Integer inicio, Integer fim) {

		if (inicio > fim) {
			return null;
		} else {
			Integer media = (inicio + fim) / 2;
			if (numbers[media] == valor) {
				return media;
			} else if (numbers[media] < valor) {
				return buscar(numbers, valor, media + 1, fim);
			} else if (numbers[media] > valor) {
				return buscar(numbers, valor, inicio, media - 1);
			}
		}

		return null;
	}

	public static void main(String[] args) {
		Pessoa[] pessoas = { new Pessoa("Pedro", "11111111111"), new Pessoa("Andre", "25222222222"),
				new Pessoa("Maria", "22222222222"), new Pessoa("Carlos", "5555555555") };

		System.out.println(buscar(pessoas, new Pessoa("Pedro", "11111111111"), false,
				(o1, o2) -> ((Pessoa) o1).getNome().compareTo(((Pessoa) o2).getNome())));
	}
}

class Pessoa {

	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + "]";
	}

}
