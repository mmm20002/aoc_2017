(ns aoc-clj.day6.day6)

(defn max-idx [^clojure.lang.PersistentVector banks]
  (.indexOf banks (apply max banks)))

(defn redistribute [banks]
  (let [idx (max-idx banks)
        blocks (nth banks idx)
        redistribution (frequencies (take blocks
                                          (drop (inc idx)
                                                (cycle (range (count banks))))))]
    (reduce-kv (fn [res k v] (update res k #(+ v %)))
               (assoc banks idx 0)
               redistribution)))
    

(defn driver [ret-fn banks]
  (reduce (fn [seen bank]
            (if (contains? seen bank)
              (reduced (ret-fn seen bank))
              (assoc seen bank (count seen))))
          {}
          (iterate redistribute banks)))

(def day6-part1 (partial driver (fn [seen _] (count seen))))

(def day6-part2 (partial driver
                         (fn [seen bank]
                           (- (count seen)
                              (get seen bank)))))

(def part1-inp [2 8 8 5 4 2 3 1 5 5 1 2 15 13 5 14])
(def part2-inp part1-inp)
