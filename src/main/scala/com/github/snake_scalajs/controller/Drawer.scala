package com.github.snake_scalajs.controller

import com.github.snake_scalajs.item.{Food, Score, Snake}
import org.scalajs.dom
import org.scalajs.dom.{document, html}

object Drawer {
  Food.create()
  def canvas: html.Canvas =
    document.getElementById("myCanvas").asInstanceOf[html.Canvas]

  def ctx: dom.CanvasRenderingContext2D =
    canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

  def drawOnCtx[R](block: => R): Unit = {
    ctx.beginPath
    block
    ctx.closePath
  }

  def clear(): Unit = ctx.clearRect(0, 0, canvas.width, canvas.height)

  def draw(): Unit = {
    clear()
    Snake.draw()
    Snake.advance()
    Food.draw()
    Score.draw()
  }
}
