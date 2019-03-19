### Usage:
- 算出加权图中前往X的最短路径。
### Key:
- 找出图中最便宜的节点，并确保没有到该节点的更便宜的路径。
### Four Step:
1. 找出最便宜的节点，即可在最短时间内前往的节点。
2. 对于该节点的邻居，检查是否有前往它们的更短路径，如果有，就更新其开销。
3. 重复这个过程，直到对图中的每个节点都这样做了。
4. 计算最终路径。

**第一步**：找出最便宜的节点。
![](https://raw.githubusercontent.com/egonSchiele/grokking_algorithms/master/images/07_dijkstras_algorithm/071_dijkstras_algorithm/neighbors_of_start.png)

站在起点（START）,前往A需要6分钟， 而前往B需要2分钟。而前往其他节点还不知道需要多长时间。

根据node(节点)和time to node(到节点的耗时),列一个表格（是从起点出发到这些节点的耗时）。
由于还不知道从起点前往重点的耗时，所以设为无穷大。
![](https://raw.githubusercontent.com/egonSchiele/grokking_algorithms/master/images/07_dijkstras_algorithm/071_dijkstras_algorithm/neighbors_table.png)

可以看出，节点B是最近的---2分钟节能到。

**第二步**：计算经节点B前往各个邻居所需的时间。（更新B节点邻居的开销）

![](https://raw.githubusercontent.com/egonSchiele/grokking_algorithms/master/images/07_dijkstras_algorithm/071_dijkstras_algorithm/5_minutes_to_a_table.png)
