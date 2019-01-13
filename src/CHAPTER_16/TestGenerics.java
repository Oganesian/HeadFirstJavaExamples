package CHAPTER_16;

import java.util.ArrayList;

public class TestGenerics {
    public void go() {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());

        takeAnimals(animals);

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        takeAnimals(dogs);
    }

    public void takeAnimals(ArrayList<? extends Animal> animals) {
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
