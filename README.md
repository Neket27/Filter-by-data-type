# Filter for file by data type

Пример запуска улитилы с помощью jar файла:
java -jar <path>/FileContentFilteringUtility-1.0-SNAPSHOT.jar -f <inputFile>
![Screenshot_20241219_231605](https://github.com/user-attachments/assets/1cba5e28-9573-488b-94af-64e29dc66b58)

#Параметры программы
По умолчанию файлы результатов перезаписываются. Однако с помощью параметра -a можно настроить режим добавления новых данных в существующие файлы.

Параметры -s(по умолчанию) и -f позволяют выводить краткую или полную статистику по записанным файлам соответственно.

С помощью параметра -o можно указать путь для сохранения результатов.

Параметр -p позволяет задать префикс для имён выходных файлов.

Примеры значений приходящие в args[]:
![Screenshot_20241219_232550](https://github.com/user-attachments/assets/32d9e145-6728-4055-9df6-ff59b91f44d3)
![Screenshot_20241219_232617](https://github.com/user-attachments/assets/b02f7793-3c13-411a-804e-251960a3313d)
![Screenshot_20241219_232627](https://github.com/user-attachments/assets/94b9e728-5c8f-4803-a757-dba5786ed0b1)



#mvn -version

Apache Maven 3.8.7

Maven home: /usr/share/maven

Java version: 17.0.13, vendor: Debian, runtime: /usr/lib/jvm/java-17-openjdk-amd64

Default locale: ru_RU, platform encoding: UTF-8

OS name: "linux", version: "6.1.0-25-amd64", arch: "amd64", family: "unix"         

Доп. библиотеки com.google.guava и junit5

     <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactId>
        <version>33.3.1-jre</version>
     </dependency>

     <properties>
        <junit.jupiter.version>5.8.1</junit.jupiter.version>
        <junit.platform.version>1.8.1</junit.platform.version>
     </properties>
     <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-suite</artifactId>
            <version>${junit.platform.version}</version>
            <scope>test</scope>
        </dependency>
