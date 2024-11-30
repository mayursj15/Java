# Stream API

### 1. Why map, filter and reduce cant be applied directly on collection / why stream has been introduced ? ( map-filter-reduce algorithm)
     map, filter will duplicate the data e.g if list has 1 million records then map will duplicate it,\
     Similarly filter may reduce the count but still it will duplicate the things hence stream has been introduced as it does not duplicate records
   
### 2. Flatmap
    Flatmap used to deal with oneToMany relationship
    Flatmap is defined as function which takes an Object and return stream of other object
    Flatmap always take object and return stream.   
```java
/**
 *  to get the people living in city
 */
cities
   .stream()
   .flatMap(city -> city.getPeople().stream())
   .forEach(t -> System.out.println(t));
 ```

## 3. Creating Stream
#### 1. From Array
```java
    // 1. using factory method of Arrays class
    System.out.println("Using Arrays.stream()");
    Arrays.stream(people).forEach(System.out::println);

    // 2. using factory method of Stream interface (of)
    long count = Stream.of(people).count();
    System.out.println("count using stream of ::" + count);
```        
#### 2. From Reg ex
```java
    String sentence = "Java stream api is very useful";
    
    // this can be traditional way
    String[] words = sentence.split(" ");
    Arrays.stream(words).forEach(System.out::println);

    // Better way no pressure on Memory, CPU
    Pattern.compile(" ").splitAsStream(sentence).forEach(System.out::println);
```
#### 3. From String
```JAVA
    String sentence = "Java stream API is very useful";
    
    sentence.chars()
            .mapToObj(code -> Character.toString(code))
            .filter(letter->!letter.equals(" "))
            .distinct()
            .sorted()
            .forEach(System.out::println);
```            
#### 4. From Text FIle
```JAVA
    Path path = Path.of("C:\\Mayur\\work\\coding\\Java\\corejava\\src\\main\\java\\com\\mayur\\streams\\createstr\\firstName.txt");
    try (Stream<String> lines = Files.lines(path);) {
        lines.forEach(System.out::println);
    } catch (IOException e) {
        throw e;
    }
```  
## 4. IntStream
```java
    IntStream.range(0,10)
                .skip(5)
                .limit(2)
                .forEach(System.out::println);
```
## 5.TakeWhile
       
for take while if predicate condition is succssful it abort wont execute further while in case of filter if condition fails it will go to next stream element 

```java
    /// will print 123321
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
            .filter(i -> i < 4) // will go to next stream if condition fails
            .forEach(System.out::print);

    /// will print 123 and after that stream will aborted
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
            .takeWhile(i -> i < 4) // will abort the execution if condition is successful
            .forEach(System.out::print);
```                
## 6. For loop to stream API
```java
/**
 * If a single for loop doing multiple things then
 *    1. Convert each task of loop into loop i.e. if single for loop is doing 3 tasks
 *       then create 3 for loops to execute individual task because stream do one task at a time
 *    2. Should be converted into three streams
 *    3. In Streams we not process your data in single pass
 */
double average = people.stream()
        .mapToInt(Person::getAge) // map will return Stream<T> and mapToInt return IntStream
        .filter(p -> p > 20)
        .average()
        .orElseThrow();
```  
## 7. Reduce
```java
    /**
     *  Let's add identity, we have to very carefull if while adding identity if we pass wrong identity it will give wrong result
     *
     *  ints.stream().reduce(0, (a, b) -> a + b);
     *  here it actally works as : 0 + 1 + 1 + 1 + 1 + 1 = 5 which is correct
     *  but
     *  ints.stream().reduce(10, (a, b) -> a + b);
     *  here we gave buggy identity hence here result is 15, here developer has to be very carefull because compiler wont capture this
     *
     */
    int sum = ints.stream().reduce(0, (a, b) -> a + b);
    
    System.out.println("sum should be 5 " + sum);

    int sumWithWrongIdentity = ints.stream().reduce(10, (a, b) -> a + b);

    System.out.println("sum should be 15 as 10 is wrong identity " + sumWithWrongIdentity);

    /// prints statistics of the operation
    /// DoubleSummaryStatistics{count=6, sum=205000.000000, min=5000.000000, average=34166.666667, max=100000.000000}
    DoubleSummaryStatistics summaryStatistics = employeeList.stream()
            .mapToDouble(emp -> emp.getSalary())
            .summaryStatistics();

        /**
         *     identity: The identity value for the reduction (initial value).
         *     accumulator: A function that combines two values.
         *     combiner: A function that combines two partial results.
         */
        employeeList.stream()
                .reduce( 0.0, // Identity 
                 (abc, sale) -> abc + sale.getSalary(), // Accumulator
                  Double::sum);// combiner
```     

## Collectors

```java
        /// 1. map of city name and list of employee staying there
        Map<String, List<Employee>> cityEmployeeMap = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getCity));
    
        //paris=[Employee(age=45, name=sarah, salary=50000.0, city=paris), Employee(age=55, name=paul, salary=100000.0, city=paris)]
        //newyork=[Employee(age=25, name=john, salary=10000.0, city=newyork), Employee(age=35, name=julie, salary=30000.0, city=newyork), Employee(age=21, name=james, salary=5000.0, city=newyork), Employee(age=34, name=adam, salary=10000.0, city=newyork)]
        cityEmployeeMap.entrySet().stream().forEach(System.out::println);
    
        ///  2. map of city and number of employee of that city
        Map<String, Long> cityEmployeeNoOfEmpMap = employeeList.stream().
                collect(Collectors
                        .groupingBy(Employee::getCity,
                                Collectors.counting()));
        System.out.println(cityEmployeeNoOfEmpMap); // {paris=2, newyork=4}
    
    
        ///  3. map of city and name of the employee living in that city
        Map<String, Set<String>> mapOfCityAndNameOfEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toSet())));
        System.out.println(mapOfCityAndNameOfEmp); // {paris=[sarah, paul], newyork=[julie, adam, james, john]}
```








  





