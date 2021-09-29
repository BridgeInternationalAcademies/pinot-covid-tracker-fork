# Covid Tracker Data Analytics Using Apache Pinot and Visualized using Apache Superset

### What is Apache Pinot?
Apache Pinot is a distributed OLAP data store, built to deliver real-time analytics with low latency. It can ingest from batch data sources (such as Hadoop HDFS, Amazon S3, Azure ADLS or Google Cloud Storage) as well as stream data sources (such as Apache Kafka).
In terms of scale, largest Pinot Production clusters are known to handle more than 1M+ events/sec. 170k+ queries/sec with latency in several milliseconds.

### What is Apache Superset?
Superset is fast, lightweight, intuitive, and loaded with options that make it easy for users of all skill sets to explore and visualize their data, from simple line charts to highly detailed geospatial charts.

## Use Case

Covid Tracker Service will do stream ingestion of covid registered cases across different states (4 cities each). Approximately a 2k events are pushed every second through Kafka onto Apache Pinot.
Several Dashboards are created using Apache Superset to visualize the data.

![Solution Overview](images/1.png)

#### Different Reports are
- Overall Covid Cases Across Cities.
- Covid Tracker State Wise.
- Covid Cases Grouped By Cities In Telangana State.
- Covid Tracker Where direct dependents > 4.

#### Environment
- Docker Compose.
- Spring Boot 2.
- Apache Superset (Installed in My mac) Please visit this [site](https://superset.apache.org/docs/installation/installing-superset-from-scratch) for steps.
- Java 11.
- Apache Kafka (through docker).

### Set the Infrastructure using docker
``` shell
$ docker-compose up -d
Wait After everything comes up
$ docker-compose ps
           Name                          Command               State                                                             Ports                                                           
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
covid-tracker-pinot_pinot_1   ./bin/pinot-admin.sh Quick ...   Up      0.0.0.0:8000->8000/tcp,:::8000->8000/tcp, 8096/tcp, 8097/tcp, 8098/tcp, 8099/tcp, 0.0.0.0:9000->9000/tcp,:::9000->9000/tcp
kafka                         /etc/confluent/docker/run        Up      0.0.0.0:29092->29092/tcp,:::29092->29092/tcp, 0.0.0.0:9092->9092/tcp,:::9092->9092/tcp                                    
zookeeper                     /docker-entrypoint.sh zkSe ...   Up      0.0.0.0:2181->2181/tcp,:::2181->2181/tcp, 2888/tcp, 3888/tcp, 8080/tcp                                                    
```
### Create Table and Segments in Pinot
In the application we have already had a folder `pinot` that had schema definition and index specification. The index type `star-tree` is created for pre-aggregation purposes.

- Copy the pinot related data in to docker machine so we can exeute them inside docker
``` shell
cp ./pinot covid-tracker-pinot_pinot_1:.  
```
- Create table in Apache Pinot
``` shell
docker exec covid-tracker-pinot_pinot_1 bin/pinot-admin.sh AddTable \                                          
  -tableConfigFile /pinot/covid-cases-table-definition.json \
  -schemaFile /pinot/covid-cases-schema-definition.json \
  -exec
Executing command: AddTable -tableConfigFile /pinot/covid-cases-table-definition.json -schemaFile /pinot/covid-cases-schema-definition.json -controllerHost 172.23.0.4 -controllerPort 9000 -exec
Sending request: http://172.23.0.4:9000/schemas to controller: af0a1b06cabb, version: Unknown
{"status":"Table CovidCasesTracker_REALTIME succesfully added"}
```
### Access Apache Pinot
Apache pinot can be accessed from port 9000. http://localhost:9000/. And have a look at CovidCasesTracker table.
![Solution Overview](images/2.png)

### Access Superset
Apache Superset can be accessed from default port 8088. I have created a dashboard. You can create on your own.
![Solution Overview](images/3.png)

