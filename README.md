[![Build Status](https://travis-ci.org/artkuznetsov101/jmsftp.svg?branch=master)](https://travis-ci.org/artkuznetsov101/matrix-multiply)

# matrix-multiply

Matrix multiplication using different techniques:
* simple for loop
* recursive (divide and conquer) multiplier (matrix size need to be a power of two)
* Java 8 Stream API
* Java 8 work-stealing thread pool
* Java 8 work-stealing thread pool with optimization

You can set matrix size in 'com.test.Multiplier.matrixSize'. It's 1024 by default.

How to run:
         
    mvn test
