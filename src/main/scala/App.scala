
import home.HomeApp
import student._
import zhttp.service.Server
import zio.*

object App extends ZIOAppDefault {

  def run =
    Server.start(
      port = 8080,
//      http = HomeApp() ++ DownloadApp() ++ CounterApp() ++ UserApp()
      http = HomeApp() ++ StudentApp()
    ).provide(
      // An layer responsible for storing the state of the `counterApp`
      ZLayer.fromZIO(Ref.make(0)),

      // To use the persistence layer, provide the `PersistentUserRepo.layer` layer instead
      InmemoryStudentRepo.layer
    )

}
