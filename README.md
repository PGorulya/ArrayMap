# ArrayMap class


Класс ArrayMap - это параметризированный wrapped-класс,
созданный на основе двух структур - ArrayList и HashMap.
Он обладает дуальными особенностми.

С одной стороны ArrayMap по сравнению с HashMap имеет
  следующие дополнительные характеристики:
- упорядоченность значений элементов Map-ы.
- имплементация интерфейса iterable (с возможностью исполь-
  зовать цикл "for" по элементам).
- обращение к знаениям элементов Map-ы через индексы.

  С другой стороны ArrayMap по сревнению с ArrayList обладает
  следующими дополнительными возможностями:
- определение существования жлемента списка по значению
  поля ключей (со сложностью О(1)).
- определение индекса элемента списка по значению поля
  ключей (со сложностью О(1)).

Синтаксис:
  class ArrayMap<T, K> implements Iterable<T>
  где: Т - класс значений, K - класс ключей
- 
- -------------------------------------------------------------
The ArrayMap class is a parameterized wrapped class,
  created on the basis of two structures - ArrayList and HashMap.
  It has dual features.

On the one hand, ArrayMap compared to HashMap has
the following additional features:
- ordering of the values of the elements of the Map. 
- implementation of the iterable interface (with the ability 
  to use a foreach loop over elements).
- accessing of the values of Map elements through indexes.

On the other hand ArrayMap compared to ArrayList has the following
additional features:
- determining the existence of a list element by the value of
  field key (with O(1) complexity).
- determining the index of the list element by the value of the
  field keys (with O(1) complexity).
 
Syntax:
  class ArrayMap<T, K> implements Iterable<T>
  where: T is the class of values, K - class of keys
