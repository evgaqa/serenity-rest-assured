Selenium + Serenity

Start all tests

`mvn clean verify`

Start petstore API tests

`mvn clean verify -Dtags=PetstoreAPI`

Test report with screenshots generated in `target/site/serenity`

![Serenity report](serenity-report.jpg)

JMeter script for site https://www.wildberries.ru/ is in the `jmeter` folder

Graph Results
![Graph Results](jmeter/wildberries-ru-graph-results.jpg)

Summary Report  
![Summary Report](jmeter/wildberries-ru-summary-report.jpg)