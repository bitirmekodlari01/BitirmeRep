package asalsayi;
import java.util.Scanner;


class asalsayi2{
	 static long startTime = System.nanoTime();
	
	public static void main(String args[]){
		int sayi = 123456789;
		
	
		int flag=0;
		for(int i=2;i<sayi/2;i++){
			if(sayi%i==0)
			{
				System.out.println(sayi+" asal sayý deðildir");
				
				flag=1;
				
				
				break;
			}
		}
		if(flag==0)
			System.out.println(sayi+" asal sayýdýr");
		long endTime = System.nanoTime();
		long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
		 double seconds = (double)estimatedTime/1000000000;
		System.out.println("Geçen Süre:"+seconds+" saniye");
	}
}