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

We choose fair [code, fair work, fair payment, open  collaboration](https://www.license-token.com)

## [Open Compensation Token License](https://github.com/open-compensation-token-license/license/blob/main/LICENSE.md)

```
Licensed under the OPEN COMPENSATION TOKEN LICENSE (the "License").

You may not use this file except in compliance with the License.

You may obtain a copy of the License at
<https://github.com/open-compensation-token-license/license/blob/main/LICENSE.md>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressed or implied.
See the License for the specific language governing permissions and
limitations under the License.

@octl.sid: 1b6f7a5d-8dcf-44f1-b03a-77af04433496
```
* Why did we [choose the OCTL as alternative to the GNU Lesser General Public License v3](https://www.license-token.com/wiki/unveiling-gnu-lesser-general-public-license-v3-summary)?
* Why we [do NOT apply Apache 2.0 License](https://www.license-token.com/wiki/the-downside-of-apache-license-and-why-i-never-would-use-it)?
