package models

import kotlin.random.Random

enum class Character(cell: Cell, isVisible: Boolean, isSuspect: Boolean = true){

    AlfredElyBeach(StreetSpace.map[5 pos 5]!!, true) {

        fun constructMetroEntrance(cell: StreetSpace): Unit = TODO()

    },

    CloudRider(StreetSpace.map[9 pos 4]!!, true) {

        override fun moveTo(cell: Cell) = TODO()

        fun constructBuildingSite(cell: StreetSpace): Unit = TODO()

    },

    LewisHowardLatimer(StreetSpace.map[6 pos 4]!!, true) {

        fun installGasLamp(cell: StreetSpace): Unit = TODO()

    },

    MrsEmmaGrant(StreetSpace.map[10 pos 3]!!, true) {

        fun createPark(cell: StreetSpace): Unit = TODO()

    },

    JamesHCallahan(StreetSpace.map[6 pos 3]!!, true) {

        fun moveInvestigationTile(tile: InvestigationTile, cells: Pair<StreetSpace, StreetSpace>): Unit = TODO()

    },

    MonkEastman(StreetSpace.map[8 pos 2]!!, false) {

        fun moveAnotherCharacter(character: Character, cell: Cell){
            character.moveTo(cell)
        }

    },

    FrancisJTumblety(StreetSpace.map[8 pos 5]!!, false) {

        fun hypnotize(adjacent: Character, target: Character){
            adjacent.moveTo(target.cell.also { target.moveTo(adjacent.cell) })
        }

    },

    EdwardSmith(StreetSpace.map[10 pos 4]!!, true) {

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