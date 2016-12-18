package csp;

import java.util.*;
import java.io.*; 
import java.math.*;

public class HayaliHaritaForwardChecking {
    static int KomsulukMatrisi[][];
    static int[] SehirlerinRengi;
    static int[] Renkler;
    static int SehirSay�s�;
    static long startTime = System.nanoTime();; 
    
   
	static int SehireRenkAtama(int k){
        do{ 
            int j;
            Renkler = new int[]{0,1,2};
            for(j=0;j<=SehirSay�s�;j++){ 
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
           
            if(k==SehirSay�s�){
            	
            	System.out.println("Color Assignment: "+Arrays.toString(SehirlerinRengi));
            	long endTime = System.nanoTime();
				long estimatedTime = endTime - startTime; // Ge�en s�reyi milisaniye cinsinden elde ediyoruz
        		 double seconds = (double)estimatedTime/1000;
        		 System.out.println("Ge�en S�re:"+seconds+" milisaniye");
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
            SehirSay�s� = KomsulukMatrisi.length-1;
            SehirlerinRengi = new int[SehirSay�s�+1];
            
            Boyama(0);
    } 
}