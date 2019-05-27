package arvoreRubroNegra;

import java.awt.image.ConvolveOp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class Arvore {

	public static void main(String[] args) {

		
		// TesteAdicaoAleatorio(20000);
		// TesteAdicaoAleatorio(200000);
		// TesteAdicaoAleatorio(2000000); 
		 TesteAdicaoAleatorio(6000000);
		 

		
		 // TesteBuscaAleatorio(20000); 
		// TesteBuscaAleatorio(200000);
		// TesteBuscaAleatorio(2000000);
		   //TesteBuscaAleatorio(6000000);
		 
		  //(20000); TesteBuscaPorDesconhecido(200000);
		  //TesteBuscaPorDesconhecido(2000000);
		  TesteBuscaPorDesconhecido(6000000);
		 

		/*
		 * TesteRemocaoInicio(20000); TesteRemocaoInicio(200000);
		 * TesteRemocaoInicio(2000000); TesteRemocaoInicio(6000000);
		 * 
		 * TesteRemocaoMeio(20000); TesteRemocaoMeio(200000);
		 * TesteRemocaoMeio(2000000); TesteRemocaoMeio(6000000);
		 * 
		 * 
		 * TesteRemocaoFim(20000); TesteRemocaoFim(200000);
		 * TesteRemocaoFim(2000000);
		 */
		  TesteRemocaoFim(6000000);
		 
	}

	public static List<Long> GenerateNumbers(int amount) {
		List<Long> randomList = new ArrayList<Long>();
		Random gerador = new Random();
		for (int i = 0; i < amount; i++) {
			randomList.add(gerador.nextLong());
		}
		Collections.shuffle(randomList);
		return randomList;
	}

	public static void TesteAdicaoAleatorio(int QtdElemento) {
		long Inicio, Fim;
		RedBlackBST arvore = new RedBlackBST();
		//TreeMap<Long, Long> arvore = new TreeMap<>();
		List<Long> l = new ArrayList<Long>();
		l = GenerateNumbers(QtdElemento);
		Inicio = System.currentTimeMillis();
		for (long i : l) {
			arvore.put(i, i);
		}
		Fim = System.currentTimeMillis();

		System.out.println("Tempo de adição foi de " + (Fim - Inicio));
	}

	public static void TesteBuscaAleatorio(int QtdElemento) {
		Long Inicio, Fim;
		TreeMap<Long, Long> arvore = new TreeMap<>();
		List<Long> l = new ArrayList<Long>();
		l = GenerateNumbers(QtdElemento);
		for (long i : l) {
			arvore.put(i, i);
		}
		long u = arvore.lastKey();

		Inicio = System.nanoTime();
		long v = arvore.get(u);
		Fim = System.nanoTime();

		System.out.println("Tempo de busca  elemento foi de " + (Fim - Inicio));
	}

	public static void TesteBuscaPorDesconhecido(int QtdElemento) {
		Long Inicio, Fim;
		RedBlackBST arvore = new RedBlackBST();
		//TreeMap<Long, Long> arvore = new TreeMap<>();
		List<Long> l = new ArrayList<Long>();
		for (int i = 0; i < QtdElemento; i++) {
			l.add((long) i);
		}
		Collections.shuffle(l);
		for (long i : l) {
			arvore.put(i, i);
		}

		Inicio = System.nanoTime();
		try {
			long v = arvore.size();
		} catch (Exception e) {

		}

		Fim = System.nanoTime();

		System.out.println("Tempo de busca  elemento foi de " + (Fim - Inicio));
	}

	public static void TesteRemocaoInicio(int QtdElemento) {
		Long Inicio, Fim;
		
		TreeMap<Long, Long> arvore = new TreeMap<>();
		List<Long> l = new ArrayList<Long>();
		for (int i = 0; i < QtdElemento; i++) {
			l.add((long) i);
		}
		Collections.shuffle(l);
		for (long i : l) {
			arvore.put(i, i);
		}

		Inicio = System.nanoTime();

		long v = arvore.remove(arvore.firstKey());

		Fim = System.nanoTime();

		System.out.println("Tempo de Remoção  elemento foi de " + (Fim - Inicio));
	}

	public static void TesteRemocaoFim(int QtdElemento) {
		Long Inicio, Fim;
		RedBlackBST arvore = new RedBlackBST();
		//TreeMap<Long, Long> arvore = new TreeMap<>();
		List<Long> l = new ArrayList<Long>();
		for (int i = 0; i < QtdElemento; i++) {
			l.add((long) i);
		}
		Collections.shuffle(l);
		for (long i : l) {
			arvore.put(i, i);
		}

		Inicio = System.nanoTime();
  
		
		long v = arvore.deleteMax();

		Fim = System.nanoTime();

		System.out.println("Tempo de Remoção  elemento foi de " + (Fim - Inicio));
	}

	public static void TesteRemocaoMeio(int QtdElemento) {
		Long Inicio, Fim;
		TreeMap<Long, Long> arvore = new TreeMap<>();
		List<Long> l = new ArrayList<Long>();
		for (int i = 0; i < QtdElemento; i++) {
			l.add((long) i);
		}
		Collections.shuffle(l);
		for (long i : l) {
			arvore.put(i, i);
		}

		Inicio = System.nanoTime();

		long v = arvore.remove((long) QtdElemento / 2);

		Fim = System.nanoTime();

		System.out.println("Tempo de Remoção  elemento foi de " + (Fim - Inicio));
	}

}
