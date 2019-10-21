package com.github.snake_scalajs

import com.github.snake_scalajs.controller.{ActionListener, Drawer}

import scala.scalajs.js
import scala.scalajs.js.timers.SetIntervalHandle

object Global {
  var refreshId: SetIntervalHandle = _
}

object App {
  def main(args: Array[String]): Unit = {
    ActionListener.setKeyHandler()
    Global.refreshId = js.timers.setInterval(100)(Drawer.draw())
  }

}
