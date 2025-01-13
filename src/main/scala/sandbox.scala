
import doodle.core.*
import doodle.image.*
import doodle.image.syntax.all.*
import doodle.image.syntax.core.*
import doodle.java2d.*
import doodle.reactor.*
import scala.concurrent.duration.*
import cats.effect.unsafe.implicits.global

object Pizza {
    val dough = 
        Image
            .circle(500)
            .fillColor(Color.rgb(234,182,118))


    val frame = Frame.default.withSize(600, 600).withCenterAtOrigin.withTitle("Pizza Portrait")

    // @main def go(): Unit = {
    //     dough.draw()
    // }
}