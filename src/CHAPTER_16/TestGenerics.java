package CHAPTER_16;

public class TestGenerics {
    public void go() {
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    public void takeAnimals(Animal[] animals) {
        for(Animal a: animals) {
            a.eat();
        }
    }

    abstract class Animal {
        void eat() {
            System.out.println("Animal eats");
        }
    }

    class Dog extends Animal {
        void bark() {}
    }

    class Cat extends Animal {
        void meow() {}
    }
}
