package client;
import java.io.*;
import java.net.*;
import java.util.*;

public class clientasal
{
private static InetAddress host;
private static final int PORT = 1267;
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
String response,sayi = null,ajanSayisi = null;
int deger=111,ajanNo=1;

do
{
	System.out.println("\n1:"+deger);
	
	if(deger==111){
		networkOutput.println("sayi");
		sayi = networkInput.nextLine();
	}else if(deger==112){		
		networkOutput.println("ajanSayisi");
		ajanSayisi= networkInput.nextLine();
	}	
	deger=deger+1;
}
while (!(deger==113));


int flag=0;
for(int i=2;i<=(Math.sqrt(Integer.parseInt(sayi))/Integer.parseInt(ajanSayisi))*ajanNo;i++){
	 if(Integer.parseInt(sayi)%i==0){
		 flag=1;
		 break;
	 }
}

if(flag==0){
	networkOutput.println("sayi asal");
}else{
	networkOutput.println("sayi asal deðil");
}
if(Integer.parseInt(ajanSayisi)==ajanNo){
	networkOutput.println("QUIT");
}else{
	networkOutput.println("iþ bitti");
}
}
catch(IOException ioEx)
{
ioEx.printStackTrace();
}
finally
{
try
{
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