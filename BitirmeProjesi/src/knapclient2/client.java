package knapclient2;
import java.io.*;
import java.net.*;
import java.util.*;

import knapserver.knapsack;

public class client
{
	static long startTime = System.nanoTime();
private static InetAddress host;
private static final int PORT = 1268;
public static void main(String[] args) throws Exception
{
try
{
	 
host = InetAddress.getLocalHost();
}
catch(UnknownHostException uhEx)
{
System.out.println("\nHost ID not found!\n");
System.exit(1);
}
sendMessages();
}
private static void sendMessages() throws Exception
{
Socket socket = null;
try
{
	
socket = new Socket(host,PORT);
Scanner networkInput = new Scanner(socket.getInputStream());
PrintWriter networkOutput = new PrintWriter(socket.getOutputStream(),true);
String urunsayisi = null,urunagirlik = null,urundeger = null,maxagirlik = null, response;
int deger=111;

do{
	networkOutput.println("sirakac");
	
}while(!(networkInput.nextLine().equals("2")));
do
{	
	System.out.println("\n2:"+deger);	
	if(deger==111){
		networkOutput.println("urunsayisi");
		urunsayisi= networkInput.nextLine();
	}else if(deger==112){		
		networkOutput.println("urunagirlik");
		urunagirlik= networkInput.nextLine();
	}	else if(deger==113){		
		networkOutput.println("urundeger");
		urundeger= networkInput.nextLine();
	}else if(deger==114){		
		networkOutput.println("maxagirlik");
		maxagirlik= networkInput.nextLine();
	}
	deger=deger+1;
	
}
while (!(deger==115));



String[] items = urunagirlik.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

int[] urunagirlikc = new int[items.length];

for (int i = 0; i < items.length; i++) {
    try {
    	urunagirlikc[i] = Integer.parseInt(items[i]);
    } catch (NumberFormatException nfe) {

    };
}
String[] items2 = urundeger.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
int[] urundegerc = new int[items2.length];

for (int i = 0; i < items2.length; i++) {
    try {
    	urundegerc[i] = Integer.parseInt(items2[i]);
    } catch (NumberFormatException nfe) {

    };
}

urunagirlikc=knapsack.main(urunagirlikc, urundegerc, Integer.parseInt(maxagirlik), Integer.parseInt(urunsayisi));

	networkOutput.println(Arrays.toString(urunagirlikc));
	networkOutput.println("QUIT");
}
catch(IOException ioEx)
{
ioEx.printStackTrace();
}
finally
{
try
{
	long endTime = System.nanoTime();
	long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
	 double seconds = (double)estimatedTime/1000000000;
	 System.out.println("Geçen Süre:"+seconds+" saniye");
System.out.println("\nBaðlantýyý kapatýyor...");
socket.close();
}
catch(IOException ioEx)
{
System.out.println("Baðlantý kapatýlmaya uygun deðil!!");
System.exit(1);
}
}
}
}