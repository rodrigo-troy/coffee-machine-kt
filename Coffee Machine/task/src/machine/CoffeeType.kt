package machine

/**
 * Created with IntelliJ IDEA.
$ Project: coffee-machine
 * User: rodrigotroy
 * Date: 02-02-23
 * Time: 14:38
 */
enum class CoffeeType(val id: String,
                      val water: Int,
                      val milk: Int,
                      val beans: Int,
                      val price: Int) {
    ESPRESSO("1",
             250,
             0,
             16,
             4),
    LATTE("2",
          350,
          75,
          20,
          7),
    CAPPUCCINO("3",
               200,
               100,
               12,
               6)

}
