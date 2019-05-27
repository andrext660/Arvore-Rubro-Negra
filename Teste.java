/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoreRubroNegra;

import java.util.Random;


/**
 *
 * @author caetano
 */
public class Teste {

    //public static final int total = 100;
    //public static final int max = 2147483647;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	
        
        RedBlackBST av = new RedBlackBST();
        int total = 5;
        int max = 2147483647;
        int a = 5;
        int cont = 0;
        long inicioInserir = System.nanoTime();
        av.put(1, "1");
        av.put(2, "2");
        av.put(3, "3");
        av.put(4, "4");
        av.put(5, "5");
        av.put(6, "6");
        av.put(7, "7");
        av.put(8, "8");
        av.put(9, "9");
        av.put(10, "10");
        av.put(11, "11");
        av.put(12, "12");
        av.put(13, "13");
        av.put(14, "14");
        av.put(15, "15");
        av.put(16, "16");
        av.put(17, "17");
        av.put(18, "18");
        av.put(19, "19");
        av.put(20, "20");
        av.put(21, "21");
        av.put(22, "22");
        av.put(23, "23");
        av.put(24, "24");
        av.put(25, "25");
        av.put(26, "26");
        av.put(27, "27");
        av.put(28, "28");
        av.put(29, "29");
        av.put(30, "30");
        av.put(31, "31");
        long fimInserir = System.nanoTime();
        long duracaoInserir = (fimInserir - inicioInserir);
        System.out.println("Duração da inserção: "+ duracaoInserir);
        
       
 //---------------------------------------------------------------------------------
 
        long inicioTamanho = System.nanoTime();
        System.out.println("Tamnho da Árvore: ");
        System.out.println(av.size());
        long fimTamanho = System.nanoTime();
        long duracaoTamanho = (fimTamanho - inicioTamanho);
        System.out.println("Duração do Tamanho: "+ duracaoTamanho);
//-----------------------------------------------------------------------------------
        
        long inicioPrint = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Impressora da Árvore: ");
      //  av.imprimir(av);
        long fimPrint = System.nanoTime();
        long duracaoPrint = (fimPrint - inicioPrint);
        System.out.println("Duração da Impressão: "+ duracaoPrint);
        
//----------------------------------------------------------------------------------
        
         long inicioBuscar = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Buscar \n" + av.get(16));
        long fimBuscar = System.nanoTime();
        long duracaoBuscar = (fimBuscar - inicioBuscar);
        System.out.println("Duração da Busca: "+ duracaoBuscar);
        
//----------------------------------------------------------------------------------- 
 
        long inicioDeleta = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Deletar ");
        av.delete(5);
        long fimDeleta = System.nanoTime();
        long duracaoDeleta  = (fimDeleta  - inicioDeleta );
        System.out.println("Duração da Deleção: "+ duracaoDeleta ); 
        
//-----------------------------------------------------------------------------------        
       
        long inicioBuscar1 = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Buscar \n" + av.get(30));
        long fimBuscar1 = System.nanoTime();
        long duracaoBuscar1 = (fimBuscar - inicioBuscar);
        System.out.println("Duração da Busca: "+ duracaoBuscar1);
        
        
//-----------------------------------------------------------------------------------
       
      
    }

}
