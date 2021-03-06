package csp;
import java.util.*;
import java.io.*; 
import java.math.*;

public class AvustralyaHaritasıBacktracking {
    static int KomsulukMatrisi[][];
    static int[] SehirlerinRengi;
    static int RenkSayısı;
    static int SehirSayısı;
    static long startTime = System.nanoTime(); 
    static int SehireRenkAtama(int k){
        do{ 
            int j;
            SehirlerinRengi[k] = SehirlerinRengi[k]+1; 
            if(SehirlerinRengi[k]==RenkSayısı+1){
            	return 0;
            }
            
            for(j=1;j<=SehirSayısı;++j){ 
                if(KomsulukMatrisi[k][j] == 1 && SehirlerinRengi[k] == SehirlerinRengi[j] && k!=j){ 
                    break;
                }
            }  
            if(j==SehirSayısı+1){            
            	return SehirlerinRengi[k];
            }
        }while(true);
       
    }
    
    static void Boyama(int k){
        do{ 
        	SehirlerinRengi[k] = SehireRenkAtama(k); 
           
            if(k==SehirSayısı){
            	
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
    	RenkSayısı = 2;
            KomsulukMatrisi = new int[][]{
            		 {1,1,1,0,0,0,0},
                     {1,1,1,1,0,0,0},
                     {1,1,1,1,1,1,0},
                     {0,1,1,1,1,0,0},
                     {0,0,1,1,1,1,0},                
                     {0,0,1,0,1,1,0},
                     {0,0,0,0,0,0,0},
            }; 
            SehirSayısı = KomsulukMatrisi.length-1;
            SehirlerinRengi = new int[SehirSayısı+1];
            
            Boyama(1);
    } 
}