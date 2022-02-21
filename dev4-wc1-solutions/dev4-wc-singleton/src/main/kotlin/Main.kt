import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.util.*

/*
username: "u14405dev4be"
password: "WH2t2L22cLs232Qr"
databaseName: "14405dev4be"
 */

data class Student(val id: Int, val firstName: String, val lastName: String, val email: String)

fun main(args: Array<String>) {
    println("Let's start our first exercise!")

    // Test statements:
    /*
    var email = DatabaseController.getStudentEmailById(2)
    println(email)
    */

    /*
    var student = DatabaseController.getStudentById(1);
    println(student)
    */

    /*
    var students = DatabaseController.getAllStudents();
    for(student in students){
        println(student.toString())
    }
    */

}

object DatabaseController {
    var connection = getConnection("u14405dev4be", "WH2t2L22cLs232Qr", "14405dev4be")

    fun getAllStudents(): MutableList<Student> {
        val result = executeQuery(connection, "SELECT * FROM STUDENTS");
        val students = mutableListOf<Student>()

        while (result!!.next()) {
            val id = result.getInt("id")
            val firstName = result.getString("firstName")
            val lastName = result.getString("lastName")
            val email = result.getString("email")
            /*
            constructing a User object and
            putting data into the list
             */
            students.add(Student(id, firstName, lastName, email))
        }

        return students
    }

    fun getStudentById(id: Int): Student {
        val result = executeQuery(connection, "SELECT * FROM STUDENTS WHERE id=$id");
        lateinit var student : Student

        while (result!!.next()) {
            val id = result.getInt("id")
            val firstName = result.getString("firstName")
            val lastName = result.getString("lastName")
            val email = result.getString("email")
            /*
            constructing a User object and
            putting data into the list
             */
            student = Student(id, firstName, lastName, email)
        }

        return student
    }

    fun getStudentEmailById(id: Int): String {
        val result = executeQuery(connection, "SELECT * FROM STUDENTS WHERE id=$id");
        var email = "Empty"

        while (result!!.next()) {
            email = result.getString("email")
        }

        return email
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


