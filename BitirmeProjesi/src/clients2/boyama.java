package clients2;

import java.util.*;
import java.io.*; 
import java.math.*;

public class boyama {
    static int KomsulukMatrisi[][];
    static int[] SehirlerinRengi;
    static int[] Renkler;
    static int SehirSayýsý;
    
    
   
	static int getNodeColor(int k){
        do{ 
        	
            int j;
            Renkler = new int[]{0,1,2,3};
            for(j=0;j<=SehirSayýsý;j++){ 
            	
            	if(KomsulukMatrisi[k][j] == 1  && k!=j){  
            		Renkler[SehirlerinRengi[j]]=99;
                } 
                }   	
            	dongudenDevam:
            	for(int y=0;y<4;y++){
    				if(Renkler[y]==99){
    					continue dongudenDevam;
    				}else{
    					SehirlerinRengi[k]=Renkler[y];
    					break;
    				}
    			}
           	return SehirlerinRengi[k];
             
        }while(true);
       
    }
   
    
    public static int[] main(int[] a,int[] b) throws Exception{ 
            
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
            SehirSayýsý = KomsulukMatrisi.length-1;
            SehirlerinRengi = new int[SehirSayýsý+1];
            for(int j=0;j<a.length;j++){
            	SehirlerinRengi[j]=a[j];
            }
            System.out.println("\nboyama colors:"+Arrays.toString(SehirlerinRengi));
            for(int j=0;j<b.length;j++){
            	int deger=b[j];
            	SehirlerinRengi[deger] = getNodeColor(deger);
            }
            return SehirlerinRengi;
    }
}