(ns aoc-clj.day5.day5)

(defn prep-input [inp-str]
  (->> inp-str
       clojure.string/split-lines
       (map read-string)
       (into [])))

(defn driver [step-fn inp-vec]
  (let [arr (int-array inp-vec)]
    (loop [pos 0 steps 0]
      (if (<= 0 pos (dec (count arr)))
        (let [cur-offset (aget arr pos)
              next-pos (+ pos cur-offset)
              next-offset ^Integer (step-fn cur-offset)]
          (aset arr pos next-offset)
          (recur next-pos (inc steps)))
        steps))))

(def day5-part1 (partial driver inc))

;; (def part1-inp "")
;; (def part1-result (day5-part1 (prep-input part1-inp)))

(defn part2-step-fn [offset]
  (if (>= offset 3)
    (dec offset)
    (inc offset)))

(def day5-part2 (partial driver part2-step-fn))

;; (def part2-inp "")
;; (def part2-result (day5-part2 (prep-input part2-inp)))
