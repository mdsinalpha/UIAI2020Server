package models

import kotlin.random.Random

enum class Character(cell: Cell, isVisible: Boolean, isSuspect: Boolean = true){

    AlfredElyBeach(TODO(), true) {

        fun constructMetroEntrance(cell: StreetSpace): Unit = TODO()

    },

    CloudRider(TODO(), true) {

        override fun moveTo(cell: Cell) = TODO()

        fun constructBuildingSite(cell: StreetSpace): Unit = TODO()

    },

    LewisHowardLatimer(TODO(), true) {

        fun installGasLamp(cell: StreetSpace): Unit = TODO()

    },

    MrsEmmaGrant(TODO(), true) {

        fun createPark(cell: StreetSpace): Unit = TODO()

    },

    JamesHCallahan(TODO(), true) {

        fun moveInvestigationTile(tile: InvestigationTile, cells: Pair<StreetSpace, StreetSpace>): Unit = TODO()

    },

    MonkEastman(TODO(), false) {

        fun moveAnotherCharacter(character: Character, cell: Cell){
            character.moveTo(cell)
        }

    },

    FrancisJTumblety(TODO(), false) {

        fun hypnotize(adjacent: Character, target: Character){
            adjacent.moveTo(target.cell.also { target.moveTo(adjacent.cell) })
        }

    },

    EdwardSmith(TODO(), true) {

        fun moveSteamer(from: PortSpace, to: PortSpace){
            from.hasSteamer = false
            to.hasSteamer = true
        }

    };

    var cell: Cell = cell
        private set

    var isVisible: Boolean = isVisible
        private set

    var isSuspect: Boolean = isSuspect
        private set

    open fun moveTo(cell: Cell) {
        this.cell = cell
    }

    fun toggleVisibility(){
        this.isVisible = !this.isVisible
    }

    fun exonerate(){
        this.isSuspect = false
    }

}

object Informant {

    var cell: Cell = LibertyIsland
        private set

    var mute: Boolean = true

    private val innocents: MutableList<Character> = Character.values().toMutableList()

    fun move(cell: Cell) {
        this.cell = cell
    }

    fun removeJack(jack: Character): Boolean = innocents.remove(jack)

    fun leakInnocent() : Character = innocents.removeAt(Random(innocents.size).nextInt())
}