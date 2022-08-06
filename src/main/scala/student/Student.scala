package student

import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder}

case class Student(name: String)

object Student {
  implicit val encoder: JsonEncoder[Student] =
    DeriveJsonEncoder.gen[Student]
  implicit val decoder: JsonDecoder[Student] =
    DeriveJsonDecoder.gen[Student]
}