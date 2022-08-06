import student.{Student, StudentRepo}
import zhttp.http.*
import zhttp.http.*
import zio.*
import zio.json.*

import scala.collection.mutable

case class InmemoryStudentRepo(map: Ref[mutable.Map[String, Student]]) extends StudentRepo {
  def register(user: Student): UIO[String] =
    for {
      id <- Random.nextUUID.map(_.toString)
      _ <- map.updateAndGet(_ addOne(id, user))
    } yield id

  def students: UIO[List[Student]] =
    map.get.map(_.values.toList)
}

object InmemoryStudentRepo {
  def layer: ZLayer[Any, Nothing, InmemoryStudentRepo] =
    ZLayer.fromZIO(
      Ref.make(mutable.Map.empty[String, Student]).map(new InmemoryStudentRepo(_))
    )
}
