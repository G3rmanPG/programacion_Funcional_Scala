package examenes

trait ImmutableSet[T] {
  def add(elem: T): ImmutableSet[T] // añade el elemento elem al conjunto si no está presente
  def remove(elem: T): ImmutableSet[T] // elimina elem del conjunto; no modifica el conjunto si no está
  def contains(elem: T): Boolean // comprueba si un elemento está en el conjunto
  def size: Int // devuelve el número de elementos en el conjunto
  def isEmpty: Boolean // comprueba si el conjunto está vacío
}

class SimpleSet[T](elems: T*) extends ImmutableSet[T]{
  /**
   * - constructor principal privado que tome un argumento de tipo List[T]
   * - constructor que tome una secuencia de valores del tipo correspondiente (this(T*)).
   * - método toList: List[T] que devuelva los elementos del conjunto como una lista.
   * - método union(other: SimpleSet[T]): SimpleSet[T] que devuelva la unión del conjunto actual y el conjunto que recibe
   *   como argumento. La implementación debe usar match y recursión de cola.
   * - método intersection(other: SimpleSet[T]): SimpleSet[T] que devuelva la intersección del conjunto actual y el
   *   conjunto que recibe como argumento. La implementación debe utilizar funciones de orden superior.
   * - método difference(other: SimpleSet[T]): SimpleSet[T] que devuelva la diferencia entre el conjunto actual y otro
   *   conjunto (elementos que están en el primero pero no en el segundo). La implementación debe utilizar la función foldLeft
   * - Redefiniciones de los métodos toString (mostrando el conjunto con el formato "Set(1, 2, 3)"), hashCode (utilizando
   *   foldRight, calculando el valor hash simplemente como la suma de los valores hash de cada uno de los elementos, sin
   *   preocuparnos de posibles desbordamientos) y equals para asegurar que dos conjuntos con los mismos elementos se
   *   consideren iguales. */
  

}
