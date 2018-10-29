;; Task: define the function that takes three numbers and returns the sum of the square of the two largest

;; Utils
(defn test-creator [func] (
  fn [expected & args] 
    (= (apply func args) expected)))

(defn square [a] (* a a))

(defn sum-of-squares [a, b] (+ (square a) (square b)))

;; Main function
(defn sum-squares-of-two-largest [a, b, c]
  (cond
    (= (min a b c) a) (sum-of-squares b c)
    (= (min a b c) b) (sum-of-squares a c)
    :else (sum-of-squares a b)))

;; Tests
(def square-test
  (test-creator square))
(def sum-of-squares-test
  (test-creator sum-of-squares))
(def sum-squares-of-two-largest-test
  (test-creator sum-squares-of-two-largest))

(square-test 25 5)
(square-test 36 6)
(square-test 4 2)
(sum-of-squares-test 26 5 1)
(sum-of-squares-test 25 4 3)
(sum-of-squares-test 90 9 3)
(sum-squares-of-two-largest-test 26 5 1 1)
(sum-squares-of-two-largest-test 80 4 2 8)
(sum-squares-of-two-largest-test 2 1 1 1)