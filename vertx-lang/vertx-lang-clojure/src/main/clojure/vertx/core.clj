(ns vertx.core)
(println "vert.x core initializing")

;; setup for vertx

(def vertx org.vertx.java.deploy.impl.VertxLocator/vertx)
(def container org.vertx.java.deploy.impl.VertxLocator/container)
(def event-bus (. vertx eventBus))

(defmacro handle
  [bindings & body]
  `(reify org.vertx.java.core.Handler
     (handle ~bindings ~@body)))

;; deployModule
;; deployWorkerVerticle
;; undeployModule
;; undeployWorkerVerticle
;; undeployVerticle
(defmacro deployVerticle [container & args]
  `(do
     (.deployVerticle ~container  ~@args)
     container))
