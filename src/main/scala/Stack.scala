trait Stack[+T] {
  def pop: (T, Stack[T]) // 要素を取り出すメソッド
  def push[E >: T](e: E): Stack[E] // 要素を入れるメソッド
  def isEmpty: Boolean // Stack自身が空であるかの真偽値を返す
}

// --- 空ではない Stack の実装 ---
class NonEmptyStack[+T](private val top: T, private val rest: Stack[T]) extends Stack[T] {
  def push[E >: T](e: E): Stack[E] = new NonEmptyStack[E](e, this) // 再帰的に自分自身を呼び出し、新たに値をtopに置いたStackのインスタンスを作成
  def pop: (T, Stack[T]) = (top, rest) // コンストラクタで渡されているtopの値と残りの値すべてが入ったrestをタプルで返す
  def isEmpty: Boolean = false
}
// --- 空の Stack の実装 ---
case object EmptyStack extends Stack[Nothing] {
  def pop: Nothing = throw new IllegalArgumentException("empty stack") // 例外を投げる
  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def isEmpty: Boolean = true
}

// --- Stack を便利に使うためのファクトリメソッド ---
object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}