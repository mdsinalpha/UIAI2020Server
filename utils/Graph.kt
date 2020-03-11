package utils

class Graph<Node>(val nodeCount: Int,
                  private val adjacencyLists: MutableMap<Node, List<Node>> = HashMap(),
                  private val blockList: MutableSet<Node> = HashSet()){

    companion object{
        const val infiniteDepth = -1
    }

    fun updateAdjacents(node: Node, adjacents: List<Node>){
        adjacencyLists[node] = adjacents
    }

    fun addToBlockList(node: Node) = blockList.add(node)

    fun removeFromBlockList(node: Node) = blockList.remove(node)

    fun bfs(node: Node, maxDepth: Int = infiniteDepth): List<Node> = TODO()

}