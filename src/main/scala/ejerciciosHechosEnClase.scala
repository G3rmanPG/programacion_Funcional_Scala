import scala.{+:, ::}
import scala.annotation.tailrec

object FuncionesYEjsClase {
  def map[A, B](l: List[A], f: A => B): List[B] = {
    @tailrec
    def aux(currentList: List[A], l2: List[B]): List[B] = {
      currentList match {
        case Nil => l2
        case head :: tail => aux(tail, l2 :+ f(head))
      }
    }

    aux(l, Nil)
  }

  /*def foldLeft(Map [String, Int]): (acc, x) = {
    acc(x) match {
      case None => acc + (x)
      case Some(n) => acc + (x n +1)
    }
  }*/

  def unzipFR[A, B](l: List[(A, B)]): (List[A], List[B]) = {

    val valorInicial = (List.empty[A], List.empty[B])

    l.foldRight(valorInicial) {
      // Usamos pattern matching para extraer el par actual y las listas acumuladas
      case ((a, b), (listaA, listaB)) =>
        // Añadimos 'a' al principio de 'listaA' y 'b' al principio de 'listaB'
        (a :: listaA, b :: listaB)
    }
  }

  def main(args: Array[String]): Unit = {
    val pares = List((1, "Uno"), (2, "Dos"), (3, "Tres"))
    val (numeros, palabras) = unzipFR(pares)

    println("Lista original: " + pares)
    println("Números extraídos: " + numeros)
    println("Palabras extraídas: " + palabras)
  }

  def cadenas(n: Int): List[String] = {
    require(n >= 0)
    if (n == 0) then List("")
    else for
      e <- cadenas(n - 1)
      x <- List("0", "1")
    yield (e + x)
  }

  /**
   * Escribe una función que reciba un número entero n. La función debe generar y devolver una lista con
   * todas las cadenas binarias (formadas por '0' y '1') de longitud n, pero con una restricción
   * muy importante: no puede haber dos '0' juntos. */

  def generateBinaryNumbers(n: Int): List[String]={
    @tailrec
  // stack contiene el estado actual a evaluar (la cadena actual con lu longitud)
    def aux(stack: List[(String, Int)], acc: List[String]): List[String]={
      stack match{
        case Nil => acc // sin estados por analizar

        case (cad, long):: rest if long == n => // longitud igual a n -> pasamos a la sig cadena
          aux(rest, cad::acc) // añadir cadena completa

        case (cad, long):: rest =>
          var newStack = rest
          newStack = (cad + "1", long+1)::newStack // es seguro siempre añadir un 1
          // aunque si el último dígito no es 0 podemos añadir un estado nuevo a la pila con 0 al final
          if(cad.isEmpty || cad.last != '0'){
            newStack = (cad + "0", long+1)::newStack
          }
          aux(newStack, acc)
      }
    }
    aux(List(("", 0)), List.empty)
  }

  /* EVALUACIÓN PEREZOSA (Lazy evaluation)*/
}

object FoldRight {
  def foldRight[A,B](lA: List[A], lB: List[B]): Int={
    //(x_1::acc_1, x_2::acc_2)
    0
  }
}

object ejerciciosHechosEnClase extends App{
  print(FuncionesYEjsClase.generateBinaryNumbers(3))
}
