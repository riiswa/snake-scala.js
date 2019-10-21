package com.github.snake_scalajs.item

import com.github.snake_scalajs.controller.Drawer

object Score {
  var score = 0

  def draw(): Unit = {
    Drawer.ctx.font = "16px Arial"
    Drawer.ctx.fillStyle = "#0095DD"
    Drawer.ctx.fillText("Score: " + score, 8, 20)
  }
}
