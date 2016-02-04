(ns funding.core-test
  (:require [clojure.test :refer :all]
            [funding.core :as funding]))

(deftest a-test
  (testing "fixed original default test"
    (is (= 1 1))))

(deftest fixture-test
  (testing "sanity test for table fixture )"
    (is (= '(0 1 2 3 4 5 6 7 8 9) funding/table-fixture))))


