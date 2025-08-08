# OpeNLogin

A practical, secure and friendly authentication plugin.  
This plugin has been adapted for use with the Ithavollr staging server, kept offline for security and testing (legal MC users only).

### For development:

#### Gradle:
```
repositories {
    maven { 
        url = uri('https://repo.nickuc.com/maven-releases/') 
    }
}

dependencies {
    compileOnly('com.nickuc.openlogin:openlogin-universal:1.3')
}
```

#### Maven:
```xml
<repositories>
  <repository>
    <id>nickuc-repo</id>
    <url>https://repo.nickuc.com/maven-releases/</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.nickuc.openlogin</groupId>
    <artifactId>openlogin-universal</artifactId>
    <version>1.3</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```
