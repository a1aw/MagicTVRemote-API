package com.github.mob41.magictv.remote.api;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MagicTVRemote {
	
	public static final byte[] returnOK = {0x55, 0x00, 0x00, (byte) 0x80, 0x40, 0x06, 0x00, 0x01, 0x10, 0x02, 0x00, 0x04, 0x00, (byte) 0xAA};

	//Total 16. start hex is only 13
	public static final byte[] startHex = {0x55, 0x00, 0x00, 0x40, 0x40, 0x08, 0x00, 0x04, 0x00, 0x04, 0x00, (byte) 0xD8, 0x2A};
	
	//Ending HEX
	public static final byte endingHex = (byte) 0xAA;
	
	//Commands
	public static final byte[] CMD_MENU = {0x0F, (byte) 0xF0};
	
	public static final byte[] CMD_POWER = {0x11, (byte) 0xEE};
	
	public static final byte[] CMD_GUIDE = {0x32, (byte) 0xCD};
	
	public static final byte[] CMD_TEXT = {0x33, (byte) 0xCC};
	
	public static final byte[] CMD_ASPECT = {0x34, (byte) 0xCB};
	
	public static final byte[] CMD_AUDIO = {0x4E, (byte) 0xB1};
	
	public static final byte[] CMD_SUBTITLE = {0x4F, (byte) 0xB0};
	
	public static final byte[] CMD_BACK = {0x35, (byte) 0xCA};
	
	public static final byte[] CMD_UP = {0x0A, (byte) 0xF5};
	
	public static final byte[] CMD_DOWN = {0x0B, (byte) 0xF4};
	
	public static final byte[] CMD_LEFT = {0x0C, (byte) 0xF3};
	
	public static final byte[] CMD_RIGHT = {0x0D, (byte) 0xF2};
	
	public static final byte[] CMD_INFO = {0x36, (byte) 0xC9};
	
	public static final byte[] CMD_OK = {0x0E, (byte) 0xF1};
	
	public static final byte[] CMD_VOL_UP = {0x14, (byte) 0xEB};
	
	public static final byte[] CMD_VOL_DOWN = {0x15, (byte) 0xEA};
	
	public static final byte[] CMD_MUTE = {0x18, (byte) 0xE7};
	
	public static final byte[] CMD_CH_UP = {0x16, (byte) 0xE9};
	
	public static final byte[] CMD_CH_DOWN = {0x17, (byte) 0xE8};
	
	public static final byte[] CMD_REC = {0x24, (byte) 0xDB};
	
	public static final byte[] CMD_PAUSE = {0x22, (byte) 0xDD};
	
	public static final byte[] CMD_STOP = {0x23, (byte) 0xDC};
	
	public static final byte[] CMD_PLAY = {0x21, (byte) 0xDE};
	
	public static final byte[] CMD_FAST_REVERSE = {0x25, (byte) 0xDA};
	
	public static final byte[] CMD_FAST_FORWARD = {0x26, (byte) 0xD9};
	
	public static final byte[] CMD_REPLAY = {0x27, (byte) 0xD8};
	
	public static final byte[] CMD_SKIP = {0x28, (byte) 0xD7};
	
	public static final byte[] CMD_LIVE_SOURCE = {0x37, (byte) 0xC8};
	
	public static final byte[] CMD_ONE = {0x61, (byte) 0x9E};
	
	public static final byte[] CMD_TWO = {0x62, (byte) 0x9D};
	
	public static final byte[] CMD_THREE = {0x63, (byte) 0x9C};
	
	public static final byte[] CMD_FOUR = {0x64, (byte) 0x9B};
	
	public static final byte[] CMD_FIVE = {0x65, (byte) 0x9A};
	
	public static final byte[] CMD_SIX = {0x66, (byte) 0x99};
	
	public static final byte[] CMD_SEVEN = {0x67, (byte) 0x98};
	
	public static final byte[] CMD_EIGHT = {0x68, (byte) 0x97};
	
	public static final byte[] CMD_NINE = {0x69, (byte) 0x96};
	
	public static final byte[] CMD_ZERO = {0x60, (byte) 0x98};
	
	public static final byte[] CMD_CROSS_CLEAR = {0x38, (byte) 0xC7};
	
	public static final byte[] CMD_TICK_ENTER = {0x39, (byte) 0xC6};
	
	public static final byte[] CMD_RED = {0x48, (byte) 0xB7};
	
	public static final byte[] CMD_GREEN = {0x4B, (byte) 0xB4};
	
	public static final byte[] CMD_YELLOW = {0x4C, (byte) 0xB3};
	
	public static final byte[] CMD_BLUE = {0x4D, (byte) 0xB2};
	
	//Default port
	public static final int DEFAULT_PORT = 23456;
	
	private final String ip;
	
	private final int port;
	
	public MagicTVRemote(String ip){
		this.ip = ip;
		this.port = DEFAULT_PORT;
	}
	
	public MagicTVRemote(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	
	public void menu(){
		byte[] build = compile(CMD_MENU);
		for (int i = 0; i < build.length; i++){
			System.out.print(Integer.toHexString(build[i]) + " ");
		}
		System.out.println("");
		try {
			sendUDPRaw(build);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static byte[] compile(byte[] command){
		byte[] out = new byte[startHex.length + command.length + 1];
		int i = 0;
		for (i = 0; i < startHex.length; i++){
			out[i] = startHex[i];
		}
		int j = 0;
		for (; j < command.length; i++, j++){
			out[i] = command[j];
			System.out.println("[" + Integer.toHexString(out[i]) + "]");
		}
		out[i] = endingHex;
		return out;
	}
	
	public void sendUDPRaw(byte[] raw) throws IOException{
	    InetAddress hostAddress = InetAddress.getByName(ip);
		DatagramSocket s = new DatagramSocket();
		
	    byte[] buf = raw;
	    
	    DatagramPacket out = new DatagramPacket(buf, buf.length, hostAddress, port);
	    s.send(out);
	    
	    s.close();
	}
}
