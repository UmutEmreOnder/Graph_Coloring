# Recursive Largest First Algorithm

* Degree of Saturation Algorithm sorts the vertices by their degree.
* Add first color to the vertex has the largest degree.
* The selected vertex is colored with active color. Adjacent
  vertices of the selected vertex can not color with active color. But
  the uncolored vertices which are not adjacent vertices of the
  colored vertex can be colored with active color. So RLF uses a
  recursive structure for select the uncolored vertices to color with
  active color. During this process the below steps should be
  followed:
  1. Adjacent vertices of the selected vertex vi are found
  from adjacency matrix. Adjacent vertices are added to
  the adjacent set U. ( U = {u1 , u2 , ... ... . , ut })
  
  2. The vertices which are not adjacent vertices of the
  selected vertex vi are found from adjacency matrix.
  These vertices are added to the set of V′ . Calculate the
  number adjacent vertices which are in the set of U for
  every vertex in set of V′. After that, the uncolored
  vertex whose has maximum adjacent vertices (which
  are in the set of U ) in the set of V′ is selected for
  coloring. The selected vertex is colored with active
  color.
  
  3. The colored vertex and the adjacent vertices of the
  colored vertex are deleted from V ′ and added to the set
  of U.
  
  4. If the set of V′ is not empty, it is returned to the step 2.
  Otherwise move to step 3.
* If the uncolored vertex exists, next color in the color set
  is selected as active color. Otherwise the program is terminated.
* Calculate the number adjacent vertices for every
  uncolored vertex. After that, the uncolored vertex whose has
  maximum adjacent vertices is selected for coloring process. If
  more than one vertex provide this condition, the vertex which has
  the largest degree among them is selected. Then, it is returned to
  the step 2


# Compare With Real Answers

|  Test File  | Number of Vertices | Number of Edges | Real Answer | Recursive Largest First's Answer |
|:-----------:|:------------------:|:---------------:|:-----------:|:--------------------------------:|
|  test.txt   |         5          |        5        |      3      |                3                 |
| sample1.txt |         87         |       812       |     11      |                11                |
| sample2.txt |        1000        |      24500      |     50      |               113                |
| sample3.txt |        500         |      58862      |     122     |               134                |