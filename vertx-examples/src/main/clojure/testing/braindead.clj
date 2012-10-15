(use 'vertx.core)


;; the point of this is to experiment a bit with invoking vertx from
;; clojure before trying to determine the best abstraction

;; to test, add clojure JAR to APP_HOME/lib
;; (for dev build/vert.x-1.2.3.final/lib)


(println "config is" (. container getConfig))

(.runOnLoop vertx
            (handle [this _]
              (println "on loop")))

(.setPeriodic vertx 15000
              (handle [this id]
                (println "timer" id)))



(def config (new org.vertx.java.core.json.JsonObject
                 {"a" 1 "b" 2 :c 3 :hello ["this" "is"  \a "test"]}))


(-> container
    (deployVerticle "simple1.clj" config)
    (deployVerticle "simple2.clj"))


