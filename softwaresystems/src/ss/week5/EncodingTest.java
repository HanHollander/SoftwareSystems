package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";

        System.out.println(Hex.encodeHexString(input.getBytes()));

        //toCharArray -_- gg
        char[] chars = new char[]{'4','d','6','f','6','4','7','5','6','c','6','5','2','0','3','2'};
        
        byte[] bytearray1 = Hex.decodeHex(chars);
        String string = new String(bytearray1);
        
        System.out.println(string);
   
        String hWBase64 = Base64.encodeBase64String(input.getBytes());
        
        String hexString = "010203040506";
        char[] hexStringChars = hexString.toCharArray();
        byte[] bytearray2 = Hex.decodeHex(hexStringChars);
        System.out.println(Base64.encodeBase64String(bytearray2));
        
        String base64String = "U29mdHdhcmUgU3lzdGVtcw==";
        System.out.println(Base64.encodeBase64String(base64String.getBytes()));
        
        String as = "";
        String a = "a";
        for (int i = 0; i < 16; i++){
        	as = as + a;
        	System.out.println(as + " -> " + Base64.encodeBase64String(as.getBytes()));
        }
    }
}
