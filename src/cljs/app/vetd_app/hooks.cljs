(ns vetd-app.hooks
  (:require-macros vetd-app.hooks))

(defonce hook-registry (volatile! {}))

#_(vreset! hook-registry {})


(defn reg-hook! [hook-fn handle f]
  (if-let [hook-type (-> hook-fn meta ::type)]
    (vswap! hook-registry assoc-in [hook-type handle] f)
    (throw (js/Error. (str "No hook-type meta found on: " hook-fn)))))

(defn reg-hooks! [hook-fn m]
  (doseq [[k v] m]
    (reg-hook! hook-fn k v)))

;; HOOKS =========================

(vetd-app.hooks/defhook c-page (constantly [:div "no page"]))

(vetd-app.hooks/defhook c-container (fn [p] [:div p]))

(vetd-app.hooks/defhook c-general (constantly nil))

(vetd-app.hooks/defhook c-admin (constantly nil))

(vetd-app.hooks/defhook init! (constantly nil))

