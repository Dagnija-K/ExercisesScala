import scala.collection.mutable.ListBuffer

object DBTestArtists extends App {

     println("Testing DB Connection!")
       val url = "jdbc:sqlite:C:/Users/Dagnija/Documents/Scala/SQL/chinook.db"  //notice the . in ./src
    import java.sql.DriverManager

    val conn = DriverManager.getConnection(url)
    println(conn.getClientInfo())
    val statement = conn.createStatement()

    val tableName = "artists"
    val sql12 =
      s"""
         |SELECT * FROM ${tableName}
         |""".stripMargin

    val resultSet2 = statement.executeQuery(sql12)

  val artistsBuffer = scala.collection.mutable.ListBuffer.empty[Artists]
  while ( resultSet2.next() ) {
    val artist = Artists(resultSet2.getString("ArtistId").toInt, resultSet2.getString("Name"))
    artistsBuffer.append(artist)
  }
  val artistsResults = artistsBuffer.toSeq
  artistsResults.foreach(println)

}
