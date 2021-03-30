package com.mfdgaming.raknet4java;

import com.mfdgaming.raknet4java.utils.BinaryStream;

public class Main
{
	public static void main(String[] args)
	{
		BinaryStream stream = new BinaryStream(new byte[0], 0);
		stream.writeIntLE(1);
		stream.writeIntLE(255);
		System.out.println(stream.readIntLE());
		System.out.println(stream.readIntLE());
	}
}
