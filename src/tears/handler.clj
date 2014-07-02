(ns tears.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
	    [hiccup.core :refer :all]))

(defroutes app-routes
  (GET "/" [] (html [:body [:h1 "Hello World"]]))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
