/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vertx.java.deploy.impl.clojure;

import org.vertx.java.core.logging.Logger;
import org.vertx.java.core.logging.impl.LoggerFactory;
import org.vertx.java.deploy.Verticle;

import clojure.lang.RT;

public class ClojureVerticle
        extends Verticle
{
    private static final Logger log = LoggerFactory.getLogger(ClojureVerticle.class);

    private final ClassLoader cl;
    private final String scriptName;

    ClojureVerticle(String scriptName, ClassLoader cl) {
        this.cl = cl;
        this.scriptName = scriptName;
    }

    public void start() throws Exception {
        System.out.println("CLOJURE VERTICLE START: " + scriptName);

        RT.loadResourceScript(scriptName);

        System.out.println("...loadResourceScript returned");
    }

    public void stop() throws Exception {
        System.out.println("CLOJURE VERTICLE STOP: " + scriptName);
        // TODO - objviously we need to do something here
    }
}
