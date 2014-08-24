/*
 * Copyright (c) 2011-2014, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.scene.web

import javafx.scene.{web => jfxsw}
import scalafx.event.{EventType, Event}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object WebEvent {
  implicit def sfxWebEvent2jfx[T](we: WebEvent[T]) = if (we != null) we.delegate else null

  /**
   * This event occurs when a script calls the JavaScript alert function.
   */
  val ALERT: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.ALERT

  /**
   * Common supertype for all Web event types.
   */
  val ANY: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.ANY

  /**
   * This event occurs when a script changes location of the JavaScript window object.
   */
  val RESIZED: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.RESIZED

  /**
   * This event occurs when a script changes status line text.
   */
  val STATUS_CHANGED: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.STATUS_CHANGED

  /**
   * This event occurs when a script changes visibility of the JavaScript window object.
   */
  val VISIBILITY_CHANGED: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.VISIBILITY_CHANGED
}

class WebEvent[T](override val delegate: jfxsw.WebEvent[T]) extends Event(delegate) with SFXDelegate[jfxsw.WebEvent[T]] {

  /**
   * Creates a new event object.
   *
   */
  def this(source: Any, eventType: EventType[jfxsw.WebEvent[_]], data: T) = this(new jfxsw.WebEvent(source, eventType, data))

  /**
   * Returns data item carried by this event.
   */
  def data: T = delegate.getData

}