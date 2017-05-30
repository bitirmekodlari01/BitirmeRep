package serverasal;


import java.io.*;
import java.net.*;
import java.util.*;
public class server
{

private static ServerSocket serverSocket;//serversocket de�i�keni olusturuluyor
private static final int PORT = 1267;//port numaras� bel�rlen�yor
public static int sayi,ajanSayisi,asallik;
public static void main(String[] args) throws Exception
{
	
	sayi=123456789;
	ajanSayisi=3;
	asallik=0;
	
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
System.out.println(received);

if(received.equals("sayi")){
	output.println(Integer.toString(server.sayi));
}else if(received.equals("ajanSayisi")){
	output.println(Integer.toString(server.ajanSayisi));
}else if(received.equals("sayi asal degil")){
	server.asallik=server.asallik+1;
}
}
while (!received.equals("QUIT")); //"QUIT" gelinceye kadar �al���r
System.out.println(server.asallik);
if(server.asallik==0){
	System.out.println(server.sayi+" say�s� asald�r");
}else{
	System.out.println(server.sayi+" say�s�asaldegil");
}
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