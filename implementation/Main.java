package merkle.implementation;

import java.io.*;

/**
 * Class:
 * Created by joeluban on 10/18/16.
 */
public class Main {
    int passed = 0;
    int failed = 0;

    public String test1() {
        MerkleTree mt = new MerkleTree();
        String masterHash = null;

        try {
            File file = new File("project_3_data/Cryptographic_hash_function.data");
            //File file = new File("project_3_data/Hash_function.data");
            //File file = new File("project_3_data/MD5.data");
            //File file = new File("project_3_data/Megabyte.data");
            //File file = new File("project_3_data/Merkle_tree.data");
            //File file = new File("project_3_data/test.txt");

            masterHash = mt.build(file);
            String correctHash = "f77d283bc4dc37e72dc0e9a8f2e95fbd";
            if (masterHash.equals(correctHash)) {
                System.out.println("TEST 1 PASSED");
                passed++;
            }
            else {
                System.out.println("TEST 1 FAILED");
                failed++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return masterHash;
    }

    public String test2() {
        MerkleTree mt = new MerkleTree();
        String masterHash = null;

        try {
            //File file = new File("project_3_data/Cryptographic_hash_function.data");
            File file = new File("project_3_data/Hash_function.data");
            //File file = new File("project_3_data/MD5.data");
            //File file = new File("project_3_data/Megabyte.data");
            //File file = new File("project_3_data/Merkle_tree.data");
            //File file = new File("project_3_data/test.txt");

            masterHash = mt.build(file);
            String correctHash = "123fe15277d6dae1a98ca2a1c36ab8b0";
            if (masterHash.equals(correctHash)) {
                System.out.println("TEST 2 PASSED");
                passed++;
            }
            else {
                System.out.println("TEST 2 FAILED");
                failed++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return masterHash;
    }

    public String test3() {
        MerkleTree mt = new MerkleTree();
        String masterHash = null;

        try {
            //File file = new File("project_3_data/Cryptographic_hash_function.data");
            //File file = new File("project_3_data/Hash_function.data");
            File file = new File("project_3_data/MD5.data");
            //File file = new File("project_3_data/Megabyte.data");
            //File file = new File("project_3_data/Merkle_tree.data");
            //File file = new File("project_3_data/test.txt");

            masterHash = mt.build(file);
            String correctHash = "0b05bffc09bd9586ace82d6f6dfbc2e0";
            if (masterHash.equals(correctHash)) {
                System.out.println("TEST 3 PASSED");
                passed++;
            }
            else {
                System.out.println("TEST 3 FAILED");
                failed++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return masterHash;
    }

    public String test4() {
        MerkleTree mt = new MerkleTree();
        String masterHash = null;

        try {
            //File file = new File("project_3_data/Cryptographic_hash_function.data");
            //File file = new File("project_3_data/Hash_function.data");
            //File file = new File("project_3_data/MD5.data");
            File file = new File("project_3_data/Megabyte.data");
            //File file = new File("project_3_data/Merkle_tree.data");
            //File file = new File("project_3_data/test.txt");

            masterHash = mt.build(file);
            String correctHash = "a1cd515d7886e1ce074c4f3fe76da746";
            if (masterHash.equals(correctHash)) {
                System.out.println("TEST 4 PASSED");
                passed++;
            }
            else {
                System.out.println("TEST 4 FAILED");
                failed++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return masterHash;
    }

    public String test5() {
        MerkleTree mt = new MerkleTree();
        String masterHash = null;

        try {
            //File file = new File("project_3_data/Cryptographic_hash_function.data");
            //File file = new File("project_3_data/Hash_function.data");
            //File file = new File("project_3_data/MD5.data");
            //File file = new File("project_3_data/Megabyte.data");
            File file = new File("project_3_data/Merkle_tree.data");
            //File file = new File("project_3_data/test.txt");

            masterHash = mt.build(file);
            String correctHash = "3900749aa9e105e9c400b9d3218e043c";
            if (masterHash.equals(correctHash)) {
                System.out.println("TEST 5 PASSED");
                passed++;
            }
            else {
                System.out.println("TEST 5 FAILED");
                failed++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return masterHash;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println("Master Hash: " + m.test1());
        System.out.println();
        System.out.println("Master Hash: " + m.test2());
        System.out.println();
        System.out.println("Master Hash: " + m.test3());
        System.out.println();
        System.out.println("Master Hash: " + m.test4());
        System.out.println();
        System.out.println("Master Hash: " + m.test5());
        System.out.println();

        System.out.println("Passed: " + m.passed + "/5");
        System.out.println("Failed: " + m.failed + "/5");
    }

}
