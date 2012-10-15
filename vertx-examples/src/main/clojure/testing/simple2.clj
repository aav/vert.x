(use 'vertx.core)

(println "simple 2 config is" (. container getConfig))

;; startup timing
(.setTimer vertx 2000
            (handle [_ _]
              (.publish event-bus
                        "foo.bar"
                        "this is the message!")
              (println "published"))) 

