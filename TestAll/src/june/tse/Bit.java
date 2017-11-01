package june.tse;

import java.nio.ByteBuffer;

/**
 */
public class Bit {

	private static ByteBuffer buffer = ByteBuffer.allocate(8);  
	/**
	 */
	public static void main(String[] args) {
		
		
		/*
		int a = 110;
		byte b = (byte)a;
		
		System.out.println(Integer.valueOf(String.valueOf(a),2));

		for(int i = 7; i >= 0; i--)
		{
			System.out.print(b>>i&1);
		}
		*/
		long l = 1231231231223123L;
		buffer.putLong(0, l);  
	    byte[] aa = buffer.array();
	    int size = aa.length;
	    for(int i = 0; i < size; i++)
	    {
	    	System.out.println(aa[i]);
	    }
		
        buffer.put(aa, 0, aa.length);  
        buffer.flip();//need flip   
        long ll = buffer.getLong();
        System.out.println(ll);
	}

}
