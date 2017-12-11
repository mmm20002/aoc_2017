(ns aoc-clj.day3.day3)

(defn pow [base power]
  (int (Math/pow base power)))

(defn perimeter-squares [width]
  (- (* width 4) 4))

(defn start-squ-seq
  ([] (lazy-seq (cons 1 (start-squ-seq 1 2))))
  ([squ width]
   (let [new-squ (+ squ (perimeter-squares width))]
     (lazy-seq (cons new-squ (start-squ-seq new-squ (+ 2 width)))))))

(defn layer-first-value [layer]
  (inc (* 4 (* layer layer))))

(defn value-layer [value]
  (-> value dec (/ 4) Math/sqrt Math/floor int))

(defn layer-width [layer]
  (* 2 (inc layer)))

(defn key-values [layer]
  (let [first-value (layer-first-value layer)
        next-value (layer-first-value (inc layer))
        width (layer-width layer)
        v1 (+ first-value layer)
        v2 (+ v1 1 (dec (* 2 layer)))
        v3 (+ v2 width -1)
        v4 (- next-value layer 1)]
    [v1 v2 v3 v4]))

(defn min-reducer
  ([pair] pair)
  ([[_ min-value :as cur-pair]
    [_ new-value :as new-pair]]
   (if (< new-value min-value)
     new-pair
     cur-pair)))

(defn min-distance [distances]
  (min (apply min (take 2 distances))
       (apply min (map inc (drop 2 distances)))))
  
(defn day3-part1 [inp-int]
  (let [layer (value-layer inp-int)]
    (+ layer (min-distance (map #(Math/abs (- inp-int %))
                                (key-values layer))))))

(def steps {:left  [:col dec]
            :right [:col inc]
            :up    [:row dec]
            :down  [:row inc]})

(def foundations {:left  [:row inc]
                  :right [:row dec]
                  :up    [:col dec]
                  :down  [:col inc]})

(def direction-order {:left  :down
                      :down  :right
                      :right :up
                      :up    :left})

(defn get-coord [table coord direction]
  (let [[component update-fn] (direction table)]
    (update coord component update-fn)))

(def step (partial get-coord steps))
(def foundation (partial get-coord foundations))

(def offsets (for [row [-1 0 1]
                   col [-1 0 1]
                   :when (or (not= 0 row)
                              (not= 0 col))]
               {:row row :col col}))

(defn add-coords [c1 c2]
  {:row (+ (:row c1) (:row c2))
   :col (+ (:col c1) (:col c2))})

(defn next-direction [history coord direction]
  (if (contains? history (foundation coord direction))
    direction
    (direction direction-order)))

(defn adjacents [coord]
  (for [c offsets] (add-coords coord c)))

(defn adjacents-vals [history coord]
  (for [adj (adjacents coord)
        :when (contains? history adj)]
    (get history adj)))

(defn part2-seq
  ([] (let [start {:row 0 :col 0}]
        (lazy-seq (cons 1
                        (part2-seq {start 1} (step start :right) :up)))))
  ([history coord direction]
   (lazy-seq
    (let [next-val (reduce + (adjacents-vals history coord))
          new-history (assoc history coord next-val)
          next-coord (step coord direction)]
      (cons next-val (part2-seq new-history
                                next-coord
                                (next-direction new-history next-coord direction)))))))
          
(def part2-sol (first (filter #(> % 277678) (part2-seq))))
                 
