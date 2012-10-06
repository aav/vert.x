(use 'vertx.core)


;; the point of this is to experiment a bit with invoking vertx from
;; clojure before trying to determine the best abstraction

;; to test, add clojure JAR to APP_HOME/lib
;; (for dev build/vert.x-1.2.3.final/lib)

(def vertx org.vertx.java.deploy.impl.VertxLocator/vertx)
(def server (.createNetServer vertx))

(defmacro handle
  [bindings body]
  `(reify org.vertx.java.core.Handler 
     (handle ~bindings ~body)))


(def plain-sayhi
  (reify org.vertx.java.core.Handler
    (handle [this socket]
      (.write socket "hello\n"
              (reify org.vertx.java.core.Handler
                (handle [this _]
                  (.close socket)))))))

(def sayhi
  (handle [this socket]
    (.write socket "Hello, macro!\n"
            (handle [this _]
              (.close socket)))))

(.connectHandler server sayhi)
(.listen server 1234 "localhost")

(println "listening on localhost:1234")