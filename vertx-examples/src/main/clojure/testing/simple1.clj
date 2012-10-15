(use 'vertx.core)

(println "simple config is" (. container getConfig))

(.registerHandler event-bus
                  "foo.bar"
                  (handle [this message]
                    (println "simple1 got message" message (. message body))))

(println "registered!")
