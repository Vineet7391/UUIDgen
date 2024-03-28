
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
/*1.2*/import java.util.UUID

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[UUID,Int,List[UUID],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(uuid:UUID, version:Int, bulkUUIDs: List[UUID] = List()):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main(version)/*4.15*/ {_display_(Seq[Any](format.raw/*4.17*/("""
  """),format.raw/*5.3*/("""<div id="container">
    <h1>Online UUID Generator</h1>
    <div id="content">
      <p>Your Version """),_display_(if(version == 0)/*8.40*/{_display_(Seq[Any](format.raw/*8.41*/("""Nil/Empty UUID""")))}else if(version ==9)/*8.76*/{_display_(Seq[Any](format.raw/*8.77*/("""GUID""")))}else if(version != 1 && version != 3 && version != 5)/*8.135*/{_display_(Seq[Any](format.raw/*8.136*/("""4 UUID""")))}else/*8.147*/{_display_(Seq[Any](_display_(/*8.149*/version),format.raw/*8.156*/(""" """),format.raw/*8.157*/("""UUID""")))}),format.raw/*8.162*/(""":</p>
      <span id="textToCopy">"""),_display_(/*9.30*/uuid),format.raw/*9.34*/("""</span>
      <button class="button" id="copyUUID">Copy</button>
      <a class="button a_button" href=""""),_display_(/*11.41*/controllers/*11.52*/.routes.HomeController.index(version)),format.raw/*11.89*/("""">Refresh</a>
    </div>
    <br>
    <br>
    <form action=""""),_display_(/*15.20*/controllers/*15.31*/.routes.HomeController.bulkUUID(version,0)),format.raw/*15.73*/("""">
      <label for="max_value">Bulk Version """),_display_(if(version == 0)/*16.60*/{_display_(Seq[Any](format.raw/*16.61*/("""Nil/Empty UUID""")))}else if(version ==9)/*16.96*/{_display_(Seq[Any](format.raw/*16.97*/("""GUID""")))}else if(version != 1 && version != 3 && version != 5)/*16.155*/{_display_(Seq[Any](format.raw/*16.156*/("""4 UUID""")))}else/*16.167*/{_display_(Seq[Any](_display_(/*16.169*/version),format.raw/*16.176*/(""" """),format.raw/*16.177*/("""UUID""")))}),format.raw/*16.182*/(""" """),format.raw/*16.183*/("""Generation</label>
      <input type="number" class="br" id="max_value" name="maxNo" value=""""),_display_(if(bulkUUIDs.nonEmpty)/*17.97*/{_display_(_display_(/*17.99*/bulkUUIDs/*17.108*/.length))}else/*17.120*/{_display_(Seq[Any](format.raw/*17.121*/("""maxNo""")))}),format.raw/*17.127*/("""" required placeholder="Max 1000">
      <button class="button" type="submit">Submit</button>
      """),_display_(if(bulkUUIDs.nonEmpty)/*19.30*/{_display_(Seq[Any](format.raw/*19.31*/("""
      """),format.raw/*20.7*/("""<button class="button" type="button" id="copyTable" onclick="copyTableData()">Copy</button>
      <button class="button" type="button" id="downloadButton">Download</button>
      """)))} else {null} ),format.raw/*22.8*/("""
    """),format.raw/*23.5*/("""</form>
    <br>
    <br>
    """),_display_(if(bulkUUIDs.nonEmpty)/*26.28*/{_display_(Seq[Any](format.raw/*26.29*/("""
    """),format.raw/*27.5*/("""<table  id="dataTable">
      <thead>
      <tr>
        <th>Serial No</th>
        <th>UUID</th>
      </tr>
      </thead>
      <tbody>
      """),_display_(/*35.8*/for((uuid, index) <- bulkUUIDs.zipWithIndex) yield /*35.52*/{_display_(Seq[Any](format.raw/*35.53*/("""
      """),format.raw/*36.7*/("""<tr>
        <td>"""),_display_(/*37.14*/{index+1}),format.raw/*37.23*/("""</td>
        <td>"""),_display_(/*38.14*/uuid),format.raw/*38.18*/("""</td>
      </tr>
      """)))}),format.raw/*40.8*/("""
      """),format.raw/*41.7*/("""<!-- Add more rows as needed -->
      </tbody>
    </table>
    """)))} else {null} ),format.raw/*44.6*/("""
  """),format.raw/*45.3*/("""</div>

<div class="question">
  """),_display_(if(version == 9)/*48.20*/{_display_(Seq[Any](format.raw/*48.21*/("""
    """),format.raw/*49.5*/("""<p>A GUID (Globally Unique Identifier) is a unique identifier used in software development to uniquely identify resources such as documents, databases, and objects. It is a 128-bit integer typically displayed as a string of 32 hexadecimal digits separated by hyphens.</p>
  """)))}else/*50.9*/{_display_(Seq[Any](format.raw/*50.10*/("""
    """),format.raw/*51.5*/("""<p>A UUID (Universally Unique Identifier) is a 128-bit identifier used in software to uniquely identify information, ensuring that no two items have the same identifier. It's commonly used in databases, distributed systems, and web applications for various purposes like generating unique keys or session IDs.</p>
  """)))}),format.raw/*52.4*/("""
"""),format.raw/*53.1*/("""</div>
""")))}),format.raw/*54.2*/("""
"""))
      }
    }
  }

  def render(uuid:UUID,version:Int,bulkUUIDs:List[UUID]): play.twirl.api.HtmlFormat.Appendable = apply(uuid,version,bulkUUIDs)

  def f:((UUID,Int,List[UUID]) => play.twirl.api.HtmlFormat.Appendable) = (uuid,version,bulkUUIDs) => apply(uuid,version,bulkUUIDs)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: fd9fec152e56503172ce32c265e5a59666afb029
                  MATRIX: 432->1|771->24|921->81|948->83|969->96|1008->98|1037->101|1181->219|1219->220|1272->255|1310->256|1387->314|1426->315|1456->326|1495->328|1523->335|1552->336|1588->341|1649->376|1673->380|1805->485|1825->496|1883->533|1972->595|1992->606|2055->648|2144->710|2183->711|2237->746|2276->747|2354->805|2394->806|2425->817|2465->819|2494->826|2524->827|2561->832|2591->833|2733->948|2763->950|2782->959|2806->971|2846->972|2884->978|3034->1101|3073->1102|3107->1109|3330->1289|3362->1294|3442->1347|3481->1348|3513->1353|3685->1499|3745->1543|3784->1544|3818->1551|3863->1569|3893->1578|3939->1597|3964->1601|4019->1626|4053->1633|4162->1699|4192->1702|4269->1752|4308->1753|4340->1758|4637->2038|4676->2039|4708->2044|5055->2361|5083->2362|5121->2370
                  LINES: 17->1|22->2|27->3|28->4|28->4|28->4|29->5|32->8|32->8|32->8|32->8|32->8|32->8|32->8|32->8|32->8|32->8|32->8|33->9|33->9|35->11|35->11|35->11|39->15|39->15|39->15|40->16|40->16|40->16|40->16|40->16|40->16|40->16|40->16|40->16|40->16|40->16|40->16|41->17|41->17|41->17|41->17|41->17|41->17|43->19|43->19|44->20|46->22|47->23|50->26|50->26|51->27|59->35|59->35|59->35|60->36|61->37|61->37|62->38|62->38|64->40|65->41|68->44|69->45|72->48|72->48|73->49|74->50|74->50|75->51|76->52|77->53|78->54
                  -- GENERATED --
              */
          