package arvoreRubroNegra;

import java.awt.BufferCapabilities.FlipContents;
import java.util.NoSuchElementException;

import Prov.NoABB;









public class ArvRubroNegra<Chave extends Comparable<Chave>,Valor> {

	
	public ArvRubroNegra() {
		super();
		// TODO Auto-generated constructor stub
	}


	private static final boolean Vermelho   = true;
    private static final boolean Preto = false;
     private NoRB<Chave,Valor> raiz; // raiz da ARB
	
	
	
     // the smallest key; null if no such key
     public Chave minimo() {
         if (isEmpty()) return null;
         return (Chave) minimo(raiz).getChave();
     } 

     // the smallest key in subtree rooted at x; null if no such key
     private NoRB minimo(NoRB x) { 
         assert x != null;
         if (x.getNoEquerdo() == null) return x; 
         else 
        return minimo(x.getNoEquerdo()); 
     } 
     
     
  /***** Imprimir *////   
     public void print() {
 		this.print(this.raiz);
 	}

 	private void print(NoRB<Chave, Valor> start) {
 		// Simetrica
 		if (start != null) {
 			print(start.getNoDireito());
 			System.out.println(start.getElemento().toString());

 			print(start.getNoEquerdo());
 		}
 	}
     
     
	
	private boolean eVermelho(NoRB x) {
		if (x==null) return false;
		return (x.cor == Vermelho);
	}

	
	private int tamanho(NoRB x) {
		if (x == null) return 0;
		return x.getN();
	}
	
	 public int tamanho() { 
	        return tamanho(raiz); 
	    }
	
//Limpar a árvore	
	 public boolean isEmpty() {
	        return raiz == null;
	    }
	 

	 
/*******Balancear árvore*******/
	 
private NoRB balancear(NoRB no) {
	assert (no != null);
	
	if(eVermelho(no.getNoDireito())) no = rotacionarEsquerda(no);
	if(eVermelho(no.getNoEquerdo())) no = rotacionarDireita(no);
	if(eVermelho(no.getNoEquerdo()) && eVermelho(no.getNoDireito())) inversaoDeCores(no);
	no.N = tamanho(no.getNoEquerdo()) + tamanho(no.getNoDireito()) + 1;
	return no;
	
	
}
	 
	 
/************** Buscar Elemento*************/	 
	 
	 public Valor busca (Chave chave) {
		 return busca(raiz,chave);
	 }
	 private Valor busca(NoRB no,Chave chave) {
		 while (no!=null) {
			 int cmp = chave.compareTo((Chave) no.getChave());
			 if (cmp<0) no = no.getNoEquerdo();
			 else if (cmp>0) no = no.getNoDireito();
			 else
		 return  (Valor) no.getElemento();
		 }
		return null;
	 }
	 
	 
/***************** Verifica se o elemento está na árvore*****************/	 
	 public boolean contains(Chave chave) {
		 return(busca(chave)!=null);
	 }
	 private boolean contains(NoRB no,Chave chave) {
		 return (busca(no,chave)!=null);
	 }
	 
	 
	 

/****** Inserir Elemento  *****/
	 
	 public void inserir(Chave chave,Valor valor) {
		 raiz = inserir(raiz,chave,valor);
		 raiz.cor = Preto;
		// assert check();
	 }
	  
	 private NoRB inserir(NoRB no, Chave chave, Valor valor) {
		 
		 if(no==null) return new NoRB(chave,valor,1,Vermelho);
		 
		 int cmp = chave.compareTo((Chave) no.getChave());
		 if (cmp < 0) no.setNoEquerdo(inserir(no.getNoEquerdo(),chave,valor)); 
		 else if (cmp > 0) no.setNoDireito(inserir(no.getNoDireito(),chave,valor));
		 else no.setElemento(valor);
		 
		 if (eVermelho(no.getNoDireito()) && !eVermelho(no.getNoEquerdo())) no =rotacionarEsquerda(no);
		 if (eVermelho(no.getNoEquerdo()) && !eVermelho(no.getNoEquerdo().getNoEquerdo())) no =rotacionarDireita(no);
		 if (eVermelho(no.getNoEquerdo()) && eVermelho(no.getNoDireito())) inversaoDeCores(no);
		 no.N = tamanho(no.getNoEquerdo()) + tamanho(no.getNoDireito()) + 1;
		 
		return no;
	 }
	 
/*****************************************/	 
	 
	 
/****Deletar Elemento***/
	 
	 public void deletar (Chave chave) {
		 
		 if(!contains(chave)) {
			 System.out.println("Chave não encontrada"+chave);
			 return;
		 }
		 
		 if(!eVermelho(raiz.getNoEquerdo())&& !eVermelho(raiz.getNoDireito()))
			 raiz.cor = Vermelho;
		 raiz = deletar(raiz,chave);
		 if(!isEmpty()) raiz.cor =Preto;
		 //assert check();
	 }
	 
	 private NoRB deletar(NoRB no, Chave chave) {
		 
		 assert contains(no,chave);
		 
		 if(chave.compareTo((Chave) no.getChave())<0) {
			 if(!eVermelho(no.getNoEquerdo())&& !eVermelho(no.getNoEquerdo().getNoEquerdo()))
				no = moverVermelhoEsquerda(no);
			 no.setNoEquerdo(deletar(no.getNoEquerdo(), chave));
			
				 
		 }
		 else {
			 if (eVermelho(no.getNoEquerdo()))
				 no = rotacionarDireita(no);
			 if(chave.compareTo((Chave) no.getChave())== 0 && (no.getNoDireito()==null))
				 return null;
			 if(!eVermelho(no.getNoDireito())&& !eVermelho(no.getNoDireito().getNoEquerdo()))
				 no=moverVermelhoDireita(no);
			 if(chave.compareTo((Chave) no.getChave())== 0) {
				 NoRB x = minimo(no.getNoDireito());
				 no.setChave(x.getChave());
				 no.setElemento(x.getElemento());
				 no.setNoDireito(deletarMinimo(no.getNoDireito()));
			 }
			 else no.setNoDireito(deletar(no.getNoDireito(),chave));
				 
		 }
	return balancear(no);
	 }
	 
	 
	 
//Deletar o valor de chave minima
	 
	 public void deletarMinimo() {
		 if (isEmpty()) throw new NoSuchElementException(" ");
		 
		 //
		 if (!eVermelho(raiz.getNoEquerdo())&& !eVermelho(raiz.getNoDireito()))
			 raiz.cor = Vermelho;
		 
		 raiz = deletarMinimo(raiz);
		 if(!isEmpty()) raiz.cor = Preto;
		 //assert check();
		 
	 }

	 
	 private NoRB deletarMinimo(NoRB no) {
		 if(no.getNoEquerdo()==null)
			 return null;
		 
		 if(!eVermelho(no.getNoEquerdo())&& !eVermelho(no.getNoEquerdo().getNoEquerdo()))
			 no = moverVermelhoEsquerda(no);
		 
		 no.setNoEquerdo(deletarMinimo(no.getNoEquerdo())); 
		 return balancear(no);
	 }
	 
	 
	
	 
	 
	 
	 
	 
 /**** Rotacionar Árvore para direita*****/
	 
	 private NoRB rotacionarDireita(NoRB h) {
		 assert (h!=null) && eVermelho(h.getNoEquerdo());
		 NoRB x = h.getNoEquerdo();
		 h.setNoEquerdo(x.getNoDireito());
		 x.setNoDireito(h);
		 x.cor = x.getNoDireito().cor;
		 x.getNoDireito().cor = Vermelho;
		 x.N = h.N;
		 h.N = tamanho(h.getNoEquerdo())+tamanho(h.getNoDireito()) +1;
		 return x;
 	 }
	 
	 
	 /**** Rotacionar Árvore para esquerda****/
	 
	 private NoRB rotacionarEsquerda (NoRB h) {
		 
		 assert (h!=null) && eVermelho(h.getNoDireito());
		 NoRB x = h.getNoDireito();
		 h.setNoDireito(x.getNoEquerdo());
		 x.setNoEquerdo(h);
		 x.cor = x.getNoEquerdo().cor;
		 x.getNoEquerdo().cor = Vermelho;
		 x.N = h.N;
		 h.N = tamanho(h.getNoEquerdo())+tamanho(h.getNoDireito()) +1;
		 return x;
	 }
	 
	 /*** Inversão de Cores ***/
	 
	 // Modifica a cor do nó e dos seus 2 filhos 
	 private void inversaoDeCores(NoRB h) {
		 
		 assert (h!=null) && (h.getNoEquerdo() !=null) && (h.getNoDireito() !=null);
		 assert (!eVermelho(h)) && eVermelho(h.getNoEquerdo()) && eVermelho(h.getNoDireito())
		 || (eVermelho(h) && !eVermelho(h.getNoEquerdo()) && !eVermelho(h.getNoDireito()));
		 h.cor = !h.cor;
		 h.getNoEquerdo().cor = !h.getNoEquerdo().cor;
		 h.getNoDireito().cor = !h.getNoDireito().cor;
	 }
	 
	 
/*Assumindo que o nó é vermelho e, no.esquerdo e no.esquerdo.esquerdo é preto
 * Transforma no.esquerda ou um dos seus filhos em vermelho */
	 private NoRB moverVermelhoEsquerda(NoRB no) {
		 assert (no!=null);
		 assert eVermelho(no) && !eVermelho(no.getNoEquerdo()) && !eVermelho(no.getNoEquerdo().getNoEquerdo());
	 	 inversaoDeCores(no);
	 	 if(eVermelho(no.getNoDireito().getNoEquerdo())) {
	 		 no.setNoDireito(rotacionarDireita(no.getNoDireito()));
	 		 no =rotacionarEsquerda(no);
	 		 
	 		 
	 	 }
	 	return no;
	 }
	 
	 
	 /*Assumindo que o nó é vermelho e, no.direito e no.direito.esquerdo é preto
	  * Transforma no.esquerda ou um dos seus filhos em vermelho */
	 	 private NoRB moverVermelhoDireita(NoRB no) {
	 		 assert (no!=null);
	 		 assert eVermelho(no) && !eVermelho(no.getNoDireito()) && !eVermelho(no.getNoDireito().getNoEquerdo());
	 	 	 inversaoDeCores(no);
	 	 	 if(eVermelho(no.getNoEquerdo().getNoEquerdo())) {
	 	 		
	 	 		 no =rotacionarDireita(no);
	 	 		 
	 	 	 }
			 return no;
	 	 }
	 
	 
	 
	 
	 
	 
}
