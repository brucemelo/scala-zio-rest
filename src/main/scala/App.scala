
import home.HomeHttp
import student._
import zhttp.service.Server
import zio.*

object App extends ZIOAppDefault {

  def run =
    Server.start(
      port = 8080,
      http = HomeHttp() ++ StudentHttp()
    ).provide(
      InmemoryStudentRepo.layer
    )

}
