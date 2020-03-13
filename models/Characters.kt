package models

import kotlin.random.Random

enum class Character(cell: Cell, isVisible: Boolean, isSuspect: Boolean = true){

    AlfredElyBeach(TODO(), true) {

        fun constructMetroEntrance(cell: StreetSpace) {
            cell.tile = Tile.MetroEntrance
            Tile.MetroEntrance.cells.add(cell)
        }

    },

    CloudRider(TODO(), true) {

        override fun moveTo(cell: Cell) = TODO()

        fun constructBuildingSite(cell: StreetSpace) {
            cell.tile = Tile.MetroEntrance
            Tile.MetroEntrance.cells.add(cell)
        }

    },

    LewisHowardLatimer(TODO(), true) {

        fun installGasLamp(cell: StreetSpace) {
            cell.tile = Tile.GasLamp
            Tile.GasLamp.cells.add(cell)
        }

    },

    MrsEmmaGrant(TODO(), true) {

        fun createPark(cell: StreetSpace) {
            cell.tile?.let {
                it.cells.remove(cell)
                cell.tile = Tile.Park
                Tile.Park.cells.add(cell)
            }
        }

    },

    JamesHCallahan(TODO(), true) {

        fun moveInvestigationTile(tile: InvestigationTile, cells: Pair<StreetSpace, StreetSpace>) {
            tile.blockedCells = cells
        }

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