def foo[T >: Int with Double](a: T) = a

foo(1)
foo("abc")
foo(2.3)
