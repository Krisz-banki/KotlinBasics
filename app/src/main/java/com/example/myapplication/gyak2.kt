package com.example.myapplication

//1. feladat (2024. 11. 25)
data class Order(
    var orderId: String,
    var customers: Customer,
    var orderItems: OrderItem,
    var shippings: Shipping,
    var payments: Payment,
    var status: String
    )
data class Customer(
    var customerId: String,
    var name: String,
    var email: String,
    var phone: String
)
data class OrderItem(
    var itemId: String,
    var productName: String,
    var quantity: Integer,
    var pricePerUnit: Double,
    var discount: Double?
)
data class Shipping(
    var addresses: Address,
    var shippingMethod: String,
    var estimatedDeliveryDay: Integer
)
data class Address(
    var street: String,
    var city: String,
    var postalCode: String,
    var country: String
)
data class Payment(
    var paymentMethod: String,
    var totalAmount: Double,
    var paid: Boolean
)

//2. feladat

data class Project(
    var projectName: String,
    var subject: String,
    var durationWeeks: Integer,
    var teamMembers: TeamMember,
    var assignments: Assignment,
    var completed: Boolean
)
data class TeamMember(
    var studentId: String,
    var name: String,
    var grade: Integer,
    var hasCompleted: Boolean
)
data class Assignment(
    var assignmentName: String,
    var maxPoints: Integer,
    var studentsScores: StudentScore
)
data class StudentScore(
    var STU123: Integer,
    var STU124: Integer,
    var STU125: Integer
)


//3. feladat
data class City(
    var cityName: String,
    var transitSystems: TransitSystems,
    var ControlCenters: ControlCenter
)
data class TransitSystems(
    var buses: Bus,
    var trams: Tram
)
data class Bus(
    var routeNumber: Integer,
    var routeName: String,
    var vehicles: Vehicle,
    var schedules: Schedule
)
data class Vehicle(
    var vehicleId: String,
    var capacity: Integer,
    var currentLocations: CurrentLocation,
    var status: String
)
data class CurrentLocation(
    var latitude: Double,
    var longitude: Double
)
data class Schedule(
    var weekdays: Weekday,
    var weekends: Weekend
)
data class Weekday(
    var departureTime: String,
    var arrivalTime: String
)
data class Weekend(
    var departureTime: String,
    var arrivalTime: String
)

data class Tram(
    var routeNumber: Integer,
    var routeName: String,
    var vehicles: Vehicle,
    var schedules: Schedule
)
data class ControlCenter(
    var contactNumber: String,
    var emergencyContracts: EmergencyContract
)
data class EmergencyContract(
    var name: String,
    var phone: String,
    var shift: String
)
