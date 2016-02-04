# lending

Code challenge for Funding Circle: 

## Installation

Fork this repo into the directory of your choosing.

## Usage

Run the program with `lein run`

Run the tests with `lein tests`

You can also build the project with `lein uberjar`, and then run the program via `java -jar path/to/standalone-jar-file.jar`.



## Options

The program prints the output for the first 10 primes by default, as requested. You can use the `-s` or `--SIZE` flags to specify a table of any size. Formatting breaks down for tables larger than 25 x 25, but that could easily be fixed if desired. 

## Answers to the questions posed in the original coding challenge

**Consider complexity. How fast does your code run? How does it scale?**

My solution is based on the Sieve of Eratosthenes; a faster algorithm would certainly scale better. As noted above, the formatting for the table would need to be tweaked for larger outputs.

**Consider cases where we want N primes**

That's part of the solution; you can use the `-s` or `--SIZE` flags to get whatever output you want. I did it this way because it made sense to me; anything that hard-coded 10 primes seemed like an unthinkably ugly hack. Since I was already using an arbitrary n, it made sense to expose it to the user via `clojure.tools.cli`.


**Do not use the Prime class from stdlib (write your own code)**

Check!


**Write tests. Try to demonstrate TDD/BDD**

As noted above, tests are accessible via `lein test`. The tests in `test/funding/core_test.clj` appear in the chronological order that I wrote them in. This is normally how I develop anything and everything; incremental changes each associated with new tests. That's the only way I can sleep at night after writing new code.




