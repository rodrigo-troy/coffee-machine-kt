package machine

fun printState(water: Int, milk: Int, beans: Int, cups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
}

fun printIngredientsNeeded(water: Int, milk: Int, beans: Int, cups: Int) {
    println("For $cups cups of coffee you will need:")
    println("${water * cups} ml of water")
    println("${milk * cups} ml of milk")
    println("${beans * cups} g of coffee beans")
}

fun printprocess() {
    println(
        "Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!"
    )
}

fun main() {
    println("Write how many cups of coffee you will need:")
    val cups = readln().toInt()

    printIngredientsNeeded(200, 50, 15, cups)
}
