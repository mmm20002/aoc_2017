(ns aoc-clj.day6.day6-test
  (:require [clojure.test :refer :all]
            [aoc-clj.day6.day6 :refer :all]))

(deftest day6-part1-test
  (is (= 5 (day6-part1 [0 2 7 0]))))

(deftest day6-part2-test
  (is (= 4 (day6-part2 [0 2 7 0]))))
