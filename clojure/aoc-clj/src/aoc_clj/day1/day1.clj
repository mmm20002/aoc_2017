(ns aoc-clj.day1.day1)

(defn char->int [inp-char] (- (int inp-char) (int \0)))

(defn str->int-list [inp-str]
  (map char->int (seq inp-str)))

(defn add-to-result [cur-result [v1 v2]]
  (if (= v1 v2)
    (+ cur-result v1)
    cur-result))

(defn day1 [offset inp-str]
  (let [int-list (str->int-list inp-str)
        pairs (map vector int-list (drop offset (cycle int-list)))]
    (reduce add-to-result 0 pairs)))

(def day1-part1 (partial day1 1))

(defn day1-part2 [inp-str]
  (day1 (/ (count inp-str) 2) inp-str))


  
