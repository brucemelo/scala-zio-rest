package student

import student.{Student, StudentRepo}
import zhttp.http.*
import zhttp.http._
import zio._
import zio.json._

object StudentHttp {
  def apply(): Http[StudentRepo, Throwable, Request, Response] =
    Http.collectZIO[Request] {
      case req@(Method.POST -> _ / "students") =>
        for {
          u <- req.bodyAsString.map(_.fromJson[Student])
          r <- u match {
            case Left(e) =>
              ZIO.debug(s"Failed to parse the input: $e").as(
                Response.text(e).setStatus(Status.BadRequest)
              )
            case Right(u) =>
              StudentRepo.register(u)
                .map(id => Response.text(id))
          }
        } yield r
      case Method.GET -> _ / "students" =>
        for {
          _ <- StudentRepo.register(Student("Bruce"))
          get <- StudentRepo.students.map(response => Response.json(response.toJson))
        } yield get
    }

}
