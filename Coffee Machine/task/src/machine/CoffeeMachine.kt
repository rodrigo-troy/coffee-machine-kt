package machine

/**
 * Created with IntelliJ IDEA.
$ Project: coffee-machine
 * User: rodrigotroy
 * Date: 02-02-23
 * Time: 14:31
 */
class CoffeeMachine(var water: Int = 400,
                    var milk: Int = 540,
                    var beans: Int = 120,
                    var cups: Int = 9,
                    var money: Int = 550) {
    private var currentState: State = State.CHOOSE_ACTION

    fun status(): State {
        return currentState
    }

    private fun remaining() {
        println()
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$beans of coffee beans")
        println("$cups of disposable cups")
        println("\$$money of money")
        println()
        currentState = State.CHOOSE_ACTION
    }

    private fun take() {
        println()
        println("I gave you \$$money")
        money = 0
    }

    private fun fill(state: State,
                     value: Int) {
        when (state) {
            State.FILLING_WATER -> water += value
            State.FILLING_MILK -> milk += value
            State.FILLING_BEANS -> beans += value
            State.FILLING_CUPS -> cups += value
            else -> return
        }
    }


    fun setInput(input: String) {
        when (currentState) {
            State.CHOOSE_ACTION -> {
                when (input) {
                    "buy" -> currentState = State.CHOOSING_COFFEE
                    "fill" -> currentState = State.FILLING_WATER
                    "take" -> take()
                    "remaining" -> remaining()
                    "exit" -> currentState = State.EXIT
                    else -> return
                }
            }

            State.CHOOSING_COFFEE -> {
                currentState = when (input) {
                    "back" -> State.CHOOSE_ACTION
                    else -> {
                        makeCoffee(input)
                        State.CHOOSE_ACTION
                    }
                }
            }

            State.FILLING_WATER -> {
                fill(State.FILLING_WATER,
                     input.toInt())
                currentState = State.FILLING_MILK
            }

            State.FILLING_MILK -> {
                fill(State.FILLING_MILK,
                     input.toInt())
                currentState = State.FILLING_BEANS
            }

            State.FILLING_BEANS -> {
                fill(State.FILLING_BEANS,
                     input.toInt())
                currentState = State.FILLING_CUPS
            }

            State.FILLING_CUPS -> {
                fill(State.FILLING_CUPS,
                     input.toInt())
                currentState = State.CHOOSE_ACTION
            }

            else -> return
        }
    }

    private fun checkResources(coffeeType: CoffeeType): Boolean {
        return when {
            water < coffeeType.water -> {
                println("Sorry, not enough water!")
                false
            }

            milk < coffeeType.milk -> {
                println("Sorry, not enough milk!")
                false
            }

            beans < coffeeType.beans -> {
                println("Sorry, not enough beans!")
                false
            }

            cups < 1 -> {
                println("Sorry, not enough cups!")
                false
            }

            else -> true
        }
    }

    private fun makeCoffee(input: String) {
        val coffeeType = CoffeeType.fromId(input)

        if (checkResources(coffeeType)) {
            water -= coffeeType.water
            milk -= coffeeType.milk
            beans -= coffeeType.beans
            money += coffeeType.price
            cups -= 1
            println("I have enough resources, making you a coffee!")
        }
    }
}
