(ns aoc-clj.day2.day2)

(defn split-whitespace [string]
  (clojure.string/split string #"\s+"))

(defn split-lines [string]
  (clojure.string/split string #"\n"))

(defn str-list->int-list [str-list]
  (map read-string str-list))

(defn str->table [inp-str]
  (->> inp-str
       split-lines
       (map split-whitespace)
       (map str-list->int-list)))

(defn min-max-diff [l]
  (- (apply max l)
     (apply min l)))

(defn day2-part1 [inp-str]
  (let [table (str->table inp-str)]
    (reduce + (map min-max-diff table))))

(defn cartesian-product [l1 l2]
  (for [e1 l1
        e2 l2
        :when (not= e1 e2)]
    [e1 e2]))

(defn divisable? [[e1 e2]]
  (= 0 (mod e2 e1)))

(defn day2-part2 [inp-str]
  (let [table (str->table inp-str)]
    (reduce (fn [r [e1 e2]] (+ r (/ e2 e1)))
            0
            (->> table
                 (map #(cartesian-product %1 %1))
                 (map #(filter divisable? %))
                 (map first)))))

