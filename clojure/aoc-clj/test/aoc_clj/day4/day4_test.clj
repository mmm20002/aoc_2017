(ns aoc-clj.day4.day4-test
  (:require [clojure.test :refer :all]
            [aoc-clj.day4.day4 :refer :all]))

(def part1-cases
  [["aa bb cc dd ee" true]
   ["aa bb cc dd aa" false]
   ["aa bb cc dd aaa" true]])

(deftest day4-part1-test
  (doseq [[case result] part1-cases]
    (is (= result (day4-part1 case)))))

(def part2-cases
  [["abcde fghij" true]
   ["abcde xyz ecdab" false]
   ["a ab abc abd abf abj" true]
   ["iiii oiii ooii oooi oooo" true]
   ["oiii ioii iioi iiio" false]])
  

(deftest day4-part2-test
  (doseq [[case result] part2-cases]
    (is (= result (day4-part2 case)))))
