package controllers

import org.apache.pekko.protobufv3.internal.Internal.toByteArray
import org.apache.pekko.util.UUIDComparator

import javax.inject._
import play.api._
import play.api.mvc._

import java.io.{FileInputStream, IOException}
import java.nio.{ByteBuffer, ByteOrder}
import java.security.{MessageDigest, NoSuchAlgorithmException}
import java.util.{Random, UUID}
import java.nio.charset.StandardCharsets
import java.time.Instant
import scala.annotation.tailrec

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index(v: Int) = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(version(v), version = v))
  }
  def home() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(version(4), version = 4))
  }
  def catchAll(path: String) = Action { implicit request: Request[AnyContent] =>
    Redirect(routes.HomeController.index(4))
  }
  def bulkUUID(v: Int, maxNo: Int) = Action {
    implicit request: Request[AnyContent] =>
      val max = if (maxNo > 1000) 1000 else if (maxNo < 0) 0 else maxNo

      @tailrec
      def bulk(no: Int, acc: List[UUID] = List()): List[UUID] = {
        no match {
          case 0 => acc
          case _ => bulk(no - 1, acc.appended(version(v)))
        }
      }
      Ok(views.html.index(version(v), version = v, bulk(max)))
  }

  def version(v: Int): UUID = {
    def UUIDV1(): UUID = {
      def get64LeastSignificantBitsForVersion1(): Long = {
        val random = new Random()
        val random63BitLong = random.nextLong() & 0x3fffffffffffffffL
        val variant3BitFlag: Long = 0x8000000000000000L
        random63BitLong | variant3BitFlag
      }

      def get64MostSignificantBitsForVersion1(): Long = {
        val currentTimeMillis = System.currentTimeMillis()
        val time_low = (currentTimeMillis & 0x00000000ffffffffL) << 32
        val time_mid = ((currentTimeMillis >> 32) & 0xffff) << 16
        val version = 1L << 12
        val time_hi = ((currentTimeMillis >> 48) & 0x0fff)
        time_low | time_mid | version | time_hi
      }

      new UUID(
        get64MostSignificantBitsForVersion1(),
        get64LeastSignificantBitsForVersion1()
      )
    }

    def UUIDV5(name: String): UUID = {

      def fromBytes(name: Array[Byte]): UUID = {
        if (name == null) {
          throw new NullPointerException("name == null")
        }
        try {
          val md = MessageDigest.getInstance("SHA-1")
          makeUUID(md.digest(name), 5)
        } catch {
          case e: NoSuchAlgorithmException => throw new AssertionError(e)
        }
      }

      def makeUUID(hash: Array[Byte], version: Int): UUID = {
        val msb = peekLong(hash, 0, ByteOrder.BIG_ENDIAN)
        val lsb = peekLong(hash, 8, ByteOrder.BIG_ENDIAN)
        // Set the version field
        var msbModified = msb & ~(0xfL << 12)
        msbModified |= version.toLong << 12
        // Set the variant field to 2
        var lsbModified = lsb & ~(0x3L << 62)
        lsbModified |= 2L << 62
        new UUID(msbModified, lsbModified)
      }

      def peekLong(
          src: Array[Byte],
          offset: Int,
          order: ByteOrder
      ): Long = {
        var ans: Long = 0
        if (order == ByteOrder.BIG_ENDIAN) {
          for (i <- offset until offset + 8) {
            ans <<= 8
            ans |= src(i) & 0xffL
          }
        } else {
          for (i <- (offset + 7) to offset by -1) {
            ans <<= 8
            ans |= src(i) & 0xffL
          }
        }
        ans
      }

      fromBytes(name.getBytes(StandardCharsets.UTF_8))
    }

    v match {
      case 0 => UUID.fromString("00000000-0000-0000-0000-000000000000")
      case 1 => UUIDV1()
      case 3 => UUID.nameUUIDFromBytes(UUID.randomUUID().toString.getBytes())
      case 5 => UUIDV5(UUID.randomUUID().toString)
      case _ => UUID.randomUUID()

    }
  }

}
