(ns funding.core
  (:require [clojure.test :as t]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def table-fixture (range 10))

(defn make-row [n values]
  (let [row-val (nth values n)]
    (conj (map #(* row-val %) values) row-val)))

(defn sieve
  "Find primes using Sieve of Eratosthenes"
  [n]
  (cond
    (< n 1) '()
    (= n 1) '(2)    
    :default (let [ceiling (+ 4 (* (Math/log n) n) (* n (Math/log (Math/log n)))) 
                   candidates (range 2 (Math/floor ceiling))]
               (loop [x 2 survivors candidates primes []]
                 (if (or (nil? x) (> x (last candidates)))     
                   (take n primes)         ;; base case: take n from the proven primes
                   (recur
                    (some #(if (> % x) %) survivors)    ;; x for next recur 
                    (filter #(> (mod % x) 0) survivors) ;; survivors for next recur
                    (conj primes x)))))))                ;; primes for next recur


(defn make-table-rows
  "Make the table rows, given any set of primes."
  [primes]
  (map #(make-row % primes) (range (count primes))))

(defn make-pretty-row
  "Create a formatted table row string from any list of numbers"
  [numbers]
  (apply str (map #(format "%4d" %) numbers)))

(defn make-pretty-header
  "Make a table header string from any list of numbers"
  [numbers]
  (str "    " (make-pretty-row numbers)))



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








