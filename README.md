# ArrayMap class


Класс ArrayMap - это параметризированный wrapped-класс,
созданный на основе двух структур - ArrayList и LinkedHashMap.

ArrayMap по сравнению с LinkedHashMap имеет следующие 
дополнительные возможности:
- обращение к значениям элементов Map-ы через индексы.
- имплементация интерфейса iterable (с возможностью исполь-
  зовать цикл "for" по элементам).

В результате, ArrayMap подобен LinkedHashMap, но с более быстрым
и удобным доступом к значениям элементов Мар-ы.

В PerformanceTest демонстрируется преимущество ArrayMap перед 
LinkedHashMap в производительности на больших объемах данных.

В App показаны примеры использования методов класса ArrayMap

Синтаксис:

  ### class ArrayMap<K, T> implements Iterable<T>
  
  где: K - параметр ключей,  Т - параметр значений

- -------------------------------------------------------------
The ArrayMap class is a parameterized wrapped class,
created on the basis of two structures - ArrayList and LinkedHashMap.

ArrayMap compared to HashMap has the following additional 
features:
- accessing of the values of Map elements through indexes.
- implementation of the iterable interface (with the ability 
  to use a "for" loop over elements).

As a result, ArrayMap is like LinkedHashMap but with faster
  and convenient access to the values of the elements of Map.

PerformanceTest demonstrates the advantage of ArrayMap over
LinkedHashMap in performance on large amounts of data.

App shows examples of using methods of the ArrayMap class.

Syntax:

  ### class ArrayMap<K, T> implements Iterable<T>

  where: K - parameter of keys, T - parameter of values
