package models

data class Position(val column: Int, val step: Int)

sealed class Cell(val position: Position, val adjacents : List<Cell>)

class StreetSpace(position: Position, adjacents: List<Cell>,
                  val strictTile: Boolean = false): Cell(position, adjacents)
