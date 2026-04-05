object TypeClassStudy:

  trait Additive[A]:
    def plus(a: A, b: A): A
    def zero: A

  case class Rational(num: Int, den: Int)

  object Rational:
    given RationalAdditive: Additive[Rational] with
      def plus(a: Rational, b: Rational): Rational =
        if a == zero then b
        else if b == zero then a
        else Rational(a.num * b.den + b.num * a.den, a.den * b.den)

      def zero: Rational = Rational(0, 0)

  def sum[A](lst: List[A])(using m: Additive[A]): A =
    lst.foldLeft(m.zero)((x, y) => m.plus(x, y))
