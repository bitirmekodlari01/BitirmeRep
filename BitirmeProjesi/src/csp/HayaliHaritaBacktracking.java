package csp;

import java.util.*;
import java.io.*; 
import java.math.*;
//BackTracking
public class HayaliHaritaBacktracking {
    static int KomsulukMatrisi[][];
    static int[] SehirlerinRengi;
    static int RenkSay�s�;
    static int SehirSay�s�;
    static long startTime = System.nanoTime();; 
    static int SehireRenkAtama(int k){
        do{ 
            int j;
            SehirlerinRengi[k] = SehirlerinRengi[k]+1; 
            if(SehirlerinRengi[k]==RenkSay�s�+1){
            	return 0;
            }
            
            for(j=1;j<=SehirSay�s�;++j){ 
                if(KomsulukMatrisi[k][j] == 1 && SehirlerinRengi[k] == SehirlerinRengi[j] && k!=j){ 
                    break;
                }
            }  
            if(j==SehirSay�s�+1){            
            	return SehirlerinRengi[k];
            }
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
    	RenkSay�s� = 2;
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
            
            Boyama(1);
    } 
}