package arvoreRubroNegra;

import java.util.Scanner;

public class Aula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner teclado = new Scanner(System.in);
	        RedBlackBST arv = new RedBlackBST();
	       
		 
	        System.out.println("Arvore Rubro Negra Test\n");
	        char ch;
	       
	        do {
	            System.out.println("\n Árvore Operations\n");
	            System.out.println("1. Inserir Elemento ");
	            System.out.println("2. Buscar Elemento");
	            System.out.println("3. Deletar Elemento");
	            System.out.println("4. Imprimir Elementos");
	           

	            int ops = teclado.nextInt();
	            switch (ops) {
	                case 1:
	                	System.out.println("                       Inserir");
	                	System.out.println("_______________________________________________________________");
	                	
	                	
	                	//Inserir
	                    System.out.println("\nInforme a chave: ");
	                    int chave = teclado.nextInt();
	                    System.out.println("Informe o valor");
	                    int valor = teclado.nextInt(); 
	                   
	                    arv.put(chave, valor);
	                    break;
	                case 2:
	                	//Buscar
	                	System.out.println("                       Buscar Elemento");
	                	System.out.println("_______________________________________________________________");
	                    System.out.println("Informe a chave do elemento ");
	                    int c = teclado.nextInt();
	                   
	                    System.out.println("Elemento encontrado: "+arv.get(c) );
	                    
	                   
	                    break;
	                case 3:
	                	// Deletar
	                	System.out.println("                       Deletar Elemento");
	                	System.out.println("_______________________________________________________________");
	                    System.out.println("Informe a chave do Elemento");
	                    int c1 = teclado.nextInt();
	                   System.out.println("Elemento deletado: " + arv.get(c1) );
	                   arv.delete(c1);
	                   
	                    break;
	                case 4:
	                    System.out.println("Imprimir: " );
	                    arv.imprimir(arv);
	                    break;
	                
	                default:
	                    System.out.println("Programa Finalizado \n ");
	                    break;
	            }
	          
	            

	            System.out.println("\nVocê quer continuar (S ou N) \n");
	            ch = teclado.next().charAt(0);
	        } while (ch == 'S' || ch == 's');
	    }
	}


