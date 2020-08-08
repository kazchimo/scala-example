// https://stackoverflow.com/questions/47339575/low-priority-and-high-priority-implicits-in-scala
object Scanner {
  trait Console { def display(item: String) }
  trait AlarmHandler extends (() => Unit)
  trait Cause { val why: String }
  trait Fatal extends Cause

  def scanItem(item: String)(implicit c: Console) {
    c.display(item)
  }
  def hitAlarmButton()(implicit ah: AlarmHandler) { ah() }

  def break()(implicit c: Cause) { println(c.why) }
}


class OperatingMode {
  implicit val ConsoleRenderer = new Scanner.Console {
    def display(item: String) { println(s"Found a ${item}") }
  }
  implicit val DefaultAlarmHandler = new Scanner.AlarmHandler {
    def apply() { println("ALARM! ALARM!") }
  }
}
object NormalMode extends OperatingMode
object TestMode extends OperatingMode {
  override implicit val ConsoleRenderer = new Scanner.Console {
    def display(item: String) { println("Found a detonator") }
  }
  implicit val TestAlarmHandler = new Scanner.AlarmHandler {
    def apply() { println("Test successful. Well done!") }
  }
}

implicit val defaultCause = new Scanner.Cause {
  override val why: String = "human error"
}

import NormalMode._
Scanner.scanItem("knif")
Scanner.hitAlarmButton()
Scanner.break()

implicit val fatalCause = new Scanner.Fatal {
  override val why: String = "crisis"
}

import TestMode._
Scanner.scanItem("knif")
Scanner.hitAlarmButton()
Scanner.break()
