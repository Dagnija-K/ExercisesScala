import java.sql.Connection

import scala.collection.mutable.ListBuffer

object DBTest extends App {
  println("Testing DB Connection!")
  //  val url = "jdbc:sqlite:C:/sqlite/db/chinook.db" //you need to adjust your absolute url here
  //  val url = "jdbc:sqlite:C:/sqlite/db/NOTchinook.db" //so this created blank NOTchinnok.db if we did not have it
  //better would be to use a relative path (relative here to our main project folder)
  val url = "jdbc:sqlite:C:/Users/Dagnija/Documents/Scala/SQL/chinook.db"  //notice the . in ./src


  import java.sql.DriverManager

  val conn = DriverManager.getConnection(url)
  println(conn.getClientInfo()) //not too useful on SQLite but useful for something like SQL Server
  //for SQL dbs with users and permission and ports and external servers you will also need to add some extra parameters
  val statement = conn.createStatement() //Creates a Statement object for sending SQL statements to the database. S

  val tableName = "genres"
  val sql =
    s"""
       |SELECT * FROM $tableName
       |""".stripMargin
  //FIXME very careful with adding strings directly to our sql queries
  //if you do not control tableName you run a risk of SQL injection

  val resultSet = statement.executeQuery(sql)
  val meta = resultSet.getMetaData
  println(s"We have ${meta.getColumnCount} columns")

  var colSeq = ListBuffer[String]() //buffer type collections are ideal when we are adding to some results
  for (i <- 1 to
    meta.getColumnCount) {
    println(meta.getColumnName(i)) //notice we are using 1 based well columns are 1 based index
    colSeq += meta.getColumnName(i)
  }
  println(colSeq)

  //alternative using yield
  val colNames = for (i <- 1 to
    meta.getColumnCount) yield {
    meta.getColumnName(i)
  }
  colNames.foreach(println)

//  val resultsBuffer = scala.collection.mutable.ListBuffer.empty[Seq[(String,String)]]
//  while ( resultSet.next() ) {
//
//    val row = colSeq.map(col => (col, resultSet.getString(col))) //TODO think of other structures to hold data
//    resultsBuffer.append(row.toSeq)
//       println(row.size)
//  }
//    val results = resultsBuffer.toSeq
//    println(results.size) //how many entries we have in our database

//  val resultsBuffer = scala.collection.mutable.ListBuffer.empty[Seq[(String,String)]]
//  while ( resultSet.next() ) {
//
//    println(resultSet.getString("Name")) }

//  Get collection of tuples
//  val resultsBuffer = scala.collection.mutable.ListBuffer.empty[Seq[(String,String)]]
//  while ( resultSet.next() ) {
//        colSeq.foreach(col => print(col, resultSet.getString(col)))
//        println()}

//  val resultsBuffer = scala.collection.mutable.ListBuffer.empty[Seq[(String,String)]]
//  while ( resultSet.next() ) {
//        val row = colSeq.map(col => (col, resultSet.getString(col))) //TODO think of other structures to hold data
//        resultsBuffer.append(row.toSeq)
//    }
//      val results = resultsBuffer.toSeq
//      println(results.size) //how many entries we have in our database

  val genreBuffer = scala.collection.mutable.ListBuffer.empty[Genres]
  while ( resultSet.next() ) {

    val genre = Genres(resultSet.getString("GenreId").toInt, resultSet.getString("Name"))
    genreBuffer.append(genre)
  }
  val genreResults = genreBuffer.toSeq
  val filteredGenres = genreResults.filter(row => row.Name.startsWith("R"))
  filteredGenres.foreach(println)


}
