package merkle.implementation;

import merkle.Configuration;
import merkle.ICollisionGenerator;
import merkle.IMerkleTree;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * TASK 4 BONUS
 * THIS IS FOR BONUS POINTS
 * DO NOT DO THIS BEFORE COMPLETING EVERYTHING ELSE FIRST
 * TODO: IMPLEMENT generateCollision
 *
 * @euthuppa
 * @pso 17
 * @10/29/16
 *
 * Collaborators: Joel Uban, Jun Soo Kim
 */

public class CollisionGenerator extends ICollisionGenerator {

    /**
     * Given a <i>merkleTree</i> this function needs to
     * generate a file which will generate the merkleTree
     * The file then has to be dumped to <i>outputFile</i>
     * Basic code for writing blocks to a file is provided.
     */
    @Override
    public void generateCollision(File outputFile, IMerkleTree merkleTree) throws Exception {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            byte[] bytes = new byte[Configuration.blockSize]; //This is 1024
            //TODO:implement
            int blockStart = merkleTree.getTree().length / 2;
            int valueOfHash;
            int j;
            int sizeTracker;
            int rem;
            int i = blockStart;

            while (i < blockStart * 2) {
                sizeTracker = 0;    //Initialize size of spoof block

                String output = ""; //Initialize output

                valueOfHash = Integer.valueOf(merkleTree.getNode(i).getHash()); //The hash # of each node
                while (sizeTracker < valueOfHash) {
                    if ((sizeTracker + 127) > valueOfHash) {                    //Before crossing over value
                        rem = valueOfHash - sizeTracker;                        //To find the char of remainder of value
                        output += (char)rem;
                        for (j = output.length(); j < 1024; j++) {              //Pad the string with null values
                            output += '\0';
                        }
                        break;   //Output has reached 1024 bytes, now get out and go to next block
                    }
                    output += (char)127; //The value of 127 is added
                    sizeTracker += 127;  //The value
                }
                bytes = output.getBytes(); //Converts to byte

                bufferedOutputStream.write(bytes);
                bufferedOutputStream.flush();
                i++;
            }
        }
    }
}
