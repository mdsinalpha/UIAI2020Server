package models

import utils.Graph

data class Position(val column: Int, val step: Int)

infix fun Int.pos(other: Int) = Position(this, other)

sealed class Cell(val position: Position, val adjacents : List<Position>, var character: Character? = null)

class StreetSpace private constructor(position: Position, vararg adjacents: Position,
                  val strictTile: Boolean = false): Cell(position, adjacents.toList()){

    companion object{
        val map = listOf(
            StreetSpace(1 pos 3, 1 pos 2, 2 pos 2, 2 pos 3),
            StreetSpace(2 pos 1, 1 pos 2, 2 pos 2, 3 pos 1, 3 pos 1),
            StreetSpace(2 pos 2, 1 pos 2, 2 pos 1, 3 pos 2, 3 pos 3, 2 pos 3, 1 pos 3),
            StreetSpace(2 pos 3, 1 pos 3, 2 pos 2, 3 pos 3, 3 pos 4, 2 pos 4),
            StreetSpace(3 pos 2, 2 pos 1, 3 pos 1, 4 pos 2, 4 pos 3, 3 pos 3, 2 pos 2)
        ).map { it.position to it }.toMap()
    }

}

class QuaysideSpace private constructor(position: Position,
                                        vararg adjacents: Position): Cell(position, adjacents.toList()){
    companion object{
        val map = listOf(
            QuaysideSpace(1 pos 2, 1 pos 1, 1 pos 3, 2 pos 1, 2 pos 2),
            QuaysideSpace(3 pos 1, 2 pos 1, 3 pos 2, 4 pos 2, 4 pos 1)
        ).map { it.position to it }.toMap()
    }
}

class PortSpace private constructor(position: Position, vararg adjacents: Position,
                                    var hasSteamer: Boolean = false): Cell(position, adjacents.toList()){
    companion object{
        val map = listOf(
            PortSpace(2 pos 4, 2 pos 3, 3 pos 4, 3 pos 5)
        ).map { it.position to it }.toMap()
    }
}

object LibertyIsland: Cell(1 pos 1, listOf(7 pos 1, 5 pos 7))

object LandExit: Cell(TODO(), TODO())

enum class Tile(val cells: MutableList<StreetSpace>) {
    BuildingSite(ArrayList<StreetSpace>()),
    MetroEntrance(ArrayList<StreetSpace>()),
    GasLamp(ArrayList<StreetSpace>()),
    Park(ArrayList<StreetSpace>())
}

class InvestigationTile private constructor(val blockedCells: Pair<Cell, Cell>) {
    companion object {
        val InvestigationTile1: InvestigationTile = TODO()
        val InvestigationTile2: InvestigationTile = TODO()
    }
}

object Board{

    val map = StreetSpace.map + QuaysideSpace.map + PortSpace.map + listOf(LibertyIsland, LandExit).map { it.position to it }.toMap()
    val graph = Graph<Cell>(StreetSpace.map.size + QuaysideSpace.map.size + PortSpace.map.size + 2)
}
