# Largest Degree Order Algorithm

* Largest Degree Order Algorithm sorts the vertices by their degree.
* Goes from largest to smallest.
* Firstly, the selected vertex is tried to color with the colors in the color set. 
* If the color set is empty or the colors in the color set are not appropriate (all colors int the color set used from the adjacent vertices) for color the vertex, a new color is defined. 
* The new color is added to the color set and appointed to the selected vertex.

# Why Not To Use It?

Because, it is not good enough. Even though it has better time complexity than FF (O(n<sup>2</sup>)), the answers are not good enough.


# Compare With Real Answers

|  Test File  | Number of Vertices | Number of Edges | Real Answer | Largest Degree Order's Answer |
|:-----------:|:------------------:|:---------------:|:-----------:|:-----------------------------:|
|  test.txt   |         5          |        5        |      3      |               3               |
| sample1.txt |         87         |       812       |     11      |              11               |
| sample2.txt |        1000        |      24500      |     50      |              123              |
| sample3.txt |        500         |      58862      |     122     |              134              |


Actually, I was expecting LDO would be worse than WP. However, it is better than for sample2 and sample3. Nonetheless, the answer is still too far from the real answer for sample2.