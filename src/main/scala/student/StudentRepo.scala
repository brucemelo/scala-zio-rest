package student

import zio.*

trait StudentRepo {
  def register(user: Student): Task[String]
  
  def students: Task[List[Student]]
}

object StudentRepo {
  def register(student: Student): ZIO[StudentRepo, Throwable, String] =
    ZIO.serviceWithZIO[StudentRepo](_.register(student))

  def students: ZIO[StudentRepo, Throwable, List[Student]] =
    ZIO.serviceWithZIO[StudentRepo](_.students)
}
