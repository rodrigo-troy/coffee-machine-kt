package machine


fun main() {
    val coffeeMachine = CoffeeMachine(400,
                                      540,
                                      120,
                                      9,
                                      550)

    while (coffeeMachine.status() != State.EXIT) {
        println("Write action (buy, fill, take, remaining, exit):")
        var action = readln()

        coffeeMachine.setInput(action)

        when (action) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                coffeeMachine.setInput(action)
            }

            "fill" -> {
                println("Write how many ml of water do you want to add:")
                coffeeMachine.setInput(readln())
                println("Write how many ml of milk do you want to add:")
                coffeeMachine.setInput(readln())
                println("Write how many grams of coffee beans do you want to add:")
                coffeeMachine.setInput(readln())
                println("Write how many disposable cups of coffee do you want to add:")
                coffeeMachine.setInput(readln())
            }

            else -> {
                coffeeMachine.setInput(readln())
            }
        }
    }
}
