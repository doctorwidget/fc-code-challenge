(ns funding.core-test
  (:require [clojure.test :refer :all]
            [funding.core :as f]))

(deftest a-test
  (testing "fixed original default test"
    (is (= 1 1))))

(deftest fixture-test
  (testing "sanity test for table fixture"
    (is (= '(0 1 2 3 4 5 6 7 8 9) f/table-fixture))))

(deftest make-row-test
  (testing "make-row should yield a single row with the desired multiples" 
    (is (= (f/make-row 0 f/table-fixture) '(0 0 0 0 0 0 0 0 0 0 0)))
    (is (= (f/make-row 1 f/table-fixture) '(1 0 1 2 3 4 5 6 7 8 9)))
    (is (= (f/make-row 2 f/table-fixture) '(2 0 2 4 6 8 10 12 14 16 18)))))

(deftest sieve-test
  (testing "sanity test for our sieve of eratosthenes implementation"
    (is (= (f/sieve 0) '()))
    (is (= (f/sieve 1) '(2)))
    (is (= (f/sieve 2) '(2 3)))
    (is (= (f/sieve 10) '(2 3 5 7 11 13 17 19 23 29)))
    (is (= (f/sieve 15) '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)))
    (is (= (last (f/sieve 100)) 541))))

