(ns vetd-app.ui
  (:require [cljsjs.semantic-ui-react]
            [goog.object]))

;; handle to top-level extern from Semantic UI React
(def semantic-ui js/semanticUIReact)

(defn component
  "Get a component from sematic-ui-react:
    (component \"Button\")
    (component \"Menu\" \"Item\")"
  [k & ks]
  (if (seq ks)
    (apply goog.object/getValueByKeys semantic-ui k ks)
    (goog.object/get semantic-ui k)))

(def Grid (component "Grid"))
(def GridColumn (component "Grid" "Column"))
(def GridRow (component "Grid" "Row"))

(def Menu (component "Menu"))
(def MenuItem (component "Menu" "Item"))
(def MenuMenu (component "Menu" "Menu"))

(def Container (component "Container"))
(def Segment (component "Segment"))

(def Header (component "Header"))

(def Button (component "Button"))
(def Input (component "Input"))
(def Checkbox (component "Checkbox"))

(def Icon (component "Icon"))

(def Label (component "Label"))
(def LabelDetail (component "Label" "Detail"))

(def Image (component "Image"))

(def Loader (component "Loader"))

(def Item (component "Item"))
(def ItemGroup (component "ItemGroup"))
(def ItemImage (component "ItemImage"))
(def ItemContent (component "ItemContent"))
(def ItemHeader (component "ItemHeader"))
(def ItemMeta (component "ItemMeta"))
(def ItemDescription (component "ItemDescription"))
(def ItemExtra (component "ItemExtra"))
