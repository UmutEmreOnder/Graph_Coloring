# Brute Force Algorithm - First Fit Algorithm

* The algorithm starts with 0 as the color of the first vertices in the vertices list. 

* Then for each vertex, it checks the colors of the other vertices. 

* If the vertex it checks is not its adjacency, it checks whether it can use its color. 

* For this, it checks whether there is an adjacency which uses the same color. 

* If there is no adjacent vertex using this color, it gets this color. 

* If the color used by an adjacent vertex, it tries other colors again with the same algorithm. 

* At the end of the day, if it can't find any color, it assigns itself a new unique color.


# Why Not To Use It?

Because it is a bruteforce algorithm, it has time complexity of O(n<sup>3</sup>). Which is so poor.

# Compare With Real Answers

|  Test File  | Number of Vertices | Number of Edges | Real Answer | First Fit's Answer |
|:-----------:|:------------------:|:---------------:|:-----------:|:------------------:|
|  test.txt   |         5          |        5        |      3      |         3          |
| sample1.txt |         87         |       812       |     11      |         12         |
| sample2.txt |        1000        |      24500      |     50      |        126         |
| sample3.txt |        500         |      58862      |     122     |        143         |


When the number of vertices increases, the algorithm starting to produce results that are farther than the real result.