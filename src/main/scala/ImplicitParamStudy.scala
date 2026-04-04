object ImplicitParamStudy:

  class Connection:
    def executeQuery(query: String): Unit =
      println(s"Execute: $query")

  def createTitle(title: String)(using conn: Connection): Unit =
    conn.executeQuery(s"create title='${title}'")

  def selectTitle(using conn: Connection): Unit =
    conn.executeQuery("select")

  def updateTitle(title: String)(using conn: Connection): Unit =
    conn.executeQuery(s"update title='${title}'")

  def deleteTitle(title: String)(using conn: Connection): Unit =
    conn.executeQuery(s"delete title='${title}'")