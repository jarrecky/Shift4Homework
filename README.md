# What's this?
An app that takes a cron expression and prints it in specific, human readable format. Each field is printed in different line.
First - descriptive name (padded with spaces to reach 14 characters width) and then a list of values representing given cron expression eg. `1 2 3` for expression `1-3`

# Sample output
Cron expression: `*/10 0-3 1-15/3 * MON-FRI /usr/bin/find`

Output:
```
minute        0 10 20 30 40 50
hour          0 1 2 3
day of month  1 4 7 10 13
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```

# How to run (Linux)
1. Install JRE (Java Runtime Environment) (skip is already installed)
```shell
sudo apt install default-jre 
```
2. Locate file `Shift4Homework-1.0.jar` in main directory of this project and run application
```shell
java -jar Shift4Homework-1.0.jar
```

# How to run (OS X)
No expertise on my side but I guess 1st step can be easily achieved with Google's help :)
The 2nd step remains the same.