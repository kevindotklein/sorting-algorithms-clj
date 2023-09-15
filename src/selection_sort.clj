(defn- selection [ys x]
  (if-let [y (peek ys)]
    (if (< y x)
      (conj ys x)
      (conj (pop ys) x y))
    [x]))

(defn selection-sort [xs]
  (let [ys (reduce selection [] xs)]
    (if (= xs ys)
      xs
      (recur ys))))

(selection-sort [3 2 1 0.5 -1.5 -1])