(ns dream-journal.main
  (:require [babashka.cli :as cli]
           [dream-journal.add :as add]))

(def cli-opts
  {:entry    {:alias  :e
              :desc   "Your dreams."
              :require true}
  :timestamp {:alias :t
              :desc  "A unix timestamp, when you recorded this."
              :coerce {:timestamp :long}}})

(defn help
  [_]
  (println
  (str "add\n"
      (cli/format-opts {:spec cli-opts}))))

(def table
  [{:cmds ["add"] :fn add/add-entry :spec cli-opts}
   {:cmds [] :fn help}])

(defn -main [& _args]
  (cli/dispatch table *command-line-args*))
