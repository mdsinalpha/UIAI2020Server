import models.Character
import kotlin.random.Random

object CardDealer{

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
    private var cards: MutableList<Character> = CardDealer.deal(turn)
    private var visibleCharacters: List<Character> = TODO()
    private var invisibleCharacters: List<Character> = TODO()
    private var innocentCharacters: List<Character> = TODO()

    fun run(): Unit = TODO()
}


fun main() {
    println("Hello UIAI2020 Server!")
}