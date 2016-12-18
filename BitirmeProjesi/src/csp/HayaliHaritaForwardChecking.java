package csp;

import java.util.*;
import java.io.*; 
import java.math.*;

public class HayaliHaritaForwardChecking {
    static int KomsulukMatrisi[][];
    static int[] SehirlerinRengi;
    static int[] Renkler;
    static int SehirSayýsý;
    static long startTime = System.nanoTime();; 
    
   
	static int SehireRenkAtama(int k){
        do{ 
            int j;
            Renkler = new int[]{0,1,2};
            for(j=0;j<=SehirSayýsý;j++){ 
            	if(KomsulukMatrisi[k][j] == 1 && k!=j){  
                	
                		Renkler[SehirlerinRengi[j]]=4;
                
                } 
                }
            dongudenDevam:
    			for(int y=0;y<3;y++){
    				if(Renkler[y]==4){
    					continue dongudenDevam;
    				}else{
    					SehirlerinRengi[k]=Renkler[y];
    				}
    			}
           	return SehirlerinRengi[k];
           
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
        
            
            KomsulukMatrisi = new int[][]{
            		{1,1,1,1,1,1,1,1},
            		{1,1,1,0,0,1,0,0},
            		{1,1,1,1,0,1,0,0},
            		{1,0,1,1,1,1,1,1},
            		{1,0,0,1,1,0,1,0},                
            		{1,1,1,1,0,1,0,1},
            		{1,0,0,1,1,0,1,1},
            		{1,0,0,1,0,1,1,1},
            }; 
            SehirSayýsý = KomsulukMatrisi.length-1;
            SehirlerinRengi = new int[SehirSayýsý+1];
            
            Boyama(0);
    } 
}