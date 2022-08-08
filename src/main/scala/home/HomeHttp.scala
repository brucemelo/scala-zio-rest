package home

import zhttp.http.*
import zhttp.http._
import zio._
import zio.json._

object HomeHttp {

  def apply(): Http[Any, Nothing, Request, Response] =
    Http.collectHttp[Request] {
      case Method.GET -> _ / "home" => Http.text("Home")
    }

}
