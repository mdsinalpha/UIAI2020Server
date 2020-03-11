package models

data class Position(val column: Int, val step: Int)

sealed class Cell(val position: Position, val adjacents : List<Cell>)

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