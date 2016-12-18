package client;

import java.util.*;
import java.io.*; 
import java.math.*;

public class boyama {
    static int connected[][];
    static int[] colors;
    static int[] renk;
    static int nColors;
    static int nNodes;
    
    
   
	static int getNodeColor(int k){
        do{ 
        	
            int j;
            renk = new int[]{0,1,2,3};
            for(j=0;j<=nNodes;j++){ 
            	
            	if(connected[k][j] == 1  && k!=j){  
                		renk[colors[j]]=4;
                } 
                }   	
            	dongudenDevam:
            	for(int y=0;y<4;y++){
    				if(renk[y]==4){
    					continue dongudenDevam;
    				}else{
    					colors[k]=renk[y];
    					break;
    				}
    			}
           	return colors[k];
             
        }while(true);
       
    }
    /*
    static void mColoring(int k){
        do{ 
            colors[k] = getNodeColor(k); 
           
            if(k==nNodes){
            	
            	System.out.println("Color Assignment: "+Arrays.toString(colors));
            }
            else mColoring(k+1);
        }while(false);
    }
  */
    
    public static int[] main(int[] a,int[] b) throws Exception{ 
            nColors = 2;
            
            connected = new int[][]{
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
            nNodes = connected.length-1;
            colors = new int[nNodes+1];
            for(int j=0;j<a.length;j++){
            	colors[j]=a[j];
            }
            System.out.println("\nboyama colors:"+Arrays.toString(colors));
            for(int j=0;j<b.length;j++){
            	int deger=b[j];
            colors[deger] = getNodeColor(deger);
            }
            return colors;
    }
}