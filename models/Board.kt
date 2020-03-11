package models

data class Position(val column: Int, val step: Int)

sealed class Cell(val position: Position, val adjacents : List<Cell>, var character: Character? = null)

class StreetSpace(position: Position, adjacents: List<Cell>,
                  val strictTile: Boolean = false): Cell(position, adjacents)

class QuaysideSpace private constructor(position: Position,
                                        adjacents: List<Cell>): Cell(position, adjacents){
    companion object{
        val QuaysideSpace1: QuaysideSpace = TODO()
        val QuaysideSpace2: QuaysideSpace = TODO()
        val QuaysideSpace3: QuaysideSpace = TODO()
    }
}

class PortSpace private constructor(position: Position, adjacents: List<Cell>,
                                    var hasSteamer: Boolean = false): Cell(position, adjacents){
    companion object{
        val PortSpace1: PortSpace = TODO()
        val PortSpace2: PortSpace = TODO()
        val PortSpace3: PortSpace = TODO()
        val PortSpace4: PortSpace = TODO()
        val PortSpace5: PortSpace = TODO()
    }
}

object LibertyIsland: Cell(TODO(), TODO())

object LandExit: Cell(TODO(), TODO())

enum class Tile(val cells: MutableList<StreetSpace>) {
    BuildingSite(ArrayList<StreetSpace>()),
    MetroEntrance(ArrayList<StreetSpace>()),
    GasLamp(ArrayList<StreetSpace>()),
    Park(ArrayList<StreetSpace>())
}
