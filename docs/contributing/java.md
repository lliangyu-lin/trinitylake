# Java SDK

## Setup

TrinityLake Java SDK is built using Gradle with Java 11, 17, 21, or 23.

## Build

To build and run tests:

```bash
./gradlew build
```

To build without running tests:

```bash
./gradlew build -x test -x integrationTest
```

## Code Style

All Java and Scala code is linted using checkstyle and spotless.
To fix code style, run:

```bash
./gradlew spotlessApply
```


