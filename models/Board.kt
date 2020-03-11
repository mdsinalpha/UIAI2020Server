package models

import utils.Graph

data class Position(val column: Int, val step: Int)

infix fun Int.pos(other: Int) = Position(this, other)

sealed class Cell(val position: Position, val adjacents : List<Position> = emptyList(), var character: Character? = null)

class StreetSpace private constructor(position: Position, vararg adjacents: Position,
                  var tile: Tile? = null, val strictTile: Boolean = false, character: Character? = null): Cell(position, adjacents.toList(), character){

    companion object{

    }

}

class QuaysideSpace private constructor(position: Position,
                                        vararg adjacents: Position): Cell(position, adjacents.toList()){

    companion object{

    }

}

class PortSpace private constructor(position: Position, var hasSteamer: Boolean = false): Cell(position){

    companion object{

    }

}

object LibertyIsland: Cell(TODO(), TODO())

object LandExit: Cell(TODO(), TODO())

enum class Tile(val cells: MutableList<StreetSpace>) {

    BuildingSite(mutableListOf(

    )),

    MetroEntrance(mutableListOf(

    )),

    GasLamp(mutableListOf(

    )),

    Park(ArrayList())
}

class InvestigationTile private constructor(var blockedCells: Pair<StreetSpace, StreetSpace>) {
    companion object {
        val InvestigationTile1 : InvestigationTile = TODO()
        val InvestigationTile2 : InvestigationTile = TODO()
    }
}

