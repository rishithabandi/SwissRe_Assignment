## To build 
`mvn package`


## To run tests 
`mvn test`


## To Run against given an input file 

###Option 1
`java -classpath target\TrackCrypoPortfolio.jar com.bob.rest.client.CryptoPortfolioApp bobs_crypto.txt`

###Option 2
`java -jar target\TrackCrypoPortfolio-jar-with-dependencies.jar bobs_crypto.txt`

##Sample output
```
  BTC  (     10 units)  =   110797.00 EUR
  ETH  (      5 units)  =     1670.00 EUR
  XRP  (   2000 units)  =      421.80 EUR
------------------------------------------
Total Assets:               112888.80 EUR


```


