(ns dream-journal.add
  (:require
   [dream-journal.utils :as utils]))

(defn add-entry
  [text]
  (let [entries (utils/read-entries)]
    (spit utils/ENTRIES-LOCATION
      (conj entries {:timestamp (System/currentTimeMillis)
                     :entry     text}))))
