package knapserver;


import java.io.*;
import java.net.*;
import java.util.*;


public class server
{

private static ServerSocket serverSocket;//serversocket de�i�keni olusturuluyor
private static final int PORT = 1268;//port numaras� bel�rlen�yor
public static int[] ClientinSehirleri;//cl�ent�n boyacag� seh�rler de�i�keni olu�turuluyor
public static int[] urunAgirlik,urunDeger;
public static int urunSayisi,maxAgirlik;
public static int sira=1;

public static void main(String[] args) throws Exception
{
	urunSayisi=14;
	maxAgirlik=60;
	urunAgirlik=new int [] {0,50,10,20,30,40,5,15,15,60,30,25,25,5,5};
	urunDeger=new int [] {0,100,150,200,250,300,350,400,450,500,550,600,650,700,750};
	
	urunAgirlik=knapsack.main(urunAgirlik, urunDeger, maxAgirlik, urunSayisi);
	System.out.println(Arrays.toString(urunAgirlik));
try{
serverSocket = new ServerSocket(PORT);
}
catch (IOException ioEx){

System.exit(1);
}
do
{
Socket client = serverSocket.accept();//server, client�n ba�lanmas�n� bekliyor
System.out.println("\nNew client accepted.\n");
ClientHandler handler = new ClientHandler(client);//clientin taleplerini kullanabilmek i�in hander olusturuluyor
handler.start(); 

}
while (true);
}
}
class ClientHandler extends Thread
{
	static long startTime = System.nanoTime();
private Socket client;
private Scanner input;
private PrintWriter output;
public ClientHandler(Socket socket)
{

client = socket;
try{
input = new Scanner(client.getInputStream());//clienttan veri al�yor
output = new PrintWriter(client.getOutputStream(),true);//clienttan veri g�nderiyor
}
catch(IOException ioEx){
ioEx.printStackTrace();
}
}
public void run()
{
String received; 

do
{
received = input.nextLine();

System.out.println(received);
if(received.equals("sirakac")){
	output.println(Integer.toString(server.sira));	
}else if(received.equals("urunsayisi")){
	output.println(Integer.toString(server.urunSayisi));	
}else if(received.equals("urunagirlik")){	
		output.println(Arrays.toString(server.urunAgirlik));
}else if(received.equals("urundeger")){	
			output.println(Arrays.toString(server.urunDeger));
}else if(received.equals("maxagirlik")){	
	output.println(Integer.toString(server.maxAgirlik));
}else if(received.substring(0,1).equals("[")){
	String[] items2 = received.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

	for (int i = 0; i < items2.length; i++) {
	    try {
	    	if(Integer.parseInt(items2[i])!=9){
	    	server.urunAgirlik[i] = Integer.parseInt(items2[i]);
	    	}
	    } catch (NumberFormatException nfe) {
	       
	    }
	}
	output.println("islem tamamlandi");
}else if(received.equals("bitti")){
		server.sira=server.sira+1;
}
}while (!received.equals("QUIT")); //"QUIT" gelinceye kadar �al���r
System.out.println("\n server rengi:"+Arrays.toString(server.urunAgirlik));
long endTime = System.nanoTime();
long estimatedTime = endTime - startTime; // Ge�en s�reyi milisaniye cinsinden elde ediyoruz
 double seconds = (double)estimatedTime/1000000000;
 System.out.println("Ge�en S�re:"+seconds+" saniye");
try
{

if (client!=null)
{
System.out.println("Ba�lant�y� kapat�yor...");
client.close();
}
}
catch(IOException ioEx)
{
System.out.println("Ba�lant� kapat�lmaya uygun de�il!");
}
}
}
