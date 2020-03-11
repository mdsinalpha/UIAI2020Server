package models

enum class Character(cell: Cell, isVisible: Boolean, isSuspect: Boolean = true){

    AlfredElyBeach(TODO(), TODO()) {

        fun constructMetroEntrance(cell: StreetSpace): Unit = TODO()

    },

    CloudRider(TODO(), TODO()) {

        override fun moveTo(cell: Cell) = TODO()

        fun constructBuildingSite(cell: StreetSpace): Unit = TODO()

    },

    LewisHowardLatimer(TODO(), TODO()) {

        fun installGaslamp(cell: StreetSpace): Unit = TODO()

    },

    MrsEmmaGrant(TODO(), TODO()) {

        fun createPark(cell: StreetSpace): Unit = TODO()

    },
    JamesHCallahan(TODO(), TODO()) {

    },

    MonkEastman(TODO(), TODO()) {

        fun moveAnotherCharacter(character: Character, cell: Cell){
            character.moveTo(cell)
        }

    },

    FrancisJTumblety(TODO(), TODO()) {

        fun hypnotize(adjacent: Character, target: Character){
            adjacent.moveTo(target.cell.also { target.moveTo(adjacent.cell) })
        }

    },

    EdwardSmith(TODO(), TODO()) {

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