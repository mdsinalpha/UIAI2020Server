package models

import utils.Graph

data class Position(val column: Int, val step: Int)

infix fun Int.pos(other: Int) = Position(this, other)

sealed class Cell(val position: Position, val adjacents : List<Position> = emptyList(), var character: Character? = null)

class StreetSpace private constructor(position: Position, vararg adjacents: Position,
                  var tile: Tile? = null, val strictTile: Boolean = false, character: Character? = null): Cell(position, adjacents.toList(), character){

    companion object{
        val map = listOf(
            StreetSpace(1 pos 3, 1 pos 2, 2 pos 2, 2 pos 3),
            StreetSpace(2 pos 1, 1 pos 2, 2 pos 2, 3 pos 1, 3 pos 1, tile = Tile.MetroEntrance),
            StreetSpace(2 pos 2, 1 pos 2, 2 pos 1, 3 pos 2, 3 pos 3, 2 pos 3, 1 pos 3),
            StreetSpace(2 pos 3, 1 pos 3, 2 pos 2, 3 pos 3, 3 pos 4, 2 pos 4),
            StreetSpace(3 pos 2, 2 pos 1, 3 pos 1, 4 pos 2, 4 pos 3, 3 pos 3, 2 pos 2),
            StreetSpace(3 pos 3, TODO(), tile = Tile.GasLamp),
            StreetSpace(4 pos 3, TODO(), tile = Tile.BuildingSite, strictTile = true),
            StreetSpace(4 pos 4, TODO(), tile = Tile.BuildingSite, strictTile = true),
            StreetSpace(5 pos 5, TODO(), character = Character.AlfredElyBeach),
            StreetSpace(6 pos 3, TODO(), character = Character.JamesHCallahan),
            StreetSpace(6 pos 4, TODO(), character = Character.LewisHowardLatimer),
            StreetSpace(7 pos 1, TODO(), tile = Tile.MetroEntrance, strictTile = true),
            StreetSpace(8 pos 2, TODO(), character = Character.MonkEastman),
            StreetSpace(8 pos 5, TODO(), character = Character.FrancisJTumblety),
            StreetSpace(9 pos 4, TODO(), character = Character.CloudRider),
            StreetSpace(10 pos 2, TODO(), tile = Tile.BuildingSite, strictTile = true),
            StreetSpace(10 pos 3, TODO(), character = Character.MrsEmmaGrant),
            StreetSpace(10 pos 4, TODO(), character = Character.EdwardSmith),
            StreetSpace(10 pos 5, TODO(), tile = Tile.BuildingSite, strictTile = true),
            StreetSpace(11 pos 2, TODO(), tile = Tile.MetroEntrance),
            StreetSpace(11 pos 3, TODO(), tile = Tile.BuildingSite, strictTile = true),
            StreetSpace(11 pos 5, TODO(), tile = Tile.BuildingSite, strictTile = true),
            StreetSpace(12 pos 7, TODO(), tile = Tile.MetroEntrance),
            StreetSpace(13 pos 6, TODO(), tile = Tile.GasLamp)
        ).map { it.position to it }.toMap()
    }

}

class QuaysideSpace private constructor(position: Position,
                                        vararg adjacents: Position): Cell(position, adjacents.toList()){

    companion object{
        val map = listOf(
            QuaysideSpace(1 pos 2, 1 pos 1, 1 pos 3, 2 pos 1, 2 pos 2),
            QuaysideSpace(3 pos 1, 2 pos 1, 3 pos 2, 4 pos 2, 4 pos 1),
            QuaysideSpace(7 pos 1, 6 pos 1, 7 pos 2, 8 pos 1),
            QuaysideSpace(5 pos 8, 4 pos 6, 5 pos 7, 6 pos 7)
        ).map { it.position to it }.toMap()
    }

}

class PortSpace private constructor(position: Position, var hasSteamer: Boolean = false): Cell(position){

    companion object{
        val map = listOf(
            PortSpace(2 pos 4),
            PortSpace(5 pos 1, true),
            PortSpace(7 pos 8),
            PortSpace(11 pos 8),
            PortSpace(12 pos 1, true)
        ).map { it.position to it }.toMap()
    }

}

object LibertyIsland: Cell(1 pos 1, listOf(7 pos 1, 5 pos 7))

object LandExit: Cell(14 pos 1)

enum class Tile(val cells: MutableList<StreetSpace>) {

    BuildingSite(mutableListOf(
        StreetSpace.map[4 pos 3]!!,
        StreetSpace.map[4 pos 4]!!,
        StreetSpace.map[10 pos 2]!!,
        StreetSpace.map[10 pos 5]!!,
        StreetSpace.map[11 pos 3]!!,
        StreetSpace.map[11 pos 5]!!
    )),

    MetroEntrance(mutableListOf(
        StreetSpace.map[2 pos 2]!!,
        StreetSpace.map[7 pos 1]!!,
        StreetSpace.map[11 pos 2]!!,
        StreetSpace.map[12 pos 7]!!
    )),

    GasLamp(mutableListOf(
        StreetSpace.map[3 pos 3]!!,
        StreetSpace.map[13 pos 6]!!
    )),

    Park(ArrayList())
}

class InvestigationTile private constructor(var blockedCells: Pair<StreetSpace, StreetSpace>) {
    companion object {
        val InvestigationTile1 = InvestigationTile(StreetSpace.map[5 pos 2]!! to StreetSpace.map[6 pos 1]!!)
        val InvestigationTile2 = InvestigationTile(StreetSpace.map[11 pos 7]!! to StreetSpace.map[12 pos 8]!!)
    }
}

object Board{

    val map = StreetSpace.map + QuaysideSpace.map + PortSpace.map + listOf(LibertyIsland, LandExit).map { it.position to it }.toMap()
    val graph = Graph<Cell>(StreetSpace.map.size + QuaysideSpace.map.size + PortSpace.map.size + 2)
    val tiles
        get() = (Tile.BuildingSite.cells + Tile.MetroEntrance.cells + Tile.GasLamp.cells + Tile.Park.cells).mapNotNull { it.tile }
}
