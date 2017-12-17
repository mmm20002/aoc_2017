(ns aoc-clj.day4.day4)

(defn day4-part1 [inp]
  (let [words (clojure.string/split inp #" ")]
    (apply distinct? words)))

(def part1-inp "")
(def part1-result (count (filter day4-part1
                                 (clojure.string/split-lines part1-inp))))

(defn day4-part2 [inp]
  (let [words (clojure.string/split inp #" ")]
    (apply distinct? (map frequencies words))))

(def part2-inp "")
(def part2-result (count (filter day4-part2
                                 (clojure.string/split-lines part2-inp))))
