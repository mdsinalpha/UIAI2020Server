package models

enum class Character(var cell: Cell, var isVisible: Boolean, var isSuspect: Boolean = true){
    AlfredElyBeach(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },
    CloudRider(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },
    LewisHowardLatimer(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },
    MrsEmmaGrant(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },
    JamesHCallahan(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },
    MonkEastman(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },
    FrancisJTumblety(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },
    EdwardSmith(cell = TODO(), isVisible = TODO(), isSuspect = TODO()) {
        override fun moveTo(cell: Cell) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    };

    abstract fun moveTo(cell: Cell): Unit
}