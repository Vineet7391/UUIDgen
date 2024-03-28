
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

object header extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(version:Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<header>
    <nav>
        <ul>
            <li>
                <a href=""""),_display_(/*7.27*/controllers/*7.38*/.routes.HomeController.index(4)),format.raw/*7.69*/("""">
                    """),_display_(if(version != 0 && version != 1 && version != 3 && version != 5 && version != 9)/*8.102*/{_display_(Seq[Any](format.raw/*8.103*/("""
                        """),format.raw/*9.25*/("""<strong>UUID Generator</strong>
                    """)))}else/*10.28*/{_display_(Seq[Any](format.raw/*10.29*/("""
                        """),format.raw/*11.25*/("""UUID Generator
                    """)))}),format.raw/*12.22*/("""
                """),format.raw/*13.17*/("""</a>
            </li>
            <li>
                <a href=""""),_display_(/*16.27*/controllers/*16.38*/.routes.HomeController.index(9)),format.raw/*16.69*/("""">
                    """),_display_(if(version == 9)/*17.38*/{_display_(Seq[Any](format.raw/*17.39*/("""
                        """),format.raw/*18.25*/("""<strong>GUID Generator</strong>
                    """)))}else/*19.28*/{_display_(Seq[Any](format.raw/*19.29*/("""
                        """),format.raw/*20.25*/("""GUID Generator
                    """)))}),format.raw/*21.22*/("""
                """),format.raw/*22.17*/("""</a>
            </li>
            <li>
                <a href=""""),_display_(/*25.27*/controllers/*25.38*/.routes.HomeController.index(0)),format.raw/*25.69*/("""">
                    """),_display_(if(version == 0)/*26.38*/{_display_(Seq[Any](format.raw/*26.39*/("""
                    """),format.raw/*27.21*/("""<strong>Nil/Empty UUID</strong>
                    """)))}else/*28.28*/{_display_(Seq[Any](format.raw/*28.29*/("""
                    """),format.raw/*29.21*/("""Nil/Empty UUID
                    """)))}),format.raw/*30.22*/("""
                """),format.raw/*31.17*/("""</a>
            </li>
            <li>
                <div class="dropdown">
                    <a href="#" class="dropbtn">UUID versions<span class="dropdown-icon">&#9660;</span></a>
                    <div class="dropdown-content">
                        <a href=""""),_display_(/*37.35*/controllers/*37.46*/.routes.HomeController.index(1)),format.raw/*37.77*/("""">Version 1</a>
                        <a href=""""),_display_(/*38.35*/controllers/*38.46*/.routes.HomeController.index(3)),format.raw/*38.77*/("""">Version 3</a>
                        <a href=""""),_display_(/*39.35*/controllers/*39.46*/.routes.HomeController.index(4)),format.raw/*39.77*/("""">Version 4</a>
                        <a href=""""),_display_(/*40.35*/controllers/*40.46*/.routes.HomeController.index(5)),format.raw/*40.77*/("""">Version 5</a>
                    </div>
                </div>
            </li>
        </ul>
    </nav>
</header>

"""))
      }
    }
  }

  def render(version:Int): play.twirl.api.HtmlFormat.Appendable = apply(version)

  def f:((Int) => play.twirl.api.HtmlFormat.Appendable) = (version) => apply(version)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/header.scala.html
                  HASH: dbebf540ffd6bfa84a4fc2261af55b7cfea8b5a0
                  MATRIX: 727->1|834->15|861->16|962->91|981->102|1032->133|1163->237|1202->238|1254->263|1330->322|1369->323|1422->348|1489->384|1534->401|1627->467|1647->478|1699->509|1766->549|1805->550|1858->575|1934->634|1973->635|2026->660|2093->696|2138->713|2231->779|2251->790|2303->821|2370->861|2409->862|2458->883|2534->942|2573->943|2622->964|2689->1000|2734->1017|3033->1289|3053->1300|3105->1331|3182->1381|3202->1392|3254->1423|3331->1473|3351->1484|3403->1515|3480->1565|3500->1576|3552->1607
                  LINES: 21->1|26->2|27->3|31->7|31->7|31->7|32->8|32->8|33->9|34->10|34->10|35->11|36->12|37->13|40->16|40->16|40->16|41->17|41->17|42->18|43->19|43->19|44->20|45->21|46->22|49->25|49->25|49->25|50->26|50->26|51->27|52->28|52->28|53->29|54->30|55->31|61->37|61->37|61->37|62->38|62->38|62->38|63->39|63->39|63->39|64->40|64->40|64->40
                  -- GENERATED --
              */
          