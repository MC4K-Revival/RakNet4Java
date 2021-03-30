package com.mfdgaming.raknet4java.utils;

public class BinaryStream
{
	public byte[] data;
	public int pos;
	
	public BinaryStream(byte[] data, int pos)
	{
		this.data = data;
		this.pos = pos;
	}
	
	public byte[] read(int size)
	{
		byte[] temp = new byte[size];
		for (int i = 0; i < size; ++i)
		{
			temp[i] = this.data[this.pos + i];
		}
		this.pos += size;
		return temp;
	}
	
	public void write(byte[] data)
	{
		int totalLength = this.data.length + data.length;
		byte[] temp = new byte[totalLength];
		for (int i = 0; i < totalLength; ++i)
		{
			if (i < this.data.length)
			{
				temp[i] = this.data[i];
			}
			else
			{
				temp[i] = data[i - this.data.length];
			}
		}
		this.data = temp;
	}
	
	public int readByte()
	{
		return this.read(1)[0];
	}
	
	public void writeByte(int value)
	{
		byte[] temp = new byte[1];
		temp[0] = (byte) value;
		this.write(temp);
	}
}
