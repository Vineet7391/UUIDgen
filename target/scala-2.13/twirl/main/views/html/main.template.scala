
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Int,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(version: Int)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>UUID</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.versioned("images/logo.jpg")),format.raw/*15.101*/("""">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body class="body-clr">

        """),_display_(/*21.10*/header(version)),format.raw/*21.25*/("""
        """),_display_(/*22.10*/content),format.raw/*22.17*/("""
        """),_display_(/*23.10*/footer()),format.raw/*23.18*/("""

        """),format.raw/*25.9*/("""<script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/main.js")),format.raw/*25.69*/("""" type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(version:Int,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(version)(content)

  def f:((Int) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (version) => (content) => apply(version)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: 0cd76b6b01b098f991034c3ec3e864fda7fee82e
                  MATRIX: 984->260|1107->290|1134->291|1214->396|1250->405|1350->478|1365->484|1428->525|1516->586|1531->592|1589->628|1889->902|1925->917|1962->927|1990->934|2027->944|2056->952|2093->962|2134->976|2149->982|2210->1022
                  LINES: 26->7|31->8|32->9|35->12|36->13|37->14|37->14|37->14|38->15|38->15|38->15|44->21|44->21|45->22|45->22|46->23|46->23|48->25|48->25|48->25|48->25
                  -- GENERATED --
              */
          