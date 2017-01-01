package server;


import java.io.*;
import java.net.*;
import java.util.*;
public class server
{
	 static int[] SehirlerinRengi;
private static ServerSocket serverSocket;//serversocket deðiþkeni olusturuluyor
private static final int PORT = 1259;//port numarasý belýrlenýyor
public static int[] ClientinSehirleri;//clýentýn boyacagý sehýrler deðiþkeni oluþturuluyor
public static void main(String[] args) throws Exception
{
	
	int[] sehirler0={0,1,2,3,5,6,7,8,9,10};//serverýn boyayacagý sehýrler belirleniyor
	ClientinSehirleri=new int[] {11,12,13,14,15,16,17,18,19,20};//clýentýn boyacagý sehýrler belýrlenýyor
	 SehirlerinRengi = boyama.main(sehirler0);//server kendi þehirlerini boyuyor
	 
	System.out.println("Color Assignment: "+Arrays.toString(SehirlerinRengi));//ekrana bastýrýlýyor
try{
serverSocket = new ServerSocket(PORT);
}
catch (IOException ioEx){

System.exit(1);
}
do
{
Socket client = serverSocket.accept();//server, clientýn baðlanmasýný bekliyor
System.out.println("\nNew client accepted.\n");
ClientHandler handler = new ClientHandler(client);//clientin taleplerini kullanabilmek için hander olusturuluyor
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
input = new Scanner(client.getInputStream());//clienttan veri alýyor
output = new PrintWriter(client.getOutputStream(),true);//clienttan veri gönderiyor
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
	System.out.println("\n Þehirlerin rengi:"+Arrays.toString(server.SehirlerinRengi));//Boyanan þehirlerin renkleri
}
}
while (!received.equals("QUIT")); //"QUIT" gelinceye kadar çalýþýr

try
{

if (client!=null)
{
System.out.println("Baðlantýyý kapatýyor...");
client.close();
}
}
catch(IOException ioEx)
{
System.out.println("Baðlantý kapatýlmaya uygun deðil!");
}	
}
}