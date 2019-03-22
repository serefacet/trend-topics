## Trend Topic Analyzer


Trend Topic Analyzer is a Java application which reads the Meetup RSVP Data from JSON file or Kafka topic
and processed the data in order to find the trending topics.

This project is running on Apache Spark Structured Streaming platform and based on Dataset, DataFrame, Spark SQL APIs to handle the data operations.

The business flow is divided into the following phases.

- Receiver Phase
- Processor Phase
    - Filter Phase
    - Transformer Phase
    - Aggregator Phase
    - Ranker Phase
- Persister Phase

#### Receiver Phase
Receiver phase is responsible for retrieving the data from JSON or Kafka topic. The obtained dataset is formed of RsvpMessages from Meetup RSVP data.
The receiver implementation could be added according to future requirements.
#### Processor Phase
Basically, it is the data processing part which consists of filter, transformer, aggregator and ranker phases.

##### Filter Phase
The filter phase is designed as open for extension. Any developer can write a new Filter Condition and apply to the existing filter through `config.properties` without any hassle. 
The only requirement is to add the fully qualified name of the new filter condition to the `filter.conditions` property in `config.properties`

DropDuplicates and PositiveResponse conditions are default filter conditions. 
`filter.conditions=com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl.DropDuplicatesCondition,com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl.PositiveResponseCondition`

##### Transformer Phase
The Transformer phase gets the filtered Dataset<RsvpMessage> and transform the data type to target data type. 
For instance, the TrendTopicTransformer extracts the `group.group_topics.urlkey` column and prepare Dataset<TransformedDataDTO> with the date and urlkey columns.

##### Aggregator Phase
The Aggregator phase aggregates the data and calculates the count according to urlkey and date in the particular Window defined in `config.properties` or system property.

`aggregator.windowSize=30 minutes`

`aggregator.slideDuration=30 minutes`

It gets the Dataset<TransformedDataDTO> as input and returns Dataset<AggregatedDataDTO>

##### Ranker Phase
The Ranker phase ranks the count of date, urlkey groups in the particular windows and pick the top N records defined in `config.properties` or System property.

`ranker.topRecords=3`
#### Persister Phase
Duty of persister phase is to persist the ranked data to the target datasource. 
The default output datasource is JSON file and the results are created under `trendtopic-output` folder with descending order which listed in descending order. The most trending topic will be listed in the beginning with corresponding window.

### Installation

You should run `mvn install` command in order to compile & package the trend-topic analyzer project.

### Build Artifacts

- Uber JAR = `target/trendtopic-analyzer-1.0-SNAPSHOT-shaded.jar`
- Surefire Test Reports = `target/surefire-reports`
- JaCoCo Test Coverage Report = `target/site/jacoco`

### Running Trend Topic Analyzer

`java -Dreceiver.json.path=<path> -jar target/trendtopic-analyzer-1.0-SNAPSHOT-shaded.jar`

### Running Trend Topic Analyzer with Custom Properties

You can override any property written in the below through system properties.

Example : 

`java -Dreceiver.json.path=<path> -Dranker.topRecords=5 -jar target/trendtopic-analyzer-1.0-SNAPSHOT-shaded.jar`

##### config.properties
```
receiver.json.path=src/main/resources/data

receiver.kafka.bootstrap.servers=localhost:9092
receiver.kafka.topic.name=meetup

filter.conditions=com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl.DropDuplicatesCondition,com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl.PositiveResponseCondition

aggregator.windowSize=30 minutes
aggregator.slideDuration=30 minutes

ranker.topRecords=3

spark.appName=TrendTopic
spark.master=local[2]
spark.sql.shuffle.partitions=3
spark.driver.extraJavaOptions=log4j.configuration=log4j.property
spark.executor.extraJavaOptions=log4j.configuration=log4j.property
```

### Running Kafka and Zookeeper
If you want to load data from kafka topic,  you should install docker and docker-compose into your environment. Then, you need to run kafka and zookeper in your docker engine.

There is a `docker-compose.yml` configuration file in `src/main/docker` You should run `docker-compose up -d` command under this folder.

Kafka is used for handling streaming data produced by `meetup-stream/Producer.py`. Then Spark Streaming receives the data from Kafka with `TrendTopicKafkaReceiver`. Unfortunately its implementation is not finalized.
### Things to Improve

Finding trend topics is a complex problem. For now, we are just looking at url keys and we are deciding the trend topics according to them in specific time-period. 

- Some url keys are intersecting in another url key. How should we handle them? For example, "social" and "socialnetwork" or "Gaming" and "War Gaming" url keys. Should we aggregate them under "social" topic ? 

- Is there any possibility to get the data with response "yes" and then "no" ? We are not handling this situation at the moment.

- We should add `checkpointing` feature for reliable datasources such as Kafka in order to provide exactly-once message delivery.

- Should we normalize the most trending topics in order to catch up the new trends? For example, if everybody is attending session related to "Investments" is it worth to show it in the trend topic list everytime? Maybe, we could count it as stop word.

- How should we handle the rank cardinality? For example, if we pick top 3 records from the ranked data, and assume that there are 25 records which have the same rank value. How should we select them?