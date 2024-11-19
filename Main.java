import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        readCSV(rbt);
        StdOut.println("Product ID 1: 4832387affc268b3c9d6cca70dbdbcb4");
        rbt.get("4832387affc268b3c9d6cca70dbdbcb4");
        StdOut.println("Product ID 1: f5b9392a03cfae8817307a36411c8b17");
        rbt.get("f5b9392a03cfae8817307a36411c8b17");
        StdOut.println("Product ID 1: 326ebcfaa8d5204b634b5648e88e2fe4");
        rbt.get("326ebcfaa8d5204b634b5648e88e2fe4");
        StdOut.println("Insertion 1: 4832387affc268b3c9d6000000000000, Big Rig Balloon, Toys & Games, $10.99");
        rbt.put("4832387affc268b3c9d6000000000000", "Big Rig Balloon", "Toys & Games", "$10.99");
        StdOut.println("Duplicate Case: 4832387affc268b3c9d6000000000000, Big Rig Balloon, Toys & Games, $1000.99");
        rbt.put("4832387affc268b3c9d6000000000000", "Big Rig Balloon", "Toys & Games", "$1000.99");
    }
//This is horrific
    private static void readCSV(RedBlackTree redBlackTree) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("amazon-product-data.csv"))) {
            bufferedReader.readLine(); //I do not care about reading the first line please just get to the data
            String inputLine;
            while ((inputLine= bufferedReader.readLine()) != null) {
                int productIDLength = 32; //All product IDs are 32 characters!
                int priceIndex = inputLine.indexOf('$'); //Get the index of the last $ so we can get price
                if (priceIndex != -1) {
                    String nameAndCategorySubstring = inputLine.substring(productIDLength + 1, priceIndex).trim(); //Everything between ID and price is name/category
                    int firstPipeIndex = inputLine.indexOf("|");



                    String name = nameAndCategorySubstring;
                    String category = "Uncategorized";
                    String price = "Faulty Price";

                    String productID = inputLine.substring(0, productIDLength).trim(); //Retrieve product ID!
                    if (firstPipeIndex != -1) {
                        String nameOneCategorySubstring = inputLine.substring(productIDLength, firstPipeIndex).trim();
                        int nameCategorySeparatorIndex = nameOneCategorySubstring.lastIndexOf(","); //Gets last comma before the first "|"
                        if (nameCategorySeparatorIndex != -1) {
                            name = nameOneCategorySubstring.substring(0, nameCategorySeparatorIndex);
                            category = nameAndCategorySubstring.substring(nameCategorySeparatorIndex);
                        }
                    }
                    price = inputLine.substring(priceIndex);

                    redBlackTree.put(productID, name, category, price);
                }

            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }


}
