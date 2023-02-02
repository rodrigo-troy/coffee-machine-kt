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
    var currentState = State.CHOOSE_ACTION

    fun remaining() {
        println()
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$beans of coffee beans")
        println("$cups of disposable cups")
        println("\$$money of money")
    }

    fun take() {
        println()
        println("I gave you \$$money")
        money = 0
    }

    fun fill(state: State,
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
                }
            }

            State.CHOOSING_COFFEE -> {
                makeCoffee(input)
                currentState = State.CHOOSE_ACTION
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
        if (checkResources(CoffeeType.valueOf(input))) {
            water -= CoffeeType.valueOf(input).water
            milk -= CoffeeType.valueOf(input).milk
            beans -= CoffeeType.valueOf(input).beans
            money += CoffeeType.valueOf(input).price
            cups -= 1
            println("I have enough resources, making you a coffee!")
        }
    }

}
