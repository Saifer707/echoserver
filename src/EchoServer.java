import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class EchoServer{
	
	public static final int PORT = 4444;
	
	public static void main(String[] args){
		
		ServerSocket ss;
		Socket client = null;
		BufferedReader in = null;
		PrintWriter pw = null;
		
		try{
			ss = new ServerSocket(PORT);
			System.out.println("Server started: " + ss);
			client = ss.accept();
			System.out.println("Connection: " + client);
			
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
			
			while(true){
				
				String str = in.readLine();
				if(str.equals("END")) break;
				System.out.println("Echo: " + str);
				//pw.println(str);
			}
			System.out.println("EchoServer Closing");
			pw.close();
			in.close();
			client.close();
			ss.close();
	}catch(IOException ex){ex.printStackTrace();}
}
}
