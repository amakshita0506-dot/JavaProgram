# Vector Class Implementation in Java

## Description

This project demonstrates the use of the **Vector class in Java**, which is part of the Java Collections Framework.
Vector is a dynamic array that can grow or shrink automatically as elements are added or removed.
The program shows how to store and manage elements using Vector and perform basic operations on it.

## Features

* Create a Vector
* Add elements to the Vector
* Remove elements
* Access elements using index
* Display all elements

## Technologies Used

* Java
* Java Collections Framework
* Vector Class

## Example Operations

* Adding elements using `add()`
* Removing elements using `remove()`
* Accessing elements using `get()`
* Checking size using `size()`

## Example Code

import java.util.Vector;

public class VectorExample {

    public static void main(String[] args) {

        // Creating a Vector
        Vector<String> books = new Vector<>();

        // Adding elements
        books.add("Java Programming");
        books.add("Data Structures");
        books.add("Machine Learning");

        // Display all elements
        System.out.println("Books in Vector: " + books);

        // Access element using index
        System.out.println("First Book: " + books.get(0));

        // Remove an element
        books.remove("Data Structures");

        // Display updated vector
        System.out.println("After removing a book: " + books);

        // Size of vector
        System.out.println("Total books: " + books.size());
    }
}

## Author

Akshita Mishra
