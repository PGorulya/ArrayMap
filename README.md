# ArrayMap class


Класс ArrayMap - это параметризированный wrapped-класс,
созданный на основе двух структур - ArrayList и LinkedHashMap.

ArrayMap по сравнению с HashMap/LinkedHashMap имеет следующие 
дополнительные возможности:
- обращение к значениям элементов Map-ы через индексы.
- имплементация интерфейса iterable (с возможностью исполь-
  зовать цикл "for" по элементам).

В результате, ArrayMap подобен HashMap, но с более быстрым
и удобным доступом к значениям элементов Мар-ы.

В PerformanceTest демонстрируется преимущество ArrayMap перед 
HashMap в производительности на больших объемах данных.

В App показаны примеры использования методов класса ArrayMap

Синтаксис:

  ### class ArrayMap<K, T> implements Iterable<T>
  
  где: K - параметр ключей,  Т - параметр значений

- -------------------------------------------------------------
The ArrayMap class is a parameterized wrapped class,
created on the basis of two structures - ArrayList and LinkedHashMap.

ArrayMap compared to HashMap/LinkedHashMap has the following additional 
features:
- accessing of the values of Map elements through indexes.
- implementation of the iterable interface (with the ability 
  to use a "for" loop over elements).

As a result, ArrayMap is like HashMap but with faster
  and convenient access to the values of the elements of Map.

PerformanceTest demonstrates the advantage of ArrayMap over
HashMap in performance on large amounts of data.

App shows examples of using methods of the ArrayMap class.

Syntax:

  ### class ArrayMap<K, T> implements Iterable<T>

  where: K - parameter of keys, T - parameter of values
