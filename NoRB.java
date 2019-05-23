package arvoreRubroNegra;



public class NoRB<Chave extends Comparable<Chave>,Valor> {
	
	
	


	private Chave chave;
	private Valor elemento;
	private NoRB<Chave, Valor> noEquerdo; 
	private NoRB<Chave, Valor> noDireito;
	int N;  // número de elementos na sub árvore
	boolean cor; // cor do link que aponta para o nó
	
	
	public NoRB(Chave chave, Valor elemento, int n, boolean cor) {
		super();
		this.chave = chave;
		this.elemento = elemento;
		N = n;
		this.cor = cor;
	}


	
	
	/* Gett and Sets*/

	public Chave getChave() {
		return chave;
	}


	public void setChave(Chave chave) {
		this.chave = chave;
	}


	public Valor getElemento() {
		return elemento;
	}


	public void setElemento(Valor elemento) {
		this.elemento = elemento;
	}


	public NoRB<Chave, Valor> getNoEquerdo() {
		return noEquerdo;
	}


	public void setNoEquerdo(NoRB<Chave, Valor> noEquerdo) {
		this.noEquerdo = noEquerdo;
	}


	public NoRB<Chave, Valor> getNoDireito() {
		return noDireito;
	}


	public void setNoDireito(NoRB<Chave, Valor> noDireito) {
		this.noDireito = noDireito;
	}


	public int getN() {
		return N;
	}


	public void setN(int n) {
		N = n;
	}


	public boolean isCor() {
		return cor;
	}


	public void setCor(boolean cor) {
		this.cor = cor;
	}


	
	
	
	
	
	
	
	
}
