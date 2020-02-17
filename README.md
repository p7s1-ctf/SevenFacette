# Welcome to 7Facette


7Facette is an open-source multiplatform test automation library for Kotlin with support for Kotlin Native, JVM and JS. It is designed to provide a structure
for developing higher quality automated acceptance and regression tests easier, faster and of course with more fun. So your team can hit the ground running 
and not have to waste time needlessly building and maintaining their own framework. It`s ideal for agile software delivery teams who want to collaborate
around living documentation. 


## Where can I learn more?

| **[User Docs][userdocs]**     | **[Setup Guide][get-started]**     | **[Examples][examples]**           | **[Contributing][contributing]**           |
|:-------------------------------------:|:-------------------------------:|:-----------------------------------:|:---------------------------------------------:|
| [![i1][userdocs-image]][userdocs]<br>Learn more about using 7Facette | [![i2][getstarted-image]][get-started]<br> Getting started with 7Facette | [![i3][examples-image]][examples]<br>Some 7Facettee Examples | [![i4][contributing-image]][contributing]<br>How can you contribute to 7Facette? |

[userdocs-image]:/misc/images/docs.png
[getstarted-image]:/misc/images/setup.png
[examples-image]:/misc/images/roadmap.png
[contributing-image]:/misc/images/contributing.png

[userdocs]:https://github.com/p7s1-ctf/SevenFacette/wiki
[get-started]:https://github.com/p7s1-ctf/SevenFacette/wiki/Setup
[examples]:https://github.com/p7s1-ctf/SevenFacette/wiki/Examples
[contributing]:CONTRIBUTING.md

## Questions or need help?

### Troubleshooting

Context specific **Troubleshooting** guide is available in relevant pages of the [7Facette Wiki](https://github.com/p7s1-ctf/SevenFacette/wiki/Troubleshooting).

### Talk with us

Please see below for the best place to ask a query:

- How do I? -- [7Facette Telegram Channel](https://t.me/SevenFacette)
- I got this error, why? -- [7Facette Telegram Channel](https://t.me/SevenFacette)
- I got this error and I'm sure it's a bug -- create an [issue](https://github.com/p7s1-ctf/SevenFacette/issues)
- I have an idea/request -- create an [issue](https://github.com/p7s1-ctf/SevenFacette/issues)
- Why do you? -- [7Facette Telegram Channel](https://t.me/SevenFacette)
- When will you? -- [7Facette Telegram Channel](https://t.me/SevenFacette)

--- 
## Download

### Repository

You can download 7Facette packages from JFRog Bintray or Maven Central

#### JFrog Bintray

```kotlin
repositories {
    JFRog bintray()... 
}
```

#### Maven Central

```kotlin
repositories {
    mavencentral() 
}
```

### Packages

#### Core

```kotlin
implementation("de.p7s1.qa:sevenfacette:core:0.1.0")
```

#### JVM

```kotlin
implementation("de.p7s1.qa:sevenfacette:core-jvm:0.1.0")
```

#### JS

```kotlin
implementation("de.p7s1.qa:sevenfacette:core-js:0.1.0")
```
