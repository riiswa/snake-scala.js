package com.github.snake_scalajs.item

import com.github.snake_scalajs.controller.Drawer

case class SnakePart(x: Int, y: Int) {
  def draw(): Unit = {
    Drawer.drawOnCtx({
      Drawer.ctx.fillStyle = scala.scalajs.js.Any.fromString("lightgreen")
      Drawer.ctx.fillRect(x, y, 10, 10)
    })
  }

  def drawEyes(): Unit = {
    Drawer.drawOnCtx({
      Drawer.ctx.fillStyle = scala.scalajs.js.Any.fromString("red")
      if (Snake.dx == 0) {
        Drawer.ctx.fillRect(x + 2, y + 4, 2, 2)
        Drawer.ctx.fillRect(x + 5, y + 4, 2, 2)
      } else {
        Drawer.ctx.fillRect(x + 4, y + 2, 2, 2)
        Drawer.ctx.fillRect(x + 4, y + 5, 2, 2)
      }
    })
  }
}
