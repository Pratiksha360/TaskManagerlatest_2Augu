# Getting Started

### Reference Documentation


### Guides
The following guides illustrate how to use REst API:

* run App 
* [api docs link ](http://localhost:8080/swagger-ui/index.html)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

