package com.github.snake_scalajs.item

import com.github.snake_scalajs.controller.Drawer

import scala.util.Random

object Food {
  var x: Int = -1
  var y: Int = -1

  def create(): Unit = {
    val xs = 0 to (Drawer.canvas.width - 10) by 10
    val ys = 0 to (Drawer.canvas.height - 10) by 10
    val coords = (for (x <- xs)
      yield for (y <- ys) yield (x, y)).flatten.filterNot(coords =>
      Snake.parts.map { case SnakePart(x, y) => (x, y) }.contains(coords))
    val selectedCoord = coords(Random.nextInt(coords.indices.last))
    x = selectedCoord._1
    y = selectedCoord._2
  }

  def draw(): Unit = {
    Drawer.drawOnCtx({
      Drawer.ctx.fillStyle = scala.scalajs.js.Any.fromString("red")
      Drawer.ctx.fillRect(x, y, 10, 10)
    })
  }
}
