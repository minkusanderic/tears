(ns tears.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
	    [hiccup.core :refer :all]
	    [garden.core :refer [css]]))

(def first-post 
     (html "This is my First post"))

(def second-post
     (html "This is my second post"))

(def header (html [:span "1"] [:span "2"]))

(def main-css
     (css [:section {:font-size "72px"}]))
(defn section-template [& content]
    (html [:section content])
)

(defn main-template [& content]
    (html [:head [:style main-css]] [:body content])
)
(defroutes app-routes
  (GET "/" [] (main-template header (map section-template [first-post second-post])))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
