# itv

[![Build Status](https://travis-ci.org/kasonchan/itv.svg?branch=master)](https://travis-ci.org/kasonchan/itv)
[![codecov.io](https://codecov.io/github/kasonchan/itv/coverage.svg?branch=master)](https://codecov.io/github/kasonchan/itv?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/76680b51c0ce446fa36838ba45251fd3)](https://www.codacy.com/app/kasonchan/itv)

### Task

Implement a supermarket checkout program that calculates the total price of a 
number of items.

### Instructions

Implement the code for a supermarket checkout that calculates the total price
of a number of items. In a normal supermarket, things are identified using
Stock Keeping Units, or SKUs. In our store, we’ll use individual letters of
the alphabet (A, B, C, and so on as the SKUs). Our goods are priced
individually. In addition, some items are multi-priced: buy n of them, and
they’ll cost you y. For example, item ‘A’ might cost 50 pence individually,
but this week we have a special offer: buy three ‘A’s and they’ll cost you
£1.30. In fact this week’s prices are:

| Item   | Unit Price    | Special Price |
| :----- | :------------ | :------------ | 
| A      | 50            | 3 for 130     |
| B      | 30            | 2 for 45      |
| C      | 20            |               |
| D      | 15            |               |

Our checkout accepts items in any order, so that if we scan a B, an A, and
another B, we’ll recognise the two B’s and price them at 45 (for a total price
so far of 95). Because the pricing changes frequently, we need to be able to
pass in a set of pricing rules each time we start handling a checkout
transaction.

### Development

This application is built with the following:

-  [Scala](http://www.scala-lang.org/) version 2.11.7
-  [SBT](http://www.scala-sbt.org/) version 0.13.8

### Running the code 

Follow these steps to run the code:

-  Enter `git clone https://github.com/kasonchan/itv`.
Or Download `zip` file from `https://github.com/kasonchan/itv`. `Unzip` the file.
-  `cd` into the `itv` directory.
-  Enter `sbt run` to execute the program.
-  Enter `sbt test` to test. 
-  Enter `sbt clean` to clean up the compiled files.
