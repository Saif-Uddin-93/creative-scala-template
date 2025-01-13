import doodle.core.*
import doodle.image.*
import doodle.image.syntax.all.*
import doodle.image.syntax.core.*
import doodle.java2d.*
import doodle.reactor.*
import scala.concurrent.duration.*
import cats.effect.unsafe.implicits.global

// To use this example:
//
// 1. run `sbt`
// 2. run the `run` command within `sbt`
object Example {
  val image =
    Image
      .circle(100)
      .fillColor(Color.red)
      .on(Image.circle(200).fillColor(Color.aquamarine))
      .on(Image.circle(300).fillColor(Color.steelBlue))

  val mars = 
    Image
      .circle(10)
      .fillColor(Color.red)

  val sun =
    Image
      .circle(100)
      .fillColor(Color.yellow)
      // .beside(Image.square(100).strokeColor(Color.darkBlue))
      // .above(Image.triangle(100, 100).strokeColor(Color.crimson))

  val animation =
    Reactor
      .init(0.degrees)
      .withOnTick(a => a + 1.degrees)
      // .withStop(a => a > 360.degrees)
      .withTickRate(20.millis)
      .withRender { a =>
        val location = Point(200, a)
        val planet = Image.circle(40.0).noStroke.fillColor(Color.seaGreen)
        val moon = Image
          .circle(10.0)
          .noStroke
          .fillColor(Color.slateGray)
          .at(Point(60, a * 5))

        mars.on(moon).at(location).on(sun)
      }

  // val basicLayout =
  //   (Image
  //     .circle(100)
  //     .strokeColor(Color.blue)
  //     .beside(Image.square(100).strokeColor(Color.darkBlue)))
  //     .above(Image.triangle(100, 100).strokeColor(Color.crimson))
  //     .strokeWidth(5.0)

  // A.beside(B).above(C)
  //   A B
  //    C
  // A.beside(B.above(C))
  //     B
  //    AC

  val box = Image.square(20).strokeColor(Color.cadetBlue).fillColor(Color.gold)

  // count must 0 or larger, which is the number of boxes to arrange in a line
  def boxes(count: Int): Image =
    count match {
      case 0 => Image.empty
      case n => box.beside(boxes(n - 1))
    }

    // count match {
    //   case 0 => ???
    //   case n => ??? boxes(n - 1)
    // }
    

  val frame = Frame.default.withSize(600, 600).withCenterAtOrigin.withTitle("Our Amazing Solar System")

  @main def go(): Unit = {
    // sun.draw()
    // boxes(7).draw()

    // Comment out the above and uncomment the below to display the animation
    // animation.run(frame)
    Pizza.dough.draw()
  }
}
