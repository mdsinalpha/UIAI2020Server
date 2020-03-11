package models

import kotlin.random.Random

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

class InvestigationTile private constructor(val blockedCells: Pair<Cell, Cell>) {
    companion object {
        val InvestigationTile1: InvestigationTile = TODO()
        val InvestigationTile2: InvestigationTile = TODO()
    }
}

object cardDealer{
    private var previousCards: MutableList<Character> = ArrayList<Character>()

    fun deal(turn: Int): MutableList<Character> {
        val leftCards = Character.values().toMutableList()
        return if(turn % 2 == 0) {
            val tempArray = ArrayList<Character>()
            for(i in 1..4)
                tempArray.add(leftCards.removeAt(Random(leftCards.size).nextInt()))
            previousCards = tempArray
            leftCards
        } else leftCards
    }
}

class Game(private var round: Int = 1, private var turn: Int = 1, private var jackVisibility: Boolean = true) {
    private var cards: MutableList<Character> = cardDealer.deal(turn)
    private var visibleCharacters: List<Character> = TODO()
    private var invisibleCharacters: List<Character> = TODO()
    private var innocentCharacters: List<Character> = TODO()

    fun run(): Unit = TODO()
}
