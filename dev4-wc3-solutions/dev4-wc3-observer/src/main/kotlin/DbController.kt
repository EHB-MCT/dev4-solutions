import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.util.*

object DbController {
    var connection = getConnection("u14405dev4be", "WH2t2L22cLs232Qr", "14405dev4be")

    fun getCoins(): MutableMap<String, Double> {
        val result = executeQuery(connection, "SELECT * FROM coins");
        val coins = mutableMapOf<String, Double>()

        while (result!!.next()) {
            val name = result.getString("name")
            val rate = result.getDouble("rate")
            /*
            constructing a User object and
            putting data into the list
             */
            coins.put(name, rate)
        }

        return coins
    }

    private fun getConnection(username: String, password: String, databaseName: String): Connection {
        val connectionProps = Properties()
        connectionProps["user"] = username
        connectionProps["password"] = password
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()
        return DriverManager.getConnection(
            "jdbc:" + "mysql" + "://" +
                    "mysql07.websrv.be " +
                    ":" + "3306" + "/" +
                    databaseName,
            connectionProps)
    }

    private fun executeQuery(connection: Connection, query: String): ResultSet? {
        val statement = connection.prepareStatement(query)
        return statement.executeQuery()
    }

}
