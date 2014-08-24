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
package scalafx.scene.control

import scalafx.delegate.{AlignmentPropertyDelegate, SFXDelegate}
import javafx.beans.{property => jfxbp, binding => jfxbb}
import javafx.{scene => jfxs, event => jfxe}
import jfxs.{control => jfxsc}
import scalafx.beans.property.ReadOnlyObjectProperty

object TextFieldProperty {
  implicit def sfxTextFieldProperty2jfx(p: TextFieldProperty) = if (p != null) p.delegate else null
}

class TextFieldProperty(override val delegate: jfxbp.ReadOnlyObjectProperty[jfxsc.TextField])
  extends ReadOnlyObjectProperty[jfxsc.TextField](delegate)
  with SFXDelegate[jfxbp.ReadOnlyObjectProperty[jfxsc.TextField]]
  with AlignmentPropertyDelegate {

  def onAction = jfxbb.Bindings.select[jfxe.ActionEvent](delegate, "onAction")
  def prefColumnCount = jfxbb.Bindings.selectInteger(delegate, "prefColumnCount")

  // todo - these need to be moved to TextInputControl:
  def promptText = jfxbb.Bindings.selectString(delegate, "promptText")
  def text = jfxbb.Bindings.selectString(delegate, "text")
}
