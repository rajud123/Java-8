A lambda function is an anonymous function it is a used to refer a function defined inside a functional interface.
we can not implement every method as a anonymous function/lambda expression, we can use implement only the methods declared in 
functional interface as anonymous functions, since the functional interface contains only one method and it will referred 
on the reference of the interface reference without the method name.
A functional interface is an interface which contains single abstract method(SAM) can have multiple default and static methods.

eg : Runnable(I)             run()
     Callable(I)             call()
     Comparable(I)           compareTo()
     Comparator(I)           compare()

Consumer(I) :
Consumer is a functional interface it accepts something as a parameter does some operation on the input and does not return anything.
     syntax - void accept(T t)

Predicate(I) :
Predicate is a functional interface which takes some input does some conditional validation on the input and returns true or false based 
on the condition.
     Syntax - boolean test(t t)

Supplier(I) :
Supplier is a functional interface which does not take any input but it returns some output of type generic.
     syntax - T get()

Stream API:
Generally a stream is a collection of objects.
Using Stream API we can stream through a collection of objects, we can use various methods provided by Stream API we can pipeline these methods
to get the desired results on the collection.

and Streams don't change the original data objects they just stream through the pipelined methods and provide a desired results,
which will be a different data altogether.

Using streams we can achieve 
     . functional programming
     . Code reduce
     . Bulk operations can be done easily with good control

map() & flatmap()
     Both these methods are intermediate methods and returns another stream as a part of the output.
     
map() - used for data transaformation.
     signature - Stream<R> map(Stream<T> input)

     map() method takes a stream as an input and returns another stream as an output.
     It produces a single value for each input value in the stram. Its basically one-to-one mapping.

flatMap() - map() + data flattering.
     signature - Stream<R> map(Stream<Stream<T>> input)
     
     It takes stream of streams as input, it produces multiple values for each input, it is one-to-many mapping.

Optional - Using optional API we can avoid unpredictable NullPointerException.
     there are three ways of creating an optional object.
     - Optional.empty()  :: returns an empty object
     - Optional.of()     :: returns the object if not null, if null then throws NullPointerException
     - Optional.ofNullable()  :: return an empty object if null, returns the object if not null.

reduce() - to aggregate stram data.
     singnature - T reduce(T identity, BinaryOperator<T> accumulator)

     identity is the initial value for the opertaion performed by the accumulator.
     accumulator is a function which does the aggregation operation, eg: (a, b)->a +b

parallel processing :
     Parallel streaming is for utilising multiple cores of the system, for faster processing of data.
     In normal stream processing we have only one stream processing, where it will be executed sequentially.
     -However we can't control the execution order in parallel processing.
     - to achieve this replace stream() method with parallelStream()

BiFunction, BiConsumer & BiPredicate Interface:

BiFunction - Function interface takes one argument/input returns some result, while BiFunction takes two  arguemnts does some operatoin and returns a value.

     syntax - R apply(T t, U u)
Biconsumer - Consumer takes one input and does not return anything, while BiConsumer takes two arguments/inputs and does not return anything.

     syntax - void accept(T t, U u)
BiPredicate - Predicate takes an argument does some conditional check on the input and returns boolean value based on the check, while BiPredicate takes two
     arguments and does some conditional check and returns boolean value.




