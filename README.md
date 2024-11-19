# Assignment 3
## Group Members: Trinidad Little
### 49265911
Chosen balanced search tree type: Red-Black Tree

## Performance and Scalability Considerations:

### Search:
- Given that each level will eliminate half of possible nodes to be selected 
(hence, the "binary" part of the search tree), iterating through the nodes can be represented as log N. O is a stand-in for how taxing the actual implementation of searching each node takes, leading us to a final performance metric of O(log n)
- Time Complexity: O(log n)
### Insert:
- Similarly to search, the time complexity is O (log n), alongside an extra constant of the implementation of actually inserting and balancing a new value. However, this will remain constant O(1) as it is an operation independent of the height of the tree.

### Performance with Large Datasets:
- Performance stays more consistent between best and worst cases compared to an unbalanced binary tree
- Maximum height is 2(log n) in the worst case

### Maintaining Balance:
- The tree is able to remain balanced thanks to the rotateRight, rotateLeft, and flipColors operations
- Right rotation handles cases where we have two left-leaning red links in a row
- Left rotation handles cases where we have a right-leaning red link
- Color flipping is our main method of handling 4 nodes
- Thanks to this balancing, the worst case-scenario for the tree is limited to O(log n) as fewer nodes must be searched overall


Results:
Product ID 1: 4832387affc268b3c9d6cca70dbdbcb4
Product ID: 4832387affc268b3c9d6cca70dbdbcb4
Name: ,"Anagram International 3085101 Go Team Megaphone Shop Balloon Pack, 29"""
Category: Toys & Games | Party Supplies,
Price: $6.45
Product ID 1: f5b9392a03cfae8817307a36411c8b17
Product ID: f5b9392a03cfae8817307a36411c8b17
Name: ,Team Associated 9665 Hinge Pin Brace with Hinge Pins B4/T4
Category: Toys & Games | Hobbies | Hobby Building Tools & Hardware | RC Linkages,
Price: $10.99
Product ID 1: 326ebcfaa8d5204b634b5648e88e2fe4
Product ID: 326ebcfaa8d5204b634b5648e88e2fe4
Name: ,NKOK Sonic and Sega All Stars Racing Remote Controlled Car - Sonic The Hedgehog
Category: Toys & Games | Kids' Electronics,
Price: $26.99
Insertion 1: 4832387affc268b3c9d6000000000000, Big Rig Balloon, Toys & Games, $10.99
Duplicate Case: 4832387affc268b3c9d6000000000000, Big Rig Balloon, Toys & Games, $1000.99
ERROR: USER PRODUCT ALREADY EXISTS

Process finished with exit code 0