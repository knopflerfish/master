/*
 * Copyright (c) 2003-2004, KNOPFLERFISH project
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
package org.knopflerfish.bundle.soap.remotefw;

import org.osgi.framework.*;

import java.util.*;
import org.knopflerfish.service.log.LogRef;

import org.knopflerfish.bundle.soap.remotefw.client.*;
import org.knopflerfish.service.remotefw.*;

public class Activator implements BundleActivator {

  public static BundleContext bc;
  public static LogRef        log;

  RemoteFWServer remoteFW;

  public void start(BundleContext bc) {
    this.bc = bc;
    log = new LogRef(bc);

    if("true".equals(System.getProperty("org.knopflerfish.soap.remotefw.server", "true"))) {
      remoteFW = new RemoteFWServer();
      remoteFW.start();
    }

    if("true".equals(System.getProperty("org.knopflerfish.soap.remotefw.client", "true"))) {
      RemoteFrameworkImpl rc = new RemoteFrameworkImpl();

      bc.registerService(RemoteFramework.class.getName(),
       rc,
       new Hashtable());
    }
  }

  public void stop(BundleContext bc) {
    if(remoteFW != null) {
      remoteFW.stop();
      remoteFW = null;
    }

    this.log = null;
    this.bc  = null;
  }
}
