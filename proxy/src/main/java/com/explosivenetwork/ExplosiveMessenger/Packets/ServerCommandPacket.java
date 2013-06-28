package com.explosivenetwork.ExplosiveMessenger.Packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerCommandPacket implements IPacket {
	public static final short id = 3;
	
	public String user;
	public String command;
	
	public ServerCommandPacket() {
	}
	
	/**
	 * A packet sent when a server needs to execute a command as console. User can be Console when sent by the server.
	 * @param user
	 * @param command
	 */
	public ServerCommandPacket(String user, String command) {
		this.user = user;
		this.command = command;
	}

	@Override
	public void read(DataInputStream in) throws IOException {
		user = in.readUTF();
		command = in.readUTF();
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		out.writeShort(id);
		out.writeUTF(user);
		out.writeUTF(command);
		out.flush();
	}
}
