# JOM. Generics. Collections. Annotations
## Task 7

Create marker-annotation **CamelCase** which will check whether method named according to code conventions. Create class **CheckCamelCase** for checking if all the annotated methods of some class satisfy naming pattern. This class contains constant 'CAMELCASE_PATTERN' that introduces regex for checking method name. Also this class contains method **checkAndPrint(Class clazz)** which returns true if all annotated methods of class satisfy 'CAMELCASE_PATTERN' and prints to standard output information about all incorrect method names by template: **method <className>.<methodName> doesn't satisfy camelCase naming convention**.

For example
```
For class
public class Class1{
@CamelCase
public void correct(){}
@CamelCase
public void InCorrect(){}
public void JustMethod(){}
}
```
call CheckCamelCase.checkAndPrint(Class1.class)

prints to console
```
method Class1.InCorrect doesn't satisfy camelCase naming convention
```

> For correct passing of all tests don't use **print** and **println** methods in your code.
