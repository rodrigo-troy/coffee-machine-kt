package machine

/**
 * Created with IntelliJ IDEA.
$ Project: coffee-machine
 * User: rodrigotroy
 * Date: 02-02-23
 * Time: 14:46
 */
enum class State {
    CHOOSE_ACTION,
    CHOOSING_COFFEE,
    FILLING_WATER,
    FILLING_MILK,
    FILLING_BEANS,
    FILLING_CUPS,
    EXIT
}
