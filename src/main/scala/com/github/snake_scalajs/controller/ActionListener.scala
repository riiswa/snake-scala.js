package com.github.snake_scalajs.controller

import com.github.snake_scalajs.item.Snake
import org.scalajs.dom
import org.scalajs.dom.document

object ActionListener {
  def setKeyHandler(): Unit = {
    document.addEventListener(
      "keydown",
      scala.scalajs.js.Any.fromFunction1({ event: dom.Event =>
        val e = event.asInstanceOf[dom.KeyboardEvent]
        e.keyCode match {
          case 37 if Snake.dx != 10 =>
            Snake.dx = -10
            Snake.dy = 0 // LEFT
          case 39 if Snake.dx != -10 =>
            Snake.dx = 10
            Snake.dy = 0 // RIGHT
          case 38 if Snake.dy != 10 =>
            Snake.dx = 0
            Snake.dy = -10 // UP
          case 40 if Snake.dy != -10 =>
            Snake.dx = 0
            Snake.dy = 10 //DOWN
        }
      }),
      false
    )
  }
}
