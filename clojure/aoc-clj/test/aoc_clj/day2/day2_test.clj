(ns aoc-clj.day2.day2-test
  (:require [clojure.test :refer :all]
            [aoc-clj.day2.day2 :refer :all]))

(deftest day2-part1-test
  (is (= 18
         (day2-part1 "5 1 9 5\n7 5 3\n2 4 6 8"))))

(deftest day2-part2-test
  (is (= 9
         (day2-part2 "5 9 2 8\n9 4 7 3\n3 8 6 5"))))
