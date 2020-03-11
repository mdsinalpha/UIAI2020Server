package models

data class Position(val column: Int, val step: Int)

sealed class Cell(val position: Position, val adjacents : List<Cell>, var character: Character? = null)