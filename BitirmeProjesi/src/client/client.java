package client;
import 
java.io.*;
import java.net.*;
import java.util.*;

import server.server;
public class client
{
private static InetAddress host;
private static final int PORT = 1241;
public static void main(String[] args) throws Exception
{
try
{
//host = InetAddress.getByName("ServerName");
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
String colors = null,cities = null, response;
int deger=111;

do
{
	System.out.println("\n1:"+deger);
	
	if(deger==111){
		networkOutput.println("renkver");
		colors= networkInput.nextLine();
	}else if(deger==112){		
		networkOutput.println("sehirver");
		cities= networkInput.nextLine();
	}	
	deger=deger+1;
	/*
System.out.print("Enter message ('QUIT' to exit): ");
networkOutput.println("ali");
response = networkInput.nextLine();
System.out.println("\nSERVER> " + response);*/
}
while (!(deger==113));



String[] items = colors.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

int[] renkler = new int[items.length];

for (int i = 0; i < items.length; i++) {
    try {
    	renkler[i] = Integer.parseInt(items[i]);
    } catch (NumberFormatException nfe) {
        //NOTE: write something here if you need to recover from formatting errors
    };
}
String[] items2 = cities.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
int[] sehirler = new int[items2.length];

for (int i = 0; i < items2.length; i++) {
    try {
    	sehirler[i] = Integer.parseInt(items2[i]);
    } catch (NumberFormatException nfe) {
        //NOTE: write something here if you need to recover from formatting errors
    };
}

colors=Arrays.toString(boyama.main(renkler, sehirler));
System.out.println("\nson colors:"+colors);

do{
	networkOutput.println(colors);
	System.out.println("\nmesaj:"+networkInput.nextLine());
	deger=deger+1;
}while(!(deger>113));

}
catch(IOException ioEx)
{
ioEx.printStackTrace();
}
finally
{
try
{
System.out.println("\nClosing connection...");
socket.close();
}
catch(IOException ioEx)
{
System.out.println("Unableto disconnect!");
System.exit(1);
}
}
}
}