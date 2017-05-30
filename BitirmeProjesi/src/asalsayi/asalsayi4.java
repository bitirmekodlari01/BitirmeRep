package asalsayi;
import java.util.Scanner;

public class asalsayi4 {
	static long startTime = System.nanoTime();
	public static void main(String[] args) {
		
		int i;
		int sayi = 123456789;
		 int flag=0;
		
		 for(i=2;i<=Math.sqrt(sayi);i++){
			 if(sayi%i==0){
				 System.out.println("asal sayý degildir");
				 flag=1;
				 break;
			 }
		 }

       if(flag==0){
    	   System.out.println("asalsayý");
       }
       long endTime = System.nanoTime();
		long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
		 double seconds = (double)estimatedTime/1000000000;
		System.out.println("Geçen Süre:"+seconds+" saniye");

	}
	

}
