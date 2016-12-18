package csp;

import java.util.*;
import java.io.*; 
import java.math.*;

public class FransaHaritas�ForwardChecking {
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
                    /*20*/  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1},
                    
            }; 
            SehirSay�s� = KomsulukMatrisi.length-1;
            SehirlerinRengi = new int[SehirSay�s�+1];
            
            Boyama(0);
    } 
}