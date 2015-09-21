package ticTacToe;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.DatagramPacket;

public class ServerTCT {
	public static void main(String[] args) throws SocketException, IOException{
		DatagramSocket skt = new DatagramSocket(7070);
		byte[] rData = new byte[1];
		String sData = "";
		tictactoe board = new tictactoe();
		String ret = "";
		do{
			DatagramPacket rPkt = new DatagramPacket(rData, rData.length);
			skt.receive(rPkt);
			InetAddress addr = rPkt.getAddress();
			int port = rPkt.getPort();
			DatagramPacket sPkt = new DatagramPacket(sData.getBytes(), sData.length(),addr,port);
			skt.send(sPkt);
			ret = "";
		}while(ret=="No current win");
		skt.close();
	}
}
