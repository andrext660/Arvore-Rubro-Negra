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
public class RubroNegra {

    //public static final int total = 100;
    //public static final int max = 2147483647;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	
        
        ArvRubroNegra av = new ArvRubroNegra();
        int total = 5;
        int max = 2147483647;
        int a = 5;
        int cont = 0;
        long inicioInserir = System.nanoTime();
        av.inserir(1, "1");
        av.inserir(2, "2");
        av.inserir(3, "3");
        av.inserir(4, "4");
        av.inserir(5, "5");
        av.inserir(6, "6");
        av.inserir(7, "7");
        av.inserir(8, "8");
        av.inserir(9, "9");
        av.inserir(10, "10");
        av.inserir(11, "11");
        av.inserir(12, "12");
        av.inserir(13, "13");
        av.inserir(14, "14");
        av.inserir(15, "15");
        av.inserir(16, "16");
        av.inserir(17, "17");
        av.inserir(18, "18");
        av.inserir(19, "19");
        av.inserir(20, "20");
        av.inserir(21, "21");
        av.inserir(22, "22");
        av.inserir(23, "23");
        av.inserir(24, "24");
        av.inserir(25, "25");
        av.inserir(26, "26");
        av.inserir(27, "27");
        av.inserir(28, "28");
        av.inserir(29, "29");
        av.inserir(30, "30");
        av.inserir(31, "31");
        long fimInserir = System.nanoTime();
        long duracaoInserir = (fimInserir - inicioInserir);
        System.out.println("Duração da inserção: "+ duracaoInserir);
        
       
 //---------------------------------------------------------------------------------
 
        long inicioTamanho = System.nanoTime();
        System.out.println("Tamnho da Árvore: ");
        System.out.println(av.tamanho());
        long fimTamanho = System.nanoTime();
        long duracaoTamanho = (fimTamanho - inicioTamanho);
        System.out.println("Duração do Tamanho: "+ duracaoTamanho);
//-----------------------------------------------------------------------------------
        
        long inicioPrint = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Impressora da Árvore: ");
        av.imprimir(av);
        long fimPrint = System.nanoTime();
        long duracaoPrint = (fimPrint - inicioPrint);
        System.out.println("Duração da Impressão: "+ duracaoPrint);
        
//----------------------------------------------------------------------------------
        
         long inicioBuscar = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Buscar \n" + av.busca(16));
        long fimBuscar = System.nanoTime();
        long duracaoBuscar = (fimBuscar - inicioBuscar);
        System.out.println("Duração da Busca: "+ duracaoBuscar);
        
//----------------------------------------------------------------------------------- 
 
        long inicioDeleta = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Deletar ");
        av.deletar(5);
        long fimDeleta = System.nanoTime();
        long duracaoDeleta  = (fimDeleta  - inicioDeleta );
        System.out.println("Duração da Deleção: "+ duracaoDeleta ); 
        
//-----------------------------------------------------------------------------------        
       
        long inicioBuscar1 = System.nanoTime();
        System.out.println("_________________________________________________");
        System.out.println("Buscar \n" + av.busca(30));
        long fimBuscar1 = System.nanoTime();
        long duracaoBuscar1 = (fimBuscar - inicioBuscar);
        System.out.println("Duração da Busca: "+ duracaoBuscar1);
        
        
//-----------------------------------------------------------------------------------
       
      
    }

}
