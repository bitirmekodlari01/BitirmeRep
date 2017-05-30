package servers;


import java.io.*;
import java.net.*;
import java.util.*;


public class server
{
	 static int[] SehirlerinRengi;
private static ServerSocket serverSocket;//serversocket deðiþkeni olusturuluyor
private static final int PORT = 1267;//port numarasý belýrlenýyor
public static int[] ClientinSehirleri;//clýentýn boyacagý sehýrler deðiþkeni oluþturuluyor
public static int[] sehirler1,sehirler2,sehirler3;

public static int sira=1;

public static void main(String[] args) throws Exception
{
	
	sehirler1=new int [] {0,1,2,3,5,6,7};//serverýn boyayacagý sehýrler belirleniyor
	sehirler2=new int [] {8,9,10,11,12,13};//clýentýn boyacagý sehýrler belýrlenýyor
	sehirler3=new int [] {14,15,16,17,18,19,20};
	SehirlerinRengi=new int [] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
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
	static long startTime = System.nanoTime();
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
System.out.println(received+"  "+server.sira);
if(received.equals("sirakac")){
	output.println(Integer.toString(server.sira));	
}else if(received.equals("renkver")){
	output.println(Arrays.toString(server.SehirlerinRengi));
	
}else if(received.equals("ajansehir0")){	
		output.println(Arrays.toString(server.sehirler1));
}else if(received.equals("ajansehir1")){	
			output.println(Arrays.toString(server.sehirler2));
}else if(received.equals("ajansehir2")){	
	output.println(Arrays.toString(server.sehirler3));
}else if(received.substring(0,1).equals("[")){
	String[] items2 = received.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

	for (int i = 0; i < items2.length; i++) {
	    try {
	    	if(Integer.parseInt(items2[i])!=9){
	    	server.SehirlerinRengi[i] = Integer.parseInt(items2[i]);
	    	}
	    } catch (NumberFormatException nfe) {
	       
	    }
	}

	output.println("islem tamamlandi");
}else if(received.equals("bitti")){
	try {
		Thread.sleep(2000);
		server.sira=server.sira+1;		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
while (!received.equals("QUIT")); //"QUIT" gelinceye kadar çalýþýr
System.out.println("\n server rengi:"+Arrays.toString(server.SehirlerinRengi));
long endTime = System.nanoTime();
long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
 double seconds = (double)estimatedTime/1000000000;
 System.out.println("Geçen Süre:"+seconds+" saniye");
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