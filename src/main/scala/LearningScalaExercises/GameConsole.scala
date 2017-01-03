package LearningScalaExercises

import java.util.Date

import com.sun.media.jfxmedia.track.VideoResolution

/**
  * Created by edward.santos on 1/3/17.
  */

abstract class MediaFormat
class DvdMediaFormat extends MediaFormat
class BluRayMediaFormat extends MediaFormat
class USBMediaFormat extends MediaFormat
class CartridgeMediaFormat extends MediaFormat

abstract class VideoResolution(pixels: Int)
class SD extends VideoResolution(640 * 480)
class HD extends VideoResolution(1280 * 720)
class FHD extends VideoResolution(1920 * 1080)
class QHD extends VideoResolution(2560 * 1440)
class UHD4K extends VideoResolution(3840 * 2160)

class GameConsole (make: String, model: String, debut: Date, wifiType: Option[String],
                   mediaFormats: List[MediaFormat], maxVideoResolution: VideoResolution) {
  override def toString: String = s"GameConsole($make, $model), max video resolution = ${maxVideoResolution.getClass.getName}"
}

object hello {
  def main(args: Array[String]): Unit = {
    println("hello")
    val game: GameConsole = new GameConsole("Microsoft","Xbox One",strToDate("2/12/2013 0:00 AM"),Option("b/g"), List(new DvdMediaFormat,
                                            new BluRayMediaFormat), new UHD4K)
    println(game)
  }
}

class MyGameConsoles {
  def strToDate(s: String): Date = java.text.DateFormat.getInstance.parse(s)

  val xboxOne = new GameConsole("Microsoft", "Xbox One", strToDate("2/12/2013 0:00 AM"), Some("a/b"),
    List(new BluRayMediaFormat), new UHD4K)

  val superNintendo = new GameConsole("Nintendo", "Super Nintendo Entertainment System",
    strToDate("5/12/1992 09:00 AM"), None, List(new CartridgeMediaFormat), new SD)
}