package it.polimi.ingsw.s3m.launcher.Server.Network;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Notification;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private final Socket socket;
	private OutputStream outputStream;
	private ObjectOutputStream objectOutputStream;
	private InputStream inputStream;
	private ObjectInputStream objectInputStream;

	private PlayerController playerController;
	private Message messageToSend;
	private Response response;

	public ClientHandler(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run(){
		setupStream();
		this.playerController = new PlayerController(this);
		playerController.login();
		try{
			while(true){
				sendMessage();
			}
		}catch(IOException | ClassNotFoundException e){
			playerController.disconnect();
		}finally{
			close();
		}
	}

	public void setupStream(){
		try{
			outputStream = socket.getOutputStream();
			objectOutputStream = new ObjectOutputStream(outputStream);
			inputStream = socket.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void writeOutputStream(Message message) throws NullPointerException{
		if(message == null){
			System.out.println("ERROR: trying to send a null message");
			throw new NullPointerException();
		}
		try{
			objectOutputStream.writeObject(message);
			objectOutputStream.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public synchronized void sendMessage() throws IOException, ClassNotFoundException{
		while(messageToSend == null){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		if(messageToSend instanceof Notification){
			writeOutputStream(messageToSend);
			response = null;
		}else{
			writeOutputStream(messageToSend);
			response = (Response) objectInputStream.readObject();
		}
		messageToSend = null;
		notifyAll();
	}

	public synchronized Response communicateWithClient(Message message){
		while(messageToSend != null){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		messageToSend = message;
		notifyAll();
		if(message instanceof Notification){
			return null;
		}else{
			while(response == null){
				try{
					wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			Response temp = response;
			response = null;
			return temp;
		}
	}

	public void close(){
		try{
			inputStream.close();
			outputStream.close();
			socket.close();
			System.out.println("client socket closed");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
