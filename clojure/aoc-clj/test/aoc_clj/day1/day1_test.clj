(ns aoc-clj.day1.day1-test
  (:require [clojure.test :refer :all]
            [aoc-clj.day1.day1 :refer :all]))

(def part1-cases
  [["1122" 3]
   ["1111" 4]
   ["1234" 0]
   ["91212129" 9]])
  

(deftest day1-part1-test
  (doseq [[inp res] part1-cases]
    (is (= res (day1-part1 inp)))))

(def part2-cases
  [["1212" 6]
   ["1221" 0]
   ["123425" 4]
   ["123123" 12]
   ["12131415" 4]])

(deftest day1-part2-test
  (doseq [[inp res] part2-cases]
    (is (= res (day1-part2 inp)))))
