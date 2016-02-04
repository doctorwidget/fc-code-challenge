(ns funding.core
  (:require [clojure.test :as t]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def table-fixture (range 10))

(defn make-row [n values]
  (let [row-val (nth values n)]
    (conj (map #(* row-val %) values) row-val)))



(def cli-options
  ;; An option with a required argument
  [["-s" "--size SIZE" "Size of grid"
    :default 10
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 1000) "Must be a number between 0 and 1000"]]])

(defn -main [& args]
  (let [options (parse-opts args cli-options)
        size (get-in options [:options :size])]
    #_(println options)
    (println (str "Printing " size " x " size " table of primes"))
    ))








