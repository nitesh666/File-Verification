package merkle.implementation;

import merkle.Configuration;
import merkle.IMerkleTree;

import java.io.*;

import static merkle.Configuration.blockSize;
import static merkle.Configuration.hashFunction;

/**
 * TASK 1
 * TODO: IMPLEMENT build
 *
 * @euthuppa
 * @pso 17
 * @10/18/16
 */
public class MerkleTree extends IMerkleTree {
    /**
     * Given an <i>inputFile</i> this function builds a Merkle Tree and return the <i>masterHash</i>
     * <i>this.tree</i> is the array representation of the tree which you need to create
     * You can use <i>Configuration.hashFunction</i>
     * The basic code to read a file block wise is provided. You can choose to use it.
     * The tree should be 1-indexed
     */
    @Override
    public String build(File inputFile) throws Exception {
        int blocks = (int) Math.ceil((double) inputFile.length() / Configuration.blockSize);
        //System.out.println("number of blocks: " + blocks);
        tree = new Node[2 * blocks];//Initialize this with a proper size
        tree[0] = new Node("dummy", 0);//Zeroth dummy node
        System.out.println("# of blocks/leaves: " + blocks);
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(inputFile))) {
            byte[] byteArray = new byte[blockSize];
            int readStatus;
            int i = 0;
            while ((readStatus = reader.read(byteArray)) != -1) {
                String block = padBytes(byteArray, readStatus);
                tree[blocks+i] = new Node(Configuration.hashFunction.hashBlock(block), blocks+i);   //creating leaves
                i++;
            }
            for (i = 2*blocks-1; i > 1; i = i - 2) {    // Goes from the last tree node to the root
                //Jumps every two elements back and only compares to left node/2 to match the parent node
                tree[(i-1)/2] = new Node(Configuration.hashFunction.concatenateHash(tree[i-1], tree[i]), (i-1)/2);
            }
        }
        return tree[1].getHash();//to initialize
    }
}
