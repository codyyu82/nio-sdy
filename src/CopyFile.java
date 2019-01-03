// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyFile
{
  static public void main( String args[] ) throws Exception {
    if (args.length<2) {
      System.err.println( "Usage: java CopyFile infile outfile" );
      System.exit( 1 );
    }

    String infile = args[0];
    String outfile = args[1];

    FileInputStream fin = new FileInputStream( infile );
    FileOutputStream fout = new FileOutputStream( outfile );

    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();

    //ByteBuffer buffer = ByteBuffer.allocate( 1024 );
    ByteBuffer buffer = ByteBuffer.allocate( 66 );

    
    
    int i = 0;
    
    while (true) {
      i++;
      
      buffer.clear();

      int r = fcin.read( buffer );

      System.out.println("r: " + r);
      
      if (r==-1) {
        System.out.println("break ======= i: " + i);
  
        break;
      }
      
      System.out.println("i: " + i);
      
      
      buffer.flip();

      fcout.write( buffer );
    }
  }
}
