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


# Compare With Real Answers

|  Test File  | Number of Vertices | Number of Edges | Real Answer | Welsh Powell's Answer |
|:-----------:|:------------------:|:---------------:|:-----------:|:---------------------:|
|  test.txt   |         5          |        5        |      3      |           3           |
| sample1.txt |         87         |       812       |     11      |          11           |
| sample2.txt |        1000        |      24500      |     50      |          22           |
| sample3.txt |        500         |      58862      |     122     |          94           |


Actually, I have no idea why the answers are less than it should be. I'm not sure if I coded it right. But still it is better than First Fit Algorithm.