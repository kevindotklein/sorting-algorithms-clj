(defn- *merge
  [[l & *left :as left] [r & *right :as right] acc]
  (if (and (not-empty left) (not-empty right))
    (if (<= l r)
      (recur *left right (conj acc l))
      (recur left *right (conj acc r)))
    (concat acc left right)))

(defn merge-sort [xs]
  (if (> (count xs) 1)
    (let [[left right] (split-at (/ (count xs) 2) xs)]
      (*merge (merge-sort left) (merge-sort right) []))
    xs))

(merge-sort [3 2 1 0.5 -1.5 -1])