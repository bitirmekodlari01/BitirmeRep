package server;


import java.io.*;
import java.net.*;
import java.util.*;
public class server
{
	 static int[] SehirlerinRengi;
private static ServerSocket serverSocket;//serversocket de�i�keni olusturuluyor
private static final int PORT = 1259;//port numaras� bel�rlen�yor
public static int[] ClientinSehirleri;//cl�ent�n boyacag� seh�rler de�i�keni olu�turuluyor
public static void main(String[] args) throws Exception
{
	
	int[] sehirler0={0,1,2,3,5,6,7,8,9,10};//server�n boyayacag� seh�rler belirleniyor
	ClientinSehirleri=new int[] {11,12,13,14,15,16,17,18,19,20};//cl�ent�n boyacag� seh�rler bel�rlen�yor
	 SehirlerinRengi = boyama.main(sehirler0);//server kendi �ehirlerini boyuyor
	 
	System.out.println("Color Assignment: "+Arrays.toString(SehirlerinRengi));//ekrana bast�r�l�yor
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

if(received.equals("renkver")){
	output.println(Arrays.toString(server.SehirlerinRengi));
}else if(received.equals("sehirver")){
	output.println(Arrays.toString(server.ClientinSehirleri));
}else if(received.substring(0,1).equals("[")){
	String[] items2 = received.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

	for (int i = 0; i < items2.length; i++) {
	    try {
	    	server.SehirlerinRengi[i] = Integer.parseInt(items2[i]);
	    } catch (NumberFormatException nfe) {
	       
	    };
	}

	output.println("islem tamamlandi");
	System.out.println("\n �ehirlerin rengi:"+Arrays.toString(server.SehirlerinRengi));//Boyanan �ehirlerin renkleri
}
}
while (!received.equals("QUIT")); //"QUIT" gelinceye kadar �al���r

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