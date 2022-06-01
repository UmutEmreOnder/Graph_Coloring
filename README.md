# Degree of Saturation Algorithm

* Degree of Saturation Algorithm sorts the vertices by their degree.
* Add first color to the vertex has the largest degree.
* The uncolored vertex whose number of adjacent vertices
  colored with different colors is the maximum is selected for
  coloring. If more than one vertex provide this condition, the
  vertex which has the largest degree among them is selected.
* The selected vertex is tried to color with the colors
  in the color set. If the colors in the color set are not appropriate to
  color the vertex, a new color is defined. The new color is added
  to the color set and appointed to the selected vertex.

  
# Compare With Real Answers

|  Test File  | Number of Vertices | Number of Edges | Real Answer | Largest Degree Order's Answer |
|:-----------:|:------------------:|:---------------:|:-----------:|:-----------------------------:|
|  test.txt   |         5          |        5        |      3      |               3               |
| sample1.txt |         87         |       812       |     11      |              11               |
| sample2.txt |        1000        |      24500      |     50      |              114              |
| sample3.txt |        500         |      58862      |     122     |              130              |