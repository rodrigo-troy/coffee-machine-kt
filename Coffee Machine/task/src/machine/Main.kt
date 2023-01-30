package machine

fun printStatus(water: Int, milk: Int, beans: Int, cups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("\$$money of money")
}

fun printIngredientsNeeded(water: Int, milk: Int, beans: Int, cups: Int) {
    println("For $cups cups of coffee you will need:")
    println("${water * cups} ml of water")
    println("${milk * cups} ml of milk")
    println("${beans * cups} g of coffee beans")
}

fun printProcess() {
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

fun configureMachine() {
    println("Write how many ml of water the coffee machine has:")
    val water = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milk = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val beans = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val cups = readln().toInt()

    val waterCups = water / 200
    val milkCups = milk / 50
    val beansCups = beans / 15

    val minCups = minOf(waterCups, milkCups, beansCups)

    if (minCups == cups) {
        println("Yes, I can make that amount of coffee")
    } else if (minCups > cups) {
        println("Yes, I can make that amount of coffee (and even ${minCups - cups} more than that)")
    } else {
        println("No, I can make only $minCups cup(s) of coffee")
    }
}


fun main() {
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550

    println("Write action (buy, fill, take, remaining, exit):")
    var action = readln()
    while (action != "exit") {
        println()
        when (action) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                val coffeeType = readln()
                when (coffeeType) {
                    "1" -> {
                        if (water >= 250 && beans >= 16 && cups >= 1) {
                            water -= 250
                            beans -= 16
                            cups -= 1
                            money += 4
                            printProcess()
                        } else {
                            println("Sorry, not enough water!")
                        }
                    }

                    "2" -> {
                        if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                            water -= 350
                            milk -= 75
                            beans -= 20
                            cups -= 1
                            money += 7
                            printProcess()
                        } else {
                            println("Sorry, not enough water!")
                        }
                    }

                    "3" -> {
                        if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                            water -= 200
                            milk -= 100
                            beans -= 12
                            cups -= 1
                            money += 6
                            printProcess()
                        } else {
                            println("Sorry, not enough water!")
                        }
                    }
                }
            }

            "fill" -> {
                println("Write how many ml of water do you want to add:")
                water += readln().toInt()
                println("Write how many ml of milk do you want to add:")
                milk += readln().toInt()
                println("Write how many grams of coffee beans do you want to add:")
                beans += readln().toInt()
                println("Write how many disposable cups of coffee do you want to add:")
                cups += readln().toInt()
            }

            "take" -> {
                println("I gave you $$money")
                money = 0
            }

            "remaining" -> {
                printStatus(water, milk, beans, cups, money)
            }
        }
        println("Write action (buy, fill, take, remaining, exit):")
        action = readln()
    }

}
