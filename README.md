# Test
Wordline RESTFul maven project assignment

## Compile

```
$ mvn compile
```

## Test

```
$ mvn test
```

## Run

```
$ mvn exec:java
```

## Package

```
$ mvn package
```

## Endpoints



### Check PerfectNumber

```
http://localhost:8081/Test/rest/perfectNumber/{number} [GET]

Response

{
    "perfectNumbers": [Integer],
    "perfect": boolean
}
```
When succeed 200 Status code with list of perfectNumber between 1 and 10000 and Perfect(true/false) are returned.

Validate number less than or equals 10000 - Bad request 400 Status code
### Get PerfectNumber in range

```
http://localhost:8081/Test/rest/perfectNumber/range?start=x&end=y [GET]

Response

{
    "perfectNumbers": [Integer]
}
```
