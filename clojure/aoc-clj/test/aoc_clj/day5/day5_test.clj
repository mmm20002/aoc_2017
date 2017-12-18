(ns aoc-clj.day5.day5-test
  (:require [clojure.test :refer :all]
            [aoc-clj.day5.day5 :refer :all]))


(deftest day5-part1-test
  (is (= 5 (day5-part1 [0 3 0 1 -3]))))

(deftest day5-part2-test
  (is (= 10 (day5-part2 [0 3 0 1 -3]))))
