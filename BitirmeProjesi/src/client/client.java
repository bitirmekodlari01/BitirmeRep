package client;
import java.io.*;
import java.net.*;
import java.util.*;

public class client
{
private static InetAddress host;
private static final int PORT = 1259;
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
String SehirlerinRengi = null,cities = null, response;
int deger=111;

do
{
	System.out.println("\n1:"+deger);
	
	if(deger==111){
		networkOutput.println("renkver");
		SehirlerinRengi= networkInput.nextLine();
	}else if(deger==112){		
		networkOutput.println("sehirver");
		cities= networkInput.nextLine();
	}	
	deger=deger+1;
}
while (!(deger==113));



String[] items = SehirlerinRengi.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

int[] renkler = new int[items.length];

for (int i = 0; i < items.length; i++) {
    try {
    	renkler[i] = Integer.parseInt(items[i]);
    } catch (NumberFormatException nfe) {

    };
}
String[] items2 = cities.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
int[] sehirler = new int[items2.length];

for (int i = 0; i < items2.length; i++) {
    try {
    	sehirler[i] = Integer.parseInt(items2[i]);
    } catch (NumberFormatException nfe) {

    };
}

SehirlerinRengi=Arrays.toString(boyama.main(renkler, sehirler));
System.out.println("\nson colors:"+SehirlerinRengi);


	networkOutput.println(SehirlerinRengi);
	System.out.println("\nmesaj:"+networkInput.nextLine());
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