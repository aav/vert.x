(use 'vertx.core)


;; the point of this is to experiment a bit with invoking vertx from
;; clojure before trying to determine the best abstraction

;; to test, add clojure JAR to APP_HOME/lib
;; (for dev build/vert.x-1.2.3.final/lib)

(def vertx org.vertx.java.deploy.impl.VertxLocator/vertx)
(def server (.createNetServer vertx))

(def handler
  (reify org.vertx.java.core.Handler
    (handle [this e] (println "**** HANDLE" e))))

(.connectHandler server handler)
(.listen server 1234 "localhost")

(println "listening on localhost:1234")