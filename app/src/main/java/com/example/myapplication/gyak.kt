package com.example.myapplication

/*1. feladat

data class University(
    var name: String,
    var departments: List<Department>,
)
data class Department(
    var name: String,
    var professors: List<Professor>,
    var students: List<Student>
)
data class Student(
    var name: String,
    var studentId: String,
    var courses: List<Course>
)
data class Course(
    var name: String,
    var credits: Long
)
data class Professor(
    var name: String,
    var subject: String
)

/*2. feladat*/

data class Airport(
    var name: String,
    var terminals: List<Terminal>
)
data class Terminal(
    var name: String,
    var flights: List<Flight>
)
data class Flight(
    var flightNumber: String,
    var destination: String,
    var airline: List<Airline>,
)
data class Airline(
    var name: String,
    var country: String
)


/*3. feladat*/

data class Publisher(
    var name: String,
    var authors: List<Author>
)
data class Author(
    var name: String,
    var books: List<Book>
)
data class Book(
    var title: String,
    var year: Integer,
    var ratings: List<Rating>
)
data class Rating(
    var rating: Integer,
    var comment: String
)

/*4. feladat*/
data class Agency(
    var name: String,
    var customers: List<Customer>
)
data class Customer(
    var customerId: String,
    var name: String,
    var email: String,
    var bookings: List<Booking>
)
data class Booking(
    var bookingId: String,
    var packages: List<Package>,
    var ratings: List<Ratings>
)
data class Ratings(
    var score: Integer,
    var comment: String
)
data class Package(
    var packageId: String,
    var destination: String,
    var durationDays: Integer,
    var price: Integer,
    var activites: List<Activity>
)
data class Activity(
    var name: String,
    var type: String
)

/*5. feladat */

data class WeatherResponse(
    var mains: Main
)
data class Main(
    var temp: Double
)



*/
class gyak {
}