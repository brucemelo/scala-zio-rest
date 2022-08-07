
import home.HomeApp
import student._
import zhttp.service.Server
import zio.*

object App extends ZIOAppDefault {

  def run =
    Server.start(
      port = 8080,
      http = HomeApp() ++ StudentApp()
    ).provide(
      InmemoryStudentRepo.layer
    )

}
