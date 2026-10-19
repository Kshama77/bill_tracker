# BillTracker

A simple beginner-friendly Java console application to track monthly bills and payment status.

## Features
- Add a bill with a name, amount, and due date
- View all bills and whether they are paid
- Mark a bill as paid
- View a monthly summary of paid and unpaid bills
- Basic input validation

## Java concepts practiced
- Classes and objects
- Variables and data types
- `ArrayList`
- Loops and `switch`
- Methods
- `if/else` conditions
- `Scanner` input
- Basic exception handling

## Requirements
- Java 8 or newer

## Run the app

Open a terminal in the project folder and run:

```bash
javac -d out src/com/billtracker/*.java
java -cp out com.billtracker.BillTracker
```

## Notes
This beginner version stores bills in memory while the program is running. Bills are cleared when you exit the app. A future version could save data to a file or database.

## Example
```text
WELCOME TO BILLTRACKER

1. Add a bill
2. View all bills
3. Mark a bill as paid
4. View monthly summary
5. Exit
```

## Project structure
```text
BillTracker/
├── README.md
└── src/
    └── com/
        └── billtracker/
            ├── Bill.java
            └── BillTracker.java
```
