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
	
	public int readUByte()
	{
		return this.readByte() & 0xff;
	}
	
	public void writeByte(int value)
	{
		byte[] temp = new byte[1];
		temp[0] = (byte) value;
		this.write(temp);
	}
	
	public int readShortLE()
	{
		byte[] temp = this.read(2);
		int result = (temp[0] & 0xff);
		result |= ((temp[1] & 0xff) << 8);
		return result;
	}
	
	public int readUShortLE()
	{
		return (this.readShortLE() & 0xffff);
	}
	
	public void writeShortLE(int value)
	{
		byte[] temp = new byte[2];
		temp[0] = (byte) value;
		temp[1] = (byte) (value >>> 8);
		this.write(temp);
	}
	
	public int readShortBE()
	{
		byte[] temp = this.read(2);
		int result = (temp[3] & 0xff);
		result |= ((temp[2] & 0xff) << 8);
		return result;
	}
	
	public int readUShortBE()
	{
		return (this.readIntBE() & 0xffff);
	}
	
	public void writeIntBE(int value)
	{
		byte[] temp = new byte[2];
		temp[3] = (byte) value;
		temp[2] = (byte) (value >>> 8);
		this.write(temp);
	}
	
	public int readIntLE()
	{
		byte[] temp = this.read(4);
		int result = (temp[0] & 0xff);
		result |= ((temp[1] & 0xff) << 8);
		result |= ((temp[2] & 0xff) << 16);
		result |= ((temp[3] & 0xff) << 24);
		return result;
	}
	
	public int readUIntLE()
	{
		return (this.readIntLE() & 0xffffffff);
	}
	
	public void writeIntLE(int value)
	{
		byte[] temp = new byte[4];
		temp[0] = (byte) value;
		temp[1] = (byte) (value >>> 8);
		temp[2] = (byte) (value >>> 16);
		temp[3] = (byte) (value >>> 24);
		this.write(temp);
	}
	
	public int readIntBE()
	{
		byte[] temp = this.read(4);
		int result = (temp[3] & 0xff);
		result |= ((temp[2] & 0xff) << 8);
		result |= ((temp[1] & 0xff) << 16);
		result |= ((temp[0] & 0xff) << 24);
		return result;
	}
	
	public int readUIntBE()
	{
		return (this.readIntBE() & 0xffffffff);
	}
	
	public void writeIntBE(int value)
	{
		byte[] temp = new byte[4];
		temp[3] = (byte) value;
		temp[2] = (byte) (value >>> 8);
		temp[1] = (byte) (value >>> 16);
		temp[0] = (byte) (value >>> 24);
		this.write(temp);
	}
}
