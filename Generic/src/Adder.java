@FunctionalInterface
interface Adder<T extends Number> {
    T add(T num1, T num2);
}