(ns aoc-clj.day3.day3-test
  (:require [clojure.test :refer :all]
            [aoc-clj.day3.day3 :refer :all]))

(def part1-cases
  [[1 0]
   [12 3]
   [23 2]
   [1024 31]])

(deftest day3-part1-test
  (doseq [[inp res] part1-cases]
    (is (= res (day3-part1 inp)))))
