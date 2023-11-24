##Design a Logistics System
- Design a Logistics System (Object Oriented Design). 
    - Tell about the different classes and their relationships with each-other. 
    - It is not a System Design question, 
    - so scope of this question is only to define different classes (with it’s attributes and methods)
- Asked In: Adobe

### Solution 
- Let’s assume we want to design a Logistics System with following basic functionality:
    - The system can take an order to deliver it to a given destination.
    - The order will be a list of items and there is a cost of each order to process.
    - small_apps.User has to register himself / herself to use this system.
    - small_apps.User can track his / her order.
    - Orders will be shipped by bike or truck, but only a single order will be shipped by a single vehicle.
    
- The main classes will be:
    - small_apps.User
    - Item
    - Vehicle
    - Location
    - PaymentDetails
    - Order
    - LogisticsSystem

The small_apps.User class is for users/clients/customers, who will be charged to get their items delivered.

