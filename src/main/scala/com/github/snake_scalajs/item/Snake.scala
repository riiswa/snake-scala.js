package com.github.snake_scalajs.item

import com.github.snake_scalajs._
import com.github.snake_scalajs.controller.Drawer

import scala.collection.mutable.ArrayBuffer

object Snake {
  var dx = 10
  var dy = 0

  val parts: ArrayBuffer[SnakePart] = ArrayBuffer(SnakePart(150, 150),
    SnakePart(140, 150),
    SnakePart(130, 150),
    SnakePart(120, 150),
    SnakePart(110, 150))

  def didEatFood(): Boolean = parts.head.x == Food.x && parts.head.y == Food.y

  def collide(): Unit = {
    val x: Int = parts.head.x
    val y: Int = parts.head.y
    val onWalls = x < 0 || x > Drawer.canvas.width || y < 0 || y > Drawer.canvas.height
    if (!parts.distinct.sameElements(parts) || onWalls) GameUtil.gameOver()
  }

  def advance(): Unit = {
    val head = SnakePart(parts.head.x + dx, parts.head.y + dy)
    parts.insert(0, head)
    if (didEatFood()) {
      Food.create()
      Score.score += 1
    } else parts.remove(parts.indices.last)
    collide()
  }

  def draw(): Unit = {
    parts.foreach((_: SnakePart).draw())
    parts.head.drawEyes()
  }

}
