// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_0: controllers.HomeController,
  // @LINE:11
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:11
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """version<[^/]+>""", """controllers.HomeController.index(version:Int)"""),
    ("""GET""", this.prefix, """controllers.HomeController.home()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """bulk/""" + "$" + """version<[^/]+>""", """controllers.HomeController.bulkUUID(version:Int, maxNo:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:7
  private lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("version", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """""" + "$" + """version<[^/]+>""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private lazy val controllers_HomeController_home1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_HomeController_home1_invoker = createInvoker(
    HomeController_0.home(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "home",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private lazy val controllers_HomeController_bulkUUID2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("bulk/"), DynamicPart("version", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_HomeController_bulkUUID2_invoker = createInvoker(
    HomeController_0.bulkUUID(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "bulkUUID",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """bulk/""" + "$" + """version<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call(params.fromPath[Int]("version", None)) { (version) =>
        controllers_HomeController_index0_invoker.call(HomeController_0.index(version))
      }
  
    // @LINE:8
    case controllers_HomeController_home1_route(params@_) =>
      call { 
        controllers_HomeController_home1_invoker.call(HomeController_0.home())
      }
  
    // @LINE:9
    case controllers_HomeController_bulkUUID2_route(params@_) =>
      call(params.fromPath[Int]("version", None), params.fromQuery[Int]("maxNo", None)) { (version, maxNo) =>
        controllers_HomeController_bulkUUID2_invoker.call(HomeController_0.bulkUUID(version, maxNo))
      }
  
    // @LINE:11
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
