# Welsh Powell Algorithm

* Welsh Powell Algorithm, firstly sort the vertices by their degrees.
* It starts coloring with the vertex that has the highest degree.
* After the coloring, creates a list with the vertices that are NOT adjacency to that vertex.
<hr/>

* Sort these vertices by their degree also.
* Give the same color to the vertex that has the highest degree on that list.
* Removes the adjacency of that vertex from the list.
* If list is not empty, does the same steps.
<hr/>

* If every vertex is not colored yet, start from the first step with the vertex that has the highest degree and not colored yet.

# Why Not To Use It?

Because, it is not good enough. Even though it has better time complexity than FF (O(n<sup>2</sup>)), the answers are not good enough.


# Compare With Real Answers

|  Test File  | Number of Vertices | Number of Edges | Real Answer | Welsh Powell's Answer |
|:-----------:|:------------------:|:---------------:|:-----------:|:---------------------:|
|  test.txt   |         5          |        5        |      3      |           3           |
| sample1.txt |         87         |       812       |     11      |          11           |
| sample2.txt |        1000        |      24500      |     50      |          126          |
| sample3.txt |        500         |      58862      |     122     |          157          |


Actually, I was expecting WP would be better than FF. However, it is even worse than FF for sample3 but finds the exact answer for sample1.