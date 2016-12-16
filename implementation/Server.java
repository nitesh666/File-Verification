package merkle.implementation;

import merkle.IMerkleTree;
import merkle.IServer;

import java.util.LinkedList;
import java.util.List;


/**
 * TASK 2
 * TODO: IMPLEMENT generateResponse
 *
 * @euthuppa
 * @17
 * @10/26/16
 */
public class Server extends IServer {

    /**
     * Given a node to verify identified by <i>blockToTest</i>
     * which corresponds to the node received by calling <i>merkleTree.getNode(blockToTest)</i>
     * this function generates the path siblings which are required for verification
     * The returned list should contains Nodes in order from node to the root, i.e. bottom up
     */
    public List<IMerkleTree.Node> generateResponse(int blockToTest) {
        List<IMerkleTree.Node> verificationList = new LinkedList<>();
        int i;
        verificationList.add(merkleTree.getNode(blockToTest));

        if (leftoRight(merkleTree.getNode(blockToTest)) == IMerkleTree.NodeType.right) {
            verificationList.add(merkleTree.getNode(blockToTest - 1));
            i = blockToTest - 1;
        }
        else {
            verificationList.add(merkleTree.getNode(blockToTest + 1));
            i = blockToTest + 1;
        }
        while (i > 3) {
            if (leftoRight(merkleTree.getNode(i/2)) == IMerkleTree.NodeType.left) {
                i = (i/2) + 1;
                verificationList.add(merkleTree.getNode(i));
            }
            else {
                i = (i/2) - 1;
                verificationList.add(merkleTree.getNode(i));
            }
        }
        return verificationList;
    }
    /**
     * Method to check if this is a left or right node in the tree
     */
    private IMerkleTree.NodeType leftoRight(IMerkleTree.Node node) {
        return node.getType();
    }
}
