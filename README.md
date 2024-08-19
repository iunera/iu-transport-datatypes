# iu-transport-datatypes

This project contains in essence two things:

- Domain objects for public transport
- A universal natural key generator (fuzzy hashing technique) to match schedules and rides and stops from different data sources

# Key generator
The key generator is inspired by local sensitive hashing and various data clustering techniques.
The idea is to maximize collisions within different time and geo granularity to match different data sources.
This works by using geohashes to cluster coordinates into tiles and time buckets to cluster the time. 

# Domain objects
The domain objects are leaned towards https://schema.org data types and to reflect internationalization.
For examples are there definitions of weekends that differ in Arabic countries to wester countries and so on (https://en.wikipedia.org/wiki/Workweek_and_weekend#Asia_and_Australasia).

# Usage
Use this in your maven pom.xml 
```
<dependency>
    <groupId>com.iunera.fahrbar</groupId>
    <artifactId>iu-transport-datatypes</artifactId>
    <version>2.0.1</version>
</dependency>
```

# License
[Open Compensation Token License, Version 0.20](https://github.com/open-compensation-token-license/license/blob/main/LICENSE.md)
