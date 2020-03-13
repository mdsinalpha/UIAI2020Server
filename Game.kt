import models.Character
import kotlin.random.Random

object CardDealer{

    private var previousCards: MutableList<Character> = ArrayList()

    fun deal(turn: Int): MutableList<Character> =
        if(turn % 2 == 0) {
            val leftCards = Character.values().toMutableList()
            previousCards.clear()
            for(i in 1..4)
                previousCards.add(leftCards.removeAt(Random(leftCards.size).nextInt()))
            leftCards
        } else previousCards
}

object Game {

    private var round: Int = 1
    private var turn: Int = 1
    private lateinit var Jack: Character
    private var jackVisibility: Boolean = true
    private var cards: MutableList<Character> = CardDealer.deal(turn)
    private var visibleCharacters: MutableList<Character> = mutableListOf(Character.AlfredElyBeach, Character.CloudRider,
        Character.EdwardSmith, Character.JamesHCallahan, Character.LewisHowardLatimer, Character.MrsEmmaGrant)
    private var invisibleCharacters: MutableList<Character>
            = mutableListOf<Character>(Character.FrancisJTumblety, Character.MonkEastman)
    private var innocentCharacters: MutableList<Character> = ArrayList()

    fun run(): Unit = TODO()
}


fun main() {
    println("Hello UIAI2020 Server!")
}