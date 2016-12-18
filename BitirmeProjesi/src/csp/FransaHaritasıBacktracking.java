package csp;

import java.util.*;
import java.io.*; 
import java.math.*;

public class FransaHaritasýBacktracking {
    static int KomsulukMatrisi[][];
    static int[] SehirlerinRengi;
    static int RenkSayýsý;
    static int SehirSayýsý;
    static long startTime = System.nanoTime();; 
    static int SehireRenkAtama(int k){
        do{ 
            int j;
            SehirlerinRengi[k] = SehirlerinRengi[k]+1; 
            if(SehirlerinRengi[k]==RenkSayýsý+1){
            	return 0;
            }
            
            for(j=1;j<=SehirSayýsý;++j){ 
                if(KomsulukMatrisi[k][j] == 1 && SehirlerinRengi[k] == SehirlerinRengi[j] && k!=j){ 
                    break;
                }
            }  
            if(j==SehirSayýsý+1){            
            	return SehirlerinRengi[k];
            }
        }while(true);
       
    }
    
    static void Boyama(int k){
        do{ 
        	SehirlerinRengi[k] = SehireRenkAtama(k); 
           
            if(k==SehirSayýsý){
            	
            	System.out.println("Color Assignment: "+Arrays.toString(SehirlerinRengi));
            	long endTime = System.nanoTime();
				long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
        		 double seconds = (double)estimatedTime/1000;
        		 System.out.println("Geçen Süre:"+seconds+" milisaniye");
            }
            else Boyama(k+1);
        }while(false);
    }
 
    
    public static void main(String[] args) throws Exception{ 
    	RenkSayýsý = 3;
            KomsulukMatrisi = new int[][]{
            		/*0*/   {1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    /*1*/   {1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0},
                    /*2*/   {0,1,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
                    /*3*/   {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    /*4*/   {0,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                    /*5*/   {0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0},
                    /*6*/   {0,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                    /*7*/   {0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
                    /*8*/   {1,1,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0},
                    /*9*/   {0,1,1,0,0,0,0,0,1,1,1,1,0,1,1,1,0,0,0,0,0},
                    /*10*/  {0,0,1,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
                    /*11*/  {0,0,0,0,0,1,0,0,0,1,1,1,1,0,0,1,1,0,0,0,0},
                    /*12*/  {0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,0,1,0,0,0,0},
                    /*13*/  {0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0},
                    /*14*/  {0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0},
                    /*15*/  {0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,1,1,0,1,1,0},
                    /*16*/  {0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,1,1},
                    /*17*/  {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0},
                    /*18*/  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,0},
                    /*19*/  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1},
                    /*20*/  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1}
            }; 
            SehirSayýsý = KomsulukMatrisi.length-1;
            SehirlerinRengi = new int[SehirSayýsý+1];
            
            Boyama(1);
    } 
}