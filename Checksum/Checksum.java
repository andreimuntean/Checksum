import java.io.IOException;
import java.util.ArrayList;

// Generates a value from a list of bytes using the BSD checksum algorithm.
public class Checksum
{
    // Generates a value from a list of bytes using the BSD checksum algorithm.
    public static int getChecksum(ArrayList<Integer> bytes)
    {
        int checksum = 0;

        for (int byteValue : bytes)
        {
            // Rotates right by one bit.
            if (checksum % 2 != 0)
            {
            	checksum = checksum >>> 1;
                checksum += 0x8000;
            }
            else
            {
            	checksum = checksum >>> 1;
            }

            // Adds the byte to it.
            checksum += byteValue;

            // Restricts the value to 16 bits.
            checksum = 0x0ffff & checksum;
        }

        return checksum;
    }

    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> bytes = new ArrayList<Integer>();
        int currentByte;

        // Reads the bytes from standard input.
        while ((currentByte = System.in.read()) != -1)
        {
            bytes.add(currentByte);
        }

        // Outputs the check sum.
        System.out.println(getChecksum(bytes));
    }
}