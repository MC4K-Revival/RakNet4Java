package com.mfdgaming.raknet4java;

import com.mfdgaming.raknet4java.utils.BinaryStream;

public class Main
{
	public static void main(String[] args)
	{
		BinaryStream stream = new BinaryStream(new byte[0], 0);
		stream.writeByte(1);
		stream.writeByte(255);
		System.out.println(stream.data[1]);
	}
}
