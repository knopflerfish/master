/*
 * Copyright (c) 2003, KNOPFLERFISH project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the following
 *   disclaimer in the documentation and/or other materials
 *   provided with the distribution.
 *
 * - Neither the name of the KNOPFLERFISH project nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.knopflerfish.bundle.httpconsole;
	
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import org.osgi.framework.*;

/**
 * Abstract command implementation that prints a image submit button
 * as output HTML.
 */
public abstract class IconCommand implements Command {
  String id;
  String name;
  String description;
  String icon;

  int displayFlags = 0;

  IconCommand(String id, 
	      String name, 
	      String description,
	      String icon) {
    this.id          = id;
    this.name        = name;
    this.description = description;
    this.icon        = icon;
  }

  public int getDisplayFlags() {
    return displayFlags;
  }

  public abstract StringBuffer run(HttpServletRequest request);
  
  public void toHTML(HttpServletRequest request, PrintWriter out) throws IOException {
    out.print(" <input " + 
	      " alt=\"" + getDescription() + "\"" + 
	      " type=\"image\"" + 
	      " class=\"iconcmd\"" + 
	      " name=\"" + getId() + "\"" + 
	      " src=\"" + getIcon() + "\">");
  }
  
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getIcon() {
    return icon;
  }

  public String getDescription() {
    return description;
  }

  public boolean isTrigger(HttpServletRequest request) {
    return null != request.getParameter(getId() + ".x");
  }
}
